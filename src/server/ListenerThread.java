package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ListenerThread implements Runnable{
    private BufferedReader in;
    private PrintStream out;
    Server s;
    int id;
    public ListenerThread(BufferedReader in, PrintStream out, Server s, int id) {
        this.in = in;
        this.out = out;
        this.s = s;
        this.id = id;
    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = in.readLine();
            } catch (IOException e) {
                System.out.println("this problem?");
                stop();
            }
            s.GotMessage(id + " " + msg);
        }
    }

    public void stop()  {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}