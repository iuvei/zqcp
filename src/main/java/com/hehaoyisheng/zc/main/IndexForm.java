package com.hehaoyisheng.zc.main;

import javax.swing.*;

public class IndexForm {
    private JPanel usss;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("IndexForm");
        frame.setContentPane(new IndexForm().usss);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
