package com.petStore.api.genericUtility;
/**
 * This class consists of generic methods related to java operations
 * @author Antara Pal
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will generate random no. and return it to caller method
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int random = r.nextInt(1000);
		return random;
		
	}
	/**
	 * This method is capture current system date and time and return to caller method
	 * @return
	 */
	public String getSystemDate() {
//		Date d=new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
//        String formatDate = sdf.format(d);
//        return formatDate;
        
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}


}
