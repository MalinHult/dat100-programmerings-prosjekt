package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;
		GPSPoint lastPoint = null, currentPoint = null;
		
		if(GPSPoint.size() < 2) return 0;
		lastPoint = GPSPoint.get(0);
		for(int i = 1; i < GPSPoint.size(); i++) {
			currentPoint = GPSPoint.get(i);
			distance += calcDistance(lastPoint.getLatitude()(), lastPoint.getLongitude(),
					currentPoint.getLatitude(), currentPoint.getLongitude());
			lastPoint = currentPoint;
		}
		return distance;
	}

	// beregn totale hÃ¸ydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		/*som beregner det totale antall høydemeter på 
		 ruten. Husk kun å telle høydemeter mellom to 
		 punkter om en beveger seg oppover.*/

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		int totalSek = 0;
		for(int i = 0; i < gpspoints.length - 1; i++) {
			totalSek += gpspoints[i].getTime();
			
		}
		return totalSek;

	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		/*som skal returnere en tabell med 
		 gjennomsnitshastigheter mellom hver av de 
		 punktene vi har beveget oss mellom. Dvs. første 
		 inngang i tabellen skal være hastigheten vi 
		 beveget oss med mellom punkt 0 og punkt 1, andre 
		 inngang hastigheten mellom punkt 1 og 2 osv. 
		 Hvis antall GPS datapunker er N da vil lengden av 
		 den tabellen som returneres være N-1.*/

	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		for(double e : speeds()) {
			maxspeed += e;
		}
		maxspeed /= speeds().length;
		
		return maxspeed;

	}

	public double averageSpeed() {

		double average = 0;
		
		average = totalDistance() / totalTime() * 3.6;
		
		return average;
		
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjÃ¸res med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		/*som beregnerer/estimerer hvor mye energi der er 
		 forbrent gitt vekten på personen og den tid i sekunder 
		 som personen har bevæget seg med den hastigheten. For 
		 å kunne estimere energi-forbrenningen i kilo-kalorier 
		 (kcal) skal vi først finne MET (Metabolic Equivalent 
		 of Task) som er et fysiologisk mål for hvor mange kcal 
		 vi forbrenner per kilo kroppsvekt per time ved en gitt 
		 aktivitet. MET avhenger av type aktivitet og intensitet. 
		 For sykling [ http://coachlevi.com/health/calories-burned
		 -bicycling/ ] er den gitt i tabellen nedenfor der 
		 hastighet er angitt i miles per hour (mps): 
		 Hastighet i km/t kan omregnes til mph ved å gange 
		 med en faktor 0.62. MET vil også avhenge av eks. 
		 stigningsprosent (om det går opp eller ned og 
		 hvor mye) men det skal vi se bort fra her.*/
		
		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		if(met >= 10 && met <= 12) {
			System.out.println();
		}
		if(met > 12 && met < 14) {
			System.out.println();
		}
		if(met > 14 && met < 16) {
			System.out.println();
		}
		if(met > 16 && met <= 20) {
			System.out.println();
		}
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		/*som beregner den totale energi-mengden som er 
		 forbrent på ruten.*/
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");

		System.out.printf("%-20s%10.2f\n" + "Total Time" + ":" + totalTime());
		System.out.printf("Total distance" + ":" + totalDistance() + "km");
		System.out.printf("Total elevation" + ":" + totalElevation() + "m");
		System.out.printf("Max speed" + ":" + maxSpeed() + "km/t");
		System.out.printf("Average speed" + ":" + averageSpeed() + "km/t");
		System.out.printf("Energy" + ":" + totalKcal() + "kcal");
	
		System.out.println("==============================================");

	}

}
