
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JTextField tfperson, tfdays;

    JButton checkprice, bookpackage, back;
    String username;
    BookHotel(String username){
        this.username = username;
        setBounds(400,200,1100,600);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(20,10,200,25);
        text.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 50, 150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150,25);
        add(labelusername);


        JLabel  lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(20,100,150,25);
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(220,100,200,25);
        add(chotel);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");

            while (rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch (Exception e){

        }

        JLabel  lblperson = new JLabel("Total Person");
        lblperson.setBounds(20,150,150,25);
        add(lblperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(220,150,50,25);
        add(tfperson);

        JLabel  lbldays = new JLabel("No. of Days");
        lbldays.setBounds(20,190,150,25);
        add(lbldays);

        tfdays= new JTextField("1");
        tfdays.setBounds(220,190,50,25);
        add(tfdays);

        JLabel  lblac = new JLabel("AC/ Non-AC");
        lblac.setBounds(20,230,150,25);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(220,230,100,25);
        add(cac);

        JLabel  lblfood = new JLabel("Food Included");
        lblfood.setBounds(20,270,150,25);
        add(lblfood);

        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(220,270,100,25);
        add(cfood);

        JLabel  lblid = new JLabel("Id");
        lblid.setBounds(20,310,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220,310,200,25);
        add(labelid);


        JLabel  lblnumber = new JLabel("Number");
        lblnumber.setBounds(20,350,150,25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220,350,200,25);
        add(labelnumber);


        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(20,390,150,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220,390,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(20,430,150,25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220,430,150,25);
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
        checkprice.setBounds(30,490,120,25);
        checkprice.setBackground(Color.BLUE);
        checkprice.setForeground(Color.white);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage= new JButton("Book Now");
        bookpackage.setBounds(230,490,120,25);
        bookpackage.setBackground(Color.BLUE);
        bookpackage.setForeground(Color.white);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back       = new JButton("Back");
        back.setBounds(430,490,120,25);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(450,50,600,400);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == checkprice){

            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");

                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons + days > 0){
                        int total = 0;
                        total +=acselected.equals("AC") ? ac : 0;
                        total +=foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total=total * persons *days;
                        labelprice.setText("Rs "+total);
                    }else {
                        JOptionPane.showMessageDialog(null, "Please Enter the Valid Number");
                    }

                }

            }    catch (SQLException e) {
                e.printStackTrace();
            }

        }else if (ae.getSource() == bookpackage){

            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+ chotel.getSelectedItem()+"', '"+tfperson.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookHotel("Ankit01");
    }


}
