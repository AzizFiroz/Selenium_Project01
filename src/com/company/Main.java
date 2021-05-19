package com.company;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;


public class Main {

    public static void main(String[] args) {


    try{
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
//        Instantiating the web driver object
        WebDriver driver= new ChromeDriver();

//        test 1: Checking the Title
        driver.get("https://www.thesparksfoundationsingapore.org/");
        driver.manage().window().maximize();

        String actual_title =driver.getTitle();
        String estimated_title = "The Sparks Foundation | Home";


        if(actual_title.equalsIgnoreCase(estimated_title)){
            System.out.println("Test 1 passed");
            System.out.println("The title is Correct\n");
        }
        else{
            System.out.println("Test 1 Failed!\n The Title is not Correct\n");

        }
        Thread.sleep(2000);
//        Test 2 : Scrolling And checking the navbar
        driver.get("https://www.thesparksfoundationsingapore.org/about/vision-mission-and-values/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0, 5000)");
        Thread.sleep(2000);
        boolean status =driver.findElement(By.className("b-nav")).isDisplayed();

        if(status){
            System.out.println("Test 2 passed");
            System.out.println("The Side Link Navbar is present at the page\n" +
                    " https://www.thesparksfoundationsingapore.org/about/vision-mission-and-values/\n");
        }
        else{
            System.out.println("Test 2 failed");
            System.out.println("The Side Link Navbar is not present at the page\n" +
                    " https://www.thesparksfoundationsingapore.org/about/vision-mission-and-values/\n");
        }
        Thread.sleep(2000);

        //        test 3: Checking if Pop up not shown before clicked
        driver.get("https://www.thesparksfoundationsingapore.org/");
        driver.manage().window().maximize();

        List<WebElement> myElementList = driver.findElements(By.className("dropdown menu__item open"));
        if (myElementList.isEmpty()) {
            System.out.println("Test 3: Passed");
            System.out.println("Top Menu popup is working properly\n");
        }else {
            // We know it exists, now we need to know if it's displayed (visible) or not
            if (myElementList.get(0).isDisplayed()) {
                System.out.println("Test 3 Failed");
                System.out.println("Top Menu popup is not working properly\n Menu item shown before clicking\n");
            }else {
                System.out.println("Test 3 Passed");
                System.out.println("Top Menu popup is not working properly\n Menu item shown before clicking\n");
            }

        }
        Thread.sleep(2000);


        // Test 4: New Menus Shown after navbar About US clicked

        driver.get("https://www.thesparksfoundationsingapore.org/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@data-hover='About']")).click();
        Thread.sleep(2000);
        boolean status4 = driver.findElement(By.className("dropdown-menu")).isDisplayed();

        if(status4){
            System.out.println("Test 4: Passed");
            System.out.println("Menu Items of AboutUS menu shown Properly\n");
        }else{
            System.out.println("Test 4: Failed");
            System.out.println("Menu Items of AboutUS menu is not shown Properly\n");
        }

        Thread.sleep(2000);
//        Test 5 : Navigating to /policies-and-code/code-of-ethics-and-conduct/ and checking the heading

        driver.findElement(By.xpath("//a[@data-hover='Policies and Code']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Code of Ethics and Conduct']")).click();

        boolean status55 = driver.findElement(By.xpath(("//h2[text()='Code of Ethics and Conduct']"))).isDisplayed();



        if(status55){
            System.out.println("Test 5 passed");
            System.out.println("Successfully Navigated to https://www.thesparksfoundationsingapore.org/policies-and-code/code-of-ethics-and-conduct/ page " +
                    "and heading is correct\n");
        }
        else{
            System.out.println("Test 5 failed");
            System.out.println("Could not Navigate to https://www.thesparksfoundationsingapore.org/policies-and-code/code-of-ethics-and-conduct/ \n");
        }

        Thread.sleep(2000);


//        Test 6 : Check the SideBar on Software and apps page
        driver.get("https://www.thesparksfoundationsingapore.org/links/software-and-app/");
        driver.manage().window().maximize();


        boolean status6 =driver.findElement(By.className("w3l-blog-list")).isDisplayed();

        if(status6){
            System.out.println("Test 6 passed");
            System.out.println("SideBar correctly Displayed on the https://www.thesparksfoundationsingapore.org/links/software-and-app/ Page\n");
        }
        else{
            System.out.println("Test 6 passed");
            System.out.println("SideBar is NOT correctly Displayed on the https://www.thesparksfoundationsingapore.org/links/software-and-app/ Page\n");
        }
        Thread.sleep(2000);


//        Test 7 : Check the Footer Links on Software and apps page
        driver.get("https://www.thesparksfoundationsingapore.org/links/software-and-app/");
        driver.manage().window().maximize();


        boolean status77 =driver.findElement(By.xpath("//*[@class='top-header-agile-right']")).isDisplayed();

        if(status77){
            System.out.println("Test 7 passed!");
            System.out.println("Footer Correctly Displayed on the https://www.thesparksfoundationsingapore.org/links/software-and-app/ Page\n");
        }
        else{
            System.out.println("Test 7 failed!");
            System.out.println("Footer is NOT Correctly Displayed on the https://www.thesparksfoundationsingapore.org/links/software-and-app/ Page\n");

        }
        Thread.sleep(2000);

//        Test 8: Navigate to /programs/student-mentorship-program/ and check quote is displayed or not
        driver.get("https://www.thesparksfoundationsingapore.org/");
        driver.manage().window().maximize();

        js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0, 5000)");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//ul[@class='b-nav']//a[text()='Student Mentorship Program']")).click();

        boolean status88 =driver.findElement(By.className("para-w3-agile")).isDisplayed();

        if(status88){
            System.out.println("Test 8 passed");
            System.out.println("Successfully Navigated to https://www.thesparksfoundationsingapore.org/programs/student-mentorship-program/ \n" +
                    "Quote Text Correctly Displayed on the /links/software-and-app/ Page\n");

        }
        else{
            System.out.println("Test 8 failed");
            System.out.println("Navigation to https://www.thesparksfoundationsingapore.org/programs/student-mentorship-program/ Failed\n");

        }
        Thread.sleep(2000);


