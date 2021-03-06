/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */

//import org.apache.derby.jdbc.*;
//import sun.jdbc.odbc.JdbcOdbcDriver;

public class PresentationGUI extends JFrame implements ActionListener
{
    //DECLARE THE ELEMENTS OR OBJECTS THAT YOU WILL PUT IN YOUR FRAME
    //NOTICE HOW A PANEL IS CREATED FOR EACH ONE THIS WILL MAKE IT EASIER BUILD
   
    public JLabel teamLabel;
    private JComboBox teamComboBox;
    public JComboBox imagesComboBox;
    private JPanel teamPanel;
    private JPanel q1Panel;
    private JLabel question1;
    private JSlider q1Slider;
    private Hashtable grades;
    private JPanel q2Panel;
    private JLabel question2;
    private JSlider q2Slider;
    private JPanel q3Panel;
    private JLabel question3;
    private JSlider q3Slider;
    private JPanel q4Panel;
    private JLabel question4;
    private JSlider q4Slider;
    private JPanel commentPanel;
    private JLabel commentLabel;
    private JTextArea commentTextArea;
    private JPanel calcAvgPanel;
    private JLabel computedLabel;
    private JTextArea avgTextArea;
    private JButton calcAvgButton;
    private JPanel buttonPanel;
    private JButton submitButton;
    private JButton clearButton;
   
   //these are fields that will be used to hold the values pulled from the interface
    int q1;
    int q2;
    int q3;
    int q4;
    String comments;
    double teamAvg;
        
    // instance variables used to manipulate database
//   private Connection con;
//   private Statement stmt;
//   private ResultSet rs;
           
