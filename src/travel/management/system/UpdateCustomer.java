package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail,  tfgender;
    JComboBox  tfid;
    JRadioButton rmale, rfemale;
    JButton add, back;


    UpdateCustomer(String username){

        setTitle("Update Customer Details");
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);//import java.awt.*; then Color work

        JLabel text = new JLabel("Update Customer Details:");
        text.setBounds(20,10,300,25);
        text.setForeground(Color.blue);
        text.setFont(new Font("SAN_SERIF",Font.BOLD,22));
        add(text);


        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel  lblid = new JLabel("Id");
        lblid.setBounds(20,90,150,25);
        add(lblid);

        tfid = new JComboBox(new String[] {"Passport", "Aadhar", "PAN Card", "Ration Card"});
        tfid.setBounds(220,90,150,25);
        add(tfid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(20,130,150,25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20,170,150,25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(20,210,150,25);
        add(lblgender);


        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);


        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(20,250,150,25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(20,290,150,25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,250,25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(20,320,100,25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220,320,130,25);
        tfphone.setFont(new Font("Raleway",Font.BOLD,14));
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(20,360,100,25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220,360,250,25);
        add(tfemail);

        add = new JButton("Update");
        add.setBounds(170,440,100,30);
        add.setBackground(Color.BLUE);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(370,440,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i5 = i4.getImage().getScaledInstance(370, 385, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(470,0,370,385);
        add(image);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");

            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
//                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add){

            String username = labelusername.getText();
            String id = (String) tfid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone   = tfphone.getText();
            String email   = tfemail.getText();

            try {
                //Connection to Database
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"',id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details updated Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }


}

