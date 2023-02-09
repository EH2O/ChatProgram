package client;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View {

    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JPanel Base;
    String message = "";

    public JPanel getPanel() {
        return Base;
    }

    public String GetMessage(){return textArea1.getText();}
    public void ResetText(){
        textArea1.setText("");
    }

    public void Chat(){
        message += "\n" + textArea1.getText();
        textField1.setText(message);
        ResetText();
    }
    public void setButtonPresser(ActionListener bp){
        button1.addActionListener(bp);
    }

}
