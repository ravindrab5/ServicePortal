package com.yantra.serviceportal;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import com.yantra.serviceportal.util.Environment;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  ConsoleAppender console = new ConsoleAppender(); //create appender
    	  //configure the appender
    	  String PATTERN = "%d [%p|%c|%C{1}] %m%n";
    	  console.setLayout(new PatternLayout(PATTERN)); 
    	  console.setThreshold(Level.FATAL);
    	  console.activateOptions();
    	  //add appender to any Logger (here is root)
    	  Logger.getRootLogger().addAppender(console);

    	  //RollingFileAppender f1;
    	 // CsvParameterLayout csv;
    	  
    	  FileAppender fa = new FileAppender();
    	  fa.setName("FileLogger");
    	  fa.setFile("mylog.log");
    	  fa.setLayout(new PatternLayout("%m%n"));
    	  fa.setThreshold(Level.DEBUG);
    	  fa.setAppend(true);
    	  fa.activateOptions();
    	  
    	  
    	  
    	  FileAppender fa1 = new FileAppender();
    	  fa1.setName("FileLogger1");
    	  fa1.setFile("mylog1.log");
    	  fa1.setLayout(new PatternLayout("%m%n"));
    	  fa1.setThreshold(Level.DEBUG);
    	  fa1.setAppend(true);
    	  fa1.activateOptions();

    	  //add appender to any Logger (here is root)
    	  //Logger.getLogger("FileLogger").setAdditivity(false);
    	  //Logger.getLogger("FileLogger1").setAdditivity(false);
    	  Logger.getRootLogger().setAdditivity(false);
    	  
    	  Logger.getRootLogger().addAppender(fa1);
    	  Logger.getRootLogger().addAppender(fa);
    	  
    	  //Logger log=Logger.getLogger("FileLogger");
    	  Logger log=Logger.getRootLogger();
    	 // int ravindra,kadagoudar,abhilash = 1;
    	  log.info("ravindra,kadagoudar,abhilash");
    	  
	
    }
}
