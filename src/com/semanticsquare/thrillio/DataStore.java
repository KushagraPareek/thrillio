package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

public class DataStore {

	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	private static int bookmarkIndex;

	private static User[] users = new User[TOTAL_USER_COUNT];

	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	

	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];

	public static User[] getUsers() {
		return users;
	}

	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}
	
	public static void loadData() {

		loadUsers();
		loadWebLinks();
		loadBooks();
		loadMovies();
	}

	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M",
				Gender.MALE, UserType.USER);
		users[1] = UserManager.getInstance().createUser(1000, "user1@semanticsquare.com", "test", "Sam", "M",
				Gender.MALE, UserType.USER);
		users[2] = UserManager.getInstance().createUser(1000, "user2@semanticsquare.com", "test", "Anita", "M",
				Gender.FEMALE, UserType.EDITOR);
		users[3] = UserManager.getInstance().createUser(1000, "user3@semanticsquare.com", "test", "Sara", "M",
				Gender.FEMALE, UserType.EDITOR);
		users[4] = UserManager.getInstance().createUser(1000, "user4@semanticsquare.com", "test", "Dheeru", "M",
				Gender.MALE, UserType.CHIEF_EDITOR);
	}

	private static void loadWebLinks() {

		bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2001,
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");

		bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2002, "Interface vs Abstract Class",
				"http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com");

		bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2003, "NIO tutorial by Greg Travis",
				"http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu");

		bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2004, "Virtual Hosting and Tomcat",
				"http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org");

	}

	private static void loadBooks() {

		String[] authors = new String[3];
		authors[0] = "Henry";
		authors[1] = "David";
		authors[2] = "Thoreau";

		bookmarks[1][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", authors,
				BookGenre.PHILOSOPHY, 4.3);

		authors = new String[3];
		authors[0] = "Ralph";
		authors[1] = "Waldo";
		authors[2] = "Emerson";

		bookmarks[1][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", 1993,
				"Dover Publications", authors, BookGenre.PHILOSOPHY, 4.5);

		authors = new String[3];
		authors[0] = "Lillian";
		authors[1] = "Eichler";
		authors[2] = "Watson";

		bookmarks[1][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", 1988, "Touchstone",
				authors, BookGenre.PHILOSOPHY, 5.0);

		authors = new String[4];
		authors[0] = "Eric Freeman";
		authors[1] = "Bert Bates";
		authors[2] = "Kathy Sierra";
		authors[3] = "Elisabeth Robson";

		bookmarks[1][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", 2004,
				"O'Reilly Media", authors, BookGenre.TECHNICAL, 4.5);

		authors = new String[1];
		authors[0] = "Joshua Bloch";

		bookmarks[1][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide",
				2007, "Prentice Hall", authors, BookGenre.TECHNICAL, 4.9);

	}

	private static void loadMovies() {

		String[] actors = new String[2];
		String[] directors = new String[1];

		actors[0] = "Orson Welles";
		actors[1] = "Joseph Cotten";

		directors[0] = "Orson Welles";
		bookmarks[2][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, actors, directors,
				MovieGenre.CLASSICS, 8.5);

		actors = new String[2];
		directors = new String[1];

		actors[0] = "Henry Fonda";
		actors[1] = "Jane Darwell";

		directors[0] = "John Ford";

		bookmarks[2][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", 1940, actors,
				directors, MovieGenre.CLASSICS, 8.2);

		actors = new String[1];
		directors = new String[1];

		actors[0] = "Albert Cullum";

		directors[0] = "Leslie Sullivan";

		bookmarks[2][2] = BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness", 2004, actors,
				directors, MovieGenre.DOCUMENTARIES, 7.3);

		actors = new String[2];
		directors = new String[2];

		actors[0] = "Kaley Cuoco";
		actors[1] = "Jim Parsons";

		directors[0] = "Chuck Lorre";
		directors[1] = "Bill Prady";

		bookmarks[2][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory", 2007, actors,
				directors, MovieGenre.TV_SHOWS, 8.7);

		actors = new String[2];
		directors = new String[1];

		actors[0] = "Takashi Shimura";
		actors[1] = "Minoru Chiaki";

		directors[0] = "Akira Kurosawa";

		bookmarks[2][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru", 1952, actors, directors,
				MovieGenre.FOREIGN_MOVIES, 8.4);

	}

	public static void add(UserBookmark userBookmark) {
		
		userBookmarks[bookmarkIndex++] = userBookmark;
		
	}
}
