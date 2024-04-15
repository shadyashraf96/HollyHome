package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PropertyDAO;
import model.Property;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		String propertyType = request.getParameter("propertyType");

		// Create an instance of PropertyDAO
		PropertyDAO propertyDAO = new PropertyDAO();
		// Retrieve filtered properties
		List<Property> properties = propertyDAO.getPropertiesByFilters(area, city, propertyType);

		// Set properties as a request attribute
		request.setAttribute("properties", properties);
		// Forward request to the JSP page for display
		RequestDispatcher dispatcher = request.getRequestDispatcher("listings.jsp");
		dispatcher.forward(request, response);
	}

}
