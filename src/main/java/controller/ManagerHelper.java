/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Manager;

public class ManagerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ContactManager");
	
	public void insertManager(Manager s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Manager> showAllManagers() {
		EntityManager em = emfactory.createEntityManager();
		List<Manager> allManagers = em.createQuery("SELECT m FROM Manager m").getResultList();
		return allManagers;
	}
	
	public Manager findManager(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Manager> typedQuery = em.createQuery("select mh from Manager mh where mh.managerName = :selectedName", Manager.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Manager foundManager;
		
		try {
			foundManager = typedQuery.getSingleResult();
		}catch(NoResultException ex) {
			foundManager = new Manager(nameToLookUp);
		}
		em.close();
		return foundManager;
	}
}
