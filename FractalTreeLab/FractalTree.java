import java.awt.*;
import javax.swing.JPanel;

/**
 * @author (ikbiel) 
 * @version (23 March 2015)
 */
public class FractalTree extends JPanel
{
    //starting trunk point
     private int startX = 200, startY = 350;
    //ending trunk points
     private int endX = 200, endY = 300;
    // how much smaller branches are
     private int diffOfSize = .75;
    // how small branches get
     private int minSize = .5;
    // angle between branches
     private int angle = 60;
    
     private final double SQ = Math.sqrt(3.0) / 2;
     
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
    //Base case is order of 1 -- simple straight line is drawn
    //Otherwise two branches are computed - each line segment is drawn as a fractal
    public void drawFractal(int order, int x1, int y1, int x2, int y2, Graphics page)
    {
        //calculate all new points
        
        int deltaX, deltaY;
        int rightX, rightY;
        int leftX, leftY;

        if(order == 1)
        {
            page.drawLine(x1, y1, x2, y2);
        }
        else
        {
            deltaX = x2-x1;
            deltaY = y2-y1;
            
            rightX = (int) (x1+x2)/2 + SQ * (y1-y2));
            rightY = (int) (y1+y2)/2 + SQ * (x2-x1));
            
            leftX = (int) (x1+x2)/2 - SQ * (y1-y2));
            leftY = (int) (y1+y2)/2 - SQ * (x2-x1));
            
            drawFractal(order-1, x2, y2, rightX, rightY, page);
            drawFractal(order-1, x2, y2, leftX, leftY, page);
            
        }
        
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(Color.green);
        
        drawFractal(current, startX, startY, endX, endY, page);
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
