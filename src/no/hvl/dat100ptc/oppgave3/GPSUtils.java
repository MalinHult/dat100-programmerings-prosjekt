package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		
		for(int i = 0; i >= da.length; i++) {
			for(int j = 0; j >= da[i]; j++) {
				if(da[i] <= da[j] && j == da.length) {
					min = da[i];
				}
				else {
					continue;
				}
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		
		for(int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		
		for(int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();			
		}
		return longitudes;
	}
	
	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		//double d;
		double latitude1 = 0, longitude1 = 0, latitude2 = 0, longitude2 = 0;

		double dLat = Math.toRadians((latitude2 - latitude1));
		double dLong = Math.toRadians((longitude2 - longitude1));
		
		double a = (Math.sin(dLat / 2) * Math.sin(dLat / 2)) + 
				(Math.cos(Math.toRadians(latitude1)))*
				(Math.cos(Math.toRadians(latitude2)))*
				(Math.sin(dLong / 2)) * (Math.sin(dLong / 2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		return (int) (Math.round(R * c));

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		/*som beregninger gjennomsnittshastighet 
		 i km/t om man beveger seg fra punktet gitt ved 
		 gpspoint1 til punktet gpspoint2 på det antall 
		 sekunder som er gitt med parameteren secs.
		 Hint: Bruk metoden distance fra d) samt 
		 get-metode(r) på GPSPoint-objekt.*/
				
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		
		/*som returnerer en streng på formatet hh:mm:ss 
		 der tiden i sekunder fra midnatt er gitt av 
		 parameteren secs. I strengen på formatet 
		 hh:mm:ss er hh er antall timer, mm er antall 
		 minutter og ss er antall sekunder. Videre skal 
		 metoden legge inn mellomrom foran tiden slik den 
		 total lengden på strengen blir 10. 
		 Hint: se på format-metoden i String-klassen.`*/
		
	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		/*som runder av et flyttall til to desimaler, 
		 setter resultat inn i en streng og fyller på med 
		 mellomrom foran i strengen slik at lengden på 
		 strengen blir 10.*/
		
	}
}
