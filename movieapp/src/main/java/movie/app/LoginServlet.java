package movie.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	private static ArrayList<User> userList = new ArrayList<>();

   
	
	@Override
	public void init() throws ServletException {
		userList.add(new User("lakshmi", "9866709807", "lakshmi@gmail.com", "1234567"));
		userList.add(new User("neelu", "1234567891", "neelu@gmail.com", "456"));
		userList.add(new User("ooha", "1234567892", "ooha@gmail.com", "789"));
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		for (User user : userList) {
			if (user.getPhoneNumber().equals(phone)) {
				if (user.getPassword().equals(password)) {

					Cookie loginCookie = new Cookie("user", phone);
					loginCookie.setMaxAge(3600);
					response.addCookie(loginCookie);

//					For cookies we cant use RequestDispatcher because the browser doesn't receive the response with the cookies.
//	              	Thus, cookies are unavailable in the target servlet during the same request lifecycle.

//	              	RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
//	              	dispatcher.forward(request, response);

//	 			  	So when we use the cookies, we can use sendRedirect method so the to ensure cookies are sent back to the server in a new request.
//	              	RequestDispatcher.forward only for internal navigation when cookies or a new request lifecycle are not required.

					response.sendRedirect("dashboard");
				}
			}
		}

		response.getWriter().println("Account Not Present");
	}
}
