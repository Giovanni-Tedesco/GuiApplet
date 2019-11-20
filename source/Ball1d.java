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

  public void collides(Ball1d other){

    if(this.xPos + 100 < other.xPos || this.xPos > other.xPos + 100){
      System.out.println("Does not collide");
    } else {
      if(other.getVelocity() == 0){
        this.velocity = this.velocity * ((this.mass - other.getMass()) / (this.mass + other.getMass()));
        System.out.println(this.velocity);

        other.setVelocity(this.velocity * ( (2 * this.mass) / (this.mass + other.getMass()) ) );
        System.out.println(other.getVelocity());
      } else if(other.getVelocity() != 0){
        //Elastic Momentum if v2 is greater than 0
        double tempV2 = other.getVelocity() + -other.getVelocity();
        double tempV1 = this.velocity + tempV2;

        this.velocity = tempV1 * ((this.mass - other.getMass()) / (this.mass + other.getMass())) - tempV2;
        other.setVelocity(tempV1 * ( (2 * this.mass) / (this.mass + other.getMass())) - tempV2) ;
      }
    }
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
