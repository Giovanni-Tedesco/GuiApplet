import java.awt.*;
import javax.swing.*;

public class Ball1d {

  private double dblVelocity; //Note this has to be signed
  private double dblMass;
  public double dblXPos = 0; //Default to 0
  private int intBounds;

  //Constructors
  /** Creates a one dimensionsal ball with a preset x_position
    *@param dblVelocity initial velocity of the ball
    *@param dblMass initial mass of the ball
    *@param intWidth width of the ball
    */
  Ball1d(double dblVelocity, double dblMass, int intWidth){
    this.dblVelocity = dblVelocity;
    this.dblMass = dblMass;
    this.intBounds = intWidth;
  }

  /** Creates a one dimensional ball with a changable xPosition
    *@param dblVelocity initial velocity of the ball
    *@param dblMass initial mass of the ball
    *@param dblXPos initial x position of the ball
    *@param intWidth initial width of the ball
    */
  Ball1d(double dblVelocity, double dblMass, double dblXPos, int intWidth){
    this.dblVelocity = dblVelocity;
    this.dblMass = dblMass;
    this.dblXPos = dblXPos;
    this.intBounds = intWidth;

  }
  //Utility Functions

  /** Updates the position of the ball each frame
    * @param g Graphics object used for drawing
    */
  public void update(Graphics g) {

    g.fillOval((int)dblXPos, 50, 100, 100);
    this.dblXPos += this.dblVelocity;

    if(this.dblXPos <= 0 || this.dblXPos >= this.intBounds - 100){
      this.dblVelocity = -this.dblVelocity;
    }
  }

  /** Checks for collision between two balls
    *@param other Ball1d object
    *@return boolean to tell whether the ball has collided or not
    */
  public boolean collides(Ball1d other){

    return !(this.dblXPos + 100 < other.dblXPos || this.dblXPos > other.dblXPos + 100);
  }


  /** Returns the new velocity of the balls after collision
    *@param other Ball1d object
    *@return new velocity of ball
    */
  public double bounce(Ball1d other){
    double dblSumMass = this.dblMass + other.getMass();
    double dblNewV = (this.dblMass - other.getMass()) / dblSumMass * this.dblVelocity;
    dblNewV += (2 * other.getMass() / dblSumMass) * other.getVelocity();

    return dblNewV;


  }

  //Accessors and Mutators

  /**X Position accessor
    *@return ball xPosition
    */
  public double getXPos() {

    return this.dblXPos;

  }

  /** Velocity accessors
    * @return ball velocity
    */
  public double getVelocity() {
    return this.dblVelocity;
  }

  /** Mass Accessor
    * @return ball mass
    */
  public double getMass() {
    return this.dblMass;
  }

  /** Velocity mutator
    *@param dblVelocity new velocity of Ball
    */
  public void setVelocity(double dblVelocity){
    this.dblVelocity = dblVelocity;
  }

  /** Mass mutator
    *@param dblMass new mass of Ball
    */
  public void setMass(double dblMass){
    this.dblMass = dblMass;
  }

}
