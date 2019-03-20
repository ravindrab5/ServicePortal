package com.yantra.serviceportal.model;

public class Installation {
    private int id;

    private String kiviboxId;

    private String listDepots;

    private String assignedTo;

    private String busNumber;

    private String chassisNumber;

    private String busType;

    private String depot;

    private String vehicleBtryVolt;

    private String terminal1VccBtryVolt;

    private String terminal4IgnitionBtryVolt;

    private String comment;

    private String wifiCheck;

    private String playVideoCheck;

    private String kiviboxIdCheck;

    private String startedInstallationTs;

    private String completedInstallationTs;

    private String installationRequestStatus;

    private String operator;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setKiviboxId(String kiviboxId){
        this.kiviboxId = kiviboxId;
    }
    public String getKiviboxId(){
        return this.kiviboxId;
    }
    public void setListDepots(String listDepots){
        this.listDepots = listDepots;
    }
    public String getListDepots(){
        return this.listDepots;
    }
    public void setAssignedTo(String assignedTo){
        this.assignedTo = assignedTo;
    }
    public String getAssignedTo(){
        return this.assignedTo;
    }
    public void setBusNumber(String busNumber){
        this.busNumber = busNumber;
    }
    public String getBusNumber(){
        return this.busNumber;
    }
    public void setChassisNumber(String chassisNumber){
        this.chassisNumber = chassisNumber;
    }
    public String getChassisNumber(){
        return this.chassisNumber;
    }
    public void setBusType(String busType){
        this.busType = busType;
    }
    public String getBusType(){
        return this.busType;
    }
    public void setDepot(String depot){
        this.depot = depot;
    }
    public String getDepot(){
        return this.depot;
    }
    public void setVehicleBtryVolt(String vehicleBtryVolt){
        this.vehicleBtryVolt = vehicleBtryVolt;
    }
    public String getVehicleBtryVolt(){
        return this.vehicleBtryVolt;
    }
    public void setTerminal1VccBtryVolt(String terminal1VccBtryVolt){
        this.terminal1VccBtryVolt = terminal1VccBtryVolt;
    }
    public String getTerminal1VccBtryVolt(){
        return this.terminal1VccBtryVolt;
    }
    public void setTerminal4IgnitionBtryVolt(String terminal4IgnitionBtryVolt){
        this.terminal4IgnitionBtryVolt = terminal4IgnitionBtryVolt;
    }
    public String getTerminal4IgnitionBtryVolt(){
        return this.terminal4IgnitionBtryVolt;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getComment(){
        return this.comment;
    }
    public void setWifiCheck(String wifiCheck){
        this.wifiCheck = wifiCheck;
    }
    public String getWifiCheck(){
        return this.wifiCheck;
    }
    public void setPlayVideoCheck(String playVideoCheck){
        this.playVideoCheck = playVideoCheck;
    }
    public String getPlayVideoCheck(){
        return this.playVideoCheck;
    }
    public void setKiviboxIdCheck(String kiviboxIdCheck){
        this.kiviboxIdCheck = kiviboxIdCheck;
    }
    public String getKiviboxIdCheck(){
        return this.kiviboxIdCheck;
    }
    public void setStartedInstallationTs(String startedInstallationTs){
        this.startedInstallationTs = startedInstallationTs;
    }
    public String getStartedInstallationTs(){
        return this.startedInstallationTs;
    }
    public void setCompletedInstallationTs(String completedInstallationTs){
        this.completedInstallationTs = completedInstallationTs;
    }
    public String getCompletedInstallationTs(){
        return this.completedInstallationTs;
    }
    public void setInstallationRequestStatus(String installationRequestStatus){
        this.installationRequestStatus = installationRequestStatus;
    }
    public String getInstallationRequestStatus(){
        return this.installationRequestStatus;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }
    public String getOperator(){
        return this.operator;
    }
}
