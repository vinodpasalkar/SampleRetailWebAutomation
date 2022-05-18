package net.webtestautomation;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;

public class AcceptanceTestSuite extends SerenityStories {

	
    @Managed(uniqueSession = false)
    public static WebDriver webdriver;

    @BeforeStory
    public void beforeStory() {
    	 System.out.println("--- Before Story Ends---");
    }
        
    
    @BeforeStories
    public void start() {
    }

    @AfterStory
    public void afterStory() {
    	System.out.println("--- After Story Ends---");
    }
    
    @AfterStories
    public void stop() {
        webdriver.quit();
    }
    
  
        
}
