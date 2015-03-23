import javax.swing.JFrame;
public class LogSpiralFrame
{
   
    public LogSpiralFrame()
    {
        
        JFrame frame = new Frame();
        frame.setSize(1200, 700);
        frame.setTitle("Fibonacci Spiral");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        LogSpiralPanel panel = new LogSpiralPanel();
        frame.add(panel);
    }

    
}
