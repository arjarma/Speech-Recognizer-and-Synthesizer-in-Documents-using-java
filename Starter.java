package majorProject;

import javax.speech.Central;
import javax.speech.EngineList;
import javax.speech.EngineCreate;
import javax.speech.synthesis.SynthesizerProperties;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;
import java.util.Locale;
import com.sun.speech.freetts.jsapi.FreeTTSEngineCentral;


public class Starter
{
 Starter()
{

 } 
public static void SpeakerInit(String voi)
{
 try
{
 SynthesizerProperties prop;
 Synthesizer syn=null;
SynthesizerModeDesc desc=new SynthesizerModeDesc(null,"general",Locale.US,Boolean.FALSE,null);
 FreeTTSEngineCentral cent=new FreeTTSEngineCentral();
syn=Central.createSynthesizer(desc);
EngineList list=cent.createEngineList(desc);
if(list.size()>0)
{
EngineCreate creator=(EngineCreate)list.get(0);
syn=(Synthesizer)creator.createEngine();
}
syn.allocate();
syn.resume();
prop=syn.getSynthesizerProperties();
float newSpeakingRate = prop.getSpeakingRate();
prop.setSpeakingRate(newSpeakingRate-40.0f);
float newPitchRange = prop.getPitchRange();
prop.setPitchRange(newPitchRange-5);
float newPitch = prop.getPitch();
prop.setPitch(newPitch-1);
//prop.setSpeakingRate();
syn.speakPlainText(voi,null);
boolean abc=syn.testEngineState(Synthesizer.QUEUE_NOT_EMPTY);
//System.out.println(abc);
syn.waitEngineState(Synthesizer.QUEUE_EMPTY);
}
catch(Exception e)
{
System.out.println(e);
}
}
public static void main(String args[])
{
	//SpeakerInit("hey there");
}

}
/*new Thread(new Runnable()
{
	public void run()
	{
		try{
Starter.SpeakerInit();
syn.speakPlainText("kya haal hai chutiye",null);	
syn.waitEngineState(Synthesizer.QUEUE_EMPTY);
	}
	catch(InterruptedException ie){}
	
	}
}).start();
*/