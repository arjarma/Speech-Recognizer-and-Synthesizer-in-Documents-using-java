package majorProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.Vector;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.metal.MetalLookAndFeel.*;
import java.awt.event.KeyEvent;
import java.awt.print.*;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.awt.datatransfer.*;
import java.awt.datatransfer.Clipboard;
import javax.swing.undo.UndoManager;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Font;


//importing voice Package
import javax.speech.*;

//for recording feature
import javax.sound.sampled.Mixer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.Line;
import javax.sound.sampled.*;

//import javax.speech.synthesis.*;
import javax.speech.Central;
import javax.speech.EngineList;
import javax.speech.EngineCreate;
import javax.speech.synthesis.SynthesizerProperties;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

//import com.sun.speech.freetts.*;
import com.sun.speech.freetts.jsapi.FreeTTSEngineCentral;

//importing recognizer
import org.oc.ocvolume.*;
import org.oc.ocvolume.audio.*;
import org.oc.ocvolume.audio.micInput;


public class Fonter1 extends JFrame implements ActionListener //MenuListener,
{

JFrame jf;
JList l1,l2,l3;
JLabel lb1,lb2,lb3;
JTextField tf1,tf2,tf3;
JMenuBar mb;
JTextArea ta,pre;
JMenu file,edit,format,view,comm,help;
JMenuItem newf,open,save,print,exit,cut,copy,paste,fon,undo,col,txtcol,rec,record,speak,of,looks,text_colour,select,info,helps,capture,tti,command;
JScrollPane jsp,jsp1,jsp2,jsp3;
JPanel jp,jp1;
JFileChooser jfc;
FileOutputStream fileo;
Font font;
BorderLayout br; 
Border border;
String fname=null;
Integer fstyle=null;
Integer fsize=null;
JFileChooser fc;
File foso;
///OutputStream foso;
JFrame frame1;
micInput mic=new micInput();
Thread t1; 
String tell;   

UndoManager um;
ocvolume engine= new ocvolume("list","");

//ocvolume engine= new ocvolume("list","E:\\Vocab\\");
Voice v=new Voice("kevin16",65535,65535,null);
SynthesizerProperties props;
SynthesizerModeDesc desc=new SynthesizerModeDesc(null,"general",Locale.US,Boolean.FALSE,null);
Synthesizer syn=null;
Thread speaker;

Fonter1() throws FileNotFoundException,IOException
{
mb=new JMenuBar(); 

file=new JMenu("File    ");
edit=new JMenu("Edit    ");
format=new JMenu("Advanced    ");
comm=new JMenu("Commands  ");
view=new JMenu("View    ");
help=new JMenu("Help    ");
um=new UndoManager();
//filemenu item
newf=new JMenuItem("New ",new ImageIcon("new.png"));
open=new JMenuItem("Open ",new ImageIcon("open.png"));
save=new JMenuItem("Save ",new ImageIcon("save.png"));
print=new JMenuItem("Print ",new ImageIcon("print.png"));
exit=new JMenuItem("Exit ",new ImageIcon("close.png"));
//editmenu items
undo=new JMenuItem("Undo",new ImageIcon("undo.png"));
cut=new JMenuItem("Cut ",new ImageIcon("cut.png"));
select=new JMenuItem("select",new ImageIcon("select.png"));
copy=new JMenuItem("Copy ",new ImageIcon("copy.png"));
paste=new JMenuItem("Paste ",new ImageIcon("paste.png"));

//advanced items
of=new JMenuItem("PDF options",new ImageIcon("pdf_opt.png"));
rec=new JMenuItem("Recognize",new ImageIcon("recognition.png"));
speak=new JMenuItem("Speak",new ImageIcon("synthesis.png"));
record=new JMenuItem("Record the voice",new ImageIcon("record.png"));
capture=new JMenuItem("Capture Screen",new ImageIcon("capture.png"));
tti=new JMenuItem("Text To Image",new ImageIcon("text.png"));
//view items
fon=new JMenuItem("Choose Fonts",new ImageIcon("font.png"));
col=new JMenuItem("Choose Colours",new ImageIcon("colour.png"));
text_colour=new JMenuItem("Text Colour",new ImageIcon("text_colour.png"));
looks=new JMenuItem("LookAndFeel",new ImageIcon("lookandfeel.png"));

info=new JMenuItem("Info",new ImageIcon("info.png"));
helps=new JMenuItem("help",new ImageIcon("help.png"));

comm=new JMenu("Commands");
command=new JMenuItem("Execute ",new ImageIcon("command.png"));
//file menu item
file.add(newf);
file.addSeparator();
file.add(open);
file.addSeparator();
file.add(save);
file.addSeparator();
file.add(print);
file.addSeparator();
file.add(exit);
//edit menu item
edit.add(cut);
edit.addSeparator();
edit.add(select);
edit.addSeparator();
edit.add(copy);
edit.addSeparator();
edit.add(paste);
edit.addSeparator();
edit.add(undo);
edit.addSeparator();

//format menu item
format.add(of);
format.addSeparator();
format.add(rec);
format.addSeparator();
format.add(speak);
format.addSeparator();
format.add(record);
format.addSeparator();
format.add(capture);
format.addSeparator();
format.add(tti);

//view menu item
view.add(col);
view.addSeparator();
view.add(fon);
view.addSeparator();
view.add(looks);
view.addSeparator();
view.add(text_colour);

help.add(info);
help.add(helps);

comm.add(command);
comm.addSeparator();

mb.add(file);
mb.add(edit);
mb.add(view);
mb.add(comm);
mb.add(format);
mb.add(help);

ta=new JTextArea();
ta.setTabSize(4);
pre=new JTextArea("Preview");
pre.setEditable(false);
br=new BorderLayout();
border=BorderFactory.createMatteBorder(5,3,20,4,Color.LIGHT_GRAY);
setDefaultCloseOperation(EXIT_ON_CLOSE);
jp=new JPanel();
ta.setBackground(new Color(102,0,51));
ta.setForeground(new Color(255,153,0));
ta.setLineWrap(true);
ta.setWrapStyleWord(true);
ta.setFont(new Font("Arial",Font.BOLD,20));
jp.setLayout(br);
jsp=new JScrollPane(ta);
jsp.setViewportBorder(new LineBorder(Color.BLACK));
jp.setBorder(border);
jp.add(jsp);
add(jp,BorderLayout.CENTER);
add(mb,BorderLayout.NORTH);
fc=new JFileChooser();
//fc=new JFileChooser();

file.setMnemonic(KeyEvent.VK_F);
edit.setMnemonic(KeyEvent.VK_E);
view.setMnemonic(KeyEvent.VK_V);
comm.setMnemonic(KeyEvent.VK_C);
//info.setMnemonic(KeyEvent.VK_I);
help.setMnemonic(KeyEvent.VK_H);
format.setMnemonic(KeyEvent.VK_A);

newf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));

