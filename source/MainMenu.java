import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MainMenu implements ActionListener{

  static JFrame theframe = new JFrame("Momentum App");
  JPanel thepanel = new JPanel();
  JButton aboutButton = new JButton("About");
  JButton multiObjButton = new JButton("Multi-Object Collisions");
  JButton singleObjectButton = new JButton("Single Oject Collisions");
  JButton quizButton = new JButton("Quiz");

  /**Implements the actionPerformed function from the ActionListener Class
    * @param evt ActionEvent to listen for event changes in the pane
    */
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == aboutButton){
      System.out.println("Pressed About Button");
    }
    if(evt.getSource() == multiObjButton){
      System.out.println("Pressed Multi Button");
      MultiObjectView multiObj = new MultiObjectView();
      multiObj.theframe.setVisible(true);
      this.theframe.setVisible(false); 
    }
    if(evt.getSource() == singleObjectButton){
      System.out.println("Pressed Single-Object Button");
      TwoObject singObj = new TwoObject();
      singObj.frame.setVisible(true);
      this.theframe.setVisible(false);
    }
    if(evt.getSource() == quizButton){
      System.out.println("Quiz Button");
    }


  }
  //Constructor
  /**Constructs Main Menu
    */
  MainMenu() {
    thepanel.setLayout(null);
    thepanel.setPreferredSize(new Dimension(960, 540));

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

    quizButton.setSize(new Dimension(200, 70));
    quizButton.setLocation(200, 100);
    quizButton.addActionListener(this);
    thepanel.add(quizButton);

    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    theframe.setVisible(true);
  }

  public static void changeVisibility(boolean blnState) {
    theframe.setVisible(blnState);
  }

  public static void main(String[] args){

    new MainMenu();

  }

}
