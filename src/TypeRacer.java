import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.Duration;
import java.time.LocalTime;

public class TypeRacer {

    public static void main(String[] args) {


        JFrame  f = new JFrame("TypeRacer");
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
//        ta.setWrapStyleWord(true);
        ta.setBounds(50 ,75 ,300 , 200 );

        JLabel l = new JLabel();
        l.setBounds(50 , 20, 100, 30 );
        JLabel l1 = new JLabel();
        l1.setBounds(180 , 15, 100, 30 );
        JLabel l3 = new JLabel();
        l3.setBounds(50 , 40, 200, 30 );
        JLabel l4 = new JLabel();
        l4.setBounds(180 , 40, 200, 30 );

        JButton b = new JButton("start");
        JButton b1 = new JButton("stop");
        b.setBounds(50, 300 , 90, 30);
        b1.setBounds(150, 300 , 90, 30);


        final LocalTime[] timeMeStart = {null}; // Java, when you use a local variable inside an anonymous inner class, it needs to be either final or effectively final.
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                  timeMeStart[0] = LocalTime.now();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String texts = ta.getText();
             String words[] = texts.split( "\\s");
             l.setText( "charachters : " + texts.length());
                l1.setText( "words : " + words.length);

                   if (timeMeStart[0] != null){
                       LocalTime timeMeStop = LocalTime.now();
                       Duration duration = Duration.between(timeMeStart[0], timeMeStop) ;

                       long seconds = duration.getSeconds();
                       double minutes = seconds/60;

                       double rate = words.length / seconds;
                       int rateInt = (int) rate;

                       l3.setText( "Time: " + seconds + "sec");
//                       l4.setText( "Speed:" + rateInt + "Wrds/sec" );
                   } else {
                       l3.setText( "Time : N/A" );
//                       l4.setText( "Speed: N/A"  );
                   }

             }
        });
        f.setSize(450 , 450);
        f.add(ta) ; f.add(l) ; f.add(l3); f.add(b); f.add(b1); f.add(l1); f.add(l4);
      f.setLayout(null);
      f.setVisible(true);

    }
}


