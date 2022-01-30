package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ticTacToe {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton[] button = new JButton[9];
    JLabel textfield = new JLabel();
    int i=0,check = 0,start=0;
    public ticTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,500);
        panel.setVisible(true);
        frame.setVisible(true);
        frame.setTitle("tic tac toe");

        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 450, 450);

        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button[i].setBounds(0,0,150,150);
            button[i].setFont(new Font("Arial", Font.PLAIN, 40));
            setButton(button[i],"");
        }
        button[0].setBounds(0,0,150,150);
        button[1].setBounds(150,0,150,150);
        button[2].setBounds(300,0,150,150);
        button[3].setBounds(0,150,150,150);
        button[4].setBounds(150,150,150,150);
        button[5].setBounds(300,150,150,150);
        button[6].setBounds(0,300,150,150);
        button[7].setBounds(150,300,150,150);
        button[8].setBounds(300,300,150,150);
        panel.add(button[0]);
        panel.add(button[1]);
        panel.add(button[2]);
        panel.add(button[3]);
        panel.add(button[4]);
        panel.add(button[5]);
        panel.add(button[6]);
        panel.add(button[7]);
        panel.add(button[8]);
        panel.add(textfield);
        frame.add(panel);
    }
    private void setButton(JButton b, String text) {
        b.setText(text);
        b.setText("");
        b.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(b.getText().equals(""))
                    if(i%2==0) {
                        b.setText("x");
                        i++;
                        start++;
                    }
                    else {
                        b.setText("o");
                        i++;
                        start++;
                    }
                winCheck();
            }
        });
    }

    public void gameOver(String s){
        check = 0;
        Object[] option={"New Game","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        frame.dispose();
        if(n==0){
            new ticTacToe();
        }

    }

    public void winCheck() {
        if(start>=5)
        {
            if(button[0].getText()=="x"&&button[4].getText() == "x" && button[8].getText() == "x"||button[0].getText()=="o"&&button[4].getText() == "o" && button[8].getText() == "o")
                winCheck(button[0].getText());
            if(button[0].getText()=="x"&&button[3].getText() == "x" && button[6].getText() == "x"||button[0].getText()=="o"&&button[3].getText() == "o" && button[6].getText() == "o")
                winCheck(button[0].getText());
            if(button[0].getText()=="x"&&button[1].getText() == "x" && button[2].getText() == "x"||button[0].getText()=="o"&&button[1].getText() == "o" && button[2].getText() == "o")
                winCheck(button[0].getText());
            if(button[6].getText()=="x"&&button[4].getText() == "x" && button[2].getText() == "x"||button[6].getText()=="o"&&button[4].getText() == "o" && button[2].getText() == "o")
                winCheck(button[6].getText());
            if(button[6].getText()=="x"&&button[7].getText() == "x" && button[8].getText() == "x"||button[6].getText()=="o"&&button[7].getText() == "o" && button[8].getText() == "o")
                winCheck(button[6].getText());
            if(button[3].getText()=="x"&&button[4].getText() == "x" && button[5].getText() == "x"||button[3].getText()=="o"&&button[4].getText() == "o" && button[5].getText() == "o")
                winCheck(button[3].getText());
            if(button[1].getText()=="x"&&button[4].getText() == "x" && button[7].getText() == "x"||button[1].getText()=="o"&&button[4].getText() == "o" && button[7].getText() == "o")
                winCheck(button[3].getText());
            if(button[2].getText()=="x"&&button[5].getText() == "x" && button[8].getText() == "x"||button[2].getText()=="o"&&button[5].getText() == "o" && button[8].getText() == "o")
                winCheck(button[3].getText());
            }
            if(start==9) {
                textfield.setText("Match Tie");
                gameOver("Match Tie");
            }
        }

    public void winCheck(String s) {
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        if(s=="x")
            gameOver("X Wins");
        else
            if(s=="o")
                gameOver("O Wins");
    }
}