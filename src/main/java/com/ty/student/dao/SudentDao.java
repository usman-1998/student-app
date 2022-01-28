package com.ty.student.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.ty.student.dto.Student;

public class SudentDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();

	}

	public void saveStudent(Student student) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

	}

	public ArrayList<Student> getAllUser() {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("from Student s");
		return (ArrayList<Student>) query.getResultList();
	}

	public boolean deleteStudent(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	public Student getStudentById(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		return entityManager.find(Student.class, id);
	}
	
	public void updateStudent(Student student) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		}

}
