import java.awt.*;
import javax.swing.*;

public class TwoObjectElastic extends JPanel {

  int width = 800;
  int height = 800;
  Ball1d ball = new Ball1d(5.5, 100, width);
  Ball1d ball2 = new Ball1d(-5, 100, width - 100, width);
  Dimension dimensions = new Dimension(width, height);

  public void paintComponent(Graphics g){

    g.drawLine(0, 150, width, 150);

    g.setColor(Color.BLUE);
    ball.update(g);
    g.setColor(Color.RED);
    ball2.update(g);

    ball.collides(ball2);
  }

  TwoObjectElastic() {
    super();
  }

}
