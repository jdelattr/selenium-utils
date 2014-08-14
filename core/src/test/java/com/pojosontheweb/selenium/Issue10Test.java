package com.pojosontheweb.selenium;

import org.junit.Assert;
import org.junit.Test;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class Issue10Test extends ManagedDriverJunit4TestBase {

    @Test
    public void testElemListWhereElemCount() {
        getWebDriver().get("http://www.pojosontheweb.com");

        findr()
            .elem(id("top-nav"))
            .elemList(cssSelector("li a"))
            .where(Findr.textEquals("Home"))
            .whereElemCount(1)
            .eval();

        // make sure you canot construct a ListFindr
        // with where() after whereElemCount()
        boolean failed = false;
        try {
            findr()
                .elem(id("top-nav"))
                .elemList(cssSelector("li a"))
                .whereElemCount(1)
                .where(Findr.textEquals("Home"));
        } catch(IllegalArgumentException e) {
            // all good
            failed = true;
        }
        Assert.assertTrue(failed);
    }

}
