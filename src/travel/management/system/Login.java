package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfusername;
    JPasswordField  tfpassword;

    Login(){
        setSize(900, 400);
        setLocation(350,200);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new  JLabel(i3);
        image.setBounds(100,80,200,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,15,100,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60,50,300,30);
        tfusername.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,95,100,25);
        lblpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblpassword);

        tfpassword = new JPasswordField();//.................................may issue arises here during login
        tfpassword.setBounds(60,130,300,30);
        tfpassword.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60,190,100,30);
       // login.setFont(new Font("Raleway",Font.BOLD,16));//use for Login text modification
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.white);
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(260,190,100,30);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forgot Password");
        password.setBounds(135,240,150,30);
        password.setBorder(new LineBorder(new Color(133,193,233)));
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.white);
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in Login...");
        text.setForeground(Color.red);//setForeground used for text color change
        text.setBounds(300,240,150,30);
        p2.add(text);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String username = tfusername.getText();
        String pass = tfpassword.getText();


        if (ae.getSource() == login){

            if (username.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Your Username");
            }else if (pass.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Your Password");
            }else {
               try {
                   String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                   Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery(query);

                 if (rs.next()){
                     setVisible(false);
                     new Loading(username);
                 }else {
                     JOptionPane.showMessageDialog(null,"Incorrect Username and Password");
                 }

               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        }else if (ae.getSource() == signup){
            setVisible(false);
            new Signup();
        }else {
            setVisible(false);
            new ForgotPassword();
        }
    }

    public static void main(String[] args) {
        new Login();//it is called anonymous object
    }


}
