/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arjarma
 */ 
package majorProject;
 //package PDF;
//importing awt and swing packages
 import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.metal.MetalLookAndFeel.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.print.*;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.awt.datatransfer.*;
import java.awt.datatransfer.Clipboard;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.undo.UndoManager;
import org.bouncycastle.asn1.ASN1Encoding;
//importing PDF package
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.PdfEncryption.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.crypto.AESCipherCBCnoPad;

//importing voice Package
import javax.speech.*;

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

//for recording feature
import javax.sound.sampled.Mixer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.Line;
import javax.sound.sampled.*;



public class Project extends JFrame implements ActionListener//,ListSelectionListener MenuListener,
 {
JTextArea ta;
JMenuBar mb;
JMenu file,edit,view,format,comm,info,help;
JMenuItem newoption,open,save,print,cut,copy,paste,undo,select,close,fonts,cols,looks,txtcol,pcolor,fr,hp,enc,dec,of,rec,speak,record,pause,capture,tti,command;
JFileChooser fc;
FileOutputStream fileo;
JScrollPane jsp,jsp1,jsp3;
JPanel jp;
Border bw;
JLabel lb1,lb2,lb3;
JButton b1,b2,chb,eb;
JTextField tf1,tf2,tf3;
JList l3;
Vector v3;
JRadioButton r1,r2,r3;
ButtonGroup bg,bg1,bg2;
JRadioButton rw,rlg,rg,rdg,rb,rr,rp,ro,ry,rgr,rbl,rmg,rcy;
JRadioButton rc,rh,rt,rs,rz,ru;
int BOL;
int a;
BaseColor ba;
String family;
float st;
File foso;
///OutputStream foso;
JFrame frame1;
micInput mic=new micInput();
Thread t1; 
String tell;   

UndoManager um;
//ocvolume engine= new ocvolume("wordlist","");
ocvolume engine= new ocvolume("list","");

//ocvolume engine= new ocvolume("wordlist","E:\\Vocab\\");
Voice v=new Voice("kevin16",65535,65535,null);
 SynthesizerProperties props;
 SynthesizerModeDesc desc=new SynthesizerModeDesc(null,"general",Locale.US,Boolean.FALSE,null);
 Synthesizer syn=null;
 Thread speaker;
  
 

Project() throws FileNotFoundException,IOException
{
JFrame jfs=new JFrame();

ta=new JTextArea();
ta.setTabSize(4);
mb=new JMenuBar();
jp=new JPanel();
bw=BorderFactory.createMatteBorder(5,3,20,4,Color.LIGHT_GRAY);
//v1=new Vector();
v3=new Vector();
um=new UndoManager();
ta.getDocument().addUndoableEditListener(um);
//Menu Initialization
file=new JMenu("File	");
edit=new JMenu("Edit	");
view=new JMenu("View	");
comm=new JMenu("Commands");
format=new JMenu("Advanced ");
info=new JMenu("Information	");
help=new JMenu("Help	");
//MenuItem Initialization
newoption=new JMenuItem("New",new ImageIcon("new.png"));
open=new JMenuItem("Open",new ImageIcon("open.png"));
save=new JMenuItem("Save",new ImageIcon("save.png"));
print=new JMenuItem("Print",new ImageIcon("print.png"));
close=new JMenuItem("Close",new ImageIcon("close.png"));
cut=new JMenuItem("Cut",new ImageIcon("cut.png"));
copy=new JMenuItem("Copy",new ImageIcon("copy.png"));
paste=new JMenuItem("Paste",new ImageIcon("paste.png"));
undo=new JMenuItem("Undo",new ImageIcon("undo.png"));
select=new JMenuItem("Select",new ImageIcon("select.png"));
fonts=new JMenuItem("Font",new ImageIcon("font.png"));
cols=new JMenuItem("Color",new ImageIcon("colour.png"));
looks=new JMenuItem("Look and Feel",new ImageIcon("lookandfeel.png"));
txtcol=new JMenuItem("TextColour",new ImageIcon("text_colour.png"));
pcolor=new JMenuItem("Choose PDF Colour",new ImageIcon("pdfi.png"));
fr=new JMenuItem("Info",new ImageIcon("info.png"));
hp=new JMenuItem("help",new ImageIcon("help.png"));
enc=new JMenuItem("Save with Encryption",new ImageIcon("encrypted.png"));
dec=new JMenuItem("Open Encrypted",new ImageIcon("unlock.png"));
// save and pause
//savAudio=new JMenuItem("Save In Audio Format");
pause=new JMenuItem("Pause Engine");

//Advance JMenuItems
of=new JMenuItem("More Document Options",new ImageIcon("doc1.png"));
rec=new JMenuItem("Recognize",new ImageIcon("recognition.png"));
speak=new JMenuItem("Speak",new ImageIcon("synthesis.png"));
record=new JMenuItem("Record the voice",new ImageIcon("record.png"));
capture=new JMenuItem("Capture screen",new ImageIcon("capture.png"));

tti=new JMenuItem("Text To Image",new ImageIcon("text.png"));
command=new JMenuItem("Execute",new ImageIcon("command.png"));
//add fileOptions
file.add(newoption);
file.addSeparator();
file.add(open);
file.addSeparator();
file.add(save);
file.addSeparator();
file.add(enc);
file.addSeparator();
file.add(dec);
file.addSeparator();

file.add(print);
file.addSeparator();
file.add(close);
edit.addSeparator();
//add edit option
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

//add view option
view.add(fonts);
view.addSeparator();
view.add(pcolor);
view.addSeparator();
view.add(cols);
view.addSeparator();
view.add(looks);
view.addSeparator();
view.add(txtcol);
//add format
//comm.add(txtcol);

//add format
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


//add info
info.add(fr);
help.add(hp);

comm.add(command);
comm.addSeparator();


setDefaultCloseOperation(EXIT_ON_CLOSE);
jp.setLayout(new BorderLayout());
fc=new JFileChooser();
java.awt.Font f=new java.awt.Font("Arial",Font.BOLD,20);
ta.setFont(f);
ta.setLineWrap(true);
ta.setWrapStyleWord(true);
 jsp=new JScrollPane(ta);
//ta.setBorder(bw);
jsp.setViewportBorder(new LineBorder(Color.BLACK));

jp.add(jsp);
ta.setBackground(new Color(0,153,153));
ta.setForeground(new Color(255,255,255));

jp.setBorder(bw);
add(jp);
add(jp,BorderLayout.CENTER);
add(mb,BorderLayout.NORTH);

mb.add(file);
mb.add(edit);
mb.add(view);
mb.add(comm);
mb.add(format);
mb.add(info);
mb.add(help);

//mb.add(savAudio);
//mb.add(pause);
//Mnemonic for menus
file.setMnemonic(KeyEvent.VK_F);
edit.setMnemonic(KeyEvent.VK_E);
view.setMnemonic(KeyEvent.VK_V);
comm.setMnemonic(KeyEvent.VK_C);
info.setMnemonic(KeyEvent.VK_I);
help.setMnemonic(KeyEvent.VK_H);
format.setMnemonic(KeyEvent.VK_A);
//Shorcut key set
KeyStroke ne=KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK);
newoption.setAccelerator(ne);

KeyStroke opn=KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK);
open.setAccelerator(opn);

