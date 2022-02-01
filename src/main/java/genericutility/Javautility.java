package genericutility;

import java.util.Date;
import java.util.Random;

public class Javautility {
/**
 * this method will generate a random number and returns it to the caller
 * @return
 */
	
	public int getRandomNumber()
	{
		Random ran = new Random();
		int randnum = ran.nextInt();
		return randnum;
		
		
	}
	
	/**
	 * this method will return current date
	 */
	public String getCurrentDate() {
		
		Date date = new Date();
		String currentDate = date.toString();
		return currentDate;
	}
	
	/**
	 * this method will return date in specified format
	 * @return
	 */
	public String getFinalDateFormat()
	{
		Date date = new Date();
		String d = date.toString();
		String[] dte = d.split("");
		String yyyy = dte[5];
		String DD = dte[2];
		String MM = dte[1];
		String today = yyyy+"_"+MM+"_"+DD;
		return today;
	}
	
	
	
}
