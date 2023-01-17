package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails,checkpakages, bookpakages, viewpakages, viewhotels, bookhotels, viewbookhotels, destinations, payments, calculators, notepad, about;

    Dashboard(String username){
        this.username = username;

    //    setBounds(-5,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel p1 =new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,15,200,35);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2 =new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addPersonalDetails = new JButton("Add personal details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update personal details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,40));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View personal details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,60));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete personal details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkpakages = new JButton("Check Packages");
        checkpakages.setBounds(0,200,300,50);
        checkpakages.setBackground(new Color(0,0,102));
        checkpakages.setForeground(Color.white);
        checkpakages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpakages.setMargin(new Insets(0,0,0,100));
        checkpakages.addActionListener(this);
        p2.add(checkpakages);

        bookpakages = new JButton("Book Packages");
        bookpakages.setBounds(0,250,300,50);
        bookpakages.setBackground(new Color(0,0,102));
        bookpakages.setForeground(Color.white);
        bookpakages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpakages.setMargin(new Insets(0,0,0,105));
        bookpakages.addActionListener(this);
        p2.add(bookpakages);


        viewpakages = new JButton("View Packages");
        viewpakages.setBounds(0,300,300,50);
        viewpakages.setBackground(new Color(0,0,102));
        viewpakages.setForeground(Color.white);
        viewpakages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpakages.setMargin(new Insets(0,0,0,110));
        viewpakages.addActionListener(this);
        p2.add(viewpakages);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,135));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotels = new JButton("Book Hotel");
        bookhotels.setBounds(0,400,300,50);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.white);
        bookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotels.setMargin(new Insets(0,0,0,140));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);

        viewbookhotels = new JButton("View Booked Hotel");
        viewbookhotels.setBounds(0,450,300,50);
        viewbookhotels.setBackground(new Color(0,0,102));
        viewbookhotels.setForeground(Color.white);
        viewbookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookhotels.setMargin(new Insets(0,0,0,70));
        viewbookhotels.addActionListener(this);
        p2.add(viewbookhotels);

        destinations = new JButton("Destination");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,140));
        destinations.addActionListener(this);
        p2.add(destinations);
        payments = new JButton("Payment");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,160));
        payments.addActionListener(this);
        p2.add(payments);

        calculators = new JButton("Calculator");
        calculators.setBounds(0,600,300,50);
        calculators.setBackground(new Color(0,0,102));
        calculators.setForeground(Color.white);
        calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculators.setMargin(new Insets(0,0,0,155));
        calculators.addActionListener(this);
        p2.add(calculators);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,170));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,185));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(380,80,1100,70);
        text.setForeground(Color.white);
        text.setFont(new Font("Tahoma",Font.PLAIN,60));
        image.add(text);

        JLabel wj = new JLabel("Welcome   Your   Happy   Journey!...");
        wj.setBounds(25,752,280,20);
        wj.setForeground(Color.CYAN);
        wj.setFont(new Font("Tahoma",Font.PLAIN,16));
        p2.add(wj);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }else if (ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        }else if (ae.getSource() == checkpakages){
            new CheckPackage(username);
        }else if (ae.getSource() == bookpakages){
            new BookPackage(username);
        }else if(ae.getSource() == viewpakages){
            new ViewPackage(username);
        }else if (ae.getSource() == viewhotels){
           new CheckHotels();
        }else if (ae.getSource() == destinations){
            new Destination();
        }else if (ae.getSource() == bookhotels){
           new BookHotel(username);
        }else if (ae.getSource() == viewbookhotels){
           new ViewBookedHotel(username);
        }else if (ae.getSource() == payments){
           new Payment();
        }else if (ae.getSource() == calculators){
           try {
              Runtime.getRuntime().exec("calc.exe");
           }catch (Exception e){
              e.printStackTrace();
           }
        }else if (ae.getSource() == notepad){
           try {
              Runtime.getRuntime().exec("notepad.exe");
           }catch (Exception e){
              e.printStackTrace();
           }
        }else if (ae.getSource() == deletePersonalDetails){

           new DeleteDetails(username);
        }else {
           new About();
        }
    }
    public static void main(String[] arg){

        new Dashboard("Ankit01");
    }

}
