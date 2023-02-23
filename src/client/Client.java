package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    String ip;
    int port;
    Socket socket;

    PrintWriter out;
    BufferedReader in;
    Controller c;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        try {
            socket = new Socket(ip,port);
        } catch (IOException e) {
            System.err.println("Failed to connect to server");
            e.printStackTrace();
        }
        System.out.println("Connection ready...");
    }




    public void getStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
    }


    public void sendMessage(String message){
        out.println("CLIENT: " + message);
    }

    public void StartClient(Controller Con){
        this.getStreams();
        ListenerThread l = new ListenerThread(this.in, Con);
        Thread listener = new Thread(l);
        listener.start();

    }

    public void shutDown() {
        try {
            socket.close();
            System.out.println("Disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setController(Controller controller) {
        this.c = controller;
    }
}

