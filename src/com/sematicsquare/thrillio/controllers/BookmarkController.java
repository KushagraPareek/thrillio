package com.sematicsquare.thrillio.controllers;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;

public class BookmarkController {

	 private static BookmarkController instance;
	 
	 private BookmarkController() {}
	 
	 public static BookmarkController getInstance() {
		 
		 if(instance == null) {
			 instance = new BookmarkController();
		 }
		 
		 return instance;
	 }

	public void saveUserBookmark(User user, Bookmark bookmark) {
		
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyDecision, Bookmark bookmark) {
		
		BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyDecision,bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		
		BookmarkManager.getInstance().share(user, bookmark);
		
	}



	
}
