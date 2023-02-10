package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame {
        Client client;
        View view;

    public Controller(Client c, View v) {
        this.client = c;
        this.view = v;
        c.setController(this);
        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        view.setButtonPresser(new bp());
        client.StartClient(c);

    }




    private class bp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            client.sendMessage(view.GetMessage());

            view.Chat("Client", view.GetMessage());

        }
    }
    public void FromServer(String ID, String message){
        Update(ID, message);
    }
    private void Update(String ID, String message){
        if (ID.equals("local")){
            client.sendMessage(view.GetMessage());
            view.Chat("Client", view.GetMessage());
        }else {
            view.Chat(ID, message);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Client c = new Client("10.80.47.216", 6240);
        View v = new View();
        Controller thisIsTheProgram = new Controller(c,v);
        thisIsTheProgram.setVisible(true);
    }
}
