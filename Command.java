//package 
package majorProject;


import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.border.*;
import java.awt.event.*;
//import java.awt.event.;

import org.oc.ocvolume.*;
import org.oc.ocvolume.audio.*;
import org.oc.ocvolume.audio.micInput;

public class Command extends JFrame implements ActionListener
{
JTextField tf;
JButton exec;
JButton can,voice;
JPanel jp;
JLabel lb,lb1,lb2;
Process pro;
ProcessBuilder builder;

micInput mic;//=new micInput();
Thread thread;    
ocvolume engine= new ocvolume("command","");

//ocvolume engine= new ocvolume("command","E:\\command vocab\\");

Command()
{
	
lb=new JLabel("Enter Command ");
lb1=new JLabel("PRESS");
lb2=new JLabel("ENTER ");
jp=new JPanel();
jp.setLayout(null);
tf=new JTextField(24);
tf.setFont(new Font("Arial",Font.BOLD,22));
tf.setBackground(new Color(0,153,153));
tf.setForeground(new Color(255,153,0));//new Color(255,255,255)
Border bw=BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK);
tf.setBorder(bw);
exec=new JButton("Help");
voice=new JButton("Use Voice command");
can=new JButton("Cancel");
setDefaultCloseOperation(EXIT_ON_CLOSE);
lb.setBounds(15,5,100,20);
exec.setBounds(150,5,70,24);
tf.setBounds(10,35,195,35);
voice.setBounds(2,85,155,35);
lb1.setBounds(210,35,60,20);
lb2.setBounds(210,50,60,20);
can.setBounds(165,85,85,35);
/*
setLayout(new BorderLayout);
BorderLayout.NORTH
*/
jp.add(lb);
jp.add(tf);
jp.add(exec);
jp.add(lb1);
jp.add(lb2);
jp.add(can);
jp.add(voice);
add(jp);


tf.addFocusListener(new FocusListener()
{
	public void focusLost(FocusEvent fe)
	{
	tf.requestFocus();
	tf.setText("");
	tf.setCaretPosition(tf.getDocument().getLength());
	//Prog.React(str);
	}
	
public void focusGained(FocusEvent fe)
	{
	}
});//focus end

tf.addActionListener(this);
exec.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		String str="property advanced tab System manager cmd chrome window powerpoint google servicesresource monitor"+"\n"+
"control panel close pdf chrome  document cmd home downloads \n downloads device computer editor facebook gmail google manager"+"\n"+
" powerpoint property resource window youtube tab stop bluetooth \n calculator keyboard media services paint"+"\n"+
"terminate task system programs control";
	JOptionPane.showMessageDialog(null,str);	
	}
});
can.addActionListener(this);
voice.addActionListener(this);
addWindowListener(new WindowAdapter()
{
	public void windowOpened(WindowEvent we)
	{
		tf.requestFocus();
	}
});
}//cons ends

	
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==tf)
	{	
		Prog.React(tf.getText());
		tf.setText("");
	}
	
 	//PrintStream ps=new PrintStream("demo.txt");
	//System.setOut(ps);
	//System.out.println("hey There");	
	// run button end
if(ae.getSource()==can)
{
	this.dispose();
}
if(ae.getSource()==voice)
{
 new Thread(new Runnable()
		 {
			 public void run()
			 {
	if(voice.getLabel().equalsIgnoreCase("Use Voice Command")==true)
		 {
			 VoiceMode.sayActivated();
			 //tf.requestFocus();
		voice.setLabel("Deactivate");
		mic = new micInput();
			//mic.setDiscrete();
		    mic.start();
			while(true){
            mic.removeOldWord();
		while(!mic.byteArrayComplete()){
                try{
                    thread.sleep(200);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            mic.newWord();
            short recordedSample[] = mic.returnShortArray();
            String recognizedWord = engine.getWord(recordedSample);
            System.out.println(recognizedWord);
			tf.setText(recognizedWord);
			tf.setCaretPosition(tf.getDocument().getLength());
			Prog.React(tf.getText());
		
			}
			
}
			
	
if(voice.getLabel().equalsIgnoreCase("Deactivate")==true)
		 {
			 VoiceMode.sayDeactivated();
			 voice.setLabel("Use Voice Command");
			mic.stopRecord();
		}		
		}
		 }).start();
}
} /**///action performed finish


public static void main(String args[])
{
//VoiceMode.sayNormalMode();
Command co=new Command();
co.setSize(270,180);
co.setVisible(true);
co.setTitle("Commands");
co.setLayout(null);
VoiceMode.sayNormalMode();
}

}



