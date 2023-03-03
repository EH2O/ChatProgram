package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;


public class AcceptClient implements Runnable{
        private BufferedReader in;
        private PrintStream out;
        private Server s;
        Socket newCon;
        boolean Running = true;
        public AcceptClient(Server s ) {
            this.s = s;
            run();
        }

        @Override
        public void run() {
            while(Running){
                try {
                    newCon = s.server.accept();
                    s.NewClient(newCon);
                } catch (IOException ignored) {}
                newCon = null;
            }
            System.out.println("Stopped");
        }

        public void stop()  {
            try {
                Running = false;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
