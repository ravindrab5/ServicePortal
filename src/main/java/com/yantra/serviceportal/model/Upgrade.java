package com.yantra.serviceportal.model;

public class Upgrade {
	  private String serviceRequestBy;

	    private String boxIdOrBusNumber;

	    private String typeOfService;

	    private String operatorCode;

	    private String typeOfUpgrade;

	    private String version;

	    public void setServiceRequestBy(String serviceRequestBy){
	        this.serviceRequestBy = serviceRequestBy;
	    }
	    public String getServiceRequestBy(){
	        return this.serviceRequestBy;
	    }
	    public void setBoxIdOrBusNumber(String boxIdOrBusNumber){
	        this.boxIdOrBusNumber = boxIdOrBusNumber;
	    }
	    public String getBoxIdOrBusNumber(){
	        return this.boxIdOrBusNumber;
	    }
	    public void setTypeOfService(String typeOfService){
	        this.typeOfService = typeOfService;
	    }
	    public String getTypeOfService(){
	        return this.typeOfService;
	    }
	    public void setOperatorCode(String operatorCode){
	        this.operatorCode = operatorCode;
	    }
	    public String getOperatorCode(){
	        return this.operatorCode;
	    }
	    public void setTypeOfUpgrade(String typeOfUpgrade){
	        this.typeOfUpgrade = typeOfUpgrade;
	    }
	    public String getTypeOfUpgrade(){
	        return this.typeOfUpgrade;
	    }
	    public void setVersion(String version){
	        this.version = version;
	    }
	    public String getVersion(){
	        return this.version;
	    }
}
