package com.example.angularSpring.service;
import com.example.angularSpring.exception.UserNotFoundException;
import com.example.angularSpring.model.Patient;
import com.example.angularSpring.repository.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patientService {
    private patientRepository patientRepositroy;
    @Autowired
    public patientService(patientRepository patientRepositroy) {
        this.patientRepositroy = patientRepositroy;
    }
    public Patient addPatient(Patient patient)
    {
              return patientRepositroy.save(patient);
    }
    public List<Patient> findAllPatients()
    {
        return patientRepositroy.findAll();
    }
    public Patient updatePatient(Patient patient)
    {
        return patientRepositroy.save(patient);
    }
    public void deletePatient(Long id)
    {
        patientRepositroy.deleteById(id);
    }
    public Patient findPatientById(Long id)
    {
        return patientRepositroy.findPatientById(id).orElseThrow(() -> new UserNotFoundException("category  id :" + id +"was not found"));
    }
}
