package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entity.Patient;
import com.patient.service.PatientService;
import com.patient.vo.ResponseTemplateVo;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")

public class PatientController {
	@Autowired
	private PatientService patientservice;
	
	@PostMapping("/patients")
	public String registerPatient(@RequestBody Patient patient) {
		
		return patientservice.savePatient(patient);
	}
	
	@GetMapping("/patientid/{id}")
	public ResponseTemplateVo getPatientWithDoctor(@PathVariable("id") Long patientId) {
		return patientservice.getPatientWithDoctor(patientId);
	}
	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable("id") Long patientId) {
		return patientservice.getPatientById(patientId);
	}
	
	@GetMapping("/")
	public List<Patient> getAllPatient(){
		return patientservice.findAll();
	}
	
	@PutMapping("/id/{id}")
	public Patient updatePatient(@PathVariable("id") Long patientId,@RequestBody Patient patient) {
		return patientservice.updatePatient(patientId,patient);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public List<Patient> deletePatientById(@PathVariable("patientId") Long patientId) {
		return patientservice.deletePatientById(patientId);
	}
	
	
	
	
	
	
	
	
	

}
