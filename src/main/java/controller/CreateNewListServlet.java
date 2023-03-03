package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListContacts;
import model.Manager;
import model.ManagerListDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListContactHelper lch = new ListContactHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String managerName = request.getParameter("managerName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		String[] selectedContacts = request.getParameterValues("allContactsToAdd");
		List<ListContacts> selectedContactsInList = new ArrayList<ListContacts>();
		
		if(selectedContacts != null && selectedContacts.length > 0) {
			
			for(int i = 0; i < selectedContacts.length; i++) {
				System.out.println(selectedContacts[i]);
				ListContacts c = lch.searchForEmailById(Integer.parseInt(selectedContacts[i]));
				selectedContactsInList.add(c);
			}
		}
		Manager manager = new Manager(managerName);
		ManagerListDetails mld = new ManagerListDetails(listName, ld, manager);
		mld.setListOfContacts(selectedContactsInList);
		ManagerListDetailsHelper mldh = new ManagerListDetailsHelper();
		mldh.insertNewListDetails(mld);
		
		System.out.println("Success!");
		System.out.println(mld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
