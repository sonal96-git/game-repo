package com.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    Container c;
    JPanel panel;
    JButton[] buttons = new JButton[9];
    int sequence = 0;
    Font font;

    public TicTacToe() {
        c = this.getContentPane();
        c.setBackground(new Color(0, 0, 0, 232));
        c.setLayout(null);
        panel = new JPanel();
        panel.setBounds(150, 10, 500, 500);
        //panel.setBorder(BorderFactory.createLineBorder(Color.black,5));
        panel.setLayout(new GridLayout(3, 3));
        c.add(panel);
        initializeButtons();
          font  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 70);
    }

    public void initializeButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].setBackground(new Color(255, 250, 241));
            buttons[i].addActionListener(new ButtonListener());
           // buttons[i].setFont(font);
            panel.add(buttons[i]);
        }
    }

    public void resetButtons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i].setText("");
        }
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            String player=" ";
            buttonClicked.setFont(font);
            if (sequence % 2 == 0)

                buttonClicked.setText("X");

            else

                buttonClicked.setText("0");



            if (checkForWin() == true) {
                JOptionPane.showConfirmDialog(null, "player Wins the Game!!!!");
                resetButtons();
            }

            if (isBoardFull()) {
                JOptionPane.showMessageDialog(null, "Game Over");
                resetButtons();
            }

            sequence++;
        }


        public boolean checkForWin() {
            //horizontal Win check
            if (checkAdjacent(0, 1) && checkAdjacent(1, 2))
                return true;
            else if (checkAdjacent(3, 4) && checkAdjacent(4, 5))
                return true;
            else if (checkAdjacent(6, 7) && checkAdjacent(7, 8))
                return true;

                //Vertical Win check
            else if (checkAdjacent(0, 3) && checkAdjacent(3, 6))
                return true;
            else if (checkAdjacent(1, 4) && checkAdjacent(4, 7))
                return true;
            else if (checkAdjacent(2, 5) && checkAdjacent(5, 8))
                return true;

                //Diagonal Win Check
            else if (checkAdjacent(0, 4) && checkAdjacent(4, 8))
                return true;
            else if (checkAdjacent(2, 4) && checkAdjacent(4, 6))
                return true;
            else
                return false;

        }

        public boolean checkAdjacent(int a, int b) {
            if (buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals(""))
                return true;
            else
                return false;

        }

        public boolean isBoardFull() {
           boolean isFull=true;
           for(int i=0;i<9;i++) {

               if (buttons[i].getText().equals(""))
                   isFull = false;
           }

           return isFull;
        }
    }
}