KeyStroke sav=KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK);
save.setAccelerator(sav);

KeyStroke clos=KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK); 
close.setAccelerator(clos);

KeyStroke prin=KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK); 
print.setAccelerator(prin);

KeyStroke cu=KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK);
cut.setAccelerator(cu);

KeyStroke co=KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK);
copy.setAccelerator(co);

KeyStroke pa=KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK);
paste.setAccelerator(pa);

KeyStroke se=KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK);
select.setAccelerator(se);

KeyStroke un=KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK);
undo.setAccelerator(un);
KeyStroke eng=KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK);
enc.setAccelerator(eng);

KeyStroke dcd=KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_DOWN_MASK);
dec.setAccelerator(dcd);

KeyStroke spk=KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK+KeyEvent.SHIFT_DOWN_MASK);
speak.setAccelerator(spk);

KeyStroke rcg=KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK);
rec.setAccelerator(rcg);

KeyStroke ks=KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_DOWN_MASK);
of.setAccelerator(ks);
record.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,KeyEvent.CTRL_DOWN_MASK));
looks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_DOWN_MASK));
fonts.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
pcolor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,KeyEvent.CTRL_DOWN_MASK));
cols.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,KeyEvent.CTRL_DOWN_MASK));
txtcol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK));
fr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_DOWN_MASK));
hp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_DOWN_MASK));
capture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.CTRL_DOWN_MASK));
tti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));//+KeyEvent.SHIFT_DOWN_MASK
command.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK+KeyEvent.SHIFT_DOWN_MASK));


