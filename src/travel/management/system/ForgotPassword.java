package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgotPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;

    ForgotPassword(){
       setBounds(350,200,850,380);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.png"));

       Image i2 = i1.getImage().getScaledInstance(210,210,Image.SCALE_SMOOTH);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(575,75,210,210);
       add(image);

       JPanel p1 = new JPanel();
       p1.setLayout(null);
       p1.setBounds(30,30,500,280);
       add(p1);

       JLabel lblusername = new JLabel("Username");
       lblusername.setBounds(40, 20, 100,25);
       lblusername.setFont(new Font("Tahoma", Font.BOLD,18));
       p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(160, 20, 200,30);
        tfusername.setFont(new Font("Raleway", Font.BOLD,15));
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBounds(370, 20, 100,30);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 60, 100,25);
        lblname.setFont(new Font("Tahoma", Font.BOLD,18));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(160, 60, 200,30);
        tfname.setFont(new Font("Raleway", Font.BOLD,15));
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds(10, 110, 150,25);
        lblquestion.setFont(new Font("Tahoma", Font.BOLD,16));
        p1.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(160, 110, 220,25);
        tfquestion.setFont(new Font("Raleway", Font.BOLD,15));
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40, 145, 150,25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD,18));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(160, 145, 200,25);
        tfanswer.setFont(new Font("Raleway", Font.BOLD,15));
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(370, 144, 100,30);
        retrieve.addActionListener(this);
        p1.add(retrieve);


        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 185, 150,25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD,18));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(160, 185, 200,25);
        tfpassword.setFont(new Font("Raleway", Font.BOLD,15));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(160, 230, 100,30);
        back.addActionListener(this);
        p1.add(back);

       setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String susername = tfusername.getText();
        String answer = tfanswer.getText();



        if (ae.getSource() == search) {
            if (susername.equals("")){
                JOptionPane.showMessageDialog(null, "Username Required");

            }
            else {
                try {

                    String query1 = "select * from account where username = '" + tfusername.getText()+ "'";
                    Conn conn = new Conn();
                    ResultSet rs1 = conn.s.executeQuery(query1);
                    if (rs1.next()) {

                        String query = "select * from account where username = '" + tfusername.getText() + "'";//tfusername.getText() return String from tfusername column from mysql account table
                        Conn c = new Conn();

                        ResultSet rs = c.s.executeQuery(query);

                        while (rs.next()) {

                            tfname.setText(rs.getString("name"));//getString is method which fetch values from row in mysql table
                            //setText method return the value(String) to the that JTextField(here tfname)
                            tfquestion.setText(rs.getString("security"));
                        }
                    }

                    else {
                        JOptionPane.showMessageDialog(ForgotPassword.this, "Ohh.. Invalid Username");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if (ae.getSource() == retrieve){

            if (susername.equals("")){
                JOptionPane.showMessageDialog(null, "Username Required");
            }
            else if (answer.equals("")){
                JOptionPane.showMessageDialog(null, "Answer Required");
            }else {
                try {
                    String query1 = "select * from account where answer = '" + tfanswer.getText()+ "'";
                    Conn conn = new Conn();
                    ResultSet rs1 = conn.s.executeQuery(query1);
                    if (rs1.next()) {

                    String query = "select * from account where answer = '" + tfanswer.getText() + "' AND username = '" + tfusername.getText() + "'";//tfusername.getText() return String from tfusername column from mysql account table
                    Conn c = new Conn();

                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        tfpassword.setText(rs.getString("password"));//getString is method which fetch values from row in mysql table
                        //setText method return the value(String) to the that JTextField(here tfpassword)
                    }

                    } else {
                        JOptionPane.showMessageDialog(ForgotPassword.this, "Ohh.. Invalid Answer");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if (ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new ForgotPassword();
    }


}