   //MAIN METHOD: NOTICE WE TAKE IN THE ARGUMENTS THAT ARE
   //PASSED IN AND INSTANTIATE OUR CLASS WITH THEM
    public static void main(String args[])
    {
         // create new PresentationGUI
         PresentationGUI eval = new PresentationGUI();
         eval.createUserInterface();
         eval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    private void createUserInterface()
    {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();       
      contentPane.setLayout(null);
      
      // INSTRUCTOR COMBO BOX SET UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      // set up Instructor Panel
      
      // enable explicit positioning of GUI components
      
      teamPanel = new JPanel();
      teamPanel.setBounds(40, 20, 400, 48);
      teamPanel.setLayout(null);
      contentPane.add(teamPanel);

      // set up Instructor Label
      teamLabel = new JLabel();
      teamLabel.setBounds(25, 15, 100, 20);
      teamLabel.setText("TEAMS");
      teamPanel.add(teamLabel);

      // set up accountNumberJComboBox
      teamComboBox = new JComboBox();
      teamComboBox.setBounds(130, 15, 265, 25);
      teamComboBox.addItem("");
      teamComboBox.addItem("Team 1");
      teamComboBox.addItem("Team 2");
      teamComboBox.addItem("Team 3");
      teamComboBox.addItem("Team 4");
      teamComboBox.addItem("Team 5");
      teamComboBox.addItem("Team 6");
      teamComboBox.addItem("Team 7");
      teamComboBox.addItem("Team 8");
      teamComboBox.setSelectedIndex(0);
      teamPanel.add(teamComboBox); 
      contentPane.add(teamPanel);
      
      buildDictionary();
      
      q1Panel = new JPanel();
      q1Panel.setBounds(40, 70, 400, 60);
      q1Panel.setLayout(null);
            
      question1 = new JLabel();
      question1.setBounds(25, 15, 100, 20);
      question1.setText("Q1: Techincal ?");
      q1Panel.add(question1);
            
      q1Slider = new JSlider(JSlider.HORIZONTAL, 1, 8, 5);
      q1Slider.setBounds(120, 15, 275, 40);
      q1Slider.setMinorTickSpacing(1);
      q1Slider.setPaintTicks(true);
      q1Slider.setLabelTable(grades);
      q1Slider.setPaintLabels(true);
      q1Slider.setInverted(true);
      q1Panel.add(q1Slider);
      contentPane.add(q1Panel);
      
      q2Panel = new JPanel();
      q2Panel.setBounds(40, 130, 400, 60);
      q2Panel.setLayout(null);
      
      question2 = new JLabel();
      question2.setBounds(25, 15, 100, 20);
      question2.setText("Q2: Useful ?");
      q2Panel.add(question2);
            
      q2Slider = new JSlider(JSlider.HORIZONTAL, 1, 8, 5);
      q2Slider.setBounds(120, 15, 275, 40);
      q2Slider.setMinorTickSpacing(1);
      q2Slider.setPaintTicks(true);
      q2Slider.setLabelTable(grades);
      q2Slider.setPaintLabels(true);
      q2Slider.setInverted(true);
      q2Panel.add(q2Slider);
      contentPane.add(q2Panel);
      
      q3Panel = new JPanel();
      q3Panel.setBounds(40, 190, 400, 60);
      q3Panel.setLayout(null);
      
      question3 = new JLabel();
      question3.setBounds(25, 15, 100, 20);
      question3.setText("Q3: Clarity ?");
      q3Panel.add(question3);
            
      q3Slider = new JSlider(JSlider.HORIZONTAL, 1, 8, 5);
      q3Slider.setBounds(120, 15, 275, 40);
      q3Slider.setMinorTickSpacing(1);
      q3Slider.setPaintTicks(true);
      q3Slider.setLabelTable(grades);
      q3Slider.setPaintLabels(true);
      q3Slider.setInverted(true);
      q3Panel.add(q3Slider);
      contentPane.add(q3Panel);
      
      q4Panel = new JPanel();
      q4Panel.setBounds(40, 250, 400, 60);
      q4Panel.setLayout(null);
      
      question4 = new JLabel();
      question4.setBounds(25, 15, 100, 20);
      question4.setText("Q4: Overall ?");
      q4Panel.add(question4);
            
      q4Slider = new JSlider(JSlider.HORIZONTAL, 1, 8, 5);
      q4Slider.setBounds(120, 15, 275, 40);
      q4Slider.setMinorTickSpacing(1);
      q4Slider.setPaintTicks(true);
      q4Slider.setLabelTable(grades);
      q4Slider.setPaintLabels(true);
      q4Slider.setInverted(true);
      q4Panel.add(q4Slider);
      contentPane.add(q4Panel);
      
      commentPanel = new JPanel();
      commentPanel.setBounds(40, 310, 400, 80);
      commentPanel.setLayout(null);
      
      commentLabel = new JLabel();
      commentLabel.setBounds(25, 15, 100, 20);
      commentLabel.setText("Comments:");
      commentPanel.add(commentLabel);
      
      commentTextArea = new JTextArea("\nAdd Group Member Names Here\n");
      commentTextArea.setBounds(120, 15, 275, 50);
      commentPanel.add(commentTextArea);
      contentPane.add(commentPanel);
      
      calcAvgPanel = new JPanel();
      calcAvgPanel.setBounds(40, 390, 400, 80);
      calcAvgPanel.setLayout(null);
      
      computedLabel = new JLabel();
      computedLabel.setBounds(25, 15, 250, 20);
      computedLabel.setText("Computed Average from questions above:");
      calcAvgPanel.add(computedLabel);
      
      avgTextArea = new JTextArea();
      avgTextArea.setBounds(270, 15, 120, 55);
      calcAvgPanel.add(avgTextArea);
      
      calcAvgButton = new JButton("Calc Avg");
      calcAvgButton.setBounds(25, 40, 85, 30);
      calcAvgPanel.add(calcAvgButton);      
      contentPane.add(calcAvgPanel);
      
      buttonPanel = new JPanel();
      buttonPanel.setBounds(40, 510, 400, 40);
      buttonPanel.setLayout(null);
      
      submitButton = new JButton("Submit");
      submitButton.setBounds(40, 5, 150, 25);
      submitButton.setEnabled(false);
      buttonPanel.add(submitButton);
      
      clearButton = new JButton("Clear");
      clearButton.setBounds(240, 5, 150, 25);
      buttonPanel.add(clearButton);
      contentPane.add(buttonPanel);
      
      calcAvgButton.addActionListener(this);
      submitButton.addActionListener(this);
      clearButton.addActionListener(this);
      //teamComboBox.addItemListener(this);
      
      //loadTeams();
            
      setTitle("EEEVILL");   // set title bar string
      setSize(500, 600); // set window size
      setVisible(true);  // display window
    }

   
//    private void loadTeams()
//    {
//         // get all account numbers from database
//      try
//      {       
//         rs = stmt.executeQuery("SELECT DISTINCT TEAMNAME FROM EVALUATIONS");      
//         while (rs.next())
//         {
//             teamComboBox.addItem(rs.getString("TEAMNAME"));
//         }
//         rs = stmt.executeQuery("select * from EVALUATIONS"); //or else it won't see any other rows    
//      } // end try
//
//      catch (Exception exception)
//      {
//         exception.printStackTrace();
//      }
//    }

    @Override
   public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == calcAvgButton)
        {
            submitButton.setEnabled(true);
            q1 = q1Slider.getValue();
            q2 = q2Slider.getValue();
            q3 = q3Slider.getValue();
            q4 = q4Slider.getValue();
            teamAvg = (double) (q1 + q2 + q3 + q4)/4;
            String avgString = Double.toString(teamAvg);
            avgTextArea.setText(avgString + " out of 8.0");
        }        
        else if(event.getSource() == submitButton)
        {
            submitButton.setEnabled(false);            
            comments = commentTextArea.getText();
            try
            {
                Configuration con = new Configuration();
                con.configure("hibernate.cfg.xml");
                SessionFactory SF = con.buildSessionFactory();
                Session session = SF.openSession();
                
                team t = new team();
                t.setTeamName("Team " + teamComboBox.getSelectedIndex());
                t.setQ1(q1);
                t.setQ2(q2);
                t.setQ3(q3);
                t.setQ4(q4);
                t.setAvgScore(teamAvg);
                t.setComments(comments);
                Transaction TR = session.beginTransaction();
                session.save(t);
                System.out.println("Object saved successfully");
                TR.commit();
                session.close();
                SF.close();
                
//                rs.updateInt("Q1", q1);
//                rs.updateInt("Q2", q2);
//                rs.updateInt("Q3", q3);
//                rs.updateInt("Q4", q4);
//                rs.updateDouble("AVGSCORE", teamAvg);
//                rs.updateString("COMMENTS", comments);
//                rs.updateRow();        
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(event.getSource() == clearButton)
        {
            submitButton.setEnabled(false);
                    
            q1Slider.setValue(5);
            q2Slider.setValue(5);
            q3Slider.setValue(5);
            q4Slider.setValue(5);              
            avgTextArea.setText("");
            commentTextArea.setText("\nAdd Group Member Names Here\n");
        }
    }

    //@Override
//   public void itemStateChanged(ItemEvent event)
//   {
//        if(event.getStateChange() == ItemEvent.SELECTED)
//        {
//             try
//             {
//                 rs.absolute(teamComboBox.getSelectedIndex());
//                 if(rs.getInt("Q1")> 0)
//                 {
//                    q1Slider.setValue(rs.getInt("Q1"));
//                    q2Slider.setValue(rs.getInt("Q2"));
//                    q3Slider.setValue(rs.getInt("Q3"));
//                    q4Slider.setValue(rs.getInt("Q4"));
//                    String avgScore = Double.toString(rs.getDouble("AVGSCORE"));
//                    avgTextArea.setText(avgScore + " out of 8.0");
//                    commentTextArea.setText(rs.getString("COMMENTS"));
//                 }
//                 else
//                 {
//                    q1Slider.setValue(5);
//                    q2Slider.setValue(5);
//                    q3Slider.setValue(5);
//                    q4Slider.setValue(5);              
//                    avgTextArea.setText("");
//                    commentTextArea.setText("\nAdd Group Member Names Here\n");
//                 }
//             }
//             catch(SQLException ex)
//            {
//                ex.printStackTrace();
//            }
//        }
//   }
   
   public void buildDictionary()
   {
       grades = new Hashtable();
       grades.put(1, new JLabel("C-"));
       grades.put(2, new JLabel("C"));
       grades.put(3, new JLabel("C+"));       
       grades.put(4, new JLabel("B-"));
       grades.put(5, new JLabel("B"));
       grades.put(6, new JLabel("B+"));   
       grades.put(7, new JLabel("A-"));       
       grades.put(8, new JLabel("A"));
   }
   
   public class ImageFrame extends JFrame implements ActionListener{

    JPanel missingNoPanel;
    
    public void buildGUI()
    {
        Container contentPane = getContentPane();       
        contentPane.setLayout(null);
        
        JPanel wordPanel = new JPanel();
        wordPanel.setBounds(0, 20, 400, 48);
        wordPanel.setLayout(null);
        contentPane.add(wordPanel);

        // set up Instructor Label
        JLabel errorLabel = new JLabel();
        errorLabel.setBounds(10, 15, 400, 20);
        errorLabel.setText("An error has occured, please check your team selection & try again.");
        wordPanel.add(errorLabel);
        
        missingNoPanel = new JPanel();
        missingNoPanel.setLayout(null);
        missingNoPanel.setBounds(55, 70, 350, 300);
        ImagePanel ip = new ImagePanel(new ImageIcon("MissingNo.png").getImage());
        missingNoPanel.add(ip);
        contentPane.add(missingNoPanel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 390, 350, 50);
        buttonPanel.setLayout(null);
        
        JButton OKButton = new JButton("OK");
        OKButton.setBounds(160, 10, 85, 30);
        OKButton.addActionListener(this);
        buttonPanel.add(OKButton);      
        contentPane.add(buttonPanel);
        
        setSize(420, 500); // set window size
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) 
    {
        setVisible(false);
    }    

        public class ImagePanel extends JPanel
        {
          private Image img;

          public ImagePanel(String img) 
          {
            this(new ImageIcon(img).getImage());
          }

          public ImagePanel(Image img) 
          {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
          }

          public void paintComponent(Graphics g) 
          {
            g.drawImage(img, 0, 0, null);
          }
        }
    }
}