//        Test 9: Navigate to /policies-and-code/service-quality-values/ and
//        check line for partnership is printed
        driver.findElement(By.xpath("//a[@data-hover='Policies and Code']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Service Quality Values']")).click();

        boolean status99 = driver.findElement(By.xpath("//p[contains(.,'favourable')]")).isDisplayed();
        if(status99){
            System.out.println("Test 9 Passed");
            System.out.println("Successfully Navigated to https://www.thesparksfoundationsingapore.org/policies-and-code/service-quality-values/ \n" +
                    "and Text is Displayed Correctly\n");

        }else{
            System.out.println("Test 9  Failed");
            System.out.println("Navigation to https://www.thesparksfoundationsingapore.org/policies-and-code/service-quality-values/ Failed\n");

        }
        Thread.sleep(2000);


//        Test 10: Navigate to /links/ai-in-education/ scroll and click on learn button
        // Check if landed to the right page or not
        driver.findElement(By.xpath("//a[@data-hover='LINKS']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='AI in Education']")).click();



        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("scrollBy(0, 3000)");
        Thread.sleep(2000);
        //    Click the Learn More Button on "Can AI fix Education" Section
//      Check if correct URL is reached

        driver.findElement(By.xpath("//a[contains(@href,'www.theverge.com') and @class = 'button-w3layouts hvr-rectangle-out']")).click();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        String acutal_URL = "https://www.theverge.com/2016/4/25/11492102/bill-gates-interview-education-software-artificial-intelligence";
        String curret_Url = driver.getCurrentUrl();

        if (acutal_URL.equals(curret_Url)){
            System.out.println("Test 10 passed");
            System.out.println("URL for 'Can AI fix Education' Successfully Reached\n");

        }
        else{
            System.out.println(curret_Url);
            System.out.println("Test 10 failed");
            System.out.println("Failed to reach the URL for 'Can AI fix Education'\n");

        }
        Thread.sleep(2000);

        driver.close();
    }catch (Exception e){
        e.getStackTrace();
    }
         // close driver
    }
}