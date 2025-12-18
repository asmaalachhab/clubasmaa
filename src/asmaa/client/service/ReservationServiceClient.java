package asmaa.client.service;

import asmaa.client.model.Reservation;
import asmaa.client.network.ClientSocket;

public class ReservationServiceClient {
    private ClientSocket socket;

    public ReservationServiceClient(ClientSocket socket){ this.socket=socket; }

    public boolean makeReservation(Reservation res){
        try{
            String resp=(String) socket.sendRequest(res);
            return resp.equals("RESERVATION_OK");
        }catch(Exception e){ e.printStackTrace(); }
        return false;
    }
}
