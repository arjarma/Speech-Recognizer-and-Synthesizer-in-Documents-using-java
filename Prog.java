package majorProject;


public class Prog
{
	public static void React(String str)
	{
	if(str.equalsIgnoreCase("chrome")==true)//chrome
	{	
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start chrome");
		
		
	}
	catch(Exception ie){}
	}//chrome
	
else if(str.equalsIgnoreCase("media")==true)
	{
	try
	{
	ProcessBuilder builder;
	Process pro;
	builder=new ProcessBuilder("C:/Program Files (x86)/VideoLAN/VLC/vlc.exe");
	pro=builder.start();
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("editor")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("C:\\npp.7.4.1.bin.x64\\notepad++.exe");
		pro=builder.start();
	}
	catch(Exception e){}
	}  //notepad end
	else if(str.equalsIgnoreCase("programs")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start appwiz.cpl ");
	}
	catch(Exception e){}
	}//unisnstaller
	else if(str.equalsIgnoreCase("center")==true)
	{
	try
	{	
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start wscui.cpl");
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("pdf")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start acrord32.exe");
	}
	catch(Exception e){}
	} //adobe reader
	else if(str.equalsIgnoreCase("property")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start control.exe system");
	}
	catch(Exception e){}
	}
	
	else if(str.equalsIgnoreCase("advanced")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("systempropertiesadvanced");//advnaced tAB
		pro=builder.start();
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("system")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("msconfig ");//system configuration
		pro=builder.start();
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("task")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("taskmgr");//task manager
		pro=builder.start();
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("device")==true)
	{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("management")==true)
	{
	try
	{
		Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start compmgmt.msc");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("information")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("msinfo32");//System information
		pro=builder.start();
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("control panel")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start control");
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("registry editor")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("regedit");//registry editor
		pro=builder.start();
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("restore")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("rstrui");//System restore
		pro=builder.start();
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("resource monitor")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("resmon");//resource monitor
		pro=builder.start();
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("calculator")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("calc");//calculator
		pro=builder.start();
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("paint")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("mspaint");//mspaint
		pro=builder.start();
	}
	catch(Exception e){}
	}
	
	else if(str.equalsIgnoreCase("Services")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start services.msc");
	}
	catch(Exception e){}
	}
	
	else if(str.equalsIgnoreCase("You Tube")==true)
	{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.youtube.com");
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("keypad")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start osk");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("manager")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start diskmgmt.msc");
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("bluetooth")==true)
	{
	try
	{
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("fsquirt");//mspaint
		pro=builder.start();
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("partition")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start diskpart");//diskpart
			
	}
	catch(Exception e){}
	}
	//process builder methods end here
	//Runtime getRuntime exec starts
	else if(str.equalsIgnoreCase("CMD")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start cmd");
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("google")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start chrome www.google.com");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("tab")==true)
	{
	try
	{
	Process pro;
		
	pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.google.com");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("window")==true)
	{
	try
	{
	Process pro;
		
	pro=Runtime.getRuntime().exec("cmd /c start chrome /new-window www.google.com");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("gmail")==true)
	{
	try
	{
	Process pro;
		
	pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.gmail.com");
		
	}
	catch(Exception e){}
	}
	
	else if(str.equalsIgnoreCase("facebook")==true)
	{
	try
	{
	Process pro;
		
	pro=Runtime.getRuntime().exec("cmd /c start chrome /new-tab www.facebook.com");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("Wordpad")==true)
	{
	try
	{
	Process pro;
		
	pro=Runtime.getRuntime().exec("cmd /c start write");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("document")==true)
	{
	try
	
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start winword");
		
	}
	catch(Exception e){}
	}
	else if(str.equalsIgnoreCase("powerpoint")==true)
	{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start powerpnt");
	}
	catch(Exception e){}
	}
else if(str.equalsIgnoreCase("close powerpoint")==true)
	{
		try{
			Process pro;
	
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im powerpnt.exe  /f ");
		//pro.destroy();
		}
		catch(Exception e)
		{}
		
	}

//closing procedures
else if(str.equalsIgnoreCase("close document")==true)
	{
		try{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im winword.exe /f ");
		//pro.destroy();
		}
		catch(Exception e)
		{}
		
	}

else if(str.equalsIgnoreCase("close paint")==true)
{
	try
	{	
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start taskkill /im mspaint.exe /f");
	}
	catch(Exception e)
	{
	}
}

else if(str.equalsIgnoreCase("terminate system")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im msconfig.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("terminate task")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im taskmgr.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close calculator")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im calculator.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close pdf")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im acrord32.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close keypad")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im osk.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close information")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im msinfo32.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close restore")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im  rstrui.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close cmd")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
	}
	catch(Exception e)
	{}
}
else if(str.equalsIgnoreCase("close partition")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im diskpart.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close register")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im regedit.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close wordpad")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c  start taskkill /im wordpad.exe /f");
	}
	catch(Exception e)
	{}
}