/*
if(ae.getSource()==exec)//run button
	{		
	
	if(tf.getText().equalsIgnoreCase("media")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
	builder=new ProcessBuilder("C:/Program Files (x86)/VideoLAN/VLC/vlc.exe");
	pro=builder.start();
		
		//tf.setText("");

	}
	catch(Exception e){}
	}//notepad end
	else if(tf.getText().equalsIgnoreCase("notepad++")==true)
	{
	try
	{
		builder=new ProcessBuilder("C:\\npp.7.4.1.bin.x64\\notepad++.exe");
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("Uninstaller")==true)
	{
	try
	{
		//uninstall a program
		pro=Runtime.getRuntime().exec("cmd /c start appwiz.cpl");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("Security center")==true)
	{
	try
	{	pro=Runtime.getRuntime().exec("cmd /c start wscui.cpl");
			tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("adobe reader")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start acrord32.exe");
			tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("property")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start control.exe system");
		tf.setText("");
	}
	catch(Exception e){}
	}
	
	else if(tf.getText().equalsIgnoreCase("advanced")==true)
	{
	try
	{
		builder=new ProcessBuilder("systempropertiesadvanced");//advnaced tAB
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("system")==true)
	{
	try
	{
		builder=new ProcessBuilder("msconfig");//system configuration
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("task")==true)
	{
	try
	{
		builder=new ProcessBuilder("taskmgr");//task manager
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("device")==true)
	{
	try
	{
		builder=new ProcessBuilder();//device management
		pro=Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("event viewer")==true)
	{
	try
	{	
		builder=new ProcessBuilder("eventvwr");//event viewer
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("computer")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start compmgmt.msc");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("information")==true)
	{
	try
	{
		builder=new ProcessBuilder("msinfo32");//System information
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("control panel")==true)
	{
	try
	{
		builder=new ProcessBuilder("control");//control Panel
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("registry editor")==true)
	{
	try
	{
		builder=new ProcessBuilder("regedit");//registry editor
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("restore")==true)
	{
	try
	{
		builder=new ProcessBuilder("rstrui");//System restore
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("resource monitor")==true)
	{
	try
	{
		builder=new ProcessBuilder("resmon");//resource monitor
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("calculator")==true)
	{
	try
	{
		builder=new ProcessBuilder("calc");//calculator
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("paint")==true)
	{
	try
	{
		builder=new ProcessBuilder("mspaint");//mspaint
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	
	else if(tf.getText().equalsIgnoreCase("Services")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start services.msc");
		tf.setText("");
	}
	catch(Exception e){}
	}
	
	else if(tf.getText().equalsIgnoreCase("You Tube ")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.youtube.com");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("Keyboard")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start osk");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("manager")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start diskmgmt.msc");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("bluetooth")==true)
	{
	try
	{
		builder=new ProcessBuilder("fsquirt");//mspaint
		pro=builder.start();
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("partition")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start diskpart");//diskpart
			tf.setText("");
	}
	catch(Exception e){}
	}
	//process builder methods end here
	//Runtime getRuntime exec starts
	else if(tf.getText().equalsIgnoreCase("CMD")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start cmd");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("chrome")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start chrome");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("google")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start chrome www.google.com");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("tab")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.google.com");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("window")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start chrome /new-window www.google.com");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("gmail")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.gmail.com");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("facebook")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.facebook.com");
		tf.setText("");
	}
	catch(Exception e){}
	}
	
	else if(tf.getText().equalsIgnoreCase("Wordpad")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start write");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("microsoft word")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start winword");
		tf.setText("");
	}
	catch(Exception e){}
	}
	else if(tf.getText().equalsIgnoreCase("powerpoint")==true)
	{
	try
	{
		pro=Runtime.getRuntime().exec("cmd /c start powerpnt");
		tf.setText("");
	}
	catch(Exception e){}
	}
else if(tf.getText().equalsIgnoreCase("close")==true)
	{
		pro.destroy();
		tf.setText("");
		
	}

*/

