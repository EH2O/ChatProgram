package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ListenerThread implements Runnable{
    private BufferedReader in;
    private Controller Con;


    public ListenerThread(BufferedReader in, Controller Con) {
        this.in = in;
        this.Con = Con;

    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Con.FromServer("Server:" , msg);
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