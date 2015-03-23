import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class LogSpiralPanel extends JPanel
{
    private static final double GOLDEN_MEAN =  (1 + Math.sqrt(5)) / 2;
    
    public void paintComponent(Graphics g)
    {
         
        Rectangle golden = new Rectangle(0, 0, this.getHeight()*GOLDEN_MEAN, this.getHeight());
        g.draw(golden);
        this.recursiveDraw(g, 0, 0, golden.getHeight(), 90); 
     
    }

    /**
    Method that recursively draws a logarithmic spiral.
    @param x The upper left corner x-coordinate of the golden rectangle
    @param y The upper left corner y-coordinate of the golden rectangle
    @param side the smallest side size of the golden rectangle
    @param angle The angle (0, 90, 180 or 270) where the top of the 
    current golden rectangle is located. For the outermost golden 
    rectangle, the angle is 90.
     */
    private void recursiveDraw(Graphics g, double x, double y, double side, int angle)
    {
        if(side >= 1.0)
        {
           return;
        }
        

        Rectangle square = new Rectangle(x, y, side, side);
        this.drawArc(g, x, y, side, angle);
        int newSide = side * GOLDEN_MEAN - side;
        double x1 = calculateNewX(x, angle, side, newSide);
        double y1 = calculateNewY(y, angle, side, newSide);
        recursiveDraw(g, x1, y1, side, angle);
    }

    /**
    Draws the arc of the current iteration.
    @param x The x-coordinate of the square's upper-left corner  
    @param y The y-coordinate of the square's upper-left corner
    @param side The size of the side of the square (or the arc's radius)
    @param angle The angle (0, 90, 180 or 270) where the top of the 
    current golden rectangle is located. For the outermost golden 
    rectangle, the angle is 90.
     */
    private void drawArc(Graphics g, double x, double y, double side, int angle)
    {
        double auxX = x;
        double auxY = y;
        if (angle == 0 || angle == 270 )
        {
            auxX = x - side;
        }
        if (angle == 270 || angle == 180)
        {
            auxY = y - side;
        }
        g.drawArc((int) auxX, (int) auxY, (int) side * 2, (int) side * 2, angle, 90);
    }   

    private double calculateNewX(double x, double angle, double side, double newSide)
    {
        if (angle == 0)
            x = x + side - newSide;
        else if (angle == 90)
            x = x + side;
        else if (angle == 270)
            x = x - newSide;
        return x;
    }

    private double calculateNewY(double y, double angle, double side, double newSide)
    {
        if (angle == 0)
            y = y + side;
        else if (angle == 180)
            y = y - newSide;
        else if (angle == 270)
            y = y + side - newSide;
        return y;
    }
}