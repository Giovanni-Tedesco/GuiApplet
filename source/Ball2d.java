import java.awt.*;
import javax.swing.*;

public class Ball2d {

  double dblXPos;
  double dblYPos;
  double dblDiameter = 20;
  private double dblVx;
  private double dblVy;
  // public int quadrant;
  //Momentum exists as a variable for potential use.
  // private double momentum;
  //Mass is necessary for calculating final velocities
  private double dblMass;

  //Constructor
  /** Creates a 2 dimensional ball object
    *@param dblXPos
    *@param dblYPos
    *@param dblVx
    *@param dblVy
    *@param dblMass
    */
  Ball2d(double dblXPos,double dblYPos,double dblVx,double dblVy, double dblMass) {
    this.dblXPos = dblXPos;
    this.dblYPos = dblXPos;
    this.dblVx = dblVx;
    this.dblVy = dblVy;
  }

  public void update(Graphics g) {

    g.fillOval((int)this.dblXPos, (int)this.dblYPos, (int)dblDiameter, (int)dblDiameter);
    this.dblXPos += this.dblVx;
    this.dblYPos += this.dblVy;

    //Check if the ball has hit a wall
    if(this.dblXPos >= 800 || this.dblXPos <= 0){
      this.dblVx = -this.dblVx;
    }
    if(this.dblYPos >= 380 || this.dblYPos <= 0){
      this.dblVy = -this.dblVy;
    }
    //Set the quadrant of the ball as it moves
  }

  public boolean intersects(Ball2d other){
    //Get the distance between the centers of the two balls
    double dblR1 = this.dblDiameter / 2;
    double dblR2 = other.dblDiameter / 2;
    double dblRadiusSquared = (dblR1 + dblR2) * (dblR1 + dblR2);
    double dblXDistance = (this.dblXPos + dblR1) - (other.dblXPos + dblR2);
    double dblYDistance = (this.dblYPos + dblR1) - (other.dblYPos + dblR2);
    double dblDistSquared = (dblXDistance * dblXDistance) + (dblYDistance * dblYDistance);
    if(dblDistSquared > dblRadiusSquared){
      System.out.println("No Contact");
      return false;
    }
    System.out.println("Contact");
    return true;

  }

  public void collides(Ball2d other){
    this.dblVx = -this.dblVx;
    this.dblVy = -this.dblVy;


    //Time to do actual physics lol
    }

  public double getVx(){
    return this.dblVx;
  }

  public void setVx(double x) {
    this.dblVx = x;
  }

  public double getVy(){
    return this.dblVy;
  }

  public void setVy(double y) {
    this.dblVy = y;
  }

}
