package client;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View {

    private JTextField EnterMessage;
    private JButton Sicka;
    private JTextArea ChatHistory;
    private JPanel Base;
    String message = "";

    public JPanel getPanel() {
        return Base;
    }

    public String GetMessage(){return EnterMessage.getText();}
    public void ResetText(){
        EnterMessage.setText("");
    }

    public void Chat(String ID , String message){
        message += "\n" + ID+ ": " + message;
        ChatHistory.setText(message);
    }
    public void setButtonPresser(ActionListener bp){
        Sicka.addActionListener(bp);
    }

}
