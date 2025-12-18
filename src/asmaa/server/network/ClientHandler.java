package asmaa.server.network;

import asmaa.server.model.*;
import asmaa.server.service.ReservationService;
import asmaa.server.service.UserService;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientHandler(Socket socket) {
        this.socket=socket;
        try {
            out=new ObjectOutputStream(socket.getOutputStream());
            in=new ObjectInputStream(socket.getInputStream());
        } catch(Exception e) { e.printStackTrace(); }
    }

    @Override
    public void run() {
        try {
            Object obj;
            while((obj=in.readObject())!=null){
                if(obj instanceof Request){
                    Request req=(Request)obj;
                    Response resp = handleRequest(req);
                    out.writeObject(resp);
                    out.flush();
                } else if(obj instanceof Reservation){
                    Reservation res=(Reservation)obj;
                    boolean success=ReservationService.getInstance().makeReservation(res);
                    out.writeObject(success?"RESERVATION_OK":"RESERVATION_FAILED");
                    out.flush();
                    logReservation(res,success);
                }
            }
        } catch(Exception e){ e.printStackTrace(); }
        finally{
            try{ in.close(); out.close(); socket.close(); } catch(Exception e){ e.printStackTrace(); }
        }
    }

    private Response handleRequest(Request req){
        switch(req.getType()){
            case "LOGIN":
                User u=(User)req.getData();
                User user=UserService.getInstance().login(u.getEmail(),u.getPassword());
                log("Connexion "+(user!=null?u.getEmail():"Échec"));
                return new Response(user!=null,user,user!=null?"Connexion OK":"Échec");
            case "REGISTER":
                User newUser=(User)req.getData();
                boolean created=UserService.getInstance().register(newUser);
                log("Inscription "+newUser.getEmail()+" -> "+(created?"OK":"Erreur"));
                return new Response(created,null,created?"Inscription OK":"Erreur");
            case "GUEST":
                User guest=(User)req.getData();
                log("Invité "+guest.getName());
                return new Response(true,guest,"Session invité");
            default:
                return new Response(false,null,"Requête inconnue");
        }
    }

    private void log(String msg){ System.out.println("[SERVER] "+msg); }

    private void logReservation(Reservation res, boolean success){
        String status=success?"ACCEPTÉE":"REFUSÉE";
        System.out.println("[RESERVATION] Terrain: "+res.getTerrain().getName()+" | Date: "+res.getDate()+" | Créneau: "+res.getTimeSlot()+" | Utilisateur: "+(res.getUser()!=null?res.getUser().getName():"Invité")+" -> "+status);
    }
}
