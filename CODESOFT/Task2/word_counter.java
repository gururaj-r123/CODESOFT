import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.*;
  


public class word_counter implements ActionListener{  
    JButton b;
     JTextArea text;
     JLabel text2;
   
   public word_counter(){
  JFrame frame = new JFrame("Word Counter"); 
  
        JLabel label=new JLabel("Enter the sentence below  to count number of  words in it");
        label.setBounds(50, 10, 350, 30);
         text =new JTextArea();
        text.setLineWrap(true);
         
        text.setBounds(50, 40, 300, 60);
        b=new JButton("Count", null);
        b.setBounds(50, 150, 300, 50);
        b.addActionListener(this);
         text2 =new JLabel();
        text2.setBounds(50, 220, 300, 50);
         
      
        frame.add(label);
        frame.add(text);
        frame.add(b);
        frame.add(text2);

        frame.setSize(600, 600);  
        frame.setLayout(null);  
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String s=text.getText();
        String[] arr=s.split(" ");
        String result="The total number of words in Sentence is: "+String.valueOf(arr.length);
        text2.setText(result);
        text2.setForeground(Color.RED);
        
        
    }
    public static void main(String s[]) {  
        new word_counter();
     
    }  
}  