open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));

save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));

print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));

exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));

undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK));

select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));

cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));

copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));

paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));

text_colour.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK));
looks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_DOWN_MASK));

of.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_DOWN_MASK));

rec.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK));

speak.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK+KeyEvent.SHIFT_DOWN_MASK));

record.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,KeyEvent.CTRL_DOWN_MASK));

fon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
col.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,KeyEvent.CTRL_DOWN_MASK));
info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_DOWN_MASK));
helps.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_DOWN_MASK));
capture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.CTRL_DOWN_MASK));
tti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));//+KeyEvent.SHIFT_DOWN_MASK
command.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK+KeyEvent.SHIFT_DOWN_MASK));

ta.getDocument().addUndoableEditListener(um);

newf.addActionListener(this);
open.addActionListener(this);
save.addActionListener(this);
print.addActionListener(this);
exit.addActionListener(this);

cut.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
select.addActionListener(this);
undo.addActionListener(this);

fon.addActionListener(this);
col.addActionListener(this);
//jp.setBorder(BorderFactory.createMatteBorder(5,3,20,4,Color.LIGHT_GRAY));
text_colour.addActionListener(this);
looks.addActionListener(this);
of.addActionListener(this);
rec.addActionListener(this);
speak.addActionListener(this);
record.addActionListener(this);
capture.addActionListener(this);

tti.addActionListener(this);
command.addActionListener(this);

