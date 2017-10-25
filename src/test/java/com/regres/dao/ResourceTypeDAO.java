package com.regres.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.regres.entities.HibernateSessionFactory;
import com.regres.entities.ResourceTypes;
import com.regres.testdata.NewSubclass;

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

	public boolean hasDuplicateSubclass(String enteredNameSubclass) {
		boolean hasDuplicate = false;
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		// The default name of the organization is the same as the name of the class.
		Query query = session.createQuery("from ResourceTypes where type_name = :subclassName ");
		query.setParameter("subclassName", enteredNameSubclass);
		List<ResourceTypes> resourceTypes = query.list();

		if (resourceTypes != null && !resourceTypes.isEmpty()) {
			if (resourceTypes.size() > 1) {
				hasDuplicate = true;
			}
		}

		tx.commit();
		HibernateSessionFactory.closeSession();
		return hasDuplicate;
	}

	public boolean hasEmptyField(String enteredNameSubclass) {
		// Delete this after I disconenect
		boolean emptyField = true;
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		// The default name of the organization is the same as the name of the class.
		Query query = session.createQuery("from ResourceTypes where type_name IS NULL or type_name = '' ");
		List<ResourceTypes> resourceTypes = query.list();
		if (resourceTypes == null || resourceTypes.isEmpty()) {
			if (resourceTypes.isEmpty()) {
			}
			emptyField = true;
			System.out.println("No values with empty field found");
		} else {
			System.out.println("Found value with empty ResourceType name " + resourceTypes);
		}
		tx.commit();
		HibernateSessionFactory.closeSession();
		return emptyField;

	}
}
