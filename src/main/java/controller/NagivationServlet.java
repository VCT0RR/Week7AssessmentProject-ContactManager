package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListContacts;

/**
 * Servlet implementation class NagivationServlet
 */
@WebServlet("/nagivationServlet")
public class NagivationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NagivationServlet() {
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
		String act = request.getParameter("doThisToContact");
		String path = "/viewAllContactsServlet";
		
		ListContactHelper dao = new ListContactHelper();
		
		if(act.equals("delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListContacts contactToDelete = dao.searchForEmailById(tempId);
				dao.deleteContact(contactToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Please select a contact to delete.");
			}
		
		}
		else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListContacts contactToEdit = dao.searchForEmailById(tempId);
				request.setAttribute("contactToEdit", contactToEdit);
				path = "/edit-contact.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Please select a contact to edit.");
			}
		}
		else if(act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
