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

    public String GetMessage(){return ChatHistory.getText();}
    public void ResetText(){
        ChatHistory.setText("");
    }

    public void Chat(){
        message += "\n" + ChatHistory.getText();
        EnterMessage.setText(message);
        ResetText();
    }
    public void setButtonPresser(ActionListener bp){
        Sicka.addActionListener(bp);
    }

}
