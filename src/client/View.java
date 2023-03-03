package client;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View {

    private JTextField EnterMessage;
    private JButton Sicka;
    private JTextArea ChatHistory;
    private JPanel Base;
    private JButton disconnectButton;
    String HisMessage = "";
    boolean Statues = false;


    public JPanel getPanel() {
        return Base;
    }

    public String GetMessage(){return EnterMessage.getText();}
    public void ResetText(){
        EnterMessage.setText("");
    }

    public void Chat(String ID , String message){
        HisMessage += "\n" + ID+ ": " + message;
        ChatHistory.setText(HisMessage);

    }
    public void ChangeStatues(){
        Statues = !Statues;
        if(!Statues){
            disconnectButton.setText("Disconnect");
        }else{
            disconnectButton.setText("Connect");
        }


    }
    public void setButtonPresser(ActionListener bp){
        Sicka.addActionListener(bp);
    }


}