// add file action Listeners
newoption.addActionListener(this);
open.addActionListener(this);
save.addActionListener(this);
close.addActionListener(this);
print.addActionListener(this);

//edit listeners
cut.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
select.addActionListener(this);
undo.addActionListener(this);

//choose listeners
fonts.addActionListener(this);
cols.addActionListener(this);
looks.addActionListener(this);
txtcol.addActionListener(this);
pcolor.addActionListener(this);
fr.addActionListener(this);
hp.addActionListener(this);
enc.addActionListener(this);
dec.addActionListener(this);

//add advanced listeners
of.addActionListener(this);
rec.addActionListener(this);
speak.addActionListener(this);
record.addActionListener(this);
capture.addActionListener(this);
command.addActionListener(this);
tti.addActionListener(this);

//commands Frame
//comm.addMenuListener(this);

//savAudio.addActionListener(this);
//pause.addActionListener(this);



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
n=JOptionPane.showOptionDialog(null,"Some changes have been Done.Do You Want to save?","Project",
JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
if(n==JOptionPane.NO_OPTION)
{
System.exit(0);
}
if(n==JOptionPane.CLOSED_OPTION)

	setVisible(true);	

 if (n==JOptionPane.YES_OPTION)
{
	JFrame jfm=new JFrame();
	int p;
	p=fc.showSaveDialog(jfm);
	if(p==JFileChooser.APPROVE_OPTION)
	{
		try
		{
			Document doc=new Document(PageSize.A4);
			FileOutputStream fout=new FileOutputStream(fc.getSelectedFile()+".pdf");
			PdfWriter pwriter=PdfWriter.getInstance(doc,fout);
			doc.open();
			Font fo1 =FontFactory.getFont(FontFactory.HELVETICA,12,Font.BOLD,BaseColor.RED);
			Paragraph para=new Paragraph(ta.getText(),fo1);
			//String str=ta.getText();
			//para.add(str);
			doc.add(para);
			String docs=doc.toString();
			ta.append(docs+"\n");
			doc.close();
		ta.setText("");
		
		}
		catch(IOException e)
		{
			//System.out.println(e);
		}
		catch(DocumentException de)
		{
			//de.printStackTrace();
		}
		
	
JOptionPane.showMessageDialog(null,"Data Has Been Saved Successfully in PDF Format");
}
}
}
});
}  //constructor ends

/*@Override
public void menuSelected(MenuEvent me)
{
	if(me.getSource().equals(comm))
	{	Starter.SpeakerInit("Command Mode activated");  
		VoiceMode.sayNormalMode();
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
		java.awt.Font foo=new java.awt.Font("Arial",Font.BOLD,18);
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
		
		}
			}
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
		//VoiceMode.sayNormalMode();
		Command co=new Command();
		co.setSize(270,180);
		co.setVisible(true);
		co.setTitle("Commands");
		co.setLayout(null);
		
	}
if(ae.getSource()==of)//more docs
	{
		/*new Thread(new Runnable()
		{
			public void run()
			{}
		}).start();*/
				try
				{
		
		Fonter1 fo=new Fonter1();
		fo.setVisible(true);
		fo.setResizable(true);
		fo.setTitle("Speech Recognizer and Synthesizer [Doc|Text]");
		Toolkit.getDefaultToolkit().beep();
		fo.setSize(930,575);
		fo.setIconImage(Toolkit.getDefaultToolkit().getImage("doc.jpg"));
		fo.setLocationRelativeTo(null);
			this.dispose();
		
		
				}
				catch(Exception e)
				{}
				
				
	}
	
