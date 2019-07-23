package housesimulation;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
       
        JFrame frame=new JFrame("HOUSE SIMULATION");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,650);
        Drawer house=new Drawer();
        frame.add(house);
        frame.setVisible(true);
    }   
}
