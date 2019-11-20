import java.awt.*;
import javax.swing.*;

public class Ball2d {

  double xPos;
  double yPos;
  private double vX;
  private double vY;
  private double momentum;
  private double mass;

  Ball2d(double xPos,double yPos,double vX,double vY, double mass) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.vX = vX;
    this.vY = vY;
  }
  public void setData(double xPos,double yPos,double vX,double vY, double mass) {
      this.xPos = xPos;
      this.yPos = yPos;
      this.vX = vX;
      this.vY = vY;
      this.mass = mass;
    }
  public void update(Graphics g) {

    g.fillOval((int)this.xPos, (int)this.yPos, 20, 20);
    this.xPos += this.vX;
    this.yPos += this.vY;

    if(this.xPos >= 800 || this.xPos <= 0){
      this.vX = -this.vX;
    }
    if(this.yPos >= 380 || this.yPos <= 0){
      this.vY = -this.vY;
    }

  }
}
