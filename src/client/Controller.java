package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame {
        Client client;
        View view;
        boolean Connected;
        static String ip = "10.80.44.255";
        static int port = 6240;
    public Controller(Client c, View v) {
        this.client = c;
        this.view = v;
        c.setController(this);
        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        view.setButtonPresser(new bp());
        view.setButtonPresserDis(new Dis());
        client.StartClient(this);

    }

    public void SetConnection(boolean Stat){
        this.Connected = Stat;
    }
    private class Dis implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        if(Connected){
            client.shutDown();
        }else{
            client.StartClient(Controller.this);
        }
        Disconnected();
        }
    }
    public void Disconnected(){
        view.ChangeStatues();
    }
    private class bp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            client.sendMessage(view.GetMessage());

            view.Chat("Client", view.GetMessage());
            view.ResetText();

        }
    }
    public void FromServer(String ID, String message){
        view.Chat(ID, message);
    }

    public static void main(String[] args) throws InterruptedException {
        Client c = new Client(ip, port);
        View v = new View();
        Controller thisIsTheProgram = new Controller(c,v);
        thisIsTheProgram.setVisible(true);
    }
}
