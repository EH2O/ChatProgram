package server;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View {
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JPanel Base;


    public JPanel getPanel() {
        return Base;
    }

    public String GetMessage(){return textArea1.getText();}
    public void Chat(String text){textField1.setText(text);}
    public void setButtonPresser(ActionListener bp){
        button1.addActionListener(bp);
    }

}
