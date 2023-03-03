package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clients {
    Socket client;
    BufferedReader in;
    PrintWriter out;
    int id;
    Server s;

    Thread Listen;
    public Clients(Socket client, int id, Server s) {
        this.client = client;
        this.id = id;
        this.s = s;
        getStreams();
    }

    public void GotMessage(String msg) {
        out.println(msg);
    }
    private void getStreams() {
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
    }

    public void setListen(){
        ListenerThread l = new ListenerThread(in, System.out, s, id);
        Listen = new Thread(l);
        Listen.start();
    }

    public void ListenJoin() throws InterruptedException {
        Listen.join();
    }
}