package com.ray.crm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ray.crm.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private final SessionFactory sessionFactory;
	
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public User findByUserName(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User where username=:uname", User.class);
		theQuery.setParameter("uname", username);
		
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}
		
		return theUser;
	}

}
