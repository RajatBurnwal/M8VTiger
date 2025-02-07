package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This is a utility class which works with Java related operations
 */
public class JavaUtility {

	/**
	 * This is a generic method which will generate randome number
	 * @param bound
	 * @return
	 */
	public int generateRandomNumber(int bound)
	{
		Random r=new Random();
		int num=r.nextInt(bound);
		return num;
	}
	
	/**
	 * This is a generic method to fetch calendar details
	 * @param pattern
	 * @return
	 */
	public String getCalendarDetails(String pattern)
	{
		Calendar cal=Calendar.getInstance();
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String data=sdf.format(d);
		return data;
	}
}
