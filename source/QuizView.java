import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.event.*;

public class QuizView implements ActionListener {
    
    JFrame frame = new JFrame("Quiz");
    JPanel panel = new JPanel();
    JButton sendButton = new JButton("Send");
    Question[] questionsRepo = QuestionsRepository.loadRepo();
    ArrayList<JLabel> questionsLabels = new ArrayList<JLabel>();
    ArrayList<ButtonGroup> buttonGroups = new ArrayList<ButtonGroup>();


    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == sendButton){
            System.out.println(checkAnswers());
        }

    } 

    public ButtonGroup createButtons(Question question, int intYPosition) {
        int x = 0;
        JRadioButton firstButton = new JRadioButton();
        ButtonGroup ret = new ButtonGroup();
        for(String ans : question.allAnswers){
            JRadioButton temp = new JRadioButton(ans);
            if(x == 0){
                firstButton = temp;
            }
            temp.setLocation(x, intYPosition + 20);
            temp.setSize(new Dimension(150, 25));
            temp.setActionCommand(ans);
            panel.add(temp);
            ret.add(temp);
            x += 150;

        }
        ret.setSelected(firstButton.getModel(), true);
        
        return ret;
    }

    public void createQuestions() {
        int intY = 0;
        for(Question q: questionsRepo) {
            ButtonGroup bGroup;
            JLabel temp = new JLabel(q.strQuestion);
            temp.setSize(900, 25);
            temp.setLocation(0, intY);
            
            panel.add(temp);
            bGroup = createButtons(q, intY);
            intY += 50;
            buttonGroups.add(bGroup);
        }

    };

    public int checkAnswers() {
        int intX = 0;
        int intScore = 0;
        for(ButtonGroup b : buttonGroups){
            if(b.getSelection().getActionCommand().equalsIgnoreCase(questionsRepo[intX].strCorrectAnswer)){
                intScore++;
            }
            intX++;
        }

        return intScore;
    }

    QuizView() {
        panel.setPreferredSize(new Dimension(960, 540));
        panel.setLayout(null);

        sendButton.setSize(new Dimension(100, 50));
        sendButton.setLocation(0, 450);
        sendButton.addActionListener(this);
        panel.add(sendButton);


        createQuestions();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args){
        new QuizView();
    }
}