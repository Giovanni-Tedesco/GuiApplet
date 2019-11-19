import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SingleObject implements ActionListener {

  JFrame frame = new JFrame("Single Object View");
  Timer timer = new Timer(1000/60, this);
  AnimateSingleObj thepanel = new AnimateSingleObj();

  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == timer){
      thepanel.repaint();
    }
  }

  SingleObject(){
    thepanel.setPreferredSize(thepanel.dimensions);
    thepanel.setLayout(null);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(thepanel);
    frame.pack();
    frame.setVisible(true);
    timer.start();
  }

  public static void main(String[] args){
    new SingleObject();
  }


}
