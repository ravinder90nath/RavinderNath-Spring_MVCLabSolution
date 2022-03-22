package com.greatlearning.springmvclab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.springmvclab.model.Student;

@Repository
public class RegistrationDao {

	private SessionFactory sessionFactory;
	private Session session;

	RegistrationDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllRegistrations() {
		return session.createQuery("from Student").list();
	}

	@Transactional
	public void saveRegistration(Student student) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
	}

	public Student getStudentById(int id) {
		return session.get(Student.class, id);
	}

	@Transactional
	public void deleteStudent(int id) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		transaction.commit();
	}

}
