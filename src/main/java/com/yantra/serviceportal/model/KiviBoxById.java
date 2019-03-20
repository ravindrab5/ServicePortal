package com.yantra.serviceportal.model;

import java.util.ArrayList;
import java.util.List;

public class KiviBoxById {
	private List<String> depotCodes;

    private List<String> status;

    private String requestFrom;

    private String operatorCode;

    public KiviBoxById(String operatorCode) {
    	status=new ArrayList<String>();
    	status.add("ASSIGNED");
    	requestFrom="WEB";
    	this.operatorCode=operatorCode;
    }
    
    public void setDepotCodes(List<String> depotCodes){
        this.depotCodes = depotCodes;
    }
    public List<String> getDepotCodes(){
        return this.depotCodes;
    }
    public void setStatus(List<String> status){
        this.status = status;
    }
    public List<String> getStatus(){
        return this.status;
    }
    public void setRequestFrom(String requestFrom){
        this.requestFrom = requestFrom;
    }
    public String getRequestFrom(){
        return this.requestFrom;
    }
    public void setOperatorCode(String operatorCode){
        this.operatorCode = operatorCode;
    }
    public String getOperatorCode(){
        return this.operatorCode;
    }
    

}
