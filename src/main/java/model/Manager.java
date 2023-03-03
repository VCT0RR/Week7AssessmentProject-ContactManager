/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager {
	@Id
	@GeneratedValue
	private int id;
	private String managerName;
	
	public Manager() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Manager(int id, String managerName) {
		super();
		this.id = id;
		this.managerName = managerName;
	}
	
	public Manager(String managerName) {
		super();
		this.managerName = managerName;
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
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	@Override
	public String toString() {
		return  "Manager [id=" + id + ", managerName=" + managerName + "]";
	}

}
