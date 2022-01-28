package com.ty.student.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.student.dto.Student;
import com.ty.student.dto.User;

public class UserDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}

	public void saveUser(User user) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

	}

	public ArrayList<User> getAllUser() {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("from User u");
		return (ArrayList<User>) query.getResultList();
	}

	public boolean deleteUser(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	public User geUsertById(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		return entityManager.find(User.class, id);
	}
	
	public void updateUser(User user) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		}
	
	public User validateUser(String email,String pass) {
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1 AND u.pass = ?2");
		query.setParameter(1, email);
		query.setParameter(2, pass);
		List<User> users=query.getResultList();
		
		if(users!=null && users.size()>0) {
			return users.get(0);
		}else
			return null;
		
	}


}
