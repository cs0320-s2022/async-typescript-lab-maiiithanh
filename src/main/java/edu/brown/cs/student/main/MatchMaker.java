package edu.brown.cs.student.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchMaker {

	public static List<String> horoscopes = Arrays.asList("Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
			"Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces");
	
	public static List<String> makeMatches(String sun, String moon, String rising){
		List<String> output = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			String match = generateMatchForString(sun + i, 
					moon + i, rising + i);
			output.add(match);
		}
		
		return output;
	}
	
	public static String generateMatchForString(String sun, String moon, String rising) {
		int sunHash = Math.abs((sun + moon + rising).hashCode());
		int moonHash = Math.abs(sun.hashCode() + moon.hashCode() + rising.hashCode());
		int risingHash = Math.abs(sun.hashCode() * moon.hashCode() * rising.hashCode());
		
		String output = "Sun: " + horoscopes.get(sunHash % horoscopes.size()) + 
				"; Moon: " + horoscopes.get(moonHash % horoscopes.size()) + 
				"; Rising: " + horoscopes.get(risingHash % horoscopes.size());
		return output;
	}
}
