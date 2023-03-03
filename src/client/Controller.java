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

        client.StartClient(this);
        client.CreateSocket();


    }

    public void SetConnection(boolean Stat){
        this.Connected = Stat;
    }

    public void Disconnected(){
        view.ChangeStatues();
    }
    private class bp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            client.sendMessage(view.GetMessage());

            view.ResetText();

        }
    }
    public void FromServer(String ID, String message){
        view.Chat(ID, message);
    }

    public static void main(String[] args) {
        Client c = new Client(ip, port);
        View v = new View();
        Controller thisIsTheProgram = new Controller(c,v);
        thisIsTheProgram.setVisible(true);
    }
}
