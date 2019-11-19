import java.awt.*;
import javax.swing.*;

public class TwoObjectElastic extends JPanel {

  int width = 800;
  int height = 800;
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
      ball.collides(ball2);
    }
  }

  TwoObjectElastic() {
    super();
  }

}