//comm.addMenuListener(this);
info.addActionListener(this);
helps.addActionListener(this);
/**/
try{
			MetalTheme theme=new LightTheme();
			MetalLookAndFeel.setCurrentTheme(theme);		
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);	
}
catch(Exception e)
{
}
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we) 
{	
int n;
n=JOptionPane.showOptionDialog(null,"Some changes have been Done.Do You Want to save?","Recognizer",
JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
if(n==JOptionPane.NO_OPTION)
{
System.exit(0);
}
if(n==JOptionPane.CLOSED_OPTION)
{
	setVisible(true);	
}
 if (n==JOptionPane.YES_OPTION)
{
	//JFrame jfm=new JFrame();
	String pass=JOptionPane.showInputDialog(this,"type the file Extension");
	if(pass==null || pass.length()==0)
	{
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, "file Extension is Mandatory");
				pass=JOptionPane.showInputDialog(this,"type the file Extension");
	}
	int p=fc.showSaveDialog(new JFrame());
	if(p==JFileChooser.APPROVE_OPTION)
	{
	try
	{
	FileWriter fw=new FileWriter(fc.getSelectedFile()+"."+pass);
	BufferedWriter br=new BufferedWriter(fw);
	Scanner s=new Scanner(ta.getText());
	
	while(s.hasNext())
	{
		br.write(s.nextLine());
		br.newLine();
	}
	br.close();
}
catch(IOException e)
{
	System.out.println(e);
}
}
JOptionPane.showMessageDialog(null,"Data Has Been Saved Successfully" );
}
}
		
});


}//end of constructor

/*
public void menuSelected(MenuEvent me)
{
	if(me.getSource().equals(comm))
	{	Starter.SpeakerInit("Command Mode");   
		//VoiceMode.sayNormalMode();
		Command co=new Command();
		co.setSize(270,180);
		co.setVisible(true);
		co.setTitle("Commands");
		co.setLayout(null);
		
	}
}
public void menuCanceled(MenuEvent me)
{
}
public void menuDeselected(MenuEvent me)
{
		
}*/

