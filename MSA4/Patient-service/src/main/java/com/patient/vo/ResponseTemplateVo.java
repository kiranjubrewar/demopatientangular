package com.patient.vo;

import com.patient.entity.Patient;

public class ResponseTemplateVo {
	private Patient patient;
	private Doctor doctor;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient=patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor=doctor;
	}
	public ResponseTemplateVo() {
		super();
	}
	public ResponseTemplateVo(Patient patient, Doctor doctor) {
		super();
		this.patient = patient;
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "ResponseTemplateVo [patient=" + patient + ", doctor=" + doctor + "]";
	}
	
}
