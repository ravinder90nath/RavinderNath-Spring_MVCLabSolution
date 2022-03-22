package com.greatlearning.springmvclab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.springmvclab.model.Student;
import com.greatlearning.springmvclab.service.RegistrationService;

@Controller
@RequestMapping("/students")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping("/list")
	public String getAllRegistrations(Model model) {
		List<Student> students = registrationService.getAllRegistrations();
		model.addAttribute("Students", students);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student student = Student.builder().build();
		theModel.addAttribute("Student", student);
		return "registration-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {
		Student student = registrationService.getStudentById(id);
		theModel.addAttribute("Student", student);
		return "registration-form";
	}

	@PostMapping("/save")
	public String saveOrUpdateRegistration(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("country") String country, @RequestParam("department") String department) {
		Student student = null;
		if (id != 0) {
			student = registrationService.getStudentById(id);
			student.setCountry(country);
			student.setDepartment(department);
			student.setName(name);
		} else {
			student = Student.builder().name(name).department(department).country(country).build();
		}

		registrationService.saveOrUpdateRegistration(student);
		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String deleteStudentRegistration(@RequestParam("id") int id) {
		registrationService.deleteRegistration(id);
		return "redirect:/students/list";
	}

}
