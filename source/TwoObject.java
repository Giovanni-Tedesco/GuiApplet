import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

// import org.graalvm.compiler.nodes.memory.MemoryCheckpoint.Single;

public class TwoObject implements ActionListener, ChangeListener {

  JFrame frame = new JFrame("Single Object View");
  Timer timer = new Timer(1000/48, this);
  TwoObjectElastic thepanel = new TwoObjectElastic();
  JButton startButton = new JButton("Start");
  JButton resetButton = new JButton("Reset");
  JButton backButton = new JButton("Back");
  JLabel mass1Label = new JLabel("Mass 1");
  JLabel mass2Label = new JLabel("Mass 2");
  JLabel velocity1Label = new JLabel("Velocity 1");
  JLabel velocity2Label = new JLabel("Velocity 2");
  JSlider mass1Slider = new JSlider();
  JSlider mass2Slider = new JSlider();
  JSlider velocity1Slider = new JSlider(-10, 10, 0);
  JSlider velocity2Slider = new JSlider(-10, 10, 0);
  JLabel vel1Label = new JLabel("V1: ");
  JLabel vel2Label = new JLabel("V2: ");
  JLabel momentumLabel = new JLabel("Momenum: ");
  JLabel m1ValueLabel = new JLabel("M1: ");
  JLabel m2ValueLabel =new JLabel("M2: ");

  /** Action Performed Method required by ActionListener
    *@param evt ActionEvent - listens for an action to be performed
    */
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == timer){
      thepanel.repaint();
    }
    if(evt.getSource() == startButton){
       thepanel.blnRunning = true;
    }
    if(evt.getSource() == backButton){
      this.frame.dispose();
      this.frame.setVisible(false);
      MainMenu.changeVisibility(true);

    }
    if(evt.getSource() == resetButton){
      thepanel.blnRunning = false;
      thepanel.ball.dblXPos = 0;
      thepanel.ball2.dblXPos = thepanel.dimensions.getWidth() - 100;
    }
  }


  /** State Changed Method - Needed to check for changes in slider movement
    *@param evt ChangeEvent - Checks for changes to the sliders
    */
  public void stateChanged(ChangeEvent evt){
    timer.stop();
    if(evt.getSource() == mass1Slider){
      thepanel.ball.setMass((double)mass1Slider.getValue());
    }
    if(evt.getSource() == mass2Slider){
      thepanel.ball2.setMass((double)mass2Slider.getValue());
    }
    if(evt.getSource() == velocity1Slider){
      thepanel.ball.setVelocity((double)velocity1Slider.getValue());
    }
    if(evt.getSource() == velocity2Slider){
      thepanel.ball2.setVelocity((double)velocity2Slider.getValue());
    }
    timer.start();
  }

  //Constructor
  /** Two Object View Constructor
    */
  TwoObject(){
    thepanel.setPreferredSize(thepanel.dimensions);
    thepanel.setLayout(null);

    startButton.setSize(new Dimension(100, 50));
    startButton.addActionListener(this);
    thepanel.add(startButton);

    backButton.setSize(new Dimension(100, 50));
    backButton.setLocation(200, 0);
    backButton.addActionListener(this);
    thepanel.add(backButton);

    resetButton.setSize(new Dimension(100, 50));
    resetButton.setLocation(100,0);
    resetButton.addActionListener(this);
    thepanel.add(resetButton);

    vel1Label.setSize(new Dimension(100, 25));
    vel1Label.setLocation(0, 400);
    thepanel.add(vel1Label);

    vel2Label.setSize(new Dimension(100, 25));
    vel2Label.setLocation(100, 400);
    thepanel.add(vel2Label);

    m1ValueLabel.setSize(new Dimension(100, 25));
    m1ValueLabel.setLocation(200, 400);
    thepanel.add(m1ValueLabel);

    m2ValueLabel.setSize(new Dimension(100, 25));
    m2ValueLabel.setLocation(300, 400);
    thepanel.add(m2ValueLabel);

    momentumLabel.setSize(new Dimension(100, 25));
    momentumLabel.setLocation(400, 400);
    thepanel.add(momentumLabel);

    //Mass 1
    mass1Slider.setSize(new Dimension(300, 50));
    mass1Slider.setLocation(0, 200);
    mass1Slider.addChangeListener(this);
    mass1Slider.setMajorTickSpacing(10);
    mass1Slider.setMinorTickSpacing(1);
    mass1Slider.setPaintTicks(true);
    mass1Slider.setPaintLabels(true);
    thepanel.add(mass1Slider);

    mass1Label.setSize(new Dimension(50, 25));
    mass1Label.setLocation(0, 175);
    thepanel.add(mass1Label);

    //Mass 2
    mass2Slider.setSize(new Dimension(300, 50));
    mass2Slider.setLocation(0, 275);
    mass2Slider.addChangeListener(this);
    mass2Slider.setMajorTickSpacing(10);
    mass2Slider.setMinorTickSpacing(1);
    mass2Slider.setPaintTicks(true);
    mass2Slider.setPaintLabels(true);
    thepanel.add(mass2Slider);

    mass2Label.setSize(new Dimension(50, 25));
    mass2Label.setLocation(0, 250);
    thepanel.add(mass2Label);

    //Velocity 1
    velocity1Slider.setSize(new Dimension(300, 50));
    velocity1Slider.setLocation(300, 200);
    velocity1Slider.addChangeListener(this);
    velocity1Slider.setMajorTickSpacing(5);
    velocity1Slider.setMinorTickSpacing(1);
    velocity1Slider.setPaintTicks(true);
    velocity1Slider.setPaintLabels(true);
    thepanel.add(velocity1Slider);

    velocity1Label.setSize(new Dimension(100, 25));
    velocity1Label.setLocation(300, 175);
    thepanel.add(velocity1Label);

    //Velocity 2
    velocity2Slider.setSize(new Dimension(300, 50));
    velocity2Slider.setLocation(300, 275);
    velocity2Slider.addChangeListener(this);
    velocity2Slider.setMajorTickSpacing(5);
    velocity2Slider.setMinorTickSpacing(1);
    velocity2Slider.setPaintTicks(true);
    velocity2Slider.setPaintLabels(true);
    thepanel.add(velocity2Slider);

    velocity2Label.setSize(new Dimension(100, 25));
    velocity2Label.setLocation(300, 250);
    thepanel.add(velocity2Label);

    //Frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(thepanel);
    frame.pack();
    frame.setVisible(false);
    timer.start();
  }

  public static void main(String[] args){
    new TwoObject();
  }
}
