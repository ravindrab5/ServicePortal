package com.yantra.serviceportal.model;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateBoxData {
	 
	CreateBox box;
	Assign assign;
	Installation install;
	RaiseIncident raise;
	UninstallationRequest uninstallreq,replacement;
	Upgrade upgradeRequest;
	BoxInfo boxInfo;
    KiviBoxById kiviboxbyid;
	 
	/**
	 * Gets the box info like Box id, lifecycle state,owner, depot
	 * @return
	 */
	public BoxInfo getBoxInfo() {
		return boxInfo;
	}

	/**
	 * Gets the riase incident class object
	 * @return RiaseIncidentObject
	 */
	public RaiseIncident getRaise() {
		return raise;
	}

	/**
	 * 
	 * @return
	 */
	public UninstallationRequest getUninstallreq() {
		return uninstallreq;
	}

	public UninstallationRequest getReplacement() {
		return replacement;
	}

	public Upgrade getUpgradeRequest() {
		return upgradeRequest;
	}

	public CreateBox getBox() {
		return box;
	}

	public Assign getAssign() {
		return assign;
	}

	public Installation getInstall(String depot,String userAssignTo) {
		getInstallBox( depot,userAssignTo);
		return install;
	}

	/**
	 * Generates box data . 
	 * @param operator MSRTC/KSRTC operator
	 * @param owner owner of the box on service portal during box creation.
	 */
	public CreateBoxData(String operator,String owner) {
        
	      box=new CreateBox(operator,owner);
          assign=new Assign();
          install=new Installation();
          raise=new RaiseIncident();
          uninstallreq=new UninstallationRequest();
          replacement=new UninstallationRequest();
          upgradeRequest=new Upgrade();
          boxInfo=new BoxInfo();
          kiviboxbyid=new KiviBoxById(operator); 
         
	}
	
	// get createbox json
	// get incident
	// get service call
	
 	
	/**
	 * Gets json from the CreateBox pojo
	 * @param operator Operator - MSRTC/KSRTC
	 * @return JSON in string format for create box api
	 */
	public String getCreateBoxJson(String operator) {
	    ObjectMapper mapper = new ObjectMapper();
		String str=null;
		try {
			str=mapper.writeValueAsString(box);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * Assigns box to mentioned depotCode
	 * @param depotCode
	 * @return JSON in staring format for assign box api
	 */
	public String getAssignBox(String depotCode) {
		
		 assign.setDepotCode(depotCode);
	        List<String> boxList=new ArrayList<String>();
	        boxList.add(box.getKiviboxId());
	        assign.setKiviboxIdList(boxList);
	        assign.setOperator(box.getOperator());
	       
		
		
		ObjectMapper mapper = new ObjectMapper();
 

		//Object to JSON in file
		String str=null;
		try {
			str=mapper.writeValueAsString(assign);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return str;
	}
	
	/**
	 * Gets install box data.
	 * @param depot - name of the depot
	 * @param userAssignTo - technician name eg ; kishort
	 * @return JSON string to be used with install box api.
	 */
	public String getInstallBox(String depot,String userAssignTo) {
		 String time_len_five=new SimpleDateFormat("mmss").format(new Date());
			String time_len_two=new SimpleDateFormat("ss").format(new Date());
	     String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     Random rnd = new Random();
	     char random_3_Char = alphabet.charAt(rnd.nextInt(alphabet.length()));
	     char random_4_Char = alphabet.charAt(rnd.nextInt(alphabet.length()));

	     String chasi_no=random_3_Char+random_4_Char+random_3_Char+random_4_Char+time_len_five+"190";
	     String bus_no="MH"+time_len_two+random_3_Char+random_4_Char+time_len_five;
	  
		
		install.setId(0);
        install.setKiviboxId(box.getKiviboxId());
        install.setListDepots(assign.getDepotCode()+"::"+depot);
        install.setAssignedTo(userAssignTo);
        install.setBusNumber(bus_no);
        install.setChassisNumber(chasi_no);
        install.setBusType("SHIVNERI");
        install.setDepot(assign.getDepotCode());
        install.setVehicleBtryVolt("1.5");
        install.setTerminal1VccBtryVolt("1.5");
        install.setTerminal4IgnitionBtryVolt("2");
        install.setComment("");
        install.setWifiCheck("SUCCESS");
        install.setPlayVideoCheck("SUCCESS");
        install.setKiviboxIdCheck("SUCCESS");
        install.setStartedInstallationTs("20170109100555.555");
        install.setCompletedInstallationTs("20170113100555.555");
        install.setInstallationRequestStatus("SUCCESS");
        install.setOperator(assign.getOperator());
		
		ObjectMapper mapper = new ObjectMapper();
 

		//Object to JSON in file
		String str=null;
		try {
			str=mapper.writeValueAsString(install);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return str;
	}
	
	/**
	 * Gets raise incident JSON 
	 * @return JSON in string format to be used to raise incident
	 */
	public String getRaiseIncident() {
		
		    raise.setServiceRequestBy("Box");
	        raise.setBoxIdOrBusNumber(box.getKiviboxId());
	        raise.setTypeOfService("INCIDENT");
	        raise.setOperatorCode(assign.getOperator());
	        raise.setCommandCenterStatus("System not working");
	     
		ObjectMapper mapper = new ObjectMapper();
 

		//Object to JSON in file
		String str=null;
		try {
			str=mapper.writeValueAsString(raise);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return str;
	}
	
	/**
	 * Gets uninstallation json .
	 * @return JSON as string for uninstallation api.
	 */
	public String getRaiseUnistallation() {

		uninstallreq.setServiceRequestBy("Box");
        uninstallreq.setBoxIdOrBusNumber(box.getKiviboxId());
        uninstallreq.setTypeOfService("UNINSTALLATION");
        uninstallreq.setOperatorCode(assign.getDepotCode());
		ObjectMapper mapper = new ObjectMapper();
 

		//Object to JSON in file
		String str=null;
		try {
			str=mapper.writeValueAsString(uninstallreq);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return str;
	}
	
	
	/**
	 * Gets replacement JSON
	 * @return json for the replacement.
	 */
	public String getRaiseReplacement() {
		  replacement.setServiceRequestBy("Box");
	        replacement.setBoxIdOrBusNumber(box.getKiviboxId());
	        replacement.setTypeOfService("REPLACEMENT");
	        replacement.setOperatorCode(assign.getOperator());
	      
		ObjectMapper mapper = new ObjectMapper();
 

		//Object to JSON in file
		String str=null;
		try {
			str=mapper.writeValueAsString(replacement);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return str;
	}
	
	/**
	 * Gets json for the upgrade request
	 * @param type Type of the Upgrade
	 * @param version version to be upgraded to
	 * @return JSON as String for upgrade type of request
	 */
	public String getUpgradeRequest(String type,String version) {
		  upgradeRequest.setServiceRequestBy("Box");
	        upgradeRequest.setBoxIdOrBusNumber(box.getKiviboxId());
	        upgradeRequest.setTypeOfService("UPGRADE");
	        upgradeRequest.setOperatorCode(assign.getOperator());
	        upgradeRequest.setTypeOfUpgrade(type);
	        upgradeRequest.setVersion(version);
		ObjectMapper mapper = new ObjectMapper();
 

		//Object to JSON in file
		String str=null;
		try {
			str=mapper.writeValueAsString(upgradeRequest);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return str;
	}
	
	
	
	public String getKiviBoxId(String depotCode) {
		List<String> lst=new ArrayList<String>();
		lst.add(depotCode);
		kiviboxbyid.setDepotCodes(lst); 
		
		ObjectMapper mapper = new ObjectMapper();


		//Object to JSON in file
		String str=null;
		try {
			str=mapper.writeValueAsString(kiviboxbyid);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return str;
	}
}
