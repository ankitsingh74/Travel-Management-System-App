package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JTextField tfperson;

    JButton checkprice, bookpackage, back;
    String username;
    BookPackage(String username){
this.username = username;
        setBounds(400,200,1100,500);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(20,10,200,25);
        text.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 50, 150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150,25);
        add(labelusername);


        JLabel  lblpackage = new JLabel("Select Packages");
        lblpackage.setBounds(20,100,150,25);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.setBounds(220,100,200,25);
        cpackage.add("GOLD PACKAGE");
        cpackage.add("SILVER PACKAGE");
        cpackage.add("BRONZE PACKAGE");
        add(cpackage);


        JLabel  lblperson = new JLabel("Total Person");
        lblperson.setBounds(20,150,150,25);
        add(lblperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(220,150,50,25);
        add(tfperson);


        JLabel  lblid = new JLabel("Id");
        lblid.setBounds(20,200,150,25);
        add(lblid);

         labelid = new JLabel();
        labelid.setBounds(220,200,200,25);
        add(labelid);


        JLabel  lblnumber = new JLabel("Number");
        lblnumber.setBounds(20,250,150,25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220,250,200,25);
        add(labelnumber);


        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(20,300,150,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220,300,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(20,350,150,25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220,350,150,25);
        add(labelprice);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelusername.setText(rs.getString("username"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBounds(20,400,120,25);
        checkprice.setBackground(Color.BLUE);
        checkprice.setForeground(Color.white);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage= new JButton("Book Now");
        bookpackage.setBounds(220,400,120,25);
        bookpackage.setBackground(Color.BLUE);
        bookpackage.setForeground(Color.white);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back       = new JButton("Back");
        back.setBounds(420,400,120,25);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(550,50,500,300);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == checkprice){

            String pack = cpackage.getSelectedItem();
            int cost=0;
            if (pack.equals("GOLD PACKAGE")){
                 cost = cost + 12000;
            }else if (pack.equals("SILVER PACKAGE")){
                cost = cost + 24000;
            }else {
                cost = cost + 32000;
            }

            int persons = Integer.parseInt(tfperson.getText());
            cost=cost * persons;
            labelprice.setText("Rs "+cost);
        }else if (ae.getSource() == bookpackage){

            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfperson.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("Ankit01");
    }


}
