package com.securebankdemo.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtility {

	private static final Logger logger=LogManager.getLogger();
	
   public static void info(String mesage)
   {
	   logger.info(mesage);
   }

   public static void error(String mesage)
   {
	   logger.error(mesage);
   }
   
   public static void warn(String mesage)
   {
	   logger.warn(mesage);
   }
   
   public static void debug(String mesage)
   {
	   logger.debug(mesage);
   }
}
