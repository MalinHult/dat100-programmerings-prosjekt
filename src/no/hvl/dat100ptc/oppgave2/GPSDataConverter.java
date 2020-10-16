package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	
	private static int TIME_STARTINDEX = 11;

	public static int toSeconds(String timestr) {
				
		String hour = timestr.substring(11,13);
		String minutes = timestr.substring(14,16);
		String seconds = timestr.substring(17,19);
		
		int hr = Integer.parseInt(hour);
		int min = Integer.parseInt(minutes);
		int sec = Integer.parseInt(seconds);
		
		int secs = (hr * 60 * 60) + (min * 60) + sec;
		
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint = new GPSPoint(toSeconds(timeStr), Double.parseDouble(latitudeStr), 
				Double.parseDouble(longitudeStr), Double.parseDouble(elevationStr));		
		
		return gpspoint;
	    
	}
	
}