if(ae.getSource()==rec)//recognizer
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
		
	}
	
	/*try
{
t1.stop();
}
catch(NullPointerException e1){}
t1 = new Thread();
t1.start();
*/

if(ae.getSource()==speak)//synthesizer
	{
		Starter.SpeakerInit("Speaking");
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
		
}
	if(ae.getSource()==record)//record voice
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
//catch(LineUnavailableException lue){}
}//record the voice end
	
	
	if(ae.getSource()==capture)
	{
		ScreenCapture.Capture();
		capture.requestFocus();
	}
	
	if(ae.getSource()==fr)
	{
	JOptionPane.showMessageDialog(this,"Ver 1.128: \n Initial Release \n Ver 1.231: Added Fonts and Colour Chooser for PDF \n \n Speech recognizer and synthesizer,a \n recorder & you can execute command from single window \n Use Shortcuts and Mnemonics for better efficiency\n Please Use and Give us Feed back \n\n","arma",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	if(ae.getSource()==hp)
	{
	JOptionPane.showMessageDialog(this,"All Rights Reserved Under AGPL(Affero General Public Licence),misuse is a Criminal Offence.\n For any Query Mail us at amitrjha94@gmail.com \n or follow us at java graduates \n ","Help",JOptionPane.INFORMATION_MESSAGE);	
	}
	
	if(ae.getSource()==pcolor)    //for choosing PDF Colour
	{
		//rw,rlg,rg,rdg,rb,rr,rp,ro,ry,rgr,rbl,rmg,rcy
		JFrame pcolor=new JFrame("Choose PDF Colour");
		pcolor.setVisible(true);
		pcolor.setSize(300,500);
		pcolor.setLayout(null);
		pcolor.setLocationRelativeTo(null);
		//java.awt.Color c=;
		// radio button initialisation
		chb=new JButton("OK");
		
		rw=new JRadioButton("WHITE");
		rlg=new JRadioButton("LIGHT_GRAY");
		rg=new JRadioButton("GRAY");
		rdg=new JRadioButton("DARK_GRAY");
		rb=new JRadioButton("BLACK",true);
		rr=new JRadioButton("RED");
		rp=new JRadioButton("PINK");
		ro=new JRadioButton("ORANGE");
		ry=new JRadioButton("YELLOW");
		rgr=new JRadioButton("GREEN");
		rbl=new JRadioButton("BLUE");
		rmg=new JRadioButton("MAGNETA");
		rcy=new JRadioButton("CYAN");
		// radio set bound
		rw.setBounds(20,20,100,20);
		rlg.setBounds(20,60,100,20);
		rg.setBounds(20,100,100,20);
		rdg.setBounds(20,140,100,20);
		rb.setBounds(20,180,100,20);
		rr.setBounds(20,220,100,20);
		rp.setBounds(20,260,100,20);
		ro.setBounds(20,280,100,20);
		ry.setBounds(20,305,100,20);
		rgr.setBounds(20,330,100,20);
		rbl.setBounds(20,355,100,20);
		rmg.setBounds(20,380,100,20);
		rcy.setBounds(20,410,100,20);
		chb.setBounds(130,260,100,30);
		
		rw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
			ba=BaseColor.WHITE;	
			}
		});
		rlg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
			ba=BaseColor.LIGHT_GRAY;	
			}
		});
		rg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ba=BaseColor.GRAY;
			}
		});
		rdg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ba=BaseColor.DARK_GRAY;
			}
		});
		rb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
					ba=BaseColor.BLACK;
			}
		});
		rr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ba=BaseColor.RED;
			}
		});
		rp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
					ba=BaseColor.PINK;
			}
		});
		ro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
						ba=BaseColor.ORANGE;
			}
		});
		ry.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
						ba=BaseColor.YELLOW;
			}
		});
		rgr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ba=BaseColor.GREEN;
			}
		});
		rbl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
						ba=BaseColor.BLUE;
			}
		});
		rmg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
					ba=BaseColor.MAGENTA;
			}
		});
		rcy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ba=BaseColor.CYAN;
			}
		});
				
