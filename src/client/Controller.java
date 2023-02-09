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
        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        view.setButtonPresser(new bp());
        client.StartClient();

    }
    private class bp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           client.sendMessage(view.GetMessage());
            view.Chat();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Client c = new Client("10.80.44.255", 6240);
        View v = new View();
        Controller thisIsTheProgram = new Controller(c,v);
        thisIsTheProgram.setVisible(true);


    }
}
