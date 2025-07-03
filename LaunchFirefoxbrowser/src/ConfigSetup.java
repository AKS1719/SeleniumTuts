public class ConfigSetup
{ 
    //Please do not make any changes on variables and method signature
	public static String browserName, driverName, driverPath; 
	
    public static String getBrowserName() // DO NOT CHANGE THE METHOD SIGNATURE
    {
        //Implement you code here
        browserName = "firefox";
    	return browserName;
	}	
    
    public static String getDriverName() // DO NOT CHANGE THE METHOD SIGNATURE
    {
        driverName = "webdriver.gecko.driver";
    	return driverName;
	}	
    
    public static String getDriverPath() // DO NOT CHANGE THE METHOD SIGNATURE
    {
        driverPath = "/usr/bin/geckodriver";
        return driverPath;
	}	
}