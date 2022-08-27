package com.patient.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.patient.entity.Patient;
import com.patient.repository.PatientRepository;
import com.patient.vo.Doctor;
import com.patient.vo.ResponseTemplateVo;

@Service
public class PatientService {
	@Autowired
	private RestTemplate resttemplate;
	@Autowired
	private PatientRepository patientrepository;
	
	public String savePatient(Patient patient) {
		patientrepository.save(patient);
		return "patient"+ patient.getPatientName()+"was successfully registed";
	}
	
	
	public ResponseTemplateVo getPatientWithDoctor(Long patientId) {
		ResponseTemplateVo vo=new ResponseTemplateVo();
		Patient patient=patientrepository.findByPatientId(patientId);
		Doctor doctor =resttemplate.getForObject("Https://DOCTOR-SERVICE/doctor/doctorid/"+patient.getDoctorId(),Doctor.class);
		
		vo.setPatient(patient);
		vo.setDoctor(doctor);
		return vo;
	}
	
	
	public Patient updatePatient(Long patientId,Patient patient) {
		Patient objpat=patientrepository.findById(patientId).get();
		
		if(Objects.nonNull(patient.getPatientName()) &&! "".equalsIgnoreCase(patient.getPatientName())) {
		   objpat.setPatientName(patient.getPatientName());
		}
		if(Objects.nonNull(patient.getVisitedDoctor())) {
			   objpat.setVisitedDoctor(patient.getVisitedDoctor());
			}
		if(Objects.nonNull(patient.getPrecription())) {
			   objpat.setPrecription(patient.getPrecription());
			}
		return patientrepository.save(objpat);
		
	}
	
	
	public List<Patient> findAll(){
		return patientrepository.findAll();
	}
	
	
	public List<Patient> deletePatientById(Long patientId){
		 patientrepository.deleteById(patientId);
		 System.out.println("Doctor deleted sucessfully");
		 return patientrepository.findAll();
	}


	public Patient getPatientById(Long patientId) {
		// TODO Auto-generated method stub
		return patientrepository.findById(patientId).get();
	}
	
	
	
}
