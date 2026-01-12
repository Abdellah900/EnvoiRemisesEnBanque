package routines;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, int |
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
public class Log58 {
	
	// Niveaux de traces de Talend
	
	public static final int LOGLEVEL_ALL 	= 0;
	public static final int LOGLEVEL_TRACE 	= 1;
	public static final int LOGLEVEL_DEBUG 	= 2;
	public static final int LOGLEVEL_INFO 	= 3;
	public static final int LOGLEVEL_WARN 	= 4;
	public static final int LOGLEVEL_ERROR 	= 5;
	public static final int LOGLEVEL_FATAL 	= 6;
	public static final String[] LOGLEVEL 	= {"ALL", "TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL"};

	private static int logLevel = Log58.LOGLEVEL_ALL;
	
	public static void setLogLevel(String logLevel) {
		for (int i = 1; i < Log58.LOGLEVEL.length; i++) {
			if (Log58.LOGLEVEL[i].equals(logLevel)) Log58.logLevel = i;
		}
	}
	
	public static String getLogLevelLabel() {
		return Log58.LOGLEVEL[Log58.logLevel];
	}

	public static String getLogLevelLabel(int logLevel) {
		String logLevelLabel = null;
		try {
			logLevelLabel = Log58.LOGLEVEL[logLevel];
		} catch (ArrayIndexOutOfBoundsException e) {
			logLevelLabel = "LOGLEVEL[" + logLevel + "]";
		}
		return logLevelLabel;
	}

	public static int getLogLevel() {
		return Log58.logLevel;
	}
	
	// Codes de traces (pour tWarn et tDie) 
	
	public static final int LOGCODE_CONTENT 	= 42;
	public static final int LOGCODE_BEGIN 		= 1000;
	public static final int LOGCODE_CRE 		= 1001;
	public static final int LOGCODE_CRECONTENT 	= 1002;
}