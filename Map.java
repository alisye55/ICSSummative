import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;  // Needed for ActionListener
import java.awt.image.*;
import java.io.*;
import java.awt.event.MouseListener; //Needed for MouseListener
import java.awt.event.MouseEvent; // Neeeded for MouseListener
import javax.imageio.*; // for image importing

public class Map // Map class which includes everything
{
  private BufferedImage image1; // first four images are for loading maps
  private BufferedImage image2;
  private BufferedImage image3;
  private BufferedImage image4;
  
  private BufferedImage image5; // next 5 images are for 5 different objects, the bat, worm, snake, slime, and eyeballs
  private BufferedImage image6;
  private BufferedImage image7;
  private BufferedImage image8;
  private BufferedImage image9;
  
  String maplist1[] []; //4 map array lists of string are made for 4 different maps
  String maplist2[] [];
  String maplist3[] [];
  String maplist4[] [];
  
  int[] [] objects = new int [36] [50]; // an objects array is created (int) for the creatures it is a 36 by 50 array
  
  public Map ()  // default constructor for map
  {
    maplist1 = new String [36] [50];    // initializes the 4 maplists as 36 by 50 string 2 D arrays
    maplist2 = new String [36] [50];
    maplist3 = new String [36] [50];
    maplist4 = new String [36] [50];
    
    try // the next 9 try catches tries to read in map 1, map 2, map 3, map 4, bat, slime, eyeball ,snake and worm (TRIES TO)
    {
      image1 = ImageIO.read (new File ("Map1.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    try // read in for Map 2
    {
      image2 = ImageIO.read (new File ("Map2.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    try // read in for Map 3
    {
      image3 = ImageIO.read (new File ("Map3.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    try // read in for Map 4
    {
      image4 = ImageIO.read (new File ("Map4.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    
    // goes through every row and columb
    for (int row = 0 ; row < objects.length ; row++) // sets the objects array all to nothing
      for (int col = 0 ; col < objects [0].length ; col++) // bat 1 eyeball 2  slime blob 3 snake 4 worm 5. (all other numbers are blank spaces)
      objects [row] [col] = 0;
    
    
    try // tries to read in image for bat
    {
      image5 = ImageIO.read (new File ("Bat.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    try // tries to read in image for eyeball
    {
      image6 = ImageIO.read (new File ("Eyeball.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    try // tries to read in image for slime
    {
      image7 = ImageIO.read (new File ("Slime.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    try // tries to read in image for snake
    {
      image8 = ImageIO.read (new File ("Snake.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    try // tries to read in image for worm
    {
      image9 = ImageIO.read (new File ("Worm.png"));
    }
    catch (IOException e)  // catch if file is not there
    {
      System.out.println ("File Not Found");
    }
    
    
  }
  
  
  public void show (Graphics g, int mapnumber)
  { // show method for the map
    
    if (mapnumber == 0) // draws map 1 to 4 depending of map selection from the combo box in the GUI.
      g.drawImage (image1, 0, 0, null); // draws map 1 if selected map 1
    else if (mapnumber == 1)
      g.drawImage (image2, 0, 0, null); // draws map 2 if selected map 2
    else if (mapnumber == 2)
      g.drawImage (image3, 0, 0, null); // draws map 3 if selected ma p3
    else if (mapnumber == 3)
      g.drawImage (image4, 0, 0, null); // draws map 4 if selected map4
    
    // show for objects, draws it on top of the map
    for (int row = 0 ; row < objects.length ; row++) // goes through every row and column of the objects array
      for (int col = 0 ; col < objects [0].length ; col++)
    { //each box is 16 by 16 thats why row and col is multiplied by 16 to get the x and y coordinates of where to draw the creatures
      if (objects [row] [col] == 1) // checks if is bat, draws bat
        g.drawImage (image5, col * 16, row * 16, null);
      else if (objects [row] [col] == 2) // check if is eyeball, draws eyeball
        g.drawImage (image6, col * 16, row * 16, null);
      else if (objects [row] [col] == 3) // checks if is slime, draws slime
        g.drawImage (image7, col * 16, row * 16, null);
      else if (objects [row] [col] == 4) // chekcs if is snake, draws snake
        g.drawImage (image8, col * 16, row * 16, null);
      else if (objects [row] [col] == 5) // checks if is worm , draws worm
        g.drawImage (image9, col * 16, row * 16, null);
    }
    
  }
  
  
  public void random (int mapnumber)  // random objects array created based on the map number
  {
    
    for (int row = 0 ; row < objects.length ; row++) // sets the array to nothing in the beginning when it is pressed
      for (int col = 0 ; col < objects [0].length ; col++)
      objects [row] [col] = 0;
    
    String temp[] [] = new String [36] [50]; // temporary array created to readi n list from maps
    if (mapnumber == 0)
    {
      temp = maplist1; // if map 1, copies map 1
    }
    else if (mapnumber == 1)
    {
      temp = maplist2; // if map 2 , copies map 2
    }
    else if (mapnumber == 2)
    {
      temp = maplist3; // if map 3, copies map 3
    }
    else if (mapnumber == 3)
    {
      temp = maplist4; // if map 4, copies map 4
    }
    
    for (int row = 0 ; row < objects.length ; row++) // goes through row and column of the array
      for (int col = 0 ; col < objects [0].length ; col++)
    {
      try
      { // tries to
        if (temp [row] [col].equals ("grass")) //in random, it only creates creatures if it is grass on the ground
          objects [row] [col] = (int) (Math.random () * 15 + 1); // creates a random number between 1 and 15 to set the array to
      }
      catch (Exception e)
      {
      }
    }
  }
  
  
  public void advance (int mapnumber)  // advance method to change the objects array based on rules created
  {
    int temp1[] [] = new int [36] [50]; // creates temporary array to modify but based on original array parameteres
    
    for (int row = 0 ; row < objects.length ; row++) // goes through row and column
      for (int col = 0 ; col < objects [0].length ; col++)
      temp1 [row] [col] = live (row, col, mapnumber); // calls the live method but also giving it a mapnumber
    
    objects = temp1;
  }
  
  
  //!!!!!! NOTE MANY TRY CATHCES ARE USED IN THE LIVE METHOD TO PREVENT GOING OUT OF BOUNDS       (TO GET MORE DETAILED INFORMATION ON RULES - > GO TO INSTRUCTIONS)
  public int live (int row, int col, int mapnumber)             // bat 1 eyeball 2  slime blob 3 snake 4 worm 5.
  {
    String temp[] [] = new String [36] [50]; // creates temporary arrays to get map (look up for more details)
    if (mapnumber == 0)
    {
      temp = maplist1;
    }
    else if (mapnumber == 1)
    {
      temp = maplist2;
    }
    else if (mapnumber == 2)
    {
      temp = maplist3;
    }
    else if (mapnumber == 3)
    {
      temp = maplist4;
    }
    
    if (objects [row] [col] == 1) // bat
    {
      int one = 0;
      int counter = 0;
      for (int x = 0 ; x < objects.length ; x++)
        for (int c = 0 ; c < objects [0].length ; c++) // this checks the bat rules around the block
      {
        try
        {
          if ((Math.abs (row - x) < 11) && (Math.abs (col - c) < 11)) // checks parameters for water of 11 blocks
            if (temp [x] [c].equals ("water"))
          {
            try
            {
              if ((Math.abs (row - x) < 17) && (Math.abs (col - c) < 17)) // checks parameters for tree of 17 blocks
                if (temp [x] [c].equals ("tree"))
                one = 1; // a value of "1" is returned only if it satifies those conditions
            }
            catch (Exception e)
            {
            }
            
          }
        }
        catch (Exception e) // catch
        {
        }
        
        try
        {
          if ((Math.abs (row - x) < 5) && (Math.abs (col - c) < 5)) // checks the surounding 4 block perimeters
            counter++;
        }
        catch (Exception e)
        {
        }
      }
      if (counter >= 3) // if there is too many bats around, it dies due to competition / overcrowding
        one = 0;
      return one;
    }
    else if (objects [row] [col] == 2) // eyeball
    {
      int two = 0;
      int counter = 0;
      for (int x = 0 ; x < objects.length ; x++)
        for (int c = 0 ; c < objects [0].length ; c++)
      {
        try
        {
          if ((Math.abs (row - x) < 7) && (Math.abs (col - c) < 7)) // if there is water arround it goes to the next rule
            if (temp [x] [c].equals ("water"))
          {
            try
            {
              if ((Math.abs (row - x) < 12) && (Math.abs (col - c) < 12)) // if there are trees around
                if (temp [x] [c].equals ("tree"))
                two = 2; // the eyeball lives
            }
            catch (Exception e)
            {
            } 
            
          }
          
        }
        catch (Exception e)
        {
        }
        
        
        try // if theres lava close, it dies
        {
          if ((Math.abs (row - x) < 3) && (Math.abs (col - c) < 3))
            if (temp [x] [c].equals ("lava"))
            two = 0;
        }
        catch (Exception e)
        {
        }
       try
        {
          if ((Math.abs (row - x) < 5) && (Math.abs (col - c) < 5)) // checks the surounding 4 block perimeters
            counter++;
        }
        catch (Exception e)
        {
        }
      }
      if (counter >= 3) // if there is too many eyeballs around, it dies due to competition / overcrowding
        two = 0;
      
      return two; // returns the value if it is  eyeball
    }
    else if (objects [row] [col] == 3) // rules for slime
    {
      int three = 0;
      int counter = 0;
      for (int x = 0 ; x < objects.length ; x++) // goes through whole array to check surrounding blocks
        for (int c = 0 ; c < objects [0].length ; c++)
      {
        try
        {
          if ((Math.abs (row - x) < 5) && (Math.abs (col - c) < 5)) // if satifies water rules checks tree rules
            if (temp [x] [c].equals ("water"))
          {
             try
        {
          if ((Math.abs (row - x) < 12) && (Math.abs (col - c) < 12))
            if (temp [x] [c].equals ("tree"))
            three = 3; // if satifies tree and water rules returns it being alive
        }
        catch (Exception e)
        {
        }
            
          }
        }
        catch (Exception e)
        {
        } 
        try // dies if too close to lava
        {
          if ((Math.abs (row - x) < 3) && (Math.abs (col - c) < 3))
            if (temp [x] [c].equals ("lava"))
            three = 0;
        }
        catch (Exception e)
        {
        }
        
        try // gets eaten if something is too close
        {
          if ((Math.abs (row - x) < 4) && (Math.abs (col - c) < 4))
            if (objects [x] [c] == 4)
            three = 0;
        }
        catch (Exception e)
        {
        }
        
       try
        {
          if ((Math.abs (row - x) < 5) && (Math.abs (col - c) < 5)) // checks the surounding 4 block perimeters
            counter++;
        }
        catch (Exception e)
        {
        }
      }
      if (counter >= 3) // if there is too many slime around, it dies due to competition / overcrowding
        three = 0;
      return three;
    }
    else if (objects [row] [col] == 4) // snake
    {
      int four = 0;
      int counter = 0;
      for (int x = 0 ; x < objects.length ; x++)
        for (int c = 0 ; c < objects [0].length ; c++)
      {
        try
        {
          if ((Math.abs (row - x) < 3) && (Math.abs (col - c) < 3)) // checks water and tree rules
            if (temp [x] [c].equals ("water"))
          {
           try
        {
          if ((Math.abs (row - x) < 6) && (Math.abs (col - c) < 6))
            if (temp [x] [c].equals ("tree"))
            four = 4; // lives if satifies
        }
        catch (Exception e)
        {
        } 
            
          }
        }
        catch (Exception e)
        {
        }
        
        try // if to close to lava, dies
        {
          if ((Math.abs (row - x) < 3) && (Math.abs (col - c) < 3))
            if (temp [x] [c].equals ("lava") || objects [x] [c] == 1) // in this block range, if there is lava or a bat, the snake dies.
            four = 0;
        }
        catch (Exception e)
        {
        }
        
        try // if its a hole, it basically dies
        {
          if (maplist1 [row] [col].equals ("hole"))
            four = 0;
        }
        catch (Exception e)
        {
        }
        
       try
        {
          if ((Math.abs (row - x) < 5) && (Math.abs (col - c) < 5)) // checks the surounding 4 block perimeters
            counter++;
        }
        catch (Exception e)
        {
        }
      }
      if (counter >= 3) // if there is too many bats around, it dies due to competition / overcrowding
        four = 0;
      return four;
    }
    else if (objects [row] [col] == 5) // worm
    {
      int five = 0;
      int counter = 0;
      for (int x = 0 ; x < objects.length ; x++)
        for (int c = 0 ; c < objects [0].length ; c++)
      {
        try
        {
          if ((Math.abs (row - x) < 3) && (Math.abs (col - c) < 3))
            if (temp [x] [c].equals ("water")) // if satifies both water and tree rules, it lives
          {
            try
        {
          if ((Math.abs (row - x) < 8) && (Math.abs (col - c) < 8))
            if (temp [x] [c].equals ("tree"))
            five = 5;
        }
        catch (Exception e)
        {
        } 
          }
        }
        catch (Exception e)
        {
        }
        
        
        try // if too close to lava, dies
        {
          if ((Math.abs (row - x) < 2) && (Math.abs (col - c) < 2))
            if (temp [x] [c].equals ("lava"))
            five = 0;
        }
        catch (Exception e)
        {
        }
        
        try // checks if it is going to get destryoed by other objects.
        {
          if ((Math.abs (row - x) < 3) && (Math.abs (col - c) < 3))
            if (objects [x] [c] == 3)
            five = 0;
        }
        catch (Exception e)
        {
        }
        
        try  
        {
          if ((Math.abs (row - x) < 4) && (Math.abs (col - c) < 4))
            if (objects [x] [c] == 1 || objects [x] [c] == 2)
            five = 0;
        }
        catch (Exception e)
        {
        }
        
        try
        {
          if ((Math.abs (row - x) < 5) && (Math.abs (col - c) < 5))
            if (objects [x] [c] == 5)
            five = 0;
        }
        catch (Exception e)
        {
        }
        
        try // if it is hole, it dies
        {
          if (maplist1 [row] [col].equals ("hole"))
            five = 0;
        }
        catch (Exception e)
        {
        }
        try
        {
          if ((Math.abs (row - x) < 5) && (Math.abs (col - c) < 5)) // checks the surounding 4 block perimeters
            counter++;
        }
        catch (Exception e)
        {
        }
      }
      if (counter >= 3) // if there is too many bats around, it dies due to competition / overcrowding
        five = 0;
        
      return five;
    }
    else if (objects [row] [col] != 1 && objects [row] [col] != 2 && objects [row] [col] != 3 && objects [row] [col] != 4 && objects [row] [col] != 5) // RULES AFTER THIS ARE USED FOR REPRODUCING
    {
      int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0; // 5 counters for 5 creations
      for (int x = 0 ; x < objects.length ; x++)
        for (int c = 0 ; c < objects [0].length ; c++)
      {
        try // CHECKS SURROUNDING BLOCKS, IF SATIFIES RULES, COUNTER IS INCREASED
        {
          if (Math.abs (row - x) < 4 && (Math.abs (col - c) < 4) && objects [x] [c] == 1)
            counter1++;
        }
        catch (Exception e)
        {
        }
        
        try
        {
          if (Math.abs (row - x) < 3 && (Math.abs (col - c) < 3) && objects [x] [c] == 2)
            counter2++;
        }
        catch (Exception e)
        {
        }
        
        try
        {
          if (Math.abs (row - x) < 2 && (Math.abs (col - c) < 2) && objects [x] [c] == 3)
            counter3++;
        }
        catch (Exception e)
        {
        }
        
        try
        {
          if (Math.abs (row - x) < 2 && (Math.abs (col - c) < 2) && objects [x] [c] == 4)
            counter4++;
        }
        catch (Exception e)
        {
        }
        
        try
        {
          if (Math.abs (row - x) < 2 && (Math.abs (col - c) < 2) && objects [x] [c] == 5)
            counter5++;
        }
        catch (Exception e)
        {
        }
      }
      try // IF COUNTER SATIFIES SPECIFIC VALUES, AND IS THE PLACE IS GRASS, AN OBJECT IS CREATED
      {
        if (counter1 == 2 && temp [row] [col].equals ("grass"))
          return 1;
      }
      catch (Exception e)
      {
      }
      try
      {
        if (counter2 == 2 && temp [row] [col].equals ("grass"))
          return 2;
      }
      catch (Exception e)
      {
      }
      try
      {
        if (counter3 == 2 && temp [row] [col].equals ("grass"))
          return 3;
      }
      catch (Exception e)
      {
      }
      try
      {
        if (counter4 == 1 && temp [row] [col].equals ("grass"))
          return 4;
      }
      catch (Exception e)
      {
      }
      try
      {
        if (counter5 == 1 && temp [row] [col].equals ("grass"))
          return 5;
      }
      catch (Exception e)
      {
      }
      return 0;
    }
    else
      return 0;
  }
  
  
  
  
  //DEFAULTLOAD METHOD used to load
  public void defaultload (int mapnumber)
  {

    try
    { // attempts to read in file
      String Hi = "lolol";
      if (mapnumber == 0)
        Hi = "Map1.txt";
      else if (mapnumber == 1)
        Hi = "Map2.txt";
      else if (mapnumber == 2)
        Hi = "Map3.txt";
      else if (mapnumber == 3)
        Hi = "Map4.txt";
      
      FileInputStream fstream = new FileInputStream (Hi);   // reads in this specific file (filepath)
      
      
      DataInputStream in = new DataInputStream (fstream);  //reads in file from filepath
      BufferedReader br = new BufferedReader (new InputStreamReader (in)); //reads data
      
      String[] temp = new String [50]; // creates temporary array to store row strings from text file
      int index = 0;  //for column number
      String temp1[] [] = new String [36] [50]; // creates temporary array of 36 x50 to be later copied to grid
      
      int x = 0; // initializes counter for rows
      while (x < 36)
      { // only while loops work for some reason (while rows <36 runs)
        x++; // increases rows each time
        String a = br.readLine (); // reads in a line in the file
        
        temp = a.split (", "); // splits the file in to an array of false and true excluding the ", " from the original txt.
        
        for (int col = 0 ; col < temp1 [0].length ; col++) // goes through temp to set the correct boolean for temp1
        {
          if (temp [col].equals ("grass")) // checks in the row of arrays if there is false, if there is, set the temporary array to false accordingly.
            temp1 [index] [col] = "grass";
          else if (temp [col].equals ("water")) // does the same for true
            temp1 [index] [col] = "water";
          else if (temp [col].equals ("lava"))
            temp1 [index] [col] = "lava";
          else if (temp [col].equals ("tree"))
            temp1 [index] [col] = "tree";
          else if (temp [col].equals ("hole"))
            temp1 [index] [col] = "hole";
        }
        if (index > 35)
        { // simple index counter to break the loop (code doesn't work without for some reason)
          System.out.println ("Error : Increase array size !");
          break;
        }
        index++;   // index increases everytime loop runs
      }
      
      if (mapnumber == 0)
        maplist1 = temp1; // makes grid equal to the temporary array
      else if (mapnumber == 1)
        maplist2 = temp1;
      else if (mapnumber == 2)
        maplist3 = temp1;
      else if (mapnumber == 3)
        maplist4 = temp1;  
    }
    catch (IOException e123152)  // catch phrase
    {
      System.out.println ("not");
    }
  }
}
