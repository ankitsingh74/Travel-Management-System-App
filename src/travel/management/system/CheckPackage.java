package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CheckPackage extends JFrame  {


  JTabbedPane tab;
 String username;

    CheckPackage(String username){
      this.username = username;
        setBounds(450,200,900,600);
//        getContentPane().setBackground(Color.WHITE);//not required because of panel
      String[] package1 ={"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Soft Drink", "Full Day 3 Island Cruise", "English Speaking Guide", "Book Now", "Summer Special", "Rs 12000/- ", "package1.jpg"};
      String[] package2 ={"SILVER PACKAGE", "5 Days and 6 Nights", "Toll Free", "Entrance Free Tickets", "Meet and Greet and Airport", "Welcome Drink on Arrival", "Night Safari", "Cruise with Dinner", "Book Now", "Winter Special", "Rs 24000/- ", "package2.jpg"};
      String[] package3 ={"BRONZE PACKAGE", "6 Days and 5 Nights", "Return Airfare", "Free Clubbing", "Horse Riding & other Games", "Hard Drink Free", "Daily Buffet", "BBQ Dinner", "Book Now", "Monsoon Special", "Rs 32000/- ", "package3.jpg"};
       tab = new JTabbedPane();

      JPanel p1 = createpackage(package1);
      tab.addTab("Package 1", null, p1);

      JPanel p2 = createpackage(package2);
      tab.addTab("Package 2", null, p2);

      JPanel p3 = createpackage(package3);
      tab.addTab("Package 3", null, p3);
      add(tab);


        setVisible(true);
    }

    public JPanel createpackage(String[] pack){



      JPanel p1 = new JPanel();
      //   p1.setBounds(0,20,900,540);
      p1.setBackground(Color.white);
      p1.setLayout(null);
//      add(p1);

      JLabel l1 = new JLabel(pack[0]);
      l1.setBounds(50, 5, 300,30);
      l1.setFont(new Font("Tahoma",Font.BOLD, 30));
      l1.setForeground(new Color(150,130,0));
      p1.add(l1);

      JLabel l2 = new JLabel(pack[1]);
      l2.setBounds(50, 55, 300,30);
      l2.setFont(new Font("Tahoma",Font.BOLD, 20));
      l2.setForeground(Color.red);
      p1.add(l2);

      JLabel l3 = new JLabel(pack[2]);
      l3.setBounds(50, 105, 300,30);
      l3.setFont(new Font("Tahoma",Font.BOLD, 20));
      l3.setForeground(Color.blue);
      p1.add(l3);

      JLabel l4 = new JLabel(pack[3]);
      l4.setBounds(50, 155, 300,30);
      l4.setFont(new Font("Tahoma",Font.BOLD, 20));
      l4.setForeground(Color.red);
      p1.add(l4);

      JLabel l5 = new JLabel(pack[4]);
      l5.setBounds(50, 205, 300,30);
      l5.setFont(new Font("Tahoma",Font.BOLD, 20));
      l5.setForeground(Color.blue);
      p1.add(l5);

      JLabel l6 = new JLabel(pack[5]);
      l6.setBounds(50, 255, 300,30);
      l6.setFont(new Font("Tahoma",Font.BOLD, 20));
      l6.setForeground(Color.red);
      p1.add(l6);

      JLabel l7 = new JLabel(pack[6]);
      l7.setBounds(50, 305, 300,30);
      l7.setFont(new Font("Tahoma",Font.BOLD, 20));
      l7.setForeground(Color.blue);
      p1.add(l7);

      JLabel l8 = new JLabel(pack[7]);
      l8.setBounds(50, 355, 300,30);
      l8.setFont(new Font("Tahoma",Font.BOLD, 20));
      l8.setForeground(Color.red);
      p1.add(l8);

      JLabel l9 = new JLabel(pack[8]);
      l9.setBounds(50, 435, 300,30);
      l9.setFont(new Font("Tahoma",Font.BOLD, 25));
      l9.setForeground(new Color(150,0,250));
      p1.add(l9);

      JLabel l10 = new JLabel(pack[9]);
      l10.setBounds(50, 470, 300,30);
      l10.setFont(new Font("Tahoma",Font.BOLD, 18));
      l10.setForeground(Color.orange.darker());
      p1.add(l10);

      JLabel l11 = new JLabel(pack[10]);
      l11.setBounds(530, 430, 300,30);
      l11.setFont(new Font("Tahoma",Font.BOLD, 25));
      l11.setForeground(Color.cyan);
      p1.add(l11);

      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
      Image i5 = i4.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
      ImageIcon i6 = new ImageIcon(i5);
      JLabel image = new JLabel(i6);
      image.setBounds(350,20,500,300);
      p1.add(image);

      return p1;
    }
    public static void main(String[] args) {
        new CheckPackage("Ankit01");
    }


}
