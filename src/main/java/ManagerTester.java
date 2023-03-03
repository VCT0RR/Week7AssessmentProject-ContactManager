import java.util.List;

import controller.ManagerHelper;
import model.Manager;

/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */

public class ManagerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager ryan = new Manager("Ryan");
		Manager victor = new Manager("Victor");
		
		ManagerHelper mh = new ManagerHelper();
		
		mh.insertManager(ryan);
		mh.insertManager(victor);
		
		List<Manager> allManagers = mh.showAllManagers();
		for(Manager a : allManagers) {
			System.out.println(a.toString());
		}
	}

}