chb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				pcolor.dispose();
			}
		});
		bg1=new ButtonGroup();
		bg1.add(rw);
		bg1.add(rlg);
		bg1.add(rg);
		bg1.add(rdg);
		bg1.add(rb);
		bg1.add(rr);
		bg1.add(rp);
		bg1.add(ro);
		bg1.add(ry);
		bg1.add(rgr);
		bg1.add(rbl);
		bg1.add(rmg);
		bg1.add(rcy);
		
		pcolor.add(rw);
		pcolor.add(rlg);
		pcolor.add(rg);
		pcolor.add(rdg);
		pcolor.add(rb);
		pcolor.add(rr);
		pcolor.add(rp);
		pcolor.add(ro);
		pcolor.add(ry);
		pcolor.add(rgr);
		pcolor.add(rbl);
		pcolor.add(rmg);
		pcolor.add(rcy);
		pcolor.add(chb);
		
		
	
	}
	if(ae.getSource()==newoption)  //new page
		{
		ta.setText("");
		Starter.SpeakerInit("data erased");
		JOptionPane.showMessageDialog(null,"Previous Data Has Been Erased");		
		}
	if(ae.getSource()==undo)
	{
		Document doc=new Document();
		doc.open();
		doc.close();
	}
	
if(ae.getSource()==fonts)  //choose fonts
	{
Starter.SpeakerInit("Select Font");
		
	JFrame fn=new JFrame();
	fn.setVisible(true);
	fn.setSize(600,355);
	fn.setTitle("Font");
	fn.setLocationRelativeTo(null);
	fn.setLayout(null);		

	//String fnt[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();			
	//Font fnt[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();      //getAllFonts();
	//String arr[]=new String[]{"FoCourier","Helvetica","Time-Roman","Symbol","Zapfdingbats","Undefined"};
	/*String arr[]=new String[]{"FontFamily.COURIER","FontFamily.HELVETICA","FontFamily.TIMES_ROMAN","FontFamily.SYMBOL","FontFamily.ZAPFDINGBATS","FontFamily.UNDEFINED"};
for(int i=0;i<arr.length;i++)
{
v1.addElement(arr[i]); //.getFontName()
}
*/
for(int i=1;i<=72;i++)
{
v3.addElement(Integer.toString(i));
}
Border bor1=new BevelBorder(1);
lb1=new JLabel();
lb1.setText("Font:");
lb1.setBounds(40,20,50,15);

lb2=new JLabel();
lb2.setText("Style:");
lb2.setBounds(320,40,50,15);

lb3=new JLabel();
lb3.setText("size:");
lb3.setBounds(450,15,50,15);

setDefaultCloseOperation(EXIT_ON_CLOSE);
b1=new JButton("OK");
b2=new JButton("Cancel");
//tf1=new JTextField();  //tf1.setBounds(40,40,250,30); //tf1.setText("FontFamily.TIMES_ROMAN");

tf3=new JTextField();
tf3.setBounds(450,40,50,30);
tf3.setText("11");

l3=new JList(v3);
l3.setBorder(bor1);
//l1=new JList(v1); //l1.setBorder(bor1);


//jsp1=new JScrollPane(l1); //jsp1.setBounds(40,80,250,100);

jsp3=new JScrollPane(l3);
jsp3.setBounds(450,80,50,70);
b1.setBounds(250,220,80,50);
b2.setBounds(350,220,80,50);

r1=new JRadioButton("BOLD",true);
r1.setBounds(320,80,100,30);
r2=new JRadioButton("ITALIC");
r2.setBounds(320,120,100,30);
r3=new JRadioButton("PLAIN");
r3.setBounds(320,160,100,30);

bg=new ButtonGroup();
bg.add(r1);
bg.add(r2);
bg.add(r3);

rc=new JRadioButton("COURIER");
rh=new JRadioButton("HELVETICA");
rt=new JRadioButton("TIMES_ROMAN",true);
rs=new JRadioButton("SYMBOL");
rz=new JRadioButton("ZAPFDINGBATS");
ru=new JRadioButton("UNDEFINEDD");

rc.setBounds(40,40,150,30);
rh.setBounds(40,80,150,30);
rt.setBounds(40,120,150,30);
rs.setBounds(40,160,150,30);
ru.setBounds(40,240,150,30);
rz.setBounds(40,200,150,30);

bg2=new ButtonGroup();
bg2.add(rc);
bg2.add(rh);
bg2.add(rt);
bg2.add(rs);
bg2.add(rz);
bg2.add(ru);
fn.add(tf3);
//fn.add(tf1); //fn.add(jsp1);
	
	
/*
l1.addListSelectionListener(new ListSelectionListener()
{
public void valueChanged(ListSelectionEvent lis)
{

tf1.setText((String)l1.getSelectedValue());	
	}	
});*/

l3.addListSelectionListener(new ListSelectionListener()
{
public void valueChanged(ListSelectionEvent lis)
{
	tf3.setText((String)l3.getSelectedValue());
}
});

r1.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{   try{
	
	 BOL=Font.BOLD;
	
	}
	catch(NumberFormatException e)
		{
			
		}
	}
});
r2.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		try{
		 BOL=Font.ITALIC;   //italic
 		}
		catch(NumberFormatException e)
		{		}
	}
});
r3.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		try{
	 BOL=Font.NORMAL;  //pl
			}
