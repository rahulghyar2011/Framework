package com.utils;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.keyword.Keywords;

public class TestCase {
    @Test
	public void tc_01() {
		Keywords.openBrowser("Chrome");
		Keywords.enterURL("https://www.facebook.com/");
		Keywords.maximizeWindow();
		Keywords.enterText("xpath","//input[@id='email']","Rahul");
		Keywords.enterText("xpath","//input[@id='pass']","ghyar");
        Keywords.click("xpath","//input[@id='u_0_3']");
        assertEquals(Keywords.getCurrentURL(), "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110");
	   // Keywords.takeScreenshot("login");	 
	    Keywords.closeBrowser();
	}
    @Test
	public void tc_02() {
		Keywords.openBrowser("Chrome");
		Keywords.enterURL("https://www.facebook.com/");
		Keywords.maximizeWindow();
		Keywords.enterText("xpath","//input[@id='email']","Rahul");
		Keywords.enterText("xpath","//input[@id='pass']","ghyar");
        Keywords.click("xpath","//input[@id='u_0_3']");
        SoftAssert as=new SoftAssert();
        as.assertEquals(Keywords.getCurrentURL(), "https://www.facebook.com/log/device-based/regular/login/?login_attempt=1&lwv=110");
	    Keywords.takeScreenshot("tc_02");	 
	    Keywords.closeBrowser();
	}
	

}
