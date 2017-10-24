package com.regres.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import  com.regres.entities.HibernateSessionFactory;
import com.regres.entities.ResourceTypes;

public class ResourceTypeDAO {

	public boolean hasSubclassNameInDb(String enteredNameSubclass) {
		String typeName = getSubclassNameFromDb(enteredNameSubclass);
		boolean result = !typeName.equals("");
		return result;
	}
	
	public String getSubclassNameFromDb(String enteredNameSubclass) {
		String typeName = "";
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		// The default name of the organization is the same as the name of the class.
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
