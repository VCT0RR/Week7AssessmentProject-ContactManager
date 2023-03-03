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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManagerListDetailsHelper dao = new ManagerListDetailsHelper();
		ListContactHelper lch = new ListContactHelper();
		ManagerHelper mh = new ManagerHelper();
		Integer tempId= Integer.parseInt(request.getParameter("id"));
		ManagerListDetails listToUpdate = dao.searchForManagerListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String managerName = request.getParameter("managerName");
		Manager newManager = mh.findManager(managerName);
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedContacts = request.getParameterValues("allContactsToAdd");
			List<ListContacts> selectedContactsInList = new ArrayList<ListContacts>();
			
			for(int i = 0; i < selectedContacts.length; i++) {
				System.out.println(selectedContacts[i]);
				ListContacts c = lch.searchForEmailById(Integer.parseInt(selectedContacts[i]));
				selectedContactsInList.add(c);
			}
			listToUpdate.setListOfContacts(selectedContactsInList);
		}catch(NullPointerException ex) {
			List<ListContacts> selectedContactsInList = new ArrayList<ListContacts>();
			listToUpdate.setListOfContacts(selectedContactsInList);
		}
		
		listToUpdate.setManagerListName(newListName);
		listToUpdate.setDateAdded(ld);
		listToUpdate.setManager(newManager);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
}
