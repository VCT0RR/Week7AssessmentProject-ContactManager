import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ManagerHelper;
import controller.ManagerListDetailsHelper;
import model.ListContacts;
import model.Manager;
import model.ManagerListDetails;

/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */

public class ManagerListDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager seth = new Manager("Seth");
		
		//ManagerHelper mh = new ManagerHelper();
		
		ListContacts thomas = new ListContacts("Thomas", "p.thomass@gmail.com", "5159991234");
		ListContacts connor = new ListContacts("Connor", "connor.smith@outlook.com", "5458185155");
		
		List<ListContacts> sethsContacts = new ArrayList<ListContacts>();
		sethsContacts.add(thomas);
		sethsContacts.add(connor);
		
		//mh.insertManager(seth);
		
		ManagerListDetailsHelper mldh = new ManagerListDetailsHelper();
		
		ManagerListDetails sethsList = new ManagerListDetails("Seth's Contact Manager's List", LocalDate.now(), seth);
		sethsList.setListOfContacts(sethsContacts);
		
		mldh.insertNewListDetails(sethsList);
		
		List<ManagerListDetails> allLists = mldh.getLists();
		
		for(ManagerListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
