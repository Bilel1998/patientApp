package com.example.angularSpring;

import com.example.angularSpring.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.angularSpring.service.patientService;

import java.util.List;

@RestController
@RequestMapping("/Patient")
public class patientController {
    private final patientService patientService;

    public patientController(com.example.angularSpring.service.patientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients()
    {
        List<Patient> patients=this.patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id)
    {
        Patient patient=this.patientService.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient)
    {
        Patient newpatient= this.patientService.addPatient(patient);
        return new ResponseEntity<>(newpatient, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient)
    {
        Patient updatePatient= this.patientService.updatePatient(patient);
        return new ResponseEntity<>(updatePatient, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Long id)
    {
        this.patientService.deletePatient(id);
        return new ResponseEntity<>( HttpStatus.OK);

    }
}
