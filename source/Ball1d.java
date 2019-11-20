import java.awt.*;
import javax.swing.*;

public class Ball1d {
  //Note this has to be signed
  private double velocity;
  private double mass;
  private double momentum;
  //Default to 0
  public double xPos = 0;
  private int bounds;


  //Generally Blue Ball
  Ball1d(double velocity, double mass, int width){
    this.velocity = velocity;
    this.mass = mass;
    this.bounds = width;
  }

  //Generally Red ball
  Ball1d(double velocity, double mass, double xPos, int width){
    this.velocity = velocity;
    this.mass = mass;
    this.momentum = momentum;
    this.xPos = xPos;
    this.bounds = width;

  }
  //Utility Functions
  public void update(Graphics g) {

    g.fillOval((int)xPos, 50, 100, 100);
    this.xPos += this.velocity;

    if(this.xPos <= 0 || this.xPos >= this.bounds - 100){
      this.velocity = -this.velocity;
    }
  }

  public boolean collides(Ball1d other){

    return !(this.xPos + 100 < other.xPos || this.xPos > other.xPos + 100);
  }

  public double bounce(Ball1d other){
    double sumMass = this.mass + other.getMass();
    double newV = (this.mass - other.getMass()) / sumMass * this.velocity;
    newV += (2 * other.getMass() / sumMass) * other.getVelocity();

    return newV;


  }

  //Accessors and Mutators
  public double getXPos() {

    return this.xPos;

  }

  public double getVelocity() {
    return this.velocity;
  }

  public double getMass() {
    return this.mass;
  }

  public double calculateMomentum() {
    return this.mass * this.velocity;
  }

  public void setVelocity(double velocity){
    this.velocity = velocity;
  }
  public void setMass(double mass){
    this.mass = mass;
  }

}
