package com.regres.pages;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.regres.application.HibernateSessionFactory;
import com.regres.application.ResourceTypes;

/**
 * The class that provides the basic functionality for working with the database
 */
public class BaseFunctionalForDB {

	public boolean hasSubclassNameInDb(String enteredNameSubclass) {
		String typeName = getSubclassNameFromDb(enteredNameSubclass);
		boolean result = !typeName.equals("");
		return result;
	}

	public String getSubclassNameFromDb(String enteredNameSubclass) {
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
		return typeName;
	}

}
