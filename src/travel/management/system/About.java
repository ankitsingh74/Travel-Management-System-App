package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    About(){
        setBounds(600,200,500,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(20,50,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(l1);

        String s = "The Objective of the Travel and Tourism Management System Project is to develop a system which manage all data of customer automatically"+
                "Travel is the movement of people between distant geographical locations. Travel can be done by foot, bicycle, automobile, train, boat, bus, airplane, ship or other means, with or without luggage, and can be one way or round trip.\n" +
                " Travel can also include relatively short stays between successive movements, as in the case of tourism.\n" +
                "The origin of the word \"travel\" is most likely lost to history. The term \"travel\" may originate from the Old French word travail,\n" +
                " which means 'work'. According to the Merriam-Webster dictionary, the first known use of the word travel was in the 14th century.\n" +
                " It also states that the word comes from Middle English travailen, travelen (which means to torment, labor, strive, journey) and earlier from Old French travailler (which means to work strenuously, toil).\n" +
                "In English, people still occasionally use the words travail, which means struggle. According to Simon Winchester in his book The Best Travelers' Tales (2004), the words travel and travail both share an even more ancient root:\n" +
                " a Roman instrument of torture called the tripalium (in Latin it means \"three stakes\", as in to impale).[citation needed] This link may reflect the extreme difficulty of travel in ancient times.\n" +
                " Travel in modern times may or may not be much easier, depending upon the destination. Travel to Mount Everest, the Amazon rainforest, extreme tourism, and adventure travel are more difficult forms of travel.\n" +
                " Travel can also be more difficult depending on the method of travel, such as by bus, cruise ship, or even by bullock cart.";

        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);


        JButton   back = new JButton("Back");
        back.setBounds(300, 420, 80, 40);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
    public static void main(String[] args) {
        new About();
    }


}
