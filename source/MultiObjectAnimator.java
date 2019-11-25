import java.awt.*;
import javax.swing.*;

public class MultiObjectAnimator extends JLabel{
  //Properies
  int dblWidth = 800;
  int dblHeight = 400;
  Dimension dim = new Dimension(dblWidth, dblHeight);
  Ball2d[] balls = new Ball2d[10];

  /** Initialize the array of Ball2d Objects
    * @param balls[] Array of Ball2d Objects
    */
  private void initBalls(Ball2d[] balls){
    for(int i = 0; i < balls.length; i++){
      int intRandX = (int)(Math.random() * 800);
      // System.out.println(intRandX);
      int intRandY = (int)(Math.random() * 400);
      // System.out.println(intRandY);
      balls[i] = new Ball2d(intRandX, intRandY, 4, 4, 100);
    }
  }
  /** Overrides the paintComponent of the JPanel class
    * @param g Graphics Object used for painting
    */
  @Override
  public void paintComponent(Graphics g) {
    //
    // g.drawLine(0, dblHeight / 2, dblWidth, dblHeight / 2);
    // g.drawLine(dblWidth/2, 0, dblWidth/2, dblHeight);

    for(int i = 0; i < balls.length; i++){
      for(int j = i + 1; j < balls.length; j++){
        if(balls[i].intersects(balls[j]) == true){
          // System.out.println("LOL");
          balls[i].collides(balls[j]);
          // balls[j].collides(balls[i]);
          // balls[j].collides(balls[i]);
        }
      }
      balls[i].update(g);
    }
  }

  //Constructor
  /**Constructs the Animator Class
  */
  MultiObjectAnimator() {
    super();
    initBalls(balls);
    // balls[0] = new Ball2d(dblHeight / 2, 0, 1, 0, 100);
    // balls[1] = new Ball2d(dblHeight / 2, 700, -1, 0, 100);
  }
}
