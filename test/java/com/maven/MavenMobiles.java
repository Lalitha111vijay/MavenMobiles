package com.maven;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenMobiles {
	static WebDriver driver;
	static long startTime;
	@BeforeClass
	public static void launch(){
	System.out.println("Before class");
	WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();
	driver.get("http://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Before
	public void beforeMethod(){
		System.out.println("Before Method");
		
	startTime = System.currentTimeMillis();
	}
	@Test
	public void mobile1(){
	try {
	WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
	button.isDisplayed();
	button.click();
	} catch (Exception e){
	System.out.println("pop up is not displayed");
	}
	
	WebElement search = driver.findElement(By.name("q"));
	search.sendKeys("Mobiles",Keys.ENTER);
	WebElement mobileName = driver.findElement(By.xpath("//div[contains(text(),'realme')])[2]"));
	mobileName.click();
	driver.quit();
	
	}
}