import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MultiObjectView implements ActionListener {
  JFrame theframe = new JFrame("Multi-Balls");
  MultiObjectAnimator thepanel = new MultiObjectAnimator();
  JButton startButton = new JButton("Start");
  Timer timer = new Timer(1000/48, this);

  /** Implements the actionPerformed function from the ActionListener class
    * @param evt ActionEvent used to listen for events
    */
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == timer){
      thepanel.repaint();
    }
  }

  //Constructor
  /** Constructs the MultiObjectView
  */
  MultiObjectView() {
    thepanel.setPreferredSize(new Dimension(800, 400));
    thepanel.setLayout(null);

    startButton.setSize(new Dimension(100, 50));
    startButton.setLocation(0, 0);
    startButton.addActionListener(this);
    thepanel.add(startButton);

    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    theframe.setVisible(true);
    timer.start();

  }

  public static void main(String[] args){

    new MultiObjectView();

  }

}
