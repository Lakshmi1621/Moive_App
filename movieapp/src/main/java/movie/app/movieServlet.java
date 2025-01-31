package movie.app;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class movieServlet
 */
@WebServlet("/movie")
public class movieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public movieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init() throws ServletException {
		super.init();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getParameter("selectedMovieId"));
		Long movieId = Long.parseLong(request.getParameter("selectedMovieId"));
		ServletContext context = request.getServletContext();
	
		ArrayList<Movie> movieList = (ArrayList<Movie>) context.getAttribute("movieList");
		Movie selectedMovie = (Movie) request.getAttribute("selectedMovieObj");
	
		for(Movie m:movieList) {
			if(m.getMovieID() == movieId) {
				selectedMovie = m;
			}
		}
		if(selectedMovie != null) {
			request.setAttribute("selectedMovieObj", selectedMovie);
			RequestDispatcher rd =   request.getRequestDispatcher("/movieinfo.jsp");
			rd.forward(request, response);

		}else {
			response.getWriter().append("No information on selected Movie");
		}
		//Servlet Config is for one servlet
		//Servlet Context is for one application
		
	}
	
	private String buildMovieHtmlStr(Movie selectedMovie) {
		String str = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Movie info</title>\r\n"
				+ "    <style>\r\n"
				+ "        * {\r\n"
				+ "            margin: 0;\r\n"
				+ "            padding: 0;\r\n"
				+ "            box-sizing: border-box;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        body {\r\n"
				+ "            font-family: Arial, sans-serif;\r\n"
				+ "            background-color: #f9fafb;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-header {\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: space-between;\r\n"
				+ "            align-items: center;\r\n"
				+ "            padding: 15px 30px;\r\n"
				+ "            background-color: #1f2937;\r\n"
				+ "            color: white;\r\n"
				+ "            border-bottom: 2px solid #ef4444;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-header img {\r\n"
				+ "            width: 50px;\r\n"
				+ "            height: 50px;\r\n"
				+ "            border-radius: 50%;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-header input[type=\"text\"] {\r\n"
				+ "            padding: 8px;\r\n"
				+ "            margin: 0 10px;\r\n"
				+ "            border: 2px solid #ef4444;\r\n"
				+ "            border-radius: 5px;\r\n"
				+ "            font-size: 14px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-header button {\r\n"
				+ "            padding: 8px 16px;\r\n"
				+ "            border: 2px solid #ef4444;\r\n"
				+ "            background-color: white;\r\n"
				+ "            color: #ef4444;\r\n"
				+ "            font-size: 16px;\r\n"
				+ "            font-weight: bold;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            transition: background-color 0.3s, color 0.3s;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-header button:hover {\r\n"
				+ "            background-color: #ef4444;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-body {\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: space-between;\r\n"
				+ "            align-items: flex-start;\r\n"
				+ "            padding: 30px;\r\n"
				+ "            gap: 30px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .card-container {\r\n"
				+ "            flex: 2;\r\n"
				+ "            display: flex;\r\n"
				+ "            flex-direction: column;\r\n"
				+ "            gap: 30px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .box {\r\n"
				+ "            display: flex;\r\n"
				+ "            flex-direction: column;\r\n"
				+ "            align-items: center;\r\n"
				+ "            padding: 20px;\r\n"
				+ "            border: 2px solid #ef4444;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            text-align: center;\r\n"
				+ "            background-color: white;\r\n"
				+ "            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .box img {\r\n"
				+ "            width: 200px;\r\n"
				+ "            height: 300px;\r\n"
				+ "            object-fit: cover;\r\n"
				+ "            margin-bottom: 15px;\r\n"
				+ "            border-radius: 5px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .box h4 {\r\n"
				+ "            margin: 10px 0;\r\n"
				+ "            font-size: 18px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .info {\r\n"
				+ "            padding: 15px;\r\n"
				+ "            border: 2px solid #ddd;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            font-size: 16px;\r\n"
				+ "            background-color: white;\r\n"
				+ "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #theatre-selection {\r\n"
				+ "            flex: 1;\r\n"
				+ "            display: flex;\r\n"
				+ "            flex-direction: column;\r\n"
				+ "            gap: 20px;\r\n"
				+ "            align-items: center;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #theatre-selection h1 {\r\n"
				+ "            font-size: 24px;\r\n"
				+ "            color: #333;\r\n"
				+ "            margin-bottom: 20px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #theatre-selection button {\r\n"
				+ "            padding: 15px 20px;\r\n"
				+ "            border: 2px solid #ef4444;\r\n"
				+ "            background-color: white;\r\n"
				+ "            font-size: 18px;\r\n"
				+ "            font-weight: bold;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            width: 100%;\r\n"
				+ "            height: 50px;\r\n"
				+ "            transition: background-color 0.3s, color 0.3s;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #theatre-selection button:hover {\r\n"
				+ "            background-color: #ef4444;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-footer {\r\n"
				+ "            text-align: center;\r\n"
				+ "            padding: 15px;\r\n"
				+ "            background-color: #1f2937;\r\n"
				+ "            color: white;\r\n"
				+ "            border-top: 2px solid #ef4444;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #main-footer p {\r\n"
				+ "            font-size: 14px;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <header id=\"main-header\">\r\n"
				+ "        <img src=\"\" alt=\"logo\">\r\n"
				+ "        <input type=\"text\" placeholder=\"Search Movie\">\r\n"
				+ "        <input type=\"text\" placeholder=\"Search Theatre\">\r\n"
				+ "        <button>Profile</button>\r\n"
				+ "    </header>\r\n"
				+ "\r\n"
				+ "    <main id=\"main-body\">\r\n"
				+ "        <div class=\"card-container\">\r\n"
				+ "            <div class=\"box\">\r\n"
				+ "                <img src=\"\" alt=\"Movie 1 image\">\r\n"
				+ "                <h4>Movie name: "+selectedMovie.getMovieName()+"</h4>\r\n"
				+ "                <h4>Movie rating: "+selectedMovie.getMovieRating()+"</h4>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"info\">\r\n"
				+ "                <h4>Movie Info: "+selectedMovie.getReleaseYear()+"</h4>\r\n"
				+ "                <h4>Movie Cast: </h4>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div id=\"theatre-selection\">\r\n"
				+ "            <h1>Select Theatres</h1>\r\n"
				+ "            <button>Theatre 1</button>\r\n"
				+ "            <button>Theatre 2</button>\r\n"
				+ "            <button>Theatre 3</button>\r\n"
				+ "        </div>\r\n"
				+ "    </main>\r\n"
				+ "\r\n"
				+ "    <footer id=\"main-footer\">\r\n"
				+ "        <p>&copy; My Movie Booker</p>\r\n"
				+ "    </footer>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>\r\n"
				+ "";
		
		return str;
	}


	
	
	}


