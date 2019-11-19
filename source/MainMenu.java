import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MainMenu implements ActionListener{

  JFrame theframe = new JFrame("Momentum App");
  JPanel thepanel = new JPanel();
  JButton aboutButton = new JButton("About");
  JButton multiObjButton = new JButton("Multi-Object Collisions");
  JButton singleObjectButton = new JButton("Single Oject Collisions");
  JButton twoObjectElastic = new JButton("Two Object Elastic Collisions");

  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == aboutButton){
      System.out.println("Pressed About Button");
    }
    if(evt.getSource() == multiObjButton){
      System.out.println("Pressed Multi Button");
    }
    if(evt.getSource() == singleObjectButton){
      System.out.println("Pressed Single-Object Button");
    }
    if(evt.getSource() == twoObjectElastic){
      System.out.println("Pressed Two-Object Button");
    }


  }
  //Constructor
  MainMenu() {
    thepanel.setLayout(null);
    thepanel.setPreferredSize(new Dimension(400, 170));

    aboutButton.setSize(new Dimension(200, 70));
    aboutButton.setLocation(0, 0);
    aboutButton.addActionListener(this);
    thepanel.add(aboutButton);

    multiObjButton.setSize(new Dimension(200, 70));
    multiObjButton.setLocation(200, 0);
    multiObjButton.addActionListener(this);
    thepanel.add(multiObjButton);

    singleObjectButton.setSize(new Dimension(200, 70));
    singleObjectButton.setLocation(0, 100);
    singleObjectButton.addActionListener(this);
    thepanel.add(singleObjectButton);

    twoObjectElastic.setSize(new Dimension(200, 70));
    twoObjectElastic.setLocation(200, 100);
    twoObjectElastic.addActionListener(this);
    thepanel.add(twoObjectElastic);

    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    theframe.setVisible(true);
  }

  public static void main(String[] args){

    new MainMenu();

  }

}
