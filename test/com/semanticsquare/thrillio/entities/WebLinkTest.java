package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		
		// Test1 : Porn in url : false
		Weblink link = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		boolean isKidFriendly = link.isKidFriendlyEligible();
		assertFalse("For porn in url, must return false",isKidFriendly);
		
	    // Test2 : Porn in title: false
		link = BookmarkManager.getInstance().createWeblink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendly = link.isKidFriendlyEligible();
		
		assertFalse("For porn in title, must return false",isKidFriendly);
		
		// Test3 : Adult in host : false
		link = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaadult.com");
		
		isKidFriendly = link.isKidFriendlyEligible();
		assertFalse("For Adult in host, must return false",isKidFriendly);
		
		// Test4 : Adult in url but not in host: true
		link = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/adult/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendly = link.isKidFriendlyEligible();
		assertTrue("For Adult in url, must return true",isKidFriendly);
		
		// Test5 : Adult in title only : true
		link = BookmarkManager.getInstance().createWeblink(2000, "Taming adult Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendly = link.isKidFriendlyEligible();
		assertTrue("For Adult in title, must return true",isKidFriendly);
	}

}
