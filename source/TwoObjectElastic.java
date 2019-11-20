import java.awt.*;
import javax.swing.*;

public class TwoObjectElastic extends JPanel {

  int width = 800;
  int height = 350;
  Ball1d ball = new Ball1d(10, 2.4, width);
  Ball1d ball2 = new Ball1d(0, 3.6, width/2, width);
  Dimension dimensions = new Dimension(width, height);
  boolean running = false;

  public void paintComponent(Graphics g){
    g.drawLine(0, 150, width, 150);

    if(running){
      g.setColor(Color.BLUE);
      ball.update(g);
      g.setColor(Color.RED);
      ball2.update(g);
      if(ball.collides(ball2)){
        double v1 = ball.bounce(ball2);
        double v2 = ball2.bounce(ball);

        ball.setVelocity(v1);
        ball2.setVelocity(v2);


      }
    } else {
      g.setColor(Color.BLUE);
      g.fillOval((int)ball.xPos, 50, 100, 100);
      g.setColor(Color.RED);
      g.fillOval((int)ball2.xPos, 50, 100, 100);
    }
  }

  TwoObjectElastic() {
    super();
  }

}
