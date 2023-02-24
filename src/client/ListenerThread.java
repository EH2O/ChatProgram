package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ListenerThread implements Runnable{
    private final BufferedReader in;
    private final Controller Con;
    private boolean Connected = true;

    public ListenerThread(BufferedReader in, Controller Con) {
        this.in = in;
        this.Con = Con;

    }

    @Override
    public void run() {
        String msg = "";
        while (Connected) {
            if(!msg.equals("")){
            Con.FromServer("Server" , msg);
            }
            try {
                msg = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                Connected = false;
            }

        }
        stop();
    }

    public void stop()  {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Con.Disconnected();
    }
}