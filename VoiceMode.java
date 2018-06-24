package majorProject;

import java.io.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;


public class VoiceMode
{
public static Mixer mixer;
public static Clip clip;

VoiceMode()
{
}
public static void sayActivated()
{
	try
	{
		Mixer.Info[] infos=AudioSystem.getMixerInfo();
		/*for(Mixer.Info infon:infos)
		{
			System.out.println(infon.getName()+"  "+infon.getDescription());
		}*/
		mixer=AudioSystem.getMixer(infos[0]);
	DataLine.Info dinfos=new DataLine.Info(Clip.class,null);//AudioSystem.getAudioFormat()
	File files=new File("voice mode activated.wav");
	AudioInputStream aus=AudioSystem.getAudioInputStream(files);

	clip=(Clip)mixer.getLine(dinfos);
clip.open(aus);
System.out.println("clip started");
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
catch(LineUnavailableException lue)
	{
		lue.printStackTrace();
	}
catch(UnsupportedAudioFileException iue)
	{
		iue.printStackTrace();
	}
clip.start();
do
{
	try{
	Thread.sleep(200);
	}
	catch(InterruptedException ie){}
}
while(clip.isActive());
System.out.println("clip Closed");
clip.close();

}

public static void sayDeactivated()
{
	try
	{
		Mixer.Info[] infos=AudioSystem.getMixerInfo();
		/*for(Mixer.Info infon:infos)
		{
			System.out.println(infon.getName()+"  "+infon.getDescription());
		}*/
		Mixer mixer=AudioSystem.getMixer(infos[0]);
	DataLine.Info deinfos=new DataLine.Info(Clip.class,null);//AudioSystem.getAudioFormat()
	File files=new File("voice mode deactivated.wav");
	AudioInputStream aus=AudioSystem.getAudioInputStream(files);

	clip=(Clip)mixer.getLine(deinfos);
clip.open(aus);
System.out.println("clip started");
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
catch(LineUnavailableException lue)
	{
		lue.printStackTrace();
	}
catch(UnsupportedAudioFileException iue)
	{
		iue.printStackTrace();
	}
clip.start();
do
{
	try{
	Thread.sleep(200);
	}
	catch(InterruptedException ie){}
}
while(clip.isActive());
System.out.println("clip Closed");
clip.close();

}
public static void sayNormalMode()
{
	try
	{
		Mixer.Info[] infos=AudioSystem.getMixerInfo();
		/*for(Mixer.Info infon:infos)
		{
			System.out.println(infon.getName()+"  "+infon.getDescription());
		}*/
		Mixer mixer=AudioSystem.getMixer(infos[0]);
	DataLine.Info deinfos=new DataLine.Info(Clip.class,null);//AudioSystem.getAudioFormat()
	File files=new File("normal mode.wav");
	AudioInputStream aus=AudioSystem.getAudioInputStream(files);

	clip=(Clip)mixer.getLine(deinfos);
clip.open(aus);
System.out.println("clip started");
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
catch(LineUnavailableException lue)
	{
		lue.printStackTrace();
	}
catch(UnsupportedAudioFileException iue)
	{
		iue.printStackTrace();
	}
clip.start();
do
{
	try{
	Thread.sleep(200);
	}
	catch(InterruptedException ie){}
}
while(clip.isActive());
System.out.println("clip Closed");
clip.close();

}






public static void main(String srgs[])
{
	sayActivated();
	sayDeactivated();
	sayNormalMode();
}	
}