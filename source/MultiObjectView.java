import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MultiObjectView implements ActionListener {
  JFrame theframe = new JFrame("Multi-Balls");
  MultiObjectAnimator thepanel = new MultiObjectAnimator();
  JButton startButton = new JButton("Start");
  JButton backButton = new JButton("Back");
  Timer timer = new Timer(1000/48, this);

  /** Implements the actionPerformed function from the ActionListener class
    * @param evt ActionEvent used to listen for events
    */
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == timer){
      thepanel.repaint();
    }
    if(evt.getSource() == backButton){
      theframe.dispose();
      theframe.setVisible(false);
      MainMenu.changeVisibility(true);
    }
  }

  //Constructor
  /** Constructs the MultiObjectView
  */
  MultiObjectView() {
    thepanel.setPreferredSize(thepanel.dim);
    thepanel.setLayout(null);

    backButton.setSize(100, 50);
    backButton.setLocation(0, 0);
    backButton.addActionListener(this);
    thepanel.add(backButton);

    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    theframe.setVisible(false);
    timer.start();

  }

  public static void main(String[] args){

    new MultiObjectView();

  }

}
