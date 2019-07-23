package housesimulation;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Drawer extends JPanel{
     //initialize the shapes
    int rectWidth=0;
    int rectHeight=0;
    // rectangle's colors
    int rRect=0;
    int gRect=0;
    int bRect=0;
    // roof's color
    int rRoof=0;
    int gRoof=0;
    int bRoof=0;
    //flowers' color
    int rPetal=0;
    int gPetal=0;
    int bPetal=0;

    //generating the random  heights and widths
  public void lengthWidth(){
      int max = 200;
      int min = 50;
      int length = 0;
      boolean check = true;
      for(;check;){
          length=(int)(Math.random()*1000);
          if(length>=min && length<=max){
              check=false;
          }
      }
      rectWidth=length;
      rectHeight=length*(5/2);    
  }
  
  //generating the random colors
  public Color randomColor(String type){

      int R = (int)(Math.random()*256);
      int G = (int)(Math.random()*256);
      int B= (int)(Math.random()*256);
      
      Color color = new Color(R, G, B);
      if(type.equals("flowers")){
          rPetal=R;
          gPetal=G;
          bPetal=B;
      }
      
      if(type.equals("base")){
          rRect=R;
          gRect=G;
          bRect=B;
      }
      if(type.equals("triangle")){
          rRoof=R;
          gRoof=G;
          bRoof=B;
      } 
      return color;   
  }
  
  //raw the base/rectangle and the roof
  public void paintComponent(Graphics paint){
    super.paintComponent(paint);
    this.setBackground(Color.WHITE);
    //run lengthwidth
    lengthWidth();
    Color base=randomColor("base");
    paint.setColor(base);
    paint.fillRect(200,200,rectHeight,rectWidth);
    
    //draw the roof
    paint.setColor(randomColor("triangle"));
     int x[]={175,225+rectHeight,200+rectHeight/2};
     int y[]={200,200,150-(rectWidth/2)};
     Polygon p=new Polygon(x,y,3);
     paint.fillPolygon(p);
     
    //write the text to display the simulation details
   paint.setColor(Color.black);
   paint.drawString("DETAILS OF THE SIMULATED HOUSE AND FLOWERS:",40,10);
   paint.drawString("The base length of the house is: " +rectWidth,40,35);
   paint.drawString("The height of the house is: "+rectHeight,40,50);
   paint.drawString("The body's color is : RGB("+rRect+","+gRect+","+bRect+")",40,65);
   paint.drawString("The roof's color is : RGB("+rRoof+","+gRoof+","+bRoof+")",40,80);
   paint.drawString("The flower petals' color is :  RGB("+rPetal+","+gPetal+","+bPetal+")",40,95);
   
   
    //flowers
    Color petal=randomColor("flowers"); 
    //loop to draw more flowers
    for(int space=0;space<=600;){
           
         Graphics2D g2 = (Graphics2D) paint;

    // Drawer the GREEN stem.
    g2.setStroke(
        new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g2.setColor(new Color(0, 128, 0));  // green
    g2.drawLine(toScreenX(100+space), toScreenY(600), toScreenX(100+space), toScreenY(550));

    // Drawer the ORANGE center.
    g2.setColor(new Color(255, 165, 0));  // orange
    g2.fillOval(toScreenX(85+space), toScreenY(540), toScreenX(30), toScreenY(30));

    // Drawer eight petals at N, NE, E, SE, S, SW, W, NW positions on the center.
    int petalWidth = toScreenX(20);
    int petalHeight = toScreenY(20);
    g2.setColor(petal); 
    
    g2.fillOval(toScreenX(90+space), toScreenY(520), petalWidth, petalHeight);
    g2.fillOval(toScreenX(90+space), toScreenY(570), petalWidth, petalHeight);
    g2.fillOval(toScreenX(64+space), toScreenY(550), petalWidth, petalHeight);
    g2.fillOval(toScreenX(115+space), toScreenY(550), petalWidth, petalHeight);
    g2.fillOval(toScreenX(108+space), toScreenY(568), petalWidth, petalHeight);
    g2.fillOval(toScreenX(108+space), toScreenY(532), petalWidth, petalHeight);
    g2.fillOval(toScreenX(72+space), toScreenY(568), petalWidth, petalHeight);
    g2.fillOval(toScreenX(72+space), toScreenY(532), petalWidth, petalHeight);
    
    space+=100;   
    }
    }
    
    //Converts an x-coordinate from a 200-rectWidth screen to the actual rectWidth
  private int toScreenX(int x) {
//return Math.round(x * getWidth() / 200f);
      return x;
  }

  //Converts an y-coordinate from a 200-rectWidth screen to the actual rectWidth
  private int toScreenY(int y) {
//return Math.round(y * getHeight() / 200f);
      return y;
  }    
}
