package com.patient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long patientId;
	private String patientName;
	private String VisitedDoctor;
	private String dateOfVist;
	private String precription;
	private Long doctorId;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getVisitedDoctor() {
		return VisitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.VisitedDoctor = visitedDoctor;
	}
	public String getDateOfVist() {
		return dateOfVist;
	}
	public void setDateOfVist(String dateOfVist) {
		this.dateOfVist = dateOfVist;
	}
	public String getPrecription() {
		return precription;
	}
	public void setPrecription(String precription) {
		this.precription = precription;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Patient(Long patientId, String patientName, String visitedDoctor, String dateOfVist, String precription,
			Long doctorId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.VisitedDoctor = visitedDoctor;
		this.dateOfVist = dateOfVist;
		this.precription = precription;
		this.doctorId = doctorId;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", VisitedDoctor=" + VisitedDoctor
				+ ", dateOfVist=" + dateOfVist + ", precription=" + precription + ", doctorId=" + doctorId + "]";
	}
	
	
	
	
	

}
