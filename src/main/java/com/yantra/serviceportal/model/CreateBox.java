package com.yantra.serviceportal.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateBox {
	String kiviboxId,piCpuId,vtsSerialNumber,vtsSim,hddSerialNumber,dongleImei,dongleSimImei,dongleSimMobileNumber,dongleSimOperator,
	powerSupplySerialNumber,routerSerialNumber,boxLifecycleState,boxOwnerLoginId,operator,dongleNetwork;
	
	
	public CreateBox(String operator,String boxOwner) {
		 Date  day=new Date();
	      String[] da=day.toString().split(" ");
	        
		String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
      String time_len_nine = new SimpleDateFormat("MMddHHmmss").format(new Date());
      String time_len_eleven = new SimpleDateFormat("MMHHmmss").format(new Date());
      String time_len_ten=new SimpleDateFormat("ddHHmmss").format(new Date());
      String time_len_five=new SimpleDateFormat("mmss").format(new Date());
		String time_len_two=new SimpleDateFormat("ss").format(new Date());
      String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      Random rnd = new Random();
      char random_3_Char = alphabet.charAt(rnd.nextInt(alphabet.length()));
      char random_4_Char = alphabet.charAt(rnd.nextInt(alphabet.length()));

      kiviboxId=da[0].toUpperCase() + "0" + timeStamp;
      piCpuId="916460"+timeStamp;
      vtsSerialNumber="R-15"+time_len_eleven;
      vtsSim="99"+time_len_ten;
      dongleSimMobileNumber="98"+time_len_ten;
      hddSerialNumber=time_len_five+time_len_two+timeStamp;
      dongleImei="92568"+timeStamp;
      dongleSimImei=timeStamp+timeStamp;
      powerSupplySerialNumber=String.valueOf(random_3_Char)+String.valueOf(random_4_Char)+"1"+time_len_five;
      routerSerialNumber="7912"+time_len_ten;
      boxLifecycleState="ASSIGNED";
      boxOwnerLoginId=boxOwner;
      this.operator=operator;
      
      //chasi_no=random_3_Char+random_4_Char+random_3_Char+random_4_Char+time_len_five+"190";
     // bus_no="MH"+time_len_two+random_3_Char+random_4_Char+time_len_five;
      dongleSimOperator="AIR";
      dongleNetwork="4G";
	}

	
	
	
	
	
	
	public String getKiviboxId() {
		return kiviboxId;
	}

	public void setKiviboxId(String kiviboxId) {
		this.kiviboxId = kiviboxId;
	}

	public String getPiCpuId() {
		return piCpuId;
	}

	public void setPiCpuId(String piCpuId) {
		this.piCpuId = piCpuId;
	}

	public String getVtsSerialNumber() {
		return vtsSerialNumber;
	}

	public void setVtsSerialNumber(String vtsSerialNumber) {
		this.vtsSerialNumber = vtsSerialNumber;
	}

	public String getVtsSim() {
		return vtsSim;
	}

	public void setVtsSim(String vtsSim) {
		this.vtsSim = vtsSim;
	}

	public String getHddSerialNumber() {
		return hddSerialNumber;
	}

	public void setHddSerialNumber(String hddSerialNumber) {
		this.hddSerialNumber = hddSerialNumber;
	}

	public String getDongleImei() {
		return dongleImei;
	}

	public void setDongleImei(String dongleImei) {
		this.dongleImei = dongleImei;
	}

	public String getDongleSimImei() {
		return dongleSimImei;
	}

	public void setDongleSimImei(String dongleSimImei) {
		this.dongleSimImei = dongleSimImei;
	}

	public String getDongleSimMobileNumber() {
		return dongleSimMobileNumber;
	}

	public void setDongleSimMobileNumber(String dongleSimMobileNumber) {
		this.dongleSimMobileNumber = dongleSimMobileNumber;
	}

	public String getDongleSimOperator() {
		return dongleSimOperator;
	}

	public void setDongleSimOperator(String dongleSimOperator) {
		this.dongleSimOperator = dongleSimOperator;
	}

	public String getPowerSupplySerialNumber() {
		return powerSupplySerialNumber;
	}

	public void setPowerSupplySerialNumber(String powerSupplySerialNumber) {
		this.powerSupplySerialNumber = powerSupplySerialNumber;
	}

	public String getRouterSerialNumber() {
		return routerSerialNumber;
	}

	public void setRouterSerialNumber(String routerSerialNumber) {
		this.routerSerialNumber = routerSerialNumber;
	}

	public String getBoxLifecycleState() {
		return boxLifecycleState;
	}

	public void setBoxLifecycleState(String boxLifecycleState) {
		this.boxLifecycleState = boxLifecycleState;
	}

	public String getBoxOwnerLoginId() {
		return boxOwnerLoginId;
	}

	public void setBoxOwnerLoginId(String boxOwnerLoginId) {
		this.boxOwnerLoginId = boxOwnerLoginId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getDongleNetwork() {
		return dongleNetwork;
	}

	public void setDongleNetwork(String dongleNetwork) {
		this.dongleNetwork = dongleNetwork;
	}

}
