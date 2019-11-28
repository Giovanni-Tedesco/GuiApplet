import java.awt.*;
import javax.swing.*;

public class TwoObjectElastic extends JPanel {

  int dblWidth = 960;
  int dblHeight = 540;
  Ball1d ball = new Ball1d(0, 50, dblWidth);
  Ball1d ball2 = new Ball1d(0, 50, dblWidth/2, dblWidth);
  Dimension dimensions = new Dimension(dblWidth, dblHeight);
  boolean blnRunning = false;

  /** Overrided painComponent from JPanel
    *@param g Graphics object - used for painting
    */
  public void paintComponent(Graphics g){
    g.drawLine(0, 150, dblWidth, 150);

    if(blnRunning){
      g.setColor(Color.BLUE);
      ball.update(g);
      g.setColor(Color.RED);
      ball2.update(g);
      if(ball.collides(ball2)){
        double dblV1 = ball.bounce(ball2);
        double dblV2 = ball2.bounce(ball);

        ball.setVelocity(dblV1);
        ball2.setVelocity(dblV2);


      }
    } else {
      g.setColor(Color.BLUE);
      g.fillOval((int)ball.dblXPos, 50, 100, 100);
      g.setColor(Color.RED);
      g.fillOval((int)ball2.dblXPos, 50, 100, 100);
    }
  }

  /**Constructor for the Two Object Animation Class
    */
  TwoObjectElastic() {
    super();
  }

}
