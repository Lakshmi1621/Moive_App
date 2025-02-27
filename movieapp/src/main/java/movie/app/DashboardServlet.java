package movie.app;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("movie.app/dashboard/movieinfo.jsp")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	private ArrayList<Movie> movieList = new ArrayList<>();

	

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 List<Movie> movieList = new ArrayList<>();
		 movieList.add(new Movie("https://wallpaperaccess.com/full/1732928.jpg","Darling","10/10","2019","2.30", 1));
			movieList.add(new Movie("https://assets.gadgets360cdn.com/pricee/assets/product/202206/Sita-Ramam-poster_1656325728.jpg","Sita Ramam","10/10","2012","2.30", 2));
			movieList.add(new Movie("https://tse1.mm.bing.net/th?id=OIP.GTbSOd1XuxecTy8tuivxlAHaEK&pid=Api&P=0&h=180","Malli Malli Idi Rani Roju","9/10","2015","3.30", 3));
			movieList.add(new Movie("https://lh4.googleusercontent.com/-RCKpVLes-ck/TYhxOGCXi4I/AAAAAAAACiU/dVdhAoJKRKs/s1600/mrperfect2.jpg","Mr Perfect", "8/10", "2018","1.30",4));
			movieList.add(new Movie(
					"https://tse3.mm.bing.net/th?id=OIP.0ZTBIsTccUV0F6eh7T_yJAHaE8&pid=Api&P=0&h=180",
					"Baby", "7/10", "2020"," 1.30",5));
			movieList.add(new Movie(
					"https://tse1.mm.bing.net/th?id=OIP.uQIjaRimnLsHOFsb3sm5PwAAAA&pid=Api&P=0&h=180",
					"Geetha Govindam", "10/10", "2020"," 1.30",6));
			movieList.add(
					new Movie("https://tse3.mm.bing.net/th?id=OIP.l5Jxnl2GQWnXBE-7LtT8lwAAAA&pid=Api&P=0&h=180", "Jersey", "8/10", "2019", "1.30",7));
			movieList.add(new Movie(
					"https://tse3.mm.bing.net/th?id=OIP.1DFC10Fa8LEh1iZa6mYnlwHaEU&pid=Api&P=0&h=180",
					"#Bro", "8/10", "2019",  "1.30",8));
			movieList.add(new Movie(
					"https://timesofindia.indiatimes.com/thumb/msid-62752844,width-800,height-600,resizemode-4/62752844.jpg",
					"Chalo", "8/10", "2018"," 2.00",9));
			movieList.add(new Movie(
					"https://static.toiimg.com/photo/105240225.cms",
					"Joe", "7/10", "2023", "2.00",10));
			movieList.add(new Movie(
					"https://tse3.mm.bing.net/th?id=OIP.-ODpBLDd5tx9PxWpIb50FgHaIF&pid=Api&P=0&h=180",
					"SankranthikiVasthunam", "10/10", "2025", " 1.30",11));
			movieList.add(new Movie(
					"https://tse2.mm.bing.net/th?id=OIP.skmYKsVV0sr3JQ_YgPuN4QHaMC&pid=Api&P=0&h=180",
					"K.G.F", "9/10", "2019",  "2.30",12));
		 getServletContext().setAttribute("movieList", movieList);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
	        dispatcher.forward(request, response);
	    }
	
	    
