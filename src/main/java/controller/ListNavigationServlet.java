package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManagerListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		} else if(act.equals("delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ManagerListDetails listToDelete = dao.searchForManagerListDetailsById(tempId);
				dao.deleteList(listToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Please select a button.");
			}finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		} else if(act.equals("edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ManagerListDetails listToEdit = dao.searchForManagerListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("month", listToEdit.getDateAdded().getMonthValue());
				request.setAttribute("date", listToEdit.getDateAdded().getDayOfMonth());
				request.setAttribute("year", listToEdit.getDateAdded().getYear());
				ListContactHelper daoForContacts = new ListContactHelper();
				request.setAttribute("allContacts", daoForContacts.showAllContacts());
				
				if(daoForContacts.showAllContacts().isEmpty()) {
					request.setAttribute("allContacts", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
				}catch(NumberFormatException e) {
					getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				}
			
		} else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/addContactsForListServlet").forward(request, response);
		}
	}
}
