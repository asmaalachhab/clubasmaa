package asmaa.client.network;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientSocket(String host, int port) throws IOException {
        socket=new Socket(host,port);
        out=new ObjectOutputStream(socket.getOutputStream());
        in=new ObjectInputStream(socket.getInputStream());
    }

    public Object sendRequest(Object obj) throws IOException, ClassNotFoundException {
        out.writeObject(obj);
        out.flush();
        return in.readObject();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
