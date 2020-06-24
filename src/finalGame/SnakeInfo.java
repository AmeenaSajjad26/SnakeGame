//Ameena 
//5/11/17
//SnakeInfo.java

//import all required packages
//Create a public class named SnakeInfo
//assign public variables
//assign private variables
//geters for getting rectangle and length
//set the rectangle color to red
//create a constructor
//create methods

package finalGame;

//import all required packages
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

//Create a public class named SnakeInfo

public class SnakeInfo
{
    //assign public variables
    public final int ASSIGNEDLENGTH = 4;
    public final int ASSIGNEDHEIGHT = 10;
    
    //assign private variables
    private final double x = 300;
    private final double y = 225;
    
    private int length = ASSIGNEDLENGTH;
    
    private ArrayList<Rectangle> snake = new ArrayList(ASSIGNEDLENGTH);
    
    //geters for getting rectangle and length
    public  Rectangle getRectangle(double a,double b)
    {
     Rectangle r = new Rectangle(a, b, ASSIGNEDHEIGHT, ASSIGNEDHEIGHT);
     
     //set the rectangle color to red
     r.setFill(Color.RED);
     return r;
    }
    
     //constructor
    public SnakeInfo()
    {
    for(int i = 0; i < length; i++)
        snake.add(i,getRectangle(x - i * ASSIGNEDHEIGHT,y));
    }
    
    public void hungry()
    {
    length++;
    snake.add(getRectangle(snake.get(length - 2).getX(),snake.get(length - 2).getY()));
    }
    
    public void shake(double a,double b)
    { 
    for(int i = length - 1; i > 0; i--)
    {
        snake.get(i).setX(snake.get(i-1).getX());
        snake.get(i).setY(snake.get(i-1).getY());
    }
    
    snake.get(0).setX(a);
    snake.get(0).setY(b);
    }
    
        public int getLength()
    {
        return length;
    }
    
        public ArrayList<Rectangle> getSnake()
    {
        return snake;
    }
        
    }

