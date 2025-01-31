package movie.app;

public class Movie {
	private String movieUrl;
	private String movieName;
	private String movieRating;
	private String releaseYear;
	private String duration;
    private double movieId;
	public Movie(String movieUrl, String movieName, String movieRating, String releaseYear, String duration, double movieId) {
		super();
		this.movieUrl = movieUrl;
		this.movieName = movieName;
		this.movieRating = movieRating;
		this.releaseYear = releaseYear;
		this.duration = duration;
		this.movieId=movieId;
	}

	
	public String getMovieUrl() {
		return movieUrl;
	}

	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getMovieID() {
		
		return movieId;
	}
	public void setMovieID(double MovieID) {
		this.movieId = movieId;
	}


}

