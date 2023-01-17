package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {

    JLabel labelusername,  labelprice ;
    JButton back;

    String username;
    ViewPackage(String username){
this.username = username;
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS:");
        text.setBounds(20,20,260,25);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 50, 150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel  lblpackage = new JLabel("Package Name");
        lblpackage.setBounds(20,90,150,25);
        add(lblpackage);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,90,200,25);
        add(labelpackage);

        JLabel  lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(20,130,150,25);
        add(lblpersons);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220,130,200,25);
        add(labelpersons);

        JLabel  lblid = new JLabel("Id");
        lblid.setBounds(20,170,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,170,200,25);
        add(labelid);

        JLabel  lblnumber = new JLabel("Number");
        lblnumber.setBounds(20,210,150,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,210,200,25);
        add(labelnumber);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(20, 250, 150,25);
        add(lblPhone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);

        JLabel  lblemail = new JLabel("Email");
        lblemail.setBounds(20,290,150,25);
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(220,290,200,25);
        add(labelemail);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(20,330,200,25);
        lblprice.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,330,200,25);
        labelprice.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelprice);


        back = new JButton("Back");
        back.setBounds(550,350,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLUE);
       back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,20,500,300);
        add(image);


        try {
            Conn c = new Conn();
            String query = "select * from bookpackage where username = 'Ankit01'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ViewPackage("Ankit01");
    }


}