catch(NumberFormatException e)
		{
			
		}
		}
});

b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try{	
//font=new Font(tf1.getText(),BOL,Integer.parseInt(tf3.getText()),ba);

//ta.setFont(font);
fn.dispose();
}
catch(Exception e)
{
}
}});
	
b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{ 
try
{
	fn.dispose();
}
catch(Exception e)
{
}
	}
});

	rc.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			 family="FontFamily.COURIER";
		}
		
	});
	
	rh.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			 family="FontFamily.HELVETICA";
		}
		
	});
	rt.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		family="FontFamily.TIMES_ROMAN";
		}
		
	});
	rs.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			family="FontFamily.SYMBOL";
		}
		
	});
	rz.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			family="FontFamily.ZAPFDINGBATS";
		}
		
	});
	ru.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			family="FontFamily.UNDEFINED";
		}
		
	});
fn.add(jsp3);
fn.add(b1);
fn.add(b2);
fn.add(lb1);
fn.add(lb2);
fn.add(lb3);
fn.add(r1);
fn.add(r2);
fn.add(r3);

fn.add(rc);
fn.add(rh);
fn.add(rt);
fn.add(rs);
fn.add(rz);
fn.add(ru);




}	//choose fonts end
	if(ae.getSource()==open)   //open
	{
Starter.SpeakerInit("Select a PDF File");
	int n;
		n=fc.showOpenDialog(this);
		if(n==JFileChooser.APPROVE_OPTION)
		{
			  String xtn= "pdf";		  
        FileNameExtensionFilter  type=new FileNameExtensionFilter("Select Only PDF File Or Write File with Extension(."+ xtn + ")", xtn);
        fc.addChoosableFileFilter(type);
        fc.setFileFilter(type);
        fc.setAcceptAllFileFilterUsed(true);
		
		  try{
		
			  FileInputStream fin=new FileInputStream(fc.getSelectedFile());
			  //FileInputStream fex=new FileInputStream(fc.getSelectedFile()+"."+xtn);
			  
			  Document doc=new Document(PageSize.A4);
			  doc.open();
			  Font red = new Font(FontFamily.HELVETICA, 14, Font.BOLD, ba);
			  PdfReader pr=new PdfReader(fin);
			   int a=pr.getNumberOfPages();
			  for(int i=1;i<=a;i++)
			  {
			  String strn=PdfTextExtractor.getTextFromPage(pr,i);
			  ta.append(strn);
			  Paragraph par=new Paragraph(ta.getText(),red);
			  doc.add(par);
			  }
		doc.close();
		fin.close();
		  }
			catch(IOException ie)
			{
				System.out.println(ie);
			}
			catch(DocumentException de)
			{
			}
		}
	}
	
	if(ae.getSource()==dec)
	{
Starter.SpeakerInit("Enter. Password.");
String pass=JOptionPane.showInputDialog(this,"Enter password for yor File");
		if(pass==null || pass.length()==0)
		{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Password Cannot Be Empty");
				pass=JOptionPane.showInputDialog(this,"Enter password for yor File");
		}
		int n;
		n=fc.showDialog(this,"Decrypt");
		if(n==JFileChooser.APPROVE_OPTION)
		{
			  String xtn= "pdf";		  
        FileNameExtensionFilter  type=new FileNameExtensionFilter("Select Only PDF File Or Write File with Extension(."+ xtn + ")", xtn);
        fc.addChoosableFileFilter(type);
        fc.setFileFilter(type);
        fc.setAcceptAllFileFilterUsed(true);
		  try{
			  FileInputStream fin=new FileInputStream(fc.getSelectedFile());
				Document doc=new Document(PageSize.A4);
			  doc.open();
			  Font red = new Font(FontFamily.HELVETICA, 14, Font.BOLD, ba);
			  PdfReader pr=new PdfReader(fin,pass.getBytes());
			   int a=pr.getNumberOfPages();
			  for(int i=1;i<=a;i++)
			  {
			  String strn=PdfTextExtractor.getTextFromPage(pr,i);
			  ta.append(strn);
			  Paragraph par=new Paragraph(ta.getText(),red);
			  doc.add(par);
			  }
			  doc.close();
			  fin.close();
		  }
			catch(IOException ie)
			{
				System.out.println(ie);
			}
			catch(DocumentException de)
			{
			}
			
		}
	}
	
	if(ae.getSource()==save)  //save option
	{
		//String stra=JOptionPane.showInputDialog(this,"ask");
			Starter.SpeakerInit("Select Path for the file");
			int n;
			n=fc.showSaveDialog(this);	
			if(n==JFileChooser.APPROVE_OPTION)
		try{
			FileOutputStream fileo=new FileOutputStream(fc.getSelectedFile()+".pdf");
			Document doc=new Document(PageSize.A4);
			PdfWriter pwriter=PdfWriter.getInstance(doc,fileo);
			doc.open();
			
			Font fnt =FontFactory.getFont(family,Float.parseFloat(tf3.getText()), BOL,ba);
		//Font fo = FontFactory.getFont(FontFactory.HELVETICA,Integer.parseInt(tf3.getText()),BOL,ba);
			Paragraph para=new Paragraph(ta.getText(),fnt);
			doc.add(para);
			ta.setText("");
			doc.close();
			pwriter.close();
			fileo.close();
			JOptionPane.showMessageDialog(null,"Data Has Been Saved Successfully in PDF Format");	
			}
		catch(IOException e)
		{
			//System.out.println(e);
		}
		catch(DocumentException de)
		{
			//System.out.println(de);
		}
		catch(NullPointerException nle)
		{
			
		}
			

		}
		
		
		if(ae.getSource()==enc)
	{
		String user=JOptionPane.showInputDialog(this,"Enter User Password");
		String owner=JOptionPane.showInputDialog(this,"Enter Owner Password");
		
		int ap;
			ap=fc.showDialog(this,"Encrypt");	
			if(ap==JFileChooser.APPROVE_OPTION)
			try{
			Document doc=new Document(PageSize.A4);
			FileOutputStream fileo=new FileOutputStream(fc.getSelectedFile()+".pdf");
			PdfWriter writer =PdfWriter.getInstance(doc, fileo);
			writer.setEncryption(user.getBytes(),owner.getBytes(),PdfWriter.ALLOW_PRINTING,PdfWriter.ENCRYPTION_AES_128);//| PdfWriter.DO_NOT_ENCRYPT_METADATA
			doc.open();
			Font fnt =FontFactory.getFont(family,Float.parseFloat(tf3.getText()), BOL,ba);
			Paragraph para=new Paragraph(ta.getText(),fnt);
			doc.add(para);
			ta.setText("");	
			doc.close();
			writer.close();
			JOptionPane.showMessageDialog(null,"Data Has Been Saved Successfully in PDF Format");	
fileo.close();	

	}
	catch(IOException e)
		{
			//System.out.println(e);
		}
		catch(DocumentException de)
		{
			//System.out.println(de);
		}
		
		
	}
	
	
	
	if(ae.getSource()==print) //print option
	{
		try{
			String str=ta.getSelectedText();
		//PrintJob job=getToolkit().getPrintJob(this,str,null);
PrinterJob job = PrinterJob.getPrinterJob();
PageFormat pf = job.pageDialog(job.defaultPage());
job.setPrintable(null);
		job.print();
	//	pj.print();
			//boolean doPrint=pj.printDialog();
		}
		catch(Exception pe)
		{
			pe.printStackTrace();
		}
	}
	if(ae.getSource()==cut)  // ctrl + x
	{
		String str=ta.getSelectedText();
		Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection data=new StringSelection(str);
		clip.setContents(data,data);
		ta.replaceRange(str,ta.getSelectionStart(),ta.getSelectionEnd());
	}
	if(ae.getSource()==copy)  //ctrl + c
	{
		String str=ta.getSelectedText();
		Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection data=new StringSelection(str);
		clip.setContents(data,data);
	}
	if(ae.getSource()==paste)  //ctrl + v
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
	
	if(ae.getSource()==select) //Select All
	{
		Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
		String str=ta.getSelectedText();
	}
	if(ae.getSource()==close)  //closing
	{
			System.exit(0);
	}
