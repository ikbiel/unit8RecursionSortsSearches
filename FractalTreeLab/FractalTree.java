import java.awt.*;
import javax.swing.JPanel;

/**
 * @author (ikbiel) 
 * @version (23 March 2015)
 */
public class FractalTree extends JPanel
{
    // how much smaller branches are
     private double diffOfSize = .75;
    // how small branches get
     private double minSize = 5.0;
    // angle between branches
     private double aAngle = Math.toRadians(30);

    //create panel
     private final int PANEL_WIDTH = 400;
     private final int PANEL_HEIGHT = 400;
     private int current; //current order
     
    /**
     * Default constructor for objects of class FractalTree
     */
    public FractalTree(int currentOrder)
    {
       current = currentOrder;
       setBackground(Color.black);
       setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }
    
    //Draws fractal recursively
    //if lines are too small, stop program!
    //Otherwise trunk is drawn, two new branches are computed - 
        //each line segment is drawn as a fractal
    public void drawFractal(double angle, int x1, int y1, int x2, int y2, Graphics page)
    {
        //calculate length
        double length1 = Math.sqrt((Math.pow(x2-x1, 2))+(Math.pow(y2-y1, 2)));
        //new branch points
        int x3, y3; //right
        int x4, y4; //left
        //new angles
        double rightAngle, leftAngle;

        if(length1<minSize)
        {
            return;
        }
        else 
        {
            //draw trunk
            page.drawLine(x1, y1, x2, y2);
            //calculate next length
            double length2 = length1 * diffOfSize;
            
            //calculate right branch
            rightAngle = angle + aAngle;
            x3 = x2 + (int)(length2*Math.sin(rightAngle));
            y3 = y2 + (int)(length2*Math.cos(rightAngle));
            //draw right line
            page.drawLine(x2, y2, x3, y3);
            
            //calculate left branch
            leftAngle = angle - aAngle;
            x4 = x2 - (int)(length2*Math.sin(leftAngle));
            y4 = y2 - (int)(length2*Math.cos(leftAngle));
            //draw left line
            page.drawLine(x2, y2, x4, y4);
            
            drawFractal(rightAngle+30, x2, y2, x3, y3, page);
            drawFractal(leftAngle-30, x2, y2, x4, y4, page);
            
           
        }
        
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(Color.green);
        
        //trunk values
        int startX = 200, startY = 350;
        int endX = 200, endY = 260;
        
        drawFractal(Math.toRadians(90), startX, startY, endX, endY, page);
    }
    
    public void setOrder( int order )
    {
        current = order;
    }
    
    public int getOrder()
    {
        return current;
    }
    
    

}
