package routines;

import java.util.Date;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class TorexTransform {

    /**
     * tranformTorexDateToGMTDate: Transform Torex date in a valid Talend date:
     * http://download.oracle.com/javase/1.4.2/docs/api/java/text/SimpleDateFormat.html
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string(" ") input: The date to be transformed (Example : 2011-06-17T18:34:53+02:00).
     * 
     * {example} tranformTorexDateToGMTDate("2011-06-17T18:34:53+02:00") # 2011-06-17T18:34:53+0200.
     * 
     * 
     */
    public static String tranformTorexDateToGMTDate(String date) {
        
    	//*
        String firstPart, secondPart;
        
        firstPart = date.substring(0, date.length()-3);
        secondPart = date.substring(date.length()-2, date.length());
        
        
        return firstPart.concat(secondPart);
        //*/
    	
    	//return date.substring(0, date.length ()-6 );
    }
    
    
    
    
    /**
     * compareDateToBoolean: Transform return value from compareDate into boolean
     * 
     * @param int  (A <code>String</code> whose beginning should be parsed)
     * 
     * {talendTypes} boolean
     * 
     * {Category} User Defined
     * 
     * {param} int (1 || 0 || -1) input: the return value from compareDate (0 == the two dates are similar)
     * 
     * {example} compareDateToBoolean(1) # false
     * 
     * 
     */    
    public static boolean compareDateToBoolean(int diffDates){
    	
    	if (diffDates == 0){
    		 return true; }
    		if (diffDates == 1){
    		 return false; }  
    		
    	return false;
    }
    
    
    
    /**
     * isTheSameDate: Get a boolean as result of comparing 2 dates 
     * 
     * 
     * 
     * {talendTypes} boolean
     * 
     * {Category} User Defined
     * 
     * {param} Date in format yyyy-MM-dd
     * 
     * {param} Date in format yyyy-MM-dd HH:mm:ss
     * 
     * {example} isTheSameDate("2011-07-12", "2011-07-12") # true
     * 
     * 
     */    
    public static boolean isTheSameDate(Date referenceDate, Date dateToCompare){
    	
    	return TorexTransform.compareDateToBoolean(
    			TalendDate.compareDate(
    				TalendDate.parseDate(
    						"yyyy-MM-dd",
    						TalendDate.formatDate("yyyy-MM-dd HH:mm:ss",
    								referenceDate) ) , 
    				TalendDate.parseDate(
    						"yyyy-MM-dd", 
    						TalendDate.formatDate("yyyy-MM-dd HH:mm:ss",
    								dateToCompare)	)  ));      				
    }
    
    /**
     * isTodayDate: Get a boolean as result of comparing a date with the current date ( in format yyyy-MM-dd)
     * 
     * 
     * 
     * {talendTypes} boolean
     * 
     * {Category} User Defined
     * 
     * {param} Date in format yyyy-MM-dd HH:mm:ss
     * 
     * {example} isTodayDate("2011-07-12") # true  (if today is "2011-07-12")
     * {example} isTodayDate("2011-07-12") # false  (if today is different to "2011-07-12")
     * 
     */    
    public static boolean isTodayDate(Date dateToCompare){
    	
    	Date today = TalendDate.parseDate(
				"yyyy-MM-dd",
				TalendDate.getDate("yyyy-MM-dd") );
    	
    	return isTheSameDate (today, dateToCompare);
    }
    
    
    
    /**
     * compareDates: Get a boolean as result of comparing 2 dates
     * 
     * @param date1 (first date)
     * @param date2 (second date)
     * @return the result wheather two dates are the same, if they are different the return value is false, 
     * is the are equal so the results is true
     * 
     * 
     * {talendTypes} boolean
     * 
     * {Category} User Defined
     * 
     * {param} Date in format yyyy-MM-dd
     * 
     * {example} compareDates(2011-07-12) # true  (if today is "2011-07-12")
     * {example} compareDates(2011-07-12, 2011-07-11) # false  
     * 
     */   
    public static boolean compareDates(Date referenceDate, Date dateToCompare){
    	
    	if (referenceDate==null){
    		return TorexTransform.isTodayDate(dateToCompare);
    	}
    	else{
    	  boolean result= TorexTransform.isTheSameDate(referenceDate, dateToCompare);
    	  return result;
    	}
    }
    
    
    
    /**
     * compareDates: Get a boolean as result of comparing 2 dates
     * 
     * @param date1 (first date)
     * @param date2 (second date)
     * @return the result wheather two dates are the same, if they are different the return value is false, 
     * is the are equal so the results is true
     * 
     * 
     * {talendTypes} boolean
     * 
     * {Category} User Defined
     * 
     * {param} Date in format yyyy-MM-dd
     * 
     * {example} compareDates(2011-07-12) # true  (if today is "2011-07-12")
     * {example} compareDates(2011-07-12, 2011-07-11) # false  
     * 
     */   
    public static boolean compareDates(Date dateToCompare){
    	
    		return TorexTransform.isTodayDate(dateToCompare);
    	
    }
        
    /**
     * convertAsciiToDecimal: Converts an ascii string to its decimal value
     * 
     * @param string (string to convert)
     * 
     * @return its decimal value
     * 
     * 
     * {talendTypes} string
     * 
     * {Category} User Defined
     * 
     * {param} string (string to convert)
     * 
     * {example} convertAsciiToDecimal("AMY") #657789
     * 
     */   
    public static String convertAsciiToDecimal(String stringToConvert){
    	
    	
    	int i;
    	int decimalValue;
    	Character c;
    	StringBuilder decimalValueStr = new StringBuilder();
    	
    	for (i=0; i<stringToConvert.length(); i++){
    		
    		c = new Character(stringToConvert.charAt(i));
    		//System.out.println("char:"+c);
    		decimalValue = (int)c;
    		//System.out.println("decimalValue:"+decimalValue);
    		//decimalValue:
    		decimalValueStr.append(decimalValue);
    		//System.out.println("decimalValueStr:"+decimalValueStr);
    	}
    		
    	return decimalValueStr.toString();
    }
    
    
    
    /**
     * getDateFromOriginalActionID: Recuperer la date de l'action d'origine d'une action d'annulation
     * 
     * @param String (string OriginalActionID )
     * 
     * @return String date
     * 
     * 
     * {talendTypes} string
     * 
     * {Category} User Defined
     * 
     * {param} string (string OriginalActionID)
     * 
     * {example} getDateFromOriginalActionID("MARS3|1|20111107122553|21|CAPADMIN") #20111107T122553
     * 
     */   
    public static String getDateFromOriginalActionID(String OriginalActionID){
    	
    	String[] temp;
    	String delimiter = "[|]";
    	temp = OriginalActionID.split(delimiter);
        	
    	return temp[2];
    }
    
    
    /**
     * return Replace the special character(e.g. gt;,lt;,amp; etc) within a "".
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} TalendString
     * 
     * {param} string("") input: The string with the special character(s) need to be replaced.
     * 
     * {example} replaceSpecialXml("<title>Empire &lt;&gt;Burlesque</title>") # <title>Empire Burlesque</title>
     */
    public static String replaceSpecialXml(String input) {
        input = input.replaceAll("&amp;", ""); //$NON-NLS-1$ //$NON-NLS-2$
//        input = input.replaceAll("lt;", ""); //$NON-NLS-1$ //$NON-NLS-2$
//        input = input.replaceAll("gt;", ""); //$NON-NLS-1$ //$NON-NLS-2$
//        input = input.replaceAll("apos;", ""); //$NON-NLS-1$ //$NON-NLS-2$
//        input = input.replaceAll("quot;", ""); //$NON-NLS-1$ //$NON-NLS-2$
        input = input.replaceAll("&apos;", ""); //$NON-NLS-1$ //$NON-NLS-2$
        input = input.replaceAll("&quot;", ""); //$NON-NLS-1$ //$NON-NLS-2$
        input = input.replaceAll("&lt;", ""); //$NON-NLS-1$ //$NON-NLS-2$
        input = input.replaceAll("&gt;", ""); //$NON-NLS-1$ //$NON-NLS-2$
        return input;
    }
    
}
