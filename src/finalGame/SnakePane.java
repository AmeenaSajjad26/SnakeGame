//Ameena
//SnakePane.java
//5/11/17

//insert all the required packages
//Creata class name SnakeGame that extends Pane
//Initializing all the private variables
//Create a constructor
//set the color of the food box to red in color
//setter to setDirection
//setters to setFood
//Check for food eaten4
//A boolean method to check death
//set boolean to true
//If the boolean value is false then break
//boolean method to check the meal by the snake
//int the protected mehod -
//Switch for directions and movement of the snake
//Check if the snake is dead then exit the program
//call the required methods
//to move snake up
//to move snake down
//to move snake left
//to move snake right
//TO start the animation
//TO pause the animation



package finalGame;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.paint.Color;
import javafx.util.Duration;

//Creata class name SnakeGame that extends Pane
public class SnakePane extends Pane
{
    //Initializing private variables
    public final int TOP = 0;
    public final int DOWN = 1;
    public final int LEFTSIDE = 3;
    public final int RIGHTSIDE = 4;
    
    private double x = 300;
    private double y = 225; 
    
    private int directionC = RIGHTSIDE;
    
    private SnakeInfo snake = new SnakeInfo();
    private Rectangle food = new Rectangle(100,105,snake.ASSIGNEDHEIGHT,snake.ASSIGNEDHEIGHT);
    private Timeline animation;

    //constructor
    public SnakePane()
    {       
    for(int i = 0;i < snake.getLength(); i++)    
    {
        getChildren().add(snake.getSnake().get(i));
    }
    
    //set the color of the food box to red in color
    food.setFill(Color.RED);
    getChildren().add(food);
    setWall();
    
    animation = new Timeline(
              new KeyFrame(Duration.millis(50),e->snakeMovement(directionC)));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play();
    }
    
    //setter to setDirection
    public void setDirection(int direction)
    {   
        if(1!=Math.abs(direction-directionC))
        directionC = direction;
    }
    
    //setters to setFood
    private void setFood()
    {
    double e;
    double f;
    
    do
    {
    e =((int)(Math.random()*570)) / 10 * 10 + 10;
    f =((int)(Math.random()*415))/10 * 10 + 15;
    }
    
    //Check for food eaten
    while(!mealCheck(e,f));
    food.setX(e);
    food.setY(f);
    }
    
    //A boolean method to check death
    private boolean deadCheck()
    {
        //set boolean to true
    boolean check = true;
    
    for(int i=1;i<snake.getLength();i++)
        
        if(x==snake.getSnake().get(i).getX()&&y==snake.getSnake().get(i).getY())
        {
            //If the boolean value is false then break
            check=false;
            break;
        } 
    
    if(x==0)
        check=false;
    if(x==590)
        check=false;
    if(y==5)
        check=false;
    if(y==435)
        check=false;
    
    return check;
    }
    
    //boolean method to check the meal by the snake
    private boolean mealCheck(double a,double b)
    {
    boolean check = true;
    
    for(int i=0;i<snake.getLength();i++)
        
        if(a==snake.getSnake().get(i).getX()&&b==snake.getSnake().get(i).getY())
            
            check=false;
    
    return check;
    }
    
    //Setters to setWall
    private void setWall()
    {
    for(int i=0; i<120; i++)
    {
        getChildren().add(new Rectangle(5*i,5,snake.ASSIGNEDHEIGHT,snake.ASSIGNEDHEIGHT));
        getChildren().add(new Rectangle(5*i,435,snake.ASSIGNEDHEIGHT,snake.ASSIGNEDHEIGHT));
    }
     for(int i=0; i<90; i++)
    {
        getChildren().add(new Rectangle(0,5*i,snake.ASSIGNEDHEIGHT,snake.ASSIGNEDHEIGHT));
        getChildren().add(new Rectangle(590,5*i,snake.ASSIGNEDHEIGHT,snake.ASSIGNEDHEIGHT));
    }
     
    }
    
    //Protected method
    protected void snakeMovement(int path)
    {
        //Switch for directions and movement of the snake
    switch(path)
    {
        case TOP:moveSnakeUp();
             directionC = TOP;
             break;
             
        case DOWN:moveSnakeDown();
             directionC = DOWN;
             break;
             
        case LEFTSIDE:moveSnakeLeft();
             directionC = LEFTSIDE;
             break;
             
        case RIGHTSIDE:moveSnakeRight();
             directionC = RIGHTSIDE;     
    }
    
    if(x==food.getX()&&y==food.getY())
    {
        snake.hungry();
        
        getChildren().add(snake.getSnake().get(snake.getLength()-1));
        setFood();
    }
    
    //Check if the snake is dead then exit the program
     if(!deadCheck())
     {
         animation.stop();
     }
    }
    
    //to move snake up
    private void moveSnakeUp()
    {
    {
        y-=5;
        snake.shake(x,y);
    }
    }
    
        
    //to move snake left
    private void moveSnakeLeft()
    {
    {
        x-=5;
        snake.shake(x,y);
    }
    }
    
    
    //To move snake to right
    private void moveSnakeRight()
    {
    {
        x+=5;
        snake.shake(x,y);
    }
    }
    
    //to move snake down 
    private void moveSnakeDown()
    {
    {
        y+=5;
        snake.shake(x,y);
    }
    }
    
    //TO pause the animation
    public void pause()
    {
        animation.pause();
    }
    
        //TO start the animation
    public void play()
    {
        animation.play();
    }
}