public void actionPerformed(ActionEvent ae)
{
	/*if(ae.getSource()==)
	{
	}*/
	if(ae.getSource()==tti)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
		String strtext;	
			if(ta.getSelectedText() !=null)
			{
				strtext=ta.getSelectedText();
			}
			else
			{
		strtext=ta.getText();
			}
		StringBuilder sb=new StringBuilder(strtext);
		int a=0;
		while((a=sb.indexOf(" ",a+65)) != -1)
		{
			sb.replace(a,a+1,"\n");
		}
		
		String manipulatedString=sb.toString();
		String strArr[]=manipulatedString.split("\n");
		
		BufferedImage img=new BufferedImage(640,480,BufferedImage.TYPE_INT_ARGB);
		Graphics g=img.getGraphics();
		//System.out.println(strtext.length());
		g.setColor(Color.WHITE);
		Font foo=new Font("Arial",Font.BOLD,18);
		FontMetrics fm=g.getFontMetrics(foo);
		g.setFont(foo);
		
		for(int i=0;i<strArr.length;i++)
		{
			g.drawString(strArr[i],10,(fm.getAscent()+5)*(i+1));
		}

int n;
n=fc.showSaveDialog(new JFrame());
			if(n==JFileChooser.APPROVE_OPTION)
			{
				try{
		ImageIO.write(img,"jpg",new File(fc.getSelectedFile()+".jpg"));
		System.out.println("Created");
		
JOptionPane.showMessageDialog(null,"Image Created");
				}
				catch(IOException e)
		{
		}		
		
		}	}
		}).start();
		
	}
	
	if(ae.getSource()==undo)
	{
		if(um.canUndo())
		{
			um.undo();
		}
		else
		{
			//System.out.println("Can't do it");
			JOptionPane.showMessageDialog(null,"No Data in Undo Manager");
			Toolkit.getDefaultToolkit().beep();
		}
	}
	if(ae.getSource()==command)
	{
		Starter.SpeakerInit("Command Mode");   
		Command co=new Command();
		co.setSize(270,180);
		co.setVisible(true);
		co.setTitle("Commands");
		co.setLayout(null);
		
	}
	
	if(ae.getSource()==capture)
	{
		ScreenCapture.Capture();
		
	}
	
	if(ae.getSource()==info)
	{
	JOptionPane.showMessageDialog(this,"Ver 1.128: \n Initial Release \n Ver 1.231: Added Fonts,Colour Chooser for texts and documents \n Speech recognizer and synthesizer,a \n recorder & you can execute command from single window \n Use Shortcuts and Mnemonics for better efficiency\n Please Use it and Give us Feedback \n\n ","arma",JOptionPane.INFORMATION_MESSAGE);
	}

	if(ae.getSource()==helps)
	{
	JOptionPane.showMessageDialog(this,"All Rights Reserved Under AGPL(Affero General Public Licence),misuse is a Criminal Offence.\n For any Query Mail us at amitrjha94@gmail.com \n or follow us at java graduates \n ","Help",JOptionPane.INFORMATION_MESSAGE);	
	}
		
	if(ae.getSource()==newf)
	{
		if(ta.getText()!=null)
		{
		JOptionPane.showMessageDialog(null,"All data will be erased !");
		ta.setText("");
		}
		else
		{
			ta.setText("");
			JOptionPane.showMessageDialog(null,"Date Erased");
		}
	}
	if(ae.getSource()==open)
		{
		ta.setText("");
		Starter.SpeakerInit("Select Location of file");
		int n=fc.showOpenDialog(this);
		if(n==JFileChooser.APPROVE_OPTION)
		{
		try
	{
		Scanner sc=new Scanner(fc.getSelectedFile());
		while(sc.hasNext())
	{
		String str=sc.nextLine();
		ta.append(str+"\n");
		}
	}
	catch(FileNotFoundException fnf)
	{
		System.out.println(fnf);
	}
	}

	}
	
	if(ae.getSource()==save)
		{
	String pass=JOptionPane.showInputDialog(this,"type the file Extension");
	if(pass==null || pass.length()==0)
	{
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(this, "file Extension is Mandatory");
				pass=JOptionPane.showInputDialog(this,"type the file Extension");
	}
	Starter.SpeakerInit("Select Path for the file");
int n=fc.showSaveDialog(this);
if(n==JFileChooser.APPROVE_OPTION)
{
	try
{
	FileWriter fw=new FileWriter(fc.getSelectedFile()+"."+pass);
	BufferedWriter br=new BufferedWriter(fw);
	Scanner s=new Scanner(ta.getText());
	
	while(s.hasNext())
	{
		br.write(s.nextLine());
		br.newLine();
	}
	br.close();
	JOptionPane.showMessageDialog(null,"Data Has Been Saved Successfully in specified Format");	
	ta.setText("");
}
catch(IOException e)
{
	System.out.println(e);
}
}	
}
	if(ae.getSource()==print)
		{
			try
			{
			ta.print();
			}
			
			catch(PrinterException pe)
			{
			}
		}
	if(ae.getSource()==exit)
		{
			System.exit(0);
		}
		
		
	if(ae.getSource()==cut)
		{
			String str=ta.getSelectedText();
		Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection data=new StringSelection(str);
		clip.setContents(data,data);
		ta.replaceRange(str,ta.getSelectionStart(),ta.getSelectionEnd());
			
		}
	if(ae.getSource()==copy)
		{
			String str=ta.getSelectedText();
		Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection data=new StringSelection(str);
		clip.setContents(data,data);
			
		}
	if(ae.getSource()==paste)
		{
			try
		{
		Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();		
		Transferable cdata=clip.getContents(clip);
		
		if(cdata.isDataFlavorSupported(DataFlavor.stringFlavor))
		{
			String str=(String)(cdata.getTransferData(DataFlavor.stringFlavor));
		}
		}
		catch(Exception e)
		{ }	
			
		}
	if(ae.getSource()==select)
		{
			Clipboard clips=Toolkit.getDefaultToolkit().getSystemClipboard();
			String str=ta.getSelectedText();
			//clips.setContents(str,null);
		}
		if(ae.getSource()==undo)
		{
			
		}
	
	if(ae.getSource()==fon)
	{
		JFrame fr=new JFrame();
		fr.setSize(600,500);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setTitle("Font");
		fr.setLayout(null);
		//String fnf[];
		Font fnf[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		//GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		//fnf=ge.getAvailableFontFamilyNames();	
		Vector v1=new Vector();
		Vector v2=new Vector();
		Vector v3=new Vector();
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		Button b1=new Button("Ok");
		Button b2=new Button("Cancel");
		Button b3=new Button("Preview");
for(int i=0;i<fnf.length;i++)
{
	v1.addElement(fnf[i].getFontName());
}

v2.addElement("Bold");
v2.addElement("Plain");
v2.addElement("Italic");



for(int i=0;i<80;i++)
{
v3.addElement(Integer.toString(i));
}

l1=new JList(v1);
l2=new JList(v2);
l3=new JList(v3);



l1.addListSelectionListener(new ListSelectionListener()
{
public void valueChanged(ListSelectionEvent lis)
{
tf1.setText((String)l1.getSelectedValue());
}	
});
l2.addListSelectionListener(new ListSelectionListener()
{
public void valueChanged(ListSelectionEvent lis)
{
tf2.setText((String)l2.getSelectedValue());
}	
});
l3.addListSelectionListener(new ListSelectionListener()
{
public void valueChanged(ListSelectionEvent lis)
{
tf3.setText((String)l3.getSelectedValue());
}
});
	
b1.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	ta.setFont(new Font(tf1.getText(),l2.getSelectedIndex(),Integer.parseInt(tf3.getText())));
	fr.dispose();
	}
});

