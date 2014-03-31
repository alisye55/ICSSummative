import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;  // Needed for ActionListener
import java.awt.image.*;
import java.io.*;
import java.awt.event.MouseListener; //Needed for MouseListener
import java.awt.event.MouseEvent; // Neeeded for MouseListener
import javax.imageio.*; // for image importing




//GUI for Life 
public class LifeGUI extends JFrame
{
  int mapnumber; // universal variable (int ) for map number
  Map map = new Map(); // creates new Map Class object
  
   static Timer t; // map timer 
  
  
  String [] list = {"Map 1", "Map 2", "Map 3", "Map 4"}; // combo box created for map selection
  JComboBox mapselection = new JComboBox(list); // creating combo box
  
  public LifeGUI()
  {
    
    //-----------------------Set Up Components---------------------
    BtnListener btnListener = new BtnListener(); //listener for all buttons 
    
    JButton simulateBtn = new JButton ("Simulate"); // creates simulate button for simulation
    simulateBtn.addActionListener(btnListener); //adds action listener
    
    JButton stopBtn = new JButton ("Stop"); // creates stop button for stop simulation
    stopBtn.addActionListener(btnListener);//adds action listener
    
    JButton randomBtn = new JButton ("Random"); //creates random button 
    randomBtn.addActionListener(btnListener);//adds action listener
    
    JButton instructionsBtn = new JButton("Instructions"); // creates instructions button
    instructionsBtn.addActionListener(btnListener);//adds action listener
    
    mapselection.addActionListener(btnListener); // adds action listener for combo box
    
    //----------------Creates Panels and Layouts-------------------
    JPanel content = new JPanel (); // creates content panel where content is put
    content.setLayout(new BorderLayout()); // use BorderLayout for the content area
    
    JPanel input = new JPanel (); // creates input panel where buttons and input things are
    input.setLayout(new GridLayout());// uses grid layout for the input area
    
    DrawArea board = new DrawArea(800,576); // creates drawing area
    
    
    //------------------Adds Componenets to input----------------
    input.add(simulateBtn);
    input.add(stopBtn);
    input.add(instructionsBtn);
    input.add(mapselection);
    input.add(randomBtn);
    
    content.add(input, "North"); // input area
    content.add(board, "South"); // output area/ draw area
    
    
    //----------------------Frame Attributes -----------------------
    setContentPane(content);
    pack();
    setTitle("Life"); // set the title of the frame / window
    setSize(816,641); // set the size of the frame
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // closes program when X is pressed.
    setLocationRelativeTo(null); // center window when opened
  }
  
  class BtnListener implements ActionListener //button menu
  {
    public void actionPerformed (ActionEvent e){
      
      mapnumber = mapselection.getSelectedIndex();  // action listen for map selection
      map.defaultload(mapnumber); // loads the map 
      
      if (e.getActionCommand ().equals ("Simulate"))
      {
        Movement Simulate = new Movement(map); // action listeener
        t = new Timer (1000, Simulate); // set up timer
        t.start();
      }
      if(e.getActionCommand ().equals ("Stop")) // stop commands 
      {
        t.stop();      
      }
      if(e.getActionCommand ().equals ("Instructions"))// Instructions
      {
        JOptionPane.showMessageDialog(null,"Instructions:\n This is a Life Simulation With Bats, Eyeballs, Snakes, Slime, and Worms" +
                                    "\n\nEach creature satifies their own set of rules that are created relative to the map and other creatures. " +
                                    "\n For more information,  please visit (tobo.ca/LifeSimRules)" , "Instructions", JOptionPane.INFORMATION_MESSAGE);
      }
      if(e.getActionCommand ().equals("Random")) //  Random command
      {
        map.random(mapnumber); // calls the random method 
      }
      repaint(); // refreshes display
    }
  }
  
  // draw area to put drawings on
  class DrawArea extends JPanel
  {
    public DrawArea (int width, int height) // takes in parameters of width and height of the draw area
    {
      this.setPreferredSize(new Dimension (width, height)); // size of the draw area created
    }
    public void paint(Graphics g) // where things will be displayed
    {
      map.show(g, mapnumber);
    }
  }
  
  // action listener class
  class Movement implements ActionListener
  {
    private Map map;
    
    public Movement(Map maplol)
    {
      map = maplol; 
    }
    
    public void actionPerformed (ActionEvent event)
    {
      map.advance(mapnumber);  // calls the advancem ethod
      repaint();// then repaints
    }    

  }
  
     
  public static void main (String[] args)
  {
    LifeGUI mainframe = new LifeGUI(); // creates new object of life class
    mainframe.setVisible(true);
  }
}