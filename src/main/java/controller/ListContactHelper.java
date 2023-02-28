/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListContacts;

public class ListContactHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ContactManager");
	
	public void insertContact(ListContacts lc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListContacts> showAllContacts() {
		EntityManager em = emfactory.createEntityManager();
		List<ListContacts> allContacts = em.createQuery("SELECT i FROM ListContacts i").getResultList();
		return allContacts;
	}
	
	public void deleteContact(ListContacts toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListContacts> typedQuery = em.createQuery("select lc from ListContacts lc where lc.email = :selectedEmail and lc.name = :selectedName", ListContacts.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedEmail", toDelete.getEmail());
		
		typedQuery.setMaxResults(1);
		
		ListContacts result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListContacts> searchForEmailByName(String contactName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListContacts> typedQuery = em.createQuery("select lc from ListContacts lc where lc.name = :selectedName", ListContacts.class);
		
		typedQuery.setParameter("selectedName", contactName);
		List<ListContacts> foundContacts = typedQuery.getResultList();
		em.close();
		return foundContacts;
	}
	
	public List<ListContacts> searchForEmailByEmail(String emailName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListContacts> typedQuery = em.createQuery("select lc from ListContacts lc where lc.email = :selectedEmail", ListContacts.class);
		
		typedQuery.setParameter("selectedEmail", emailName);
		List<ListContacts> foundContacts = typedQuery.getResultList();
		em.close();
		return foundContacts;
		
	}
	
	public ListContacts searchForEmailById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListContacts found = em.find(ListContacts.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateContact(ListContacts toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
