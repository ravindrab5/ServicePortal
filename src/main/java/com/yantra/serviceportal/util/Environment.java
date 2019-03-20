package com.yantra.serviceportal.util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:Properties/${env}.properties" // mention the property file name
})
public interface Environment extends Config {

	String browser();
	
	String hubip();
     
    String userprod();
    
    String passwordprod();
    
    String userservice();
    
    String passwordserv();
    
    String sl();
    
    @Key("url.service")
    String urlService();
    
    @Key("url.prod")
    String urlProd();
    
    @Key("technician.username")
    String technicianUsername();

    @Key("technician.password")
    String technicianPassword();

    @Key("technician.depot")
    String technicianDepot();

    @Key("technician.depotCode")
    String technicianDepotCode();
    
    @Key("technician.operator")
    String techicianOperator();
   
}