//		StringBuffer html = new StringBuffer();
//
//		html.append("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "\r\n" + "<head>\r\n"
//				+ "    <meta charset=\"UTF-8\">\r\n"
//				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
//				+ "    <title>Homepage</title>\r\n" 
//				+ "        <style>\r\n"
//				+ "* {\r\n"
//				+ "    margin: 0;\r\n"
//				+ "    padding: 0;\r\n"
//				+ "    box-sizing: border-box;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "body {\r\n"
//				+ "    font-family: Arial, sans-serif;\r\n"
//				+ "    background-color: #f9fafb;\r\n"
//				+ "    color: #333;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-header {\r\n"
//				+ "    display: flex;\r\n"
//				+ "    justify-content: space-between;\r\n"
//				+ "    align-items: center;\r\n"
//				+ "    padding: 20px;\r\n"
//				+ "    background-color: #1f2937;\r\n"
//				+ "    color: white;\r\n"
//				+ "    border-bottom: 2px solid #ef4444;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-header img {\r\n"
//				+ "    width: 50px;\r\n"
//				+ "    height: 50px;\r\n"
//				+ "    border-radius: 50%;\r\n"
//				+ "    border: 2px solid #ef4444;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-header input[type=\"text\"] {\r\n"
//				+ "    padding: 8px;\r\n"
//				+ "    margin: 0 5px;\r\n"
//				+ "    border: 2px solid #ef4444;\r\n"
//				+ "    border-radius: 5px;\r\n"
//				+ "    font-size: 14px;\r\n"
//				+ "    transition: border-color 0.3s;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-header input[type=\"text\"]:focus {\r\n"
//				+ "    border-color: #dc2626;\r\n"
//				+ "    outline: none;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-header button {\r\n"
//				+ "    padding: 8px 16px;\r\n"
//				+ "    border: 2px solid #ef4444;\r\n"
//				+ "    background-color: #ef4444;\r\n"
//				+ "    color: white;\r\n"
//				+ "    font-size: 16px;\r\n"
//				+ "    font-weight: bold;\r\n"
//				+ "    cursor: pointer;\r\n"
//				+ "    border-radius: 10px;\r\n"
//				+ "    transition: background-color 0.3s;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-header button:hover {\r\n"
//				+ "    background-color: #dc2626;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-body {\r\n"
//				+ "    padding: 20px;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-showcase {\r\n"
//				+ "    text-align: center;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "#main-showcase h1 {\r\n"
//				+ "    font-size: 28px;\r\n"
//				+ "    margin-bottom: 20px;\r\n"
//				+ "    color: #1f2937;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ ".card-container {\r\n"
//				+ "    display: grid;\r\n"
//				+ "    grid-template-columns: repeat(4, 1fr);\r\n"
//				+ "    gap: 20px;\r\n"
//				+ "    padding: 10px;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ ".box {\r\n"
//				+ "    background-color: white;\r\n"
//				+ "    border-radius: 10px;\r\n"
//				+ "    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\r\n"
//				+ "    padding: 20px;\r\n"
//				+ "    text-align: center;\r\n"
//				+ "    transition: transform 0.3s ease, box-shadow 0.3s ease;\r\n"
//				+ "    height: 350px;\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ ".box:hover {\r\n"
//				+ "    transform: translateY(-5px);\r\n"
//				+ "    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);\r\n"
//		+ "}\r\n"
//		+ "\r\n"
//		+ ".box img {\r\n"
//		+ "    width: 100%;\r\n"
//		+ "    height: 200px;\r\n"
//		+ "    object-fit: cover;\r\n"
//		+ "    border-radius: 8px;\r\n"
//		+ "    margin-bottom: 15px;\r\n"
//		+ "}\r\n"
//		+ "\r\n"
//		+ ".box h4 {\r\n"
//		+ "    font-size: 18px;\r\n"
//		+ "    color: #4b5563;\r\n"
//		+ "    margin: 5px 0;\r\n"
//		+ "}\r\n"
//		+ "\r\n"
//		+ ".box .rating {\r\n"
//		+ "    font-size: 16px;\r\n"
//		+ "    color: #ef4444;\r\n"
//		+ "}\r\n"
//		+ "\r\n"
//		+ "#main-footer {\r\n"
//		+ "    text-align: center;\r\n"
//		+ "    padding: 10px;\r\n"
//		+ "    background-color: #1f2937;\r\n"
//		+ "    color: white;\r\n"
//		+ "    font-size: 14px;\r\n"
//		+ "}\r\n"
//		+ "\r\n"
//		+ "#main-footer p {\r\n"
//		+ "    margin-top: 5px;\r\n"
//		+ "}\r\n"
//		+ "\r\n"
//		+ "    </style>\r\n" + "</head>\r\n" + "\r\n" + "<body>\r\n"
//		+ "    <header id=\"main-header\">\r\n" + "        <img src=\"\" alt=\"Logo\">\r\n"
//		+ "        <input type=\"text\" placeholder=\"Search movies\">\r\n"
//		+ "        <input type=\"text\" placeholder=\"Search theatres\">\r\n"
//		+ "        <button>Profile</button>\r\n" + "    </header>\r\n" + "    <main id=\"main-body\">\r\n"
//		+ "        <section id=\"main-showcase\">\r\n" + "            <h1>Movies</h1>\r\n"
//		+ "            <div class=\"card-container\">");
//
//for (Movie movie : movieList) {
//	html.append("<div class=\"box\">\r\n" + "                    <img src=" + movie.getMovieUrl()
//			+ " alt=\"Movie image\" />\r\n" + "                    <h4>Movie Name: " + movie.getMovieName()
//			+ "</h4>\r\n" + "                    <h4>Movie Rating: " + movie.getMovieRating() + "</h4>\r\n"
//			+ "                    <h4>Release Year: " + movie.getReleaseYear() + "</h4>\r\n"
//			+ "                    <h4>Duration: " + movie.getDuration() + "</h4>\r\n"
//			+ "                </div>");
//}
//
//html.append("</div>\r\n" + "        </section>\r\n" + "    </main>\r\n" + "    <footer id=\"main-footer\">\r\n"
//		+ "        <p>&copy; My Movie Booker</p>\r\n" + "    </footer>\r\n" + "</body>\r\n" + "\r\n"
//		+ "</html>\r\n" + "");
//
//response.getWriter().print(html.toString());
}


	




