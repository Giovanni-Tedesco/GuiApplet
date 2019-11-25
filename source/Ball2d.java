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
  double dblMass;

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

  /** Update the position of the ball each frame
    *@param g Graphics class used for drawing
    */
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

  /** Checks for intersections between two Ball2d objects
   * @param other Ball2d object that is being checked against
   * @return true if the balls are intersecting and false if the balls are not.
  */
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

  /**
   * @param other Ball2d object that has collided with the ball
   * @return new velocity of ball
  */
  public void collides(Ball2d other){
    //Angle of Deflection
    double dblXSide = Math.abs(this.dblXPos - other.dblXPos);
    double dblYSide = Math.abs(this.dblYPos - other.dblYPos);
    double dblV1 = Math.sqrt((this.dblVx * this.dblVx) + (this.dblVy * this.dblVy));
    double dblV2 = Math.sqrt((other.dblVx * other.dblVx) + (other.dblVy * other.dblVy));
    double dblVAngle = Math.atan(dblYSide/dblXSide);

    double dblTheta1 = Math.atan((other.dblMass * Math.sin(dblVAngle)) /
                                   (this.dblMass + other.dblMass * Math.cos(dblVAngle)));
    double dblTheta2 = (Math.PI - dblVAngle) / 2;


    this.dblVx = ( ((dblV1 * Math.cos(dblTheta1 - dblVAngle) * (this.dblMass - other.dblMass)) +
                 (2 * other.dblMass * dblV2 * Math.cos(dblTheta2 - dblVAngle))) /
                 this.dblMass + other.dblMass) * (Math.cos(dblVAngle) + dblV1 * Math.sin(dblTheta1 - dblVAngle)
                 * Math.cos(dblVAngle - Math.PI / 2));


    this.dblVy = ( ((dblV1 * Math.cos(dblTheta1 - dblVAngle) * (this.dblMass - other.dblMass)) +
                 (2 * other.dblMass * dblV2 * Math.cos(dblTheta2 - dblVAngle))) /
                 this.dblMass + other.dblMass) * (Math.cos(dblVAngle) + dblV1 * Math.sin(dblTheta1 - dblVAngle)
                 * Math.cos(dblVAngle - Math.PI / 2));
    }

  /** Accessor for x velocity
    * @return x velocity of ball
    */
  public double getVx(){
    return this.dblVx;
  }

  /** Mutator for x veloctiy of ball
    * @param dblX
    */
  public void setVx(double dblX) {
    this.dblVx = dblX;
  }

  /** Accessor for y velocity
    * @return y velocity of ball
    */
  public double getVy(){
    return this.dblVy;
  }

  /** Mutator for y veloctiy of ball
    * @param dblY
    */
  public void setVy(double dblY) {
    this.dblVy = dblY;
  }

}
