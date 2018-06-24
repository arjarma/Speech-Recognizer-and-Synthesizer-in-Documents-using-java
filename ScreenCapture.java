package majorProject;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.*;
 
import javax.imageio.ImageIO;
 
/**
 * This program demonstrates how to capture a screenshot (full screen)
 * as an image which will be saved into a file.
 * @author www.codejava.net
 *
 */
public class ScreenCapture
{
 public static void Capture()
	{
		try {
			JFileChooser jfc;
			JFrame frame=new JFrame();
			int a;
			File f=null;
			Starter.SpeakerInit("Switch to the screen for screenshot.");
            Robot robot = new Robot();
            String fileName = "FullScreenshot1.jpg";
			jfc=new JFileChooser();
			a=jfc.showSaveDialog(frame);
			if(a==JFileChooser.APPROVE_OPTION)
			{
				f=new File(jfc.getSelectedFile()+".jpg");
            
			}
			try{
			Thread.sleep(5000);
			}
			catch(InterruptedException ie)
			{}
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			
            ImageIO.write(screenFullImage,"jpg", f);
				Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Screenshot Captured");
            
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
	}
   public static void main(String[] args) 
	{
       
			/*try{
			Thread.sleep(100);
			}
			catch(InterruptedException ie)
			{}*/
		//Capture();	
    }
}