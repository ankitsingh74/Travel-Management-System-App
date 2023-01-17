package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    JProgressBar bar;
    String username;

    @Override
    public void run() {

        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();//100
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    Loading(String username){
        this.username = username;

        t = new Thread(this);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.blue);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, Please Wait...");
        loading.setBounds(230,135,200,20);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway",Font.BOLD,14));
        add(loading);

        JLabel lblusername = new JLabel("Welcome "+ username);
        lblusername.setBounds(20,330,200,20);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("Raleway",Font.BOLD,18));
        add(lblusername);


        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }



}