b3.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	pre.setFont(new Font(tf1.getText(),l2.getSelectedIndex(),Integer.parseInt(tf3.getText())));
	
	}
});


pre.setBounds(50,300,400,120);


Border bor1=new BevelBorder(1);
lb1=new JLabel();
lb1.setText("Font :");
lb1.setBounds(40,20,50,15);
lb2=new JLabel();
lb2.setText("Style :");
lb2.setBounds(300,20,50,15);
lb3=new JLabel();
lb3.setText("Size:");
lb3.setBounds(450,15,50,15);
tf1.setBounds(40,40,250,30);
tf2.setBounds(320,40,100,30);
tf3.setBounds(450,40,60,30);
tf1.setText("Arial");
tf2.setText("Bold");
tf3.setText("12");


fr.add(tf1);
fr.add(tf2);
fr.add(tf3);
fr.add(lb1);
fr.add(lb2);
fr.add(lb3);
fr.add(l1);
fr.add(l1);
fr.add(l1);
fr.add(pre);
l1.setBorder(bor1);
l2.setBorder(bor1);
l3.setBorder(bor1);

JScrollPane jsp1=new JScrollPane(l1);
jsp1.setBounds(40,80,250,150);
JScrollPane jsp2=new JScrollPane(l2);
jsp2.setBounds(320,80,100,150);
JScrollPane jsp3=new JScrollPane(l3);
jsp3.setBounds(450,80,60,150);

b1.setBounds(240,250,60,40);
b2.setBounds(340,250,60,40);
b3.setBounds(140,250,60,40);
fr.add(jsp1);
fr.add(jsp2);
fr.add(jsp3);
fr.add(b1);
fr.add(b2);
fr.add(b3);
}	
if(ae.getSource()==col)
	{
		JFrame fs=new JFrame();
		JPanel jp1=new JPanel();
		fs.add(jp1);
		fs.setSize(700,600);
		fs.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fs.setLocationRelativeTo(null);
		JColorChooser jfc=new JColorChooser();
		JButton b1=new JButton("OK");
		JButton b2=new JButton("Cancel");
		jp1.add(jfc,"Center");
		jp1.add(b1);
		jp1.add(b2);
		
b1.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		Color c1=jfc.getColor();
		ta.setBackground(c1);
		fs.dispose();
	}
}); 
b2.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		fs.dispose();
	}
}); 				
}

if(ae.getSource()==text_colour)
{
	JFrame col=new JFrame();
			col.setVisible(true);
		    col.setSize(700,500);
			col.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			col.setLocationRelativeTo(null);
			JColorChooser jc=new JColorChooser();
			JPanel jp=new JPanel();
			JButton set=new JButton("OK");
			JButton exit=new JButton("Cancel");
			jp.add(jc,"Center");
			jp.add(set);
			jp.add(exit);
			col.add(jp);
			set.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				Color c=jc.getColor();
				
				col.dispose();
				ta.setForeground(c);
			}
			});
exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					col.dispose();
				}
			});
}
if(ae.getSource()==looks)
{
			JFrame laf=new JFrame("LookAndFeel");
			laf.setVisible(true);
			laf.setSize(400,200);
			laf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			JPanel lb=new JPanel();
			laf.setLayout(new BorderLayout());
			laf.setLocationRelativeTo(null);
			JRadioButton jb1=new JRadioButton("Metal",true);
			JRadioButton jb2=new JRadioButton("Motif");
			JRadioButton jb3=new JRadioButton("Windows");
			JRadioButton jb4=new JRadioButton("Nimbus");
			ButtonGroup bg4=new ButtonGroup();
			bg4.add(jb1);
			bg4.add(jb2);
			bg4.add(jb3);
			bg4.add(jb4);
			/*JButton jb1=new JButton("Metal");
			JButton jb2=new JButton("Motif");
			JButton jb3=new JButton("Windows");
			JButton jb4=new JButton("Nimbus");
			*/
			lb.add(jb1);
			lb.add(jb2);
			lb.add(jb3);
			lb.add(jb4);
			MetalTheme theme=new LightTheme();
			MetalLookAndFeel.setCurrentTheme(theme);		
			laf.add(lb,BorderLayout.CENTER);
				jb1.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent ae)
			{
				try{
				MetalTheme theme=new LightTheme();
				MetalLookAndFeel.setCurrentTheme(theme);		
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Fonter1.this);	
				laf.dispose();
				
				}
				catch(Exception e)
				{
				}
			}
			});
			//SwingUtilities.updateComponentTreeUI(this);
			jb2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent ae)
			{
				try{
					
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					SwingUtilities.updateComponentTreeUI(Fonter1.this);
					laf.dispose();			
			}
			catch(Exception e)
					{ }
			}
			});
				jb3.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent ae)
			{
				try{
					
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Fonter1.this);
			laf.dispose();
				}
				catch(Exception e)
				{
				}
			}
			});
			jb4.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent ae)
			{
				try{
					
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Fonter1.this);
			laf.dispose();
				}
				catch(Exception e)
				{
				}
			}
			});
}

