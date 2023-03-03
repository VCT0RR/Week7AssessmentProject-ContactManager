/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ManagerListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String managerListName;
	private LocalDate dateAdded;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Manager manager;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListContacts> listOfContacts;
	
	public ManagerListDetails() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ManagerListDetails(int id, String managerListName, LocalDate dateAdded, Manager manager, List<ListContacts> listOfContacts) {
		super();
		this.id = id;
		this.managerListName = managerListName;
		this.dateAdded = dateAdded;
		this.manager = manager;
		this.listOfContacts = listOfContacts;
	}
	
	public ManagerListDetails(String managerListName, LocalDate dateAdded, Manager manager, List<ListContacts> listOfContacts) {
		super();
		this.managerListName = managerListName;
		this.dateAdded = dateAdded;
		this.manager = manager;
		this.listOfContacts = listOfContacts;
	}
	
	public ManagerListDetails(String managerListName, LocalDate dateAdded, Manager manager) {
		super();
		this.managerListName = managerListName;
		this.dateAdded = dateAdded;
		this.manager = manager;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the managerListName
	 */
	public String getManagerListName() {
		return managerListName;
	}

	/**
	 * @param managerListName the managerListName to set
	 */
	public void setManagerListName(String managerListName) {
		this.managerListName = managerListName;
	}

	/**
	 * @return the dateAdded
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	/**
	 * @return the listOfContacts
	 */
	public List<ListContacts> getListOfContacts() {
		return listOfContacts;
	}

	/**
	 * @param listOfContacts the listOfContacts to set
	 */
	public void setListOfContacts(List<ListContacts> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}
	
	@Override
	public String toString() {
		return "[ManagerListDetails Id=" + id + ", managerListName=" + managerListName + 
				", dateAdded=" + dateAdded + ", manager=" + manager + ", listOfContacts=" + listOfContacts + "]";
	}

}
