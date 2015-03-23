import java.awt.*;
import javax.swing.JPanel;

/**
 * @author (ikbiel) 
 * @version (23 March 2015)
 */
public class FractalTree extends JPanel
{
    //starting point
     private int startX;
     private int startY;
    //ending point
     private int endX;
     private int endY;
    // how much smaller branches are
     private int diffOfSize;
    // how small branches get
     private int minSize;
    // angle between branches
     private int angle;
     
     //create panel
     
     private final int PANEL_WIDTH = 400;
     private final int PANEL_HEIGHT = 400;
     
    /**
     * Default constructor for objects of class FractalTree
     */
    public FractalTree()
    {
       
    }
    
    public void drawFractal(int order, int x1, int y1, int x2, int y2, Graphics page)
    {
        //calculate all new points
    }
    
    public void paintComponent(Graphics page)
    {
    }
    
    public void setOrder( int order )
    {
    }
    
    public int getOrder()
    {
        return current;
    }
    
    

}