else if(str.equalsIgnoreCase("close window")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close tab")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close facebook")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close google")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close youtube")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
	}
	catch(Exception e)
	{}
}


else if(str.equalsIgnoreCase("close gmail")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close chrome")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close advanced")==true)
{
	try
	{
	Process pro;
	pro=Runtime.getRuntime().exec("cmd /c start taskkill /im systempropertiesadvanced.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close bluetooth")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im fsquirt.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close mediaplayer")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im vlc.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close editor")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec(" cmd /c start taskkill /im notepad++.exe /f");
	}
	catch(Exception e)
	{}
}
else if(str.equalsIgnoreCase("close service")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im mmc.exe /f");
	}
	catch(Exception e)
	{}
}
else if(str.equalsIgnoreCase("close resource")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im perfmon.exe /f");
	}
	catch(Exception e)
	{}
}

else if(str.equalsIgnoreCase("close management")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im mmc.exe /f");
	}
	catch(Exception e){}
}


else if(str.equalsIgnoreCase("close device")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im mmc.exe /f");
	}
	catch(Exception e){}
}

else if(str.equalsIgnoreCase("close manager")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im mmc.exe /f");
	}
	catch(Exception e){}
}

else if(str.equalsIgnoreCase("terminate control")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /fi \"windowtitle eq control panel\" /f");
	}
	catch(Exception e){}
}
else if(str.equalsIgnoreCase("downloads")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start C:/users/arma/downloads");
	}
	catch(Exception e){}
}
else if(str.equalsIgnoreCase("close downloads")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /f /fi \"windowtitle eq downloads\"");
	}
	catch(Exception e){e.printStackTrace();}
}

else if(str.equalsIgnoreCase("home")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start C:/users/arma/desktop");
	}
	catch(Exception e){}
}

else if(str.equalsIgnoreCase("close home")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /f /fi \"windowtitle eq desktop\"");
	}
	catch(Exception e){}
}

else if(str.equalsIgnoreCase("close property")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /f /fi \"windowtitle eq control panel\\system and security\\system\"");
	}
	catch(Exception e){}
}
else if(str.equalsIgnoreCase("terminate programs")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /f /fi \"windowtitle eq control panel\\programs\\programs and features\"");
	}
	catch(Exception e){}
}
else if(str.equalsIgnoreCase("terminate center")==true) 
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c taskkill /f /fi \"windowtitle eq control panel\\system and security\\security and maintenance\"");
	}
	catch(Exception e){}
}
else if(str.equalsIgnoreCase("fillers")==true)
{
	
	Starter.SpeakerInit(" anonymous sound");
}
else if(str.equalsIgnoreCase("Anonymous sound ")==true)
{
	
	Starter.SpeakerInit("word not recognized");
}

////till here working fine

}
	public static void main(String srgs[])
	{
		//React("you tube");
	}
}
/*tf.addTextListener(new TextListener()
			{public void textValueChanged(TextEvent ke)
				{	
					Prog.React(tf.getText());
					//tf.setCaretPosition(a);
					tf.setText("");
else if(str.equalsIgnoreCase("close event ")==true)
{
	try
	{
		Process pro;
		pro=Runtime.getRuntime().exec("cmd /c start taskkill /im mmc.exe /f");
	}
	catch(Exception e){}
}

else if(str.equalsIgnoreCase("event viewer ")==true)
	{
	try
	{	
		ProcessBuilder builder;
		Process pro;
		builder=new ProcessBuilder("eventvwr");//event viewer
		pro=builder.start();
		
	}
	catch(Exception e){}
	}


					}});*/