if(ae.getSource()==rec)//recognizer starts
{
	VoiceMode.sayActivated();
		new Thread(new Runnable()
		{
			public void run()
			 {
				 if(rec.getLabel().equals("Recognize")==true)
		 {
		rec.setLabel("Stop");
		mic = new micInput();
		    mic.start();
			
			while(true){
            mic.removeOldWord();
while(!mic.byteArrayComplete()){
                try{
                    t1.sleep(200);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            mic.newWord();
            short recordedSample[] = mic.returnShortArray();
            String words = engine.getWord(recordedSample);
            //System.out.println(recognizedWord);
		    ta.append(words + " ");
			ta.setCaretPosition(ta.getDocument().getLength());
        }					
}

 if(rec.getLabel().equals("Stop")==true)
		 {
			 //VoiceMode.sayDeactivated();
			rec.setLabel("Recognize");
			mic.stopRecord();
}						 
			 }
		}).start();
	
}//recognition ends
if(ae.getSource()==record) ////recording starts
{
	  int b;
		b=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter the duration for recording \n Note:30 seconds * input"));
		try
		{
		AudioFormat format=new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,16000,16,1,16000,2,false);
		DataLine.Info info=new DataLine.Info(TargetDataLine.class,null);//nullformat
		System.out.println("start record");
		record.setLabel("Stop");
		final TargetDataLine tgl=(TargetDataLine)AudioSystem.getLine(info);
		//final
		tgl.open();
		tgl.start();
	
			/**/int a;
			a=fc.showSaveDialog(frame1);
			if(a==JFileChooser.APPROVE_OPTION)
			{
				foso=new File(fc.getSelectedFile()+".wav");
			}
	new Thread(new Runnable()
		{
			public void run()
			{
				try
				{
		  		AudioInputStream aus=new AudioInputStream(tgl);
			//File foso=new File("rec.wav");
			AudioSystem.write(aus,AudioFileFormat.Type.WAVE,foso);
			}
			catch(Exception e){}
			
		}}).start();		
			record.setLabel("Record the voice");
	pauseIt(b);	
//			Thread.sleep(5000);
			tgl.stop();
			tgl.close();
			System.out.println("Recording finish");
		
		}
catch(Exception e){}
}//recording finish

if(ae.getSource()==speak)//synthesizer starts
{
	Starter.SpeakerInit("i am Speaking");
	new Thread(new Runnable()
{
	public void run()
	{
try
{	
FreeTTSEngineCentral cent=new FreeTTSEngineCentral();
syn=Central.createSynthesizer(desc);
EngineList list=cent.createEngineList(desc);
if(list.size()>0)
{
EngineCreate creator=(EngineCreate)list.get(0);
syn=(Synthesizer)creator.createEngine();
}
if(syn==null)
{
System.out.println("null");
}
speak.setLabel("Pause");
syn.allocate();
syn.resume();
props = syn.getSynthesizerProperties();
props.setVoice(v);
//float newSpeakingRate = props.getSpeakingRate();
//props.setSpeakingRate(newSpeakingRate-30.0f);
//props.setPitchRange(40.0f);
//props.setPitch(100.0f);
float newSpeakingRate = props.getSpeakingRate();
props.setSpeakingRate(newSpeakingRate-40.0f);
float newPitchRange = props.getPitchRange();
props.setPitchRange(newPitchRange-5);
float newPitch = props.getPitch();
props.setPitch(newPitch-1);

if(ta.getSelectedText() != null)
{
syn.speakPlainText(ta.getSelectedText(),null);
}
else
{
syn.speakPlainText(ta.getText(),null);
}
syn.waitEngineState(Synthesizer.QUEUE_EMPTY);
if(speak.getLabel().equals("Pause")==true)
{
	speak.setLabel("Speak");
	syn.pause();
}
}
catch(Exception e)
{
	System.out.println(e);
}
}
}).start();
}//speak ends

if(ae.getSource()==of)//pdf format frame begins
{
	/*new Thread(new Runnable()
		{
			public void run()
			{
			}
		}).start();*/
				try{
		Project pro=new Project();
		pro.setTitle("Speech Recognizer and Synthesizer [PDF]");
		pro.setIconImage(Toolkit.getDefaultToolkit().getImage("pdf64.png"));
Toolkit.getDefaultToolkit().beep();
Starter.SpeakerInit("Select Font Before Using PDF ");
JOptionPane.showMessageDialog(null,"Select Font Before Using PDF Documents","WARNING",JOptionPane.WARNING_MESSAGE);
		pro.setVisible(true);
		pro.setResizable(true);
		pro.setSize(930,575);
		pro.setLocationRelativeTo(null);
		this.dispose();
				}
				catch(Exception e){}
			
	
}//pdf format ends

}//actionPerformed end

public static void main(String arg[]) throws FileNotFoundException,IOException,InterruptedException

{
Fonter1 fn=new Fonter1();
fn.setTitle("Speech Recognizer and Synthesizer [Doc|Text]");
fn.setVisible(true);
fn.setResizable(true);
fn.setSize(930,575);
Toolkit.getDefaultToolkit().beep();
fn.setIconImage(Toolkit.getDefaultToolkit().getImage("doc.jpg"));
fn.setLocationRelativeTo(null);
VoiceMode.sayNormalMode();

}

class LightTheme extends DefaultMetalTheme {

    public String getName() { return "Oxide"; }

    private final ColorUIResource primary1 = new ColorUIResource(102, 153, 153);
    private final ColorUIResource primary2 = new ColorUIResource(128, 192, 192);// 
    private final ColorUIResource primary3 = new ColorUIResource(159, 235, 235);

    protected ColorUIResource getPrimary1() { return primary1; }
    protected ColorUIResource getPrimary2() { return primary2; }
    protected ColorUIResource getPrimary3() { return primary3; }
}
public static void pauseIt(int b)
{
	try
	{
		Thread.sleep(30000*b);
	}
	catch(InterruptedException ie){}
}
} 
