package com.greatlearning.springmvclab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.springmvclab.dao.RegistrationDao;
import com.greatlearning.springmvclab.model.Student;
import com.greatlearning.springmvclab.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationDao registrationDAO;

	@Override
	public List<Student> getAllRegistrations() {
		return registrationDAO.getAllRegistrations();
	}

	@Override
	public void saveOrUpdateRegistration(Student student) {
		registrationDAO.saveRegistration(student);
	}

	@Override
	public void deleteRegistration(int id) {
		registrationDAO.deleteStudent(id);
	}

	@Override
	public Student getStudentById(int id) {
		return registrationDAO.getStudentById(id);
	}

}
