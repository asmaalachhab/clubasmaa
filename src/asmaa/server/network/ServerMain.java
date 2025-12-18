package asmaa.server.network;

import asmaa.server.service.ReservationService;
import asmaa.server.service.UserService;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class ServerMain {
    public static void main(String[] args) {
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/asmaa_club","root","");
            UserService.init(conn);
            ReservationService.init(conn);

            ServerSocket serverSocket=new ServerSocket(5000);
            System.out.println("Serveur démarré sur le port 5000...");

            while(true){
                Socket clientSocket=serverSocket.accept();
                System.out.println("Client connecté: "+clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch(Exception e){ e.printStackTrace(); }
    }
}