if(ae.getSource()==txtcol)   //text colour
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
if(ae.getSource()==cols)
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
				Color cl=jc.getColor();
				col.dispose();
				ta.setBackground(cl);
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
			JFrame lks=new JFrame("LookAndFeel");
			lks.setVisible(true);
			lks.setSize(400,200);
			lks.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			JPanel lb=new JPanel();
			lks.setLayout(new BorderLayout());
			lks.setLocationRelativeTo(null);
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
			lks.add(lb,BorderLayout.CENTER);
				jb1.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent ae)
			{
				try{
				MetalTheme theme=new LightTheme();
				MetalLookAndFeel.setCurrentTheme(theme);		
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Project.this);	
				lks.dispose();
				
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
					SwingUtilities.updateComponentTreeUI(Project.this);
					lks.dispose();			
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
			SwingUtilities.updateComponentTreeUI(Project.this);
			lks.dispose();
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
			SwingUtilities.updateComponentTreeUI(Project.this);
			lks.dispose();
				}
				catch(Exception e)
				{
				}
			}
			});
			}
			}//actionPerformed ends

public static void main(String args[])  throws FileNotFoundException,IOException,InterruptedException
{
	
Project po=new Project();
po.setTitle("Speech Recognizer and Synthesizer [PDF]");
po.setIconImage(Toolkit.getDefaultToolkit().getImage("pdf64.png"));
po.setVisible(true);
po.setResizable(true);
po.setSize(930,575);
po.setLocationRelativeTo(null);

Toolkit.getDefaultToolkit().beep();
Starter.SpeakerInit("Select Font Before Using PDF ");
JOptionPane.showMessageDialog(null,"Select Font Before Using PDF Documents","WARNING",JOptionPane.WARNING_MESSAGE);
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
/* 

	public static void myFont()
	{
	family="FontFamily.COURIER";
	st=12;
	BOL=Font.BOLD;
	}
}*/
} 
