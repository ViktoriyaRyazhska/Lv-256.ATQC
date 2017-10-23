package com.regres.application;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.regres.entities.ResourceTypes;

public class Test {

	public static void main(String[] args) {
		
		String enteredNameSubclass = "Ivano-Frankivsk";
		String typeName = "";

		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		// По умолчанию entity name совпадает с именем класса.
		Query query = session.createQuery("from ResourceTypes where type_name = :subclassName");
		query.setParameter("subclassName", enteredNameSubclass);
		List<ResourceTypes> resourceTypes = query.list();

		if (resourceTypes != null && !resourceTypes.isEmpty()) {
			typeName = resourceTypes.get(0).getTypeName();
		}

		tx.commit();
		HibernateSessionFactory.closeSession();
		System.out.println(typeName);
	}
}
