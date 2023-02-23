package client;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View {

    private JTextField EnterMessage;
    private JButton Sicka;
    private JTextArea ChatHistory;
    private JPanel Base;
    private JButton disconnectButton;
    String HisMessage = " ";

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
    public void setButtonPresser(ActionListener bp){
        Sicka.addActionListener(bp);
    }
    public void setButtonPresserDis(ActionListener Dis){
        disconnectButton.addActionListener(Dis);
    }

}
