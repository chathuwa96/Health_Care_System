package com.hospitalManageSystem.Appointment;

public class AppointmentBean {
	
	private int appointmentID;
	private String patientID;
	private String date;
	private String docName;
	private String hosName;
	private String appType;
	
	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		date = date;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public AppointmentBean(int appointmentID, String patientID, String date, String docName, String hosName,
			String appType) {
		super();
		this.appointmentID = appointmentID;
		this.patientID = patientID;
		date = date;
		this.docName = docName;
		this.hosName = hosName;
		this.appType = appType;
	}



}
