package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;
import com.sematicsquare.thrillio.controllers.BookmarkController;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is Browsing");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					if (getBookmarkDecision(bookmark)) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println(bookmark);
						if (user.getUserType().equals(UserType.EDITOR)
								|| user.getUserType().equals(UserType.CHIEF_EDITOR)) {
							if (bookmark.isKidFriendlyEligible()
									&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {

								BookmarkController.getInstance().setKidFriendlyStatus(user,getKidFriendlyDecision(),
										bookmark);

							}
							
							//Share
							if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
									&& bookmark instanceof Shareable) {
								
								if(getShareDecision()) {
									BookmarkController.getInstance().share(user,bookmark);
								}
							}
						}

					}
				}

			}
		}

	}

	private static boolean getShareDecision() {
		
		return Math.random() > 0.5 ? true : false;
	}

	private static String getKidFriendlyDecision() {
		// TODO Auto-generated method stub
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: Math.random() >= 0.4 && Math.random() < 0.8 ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {

		return Math.random() > 0.5 ? true : false;

	}

}
