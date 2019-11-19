import java.awt.*;
import javax.swing.*;

public class AnimateSingleObj extends JPanel {

  int width = 800;
  int height = 800;
  Ball1d ball = new Ball1d(3, 1000, width);
  Ball1d ball2 = new Ball1d(-3, 100, width - 100, width);
  Dimension dimensions = new Dimension(width, height);

  public void paintComponent(Graphics g){

    g.setColor(Color.BLUE);
    ball.update(g);
    g.setColor(Color.RED);
    ball2.update(g);

    ball.collides(ball2);
  }

  AnimateSingleObj() {
    super();
  }

}
