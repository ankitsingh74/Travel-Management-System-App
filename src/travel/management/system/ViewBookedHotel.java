package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JLabel labelusername,  labelprice ;
    JButton back;

    String username;
    ViewBookedHotel(String username){
        this.username = username;
        setBounds(400,200,1000,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS:");
        text.setBounds(20,20,320,25);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 50, 150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel  lblpackage = new JLabel("Hotel Name");
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

        JLabel  lbldays = new JLabel("Total Days");
        lbldays.setBounds(20,170,150,25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(220,170,200,25);
        add(labeldays);

        JLabel  lblac = new JLabel("AC/NON-AC");
        lblac.setBounds(20,210,150,25);
        add(lblac);

        JLabel labelac = new JLabel();
        labelac.setBounds(220,210,200,25);
        add(labelac);

        JLabel  lblfood = new JLabel("Food Included");
        lblfood.setBounds(20,250,150,25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(220,250,200,25);
        add(labelfood);

        JLabel  lblid = new JLabel("Id");
        lblid.setBounds(20,290,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,290,200,25);
        add(labelid);

        JLabel  lblnumber = new JLabel("Number");
        lblnumber.setBounds(20,330,150,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,330,200,25);
        add(labelnumber);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(20, 370, 150,25);
        add(lblPhone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,370,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(20,450,200,25);
        lblprice.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,450,200,25);
        labelprice.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelprice);


        back = new JButton("Back");
        back.setBounds(400,500,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLUE);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(460,20,500,460);
        add(image);


        try {
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("name"));
                labelpersons.setText(rs.getString("persons"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));

                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
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
        new ViewBookedHotel("Ankit01");
    }


}

