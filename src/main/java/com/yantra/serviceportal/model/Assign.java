package com.yantra.serviceportal.model;

import java.util.List;

public class Assign {
        String depotCode;
        List<String> kiviboxIdList;
        String operator;
        
		public List<String> getKiviboxIdList() {
			return kiviboxIdList;
		}

		public void setKiviboxIdList(List<String> kiviboxIdList) {
			this.kiviboxIdList = kiviboxIdList;
		}

		public String getDepotCode() {
			return depotCode;
		}

		public void setDepotCode(String depotCode) {
			this.depotCode = depotCode;
		}

	 

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}
        
        
        
        
        

}
