package server;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;

public class Server {
    ServerSocket server;
    Socket client;
    int TotalUsers = 0;
    static ArrayList<Clients> users = new ArrayList<>();
    PrintWriter out;
    BufferedReader in;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to open serversocket.");
            e.printStackTrace();
        }
        System.out.println("Server started...");
    }

    private void acceptClient() {
        try {
            users.add(new Clients(server.accept(), TotalUsers, this));
            TotalUsers++;
        } catch (IOException e) {
            System.err.println("Failed to connect to client");
            e.printStackTrace();
        }
        System.out.println("client connected...");
    }



    private void runProtocol() {
        Scanner tgb = new Scanner(System.in);
        System.out.println("chatting...");
        String msg = "";
        while (!msg.equals("QUIT")) {
            msg = tgb.nextLine();
            out.println(msg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Server s = new Server(6240);
        s.acceptClient();
        for (int i = 0; i < s.TotalUsers; i++) {
            users.get(i).setListen();
        }

        s.runProtocol();
        for (Clients user : users) {
            user.ListenJoin();
        }

        s.shutdown();
    }

    private void shutdown() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}