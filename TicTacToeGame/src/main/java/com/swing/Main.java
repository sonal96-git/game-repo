package com.swing;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        TicTacToe ticTacToe=new TicTacToe();
        ticTacToe.setBounds(100,100,800,550);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setVisible(true);
        ticTacToe.setTitle("Tic-Tac-Toe Game");
    }
}
