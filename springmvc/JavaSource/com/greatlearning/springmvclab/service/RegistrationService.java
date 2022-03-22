package com.greatlearning.springmvclab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.springmvclab.model.Student;

@Service
public interface RegistrationService {

	List<Student> getAllRegistrations();

	void saveOrUpdateRegistration(Student student);

	Student getStudentById(int id);

	void deleteRegistration(int id);

}
