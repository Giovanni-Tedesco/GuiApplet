import java.awt.*;
import javax.swing.*;

public class MultiObjectAnimator extends JLabel{

  //Properies
  Ball2d[] balls = new Ball2d[10];

  private void initBalls(Ball2d[] balls){
    for(int i = 0; i < balls.length; i++){
      int randX = (int)(Math.random() * 800);
      // System.out.println(randX);
      int randY = (int)(Math.random() * 400);
      // System.out.println(randY);
      balls[i] = new Ball2d(randX, randY, 10, 10, 100);
    }
  }

  public void paintComponent(Graphics g) {
    for(Ball2d ball: balls){
      ball.update(g);
    }

  }

  MultiObjectAnimator() {
    super();
    initBalls(balls);
  }
}
