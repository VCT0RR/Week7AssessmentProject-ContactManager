/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ManagerListDetails;

public class ManagerListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ContactManager");
	
	public void insertNewListDetails(ManagerListDetails m) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ManagerListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ManagerListDetails> allDetails = em.createQuery("SELECT d FROM ManagerListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(ManagerListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ManagerListDetails> typedQuery = em.createQuery("select detail from ManagerListDetails detail where detail.id = :selectedId", ManagerListDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		ManagerListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ManagerListDetails searchForManagerListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ManagerListDetails found = em.find(ManagerListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(ManagerListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
