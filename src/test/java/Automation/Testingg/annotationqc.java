package Automation.Testingg;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class annotationqc {
	   private RemoteWebDriver driver;

	    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        URL url = new URL("http://172.20.23.92:4444/wd/hub");
        driver = new RemoteWebDriver(url, dc);
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        driver.get("http://apollo2.humanbrain.in/");
        driver.manage().window().maximize();
        System.out.println("The server is opened successfully");

        WebDriverWait wait = new WebDriverWait(driver, 50);
        try {
            String parentWindow = driver.getWindowHandle();
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
            loginButton.click();
            System.out.println("The login Button is clicked");

            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
            emailInput.sendKeys("teamsoftware457@gmail.com");
            System.out.println("Mail ID is entered");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
            nextButton.click();
            System.out.println("The Next Button is clicked");

            WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
            passwordInput.sendKeys("Health#123");
            System.out.println("Password is entered");

            WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
            nextButton2.click();
            System.out.println("The Next Button is clicked");

            driver.switchTo().window(parentWindow);
            Thread.sleep(5000);

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void table() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
            searchInput.sendKeys("AC\n");
            Thread.sleep(3000);
            System.out.println("The number Entered Successfully");
        } catch (Exception e) {
            System.err.println("The number is not Entered successfully: " + e.getMessage());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement atlasEditorButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Atlas Editor']")));
            atlasEditorButton.click();
            Thread.sleep(3000);
            System.out.println("The Atlas Editor is clicked");
        } catch (Exception e) {
            System.err.println("The Atlas Editor is not clicked: " + e.getMessage());
        }

        Thread.sleep(4000);
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    @Test(priority = 3)
    public void directDrawPage() throws InterruptedException {
        try {
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).build().perform();
            System.out.println("Action executed successfully!");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println("Error executing action: " + e.getMessage());
        }

        try {
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.SHIFT).sendKeys("o").keyUp(Keys.SHIFT).build().perform();
            System.out.println("Action executed successfully!");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println("Error executing action: " + e.getMessage());
        }

        try {
            driver.findElement(By.xpath("//button[text()='Unlock']")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println("Error clicking Unlock button: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void gapFinding() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement annotationQCButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/annotationQc.svg']")));
            annotationQCButton.click();
            Thread.sleep(5000);
            System.out.println("The Annotation QC button clicked successfully");

            waitForApiSuccess("https://apollo2.humanbrain.in/prediction/resolve_sliver", 30);
            waitForApiSuccess("https://apollo2.humanbrain.in/prediction/remove_overlap", 30);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement num1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='171,756.53']")));
            num1.click();
            Thread.sleep(5000);
            System.out.println("The Number clicked Successfully");
        } catch (Exception e) {
            System.err.println("The Number is not clicked: " + e.getMessage());
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement newLayerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' new_Layer ']")));
            newLayerButton.click();
            Thread.sleep(5000);
            System.out.println("The NewLayer button clicked Successfully");
        } catch (Exception e) {
            System.err.println("The NewLayer button is not clicked: " + e.getMessage());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement oldLayerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' old_Layer ']")));
            oldLayerButton.click();
            Thread.sleep(5000);
            System.out.println("The Old Layer button clicked Successfully");
        } catch (Exception e) {
            System.err.println("The Old Layer button is not clicked: " + e.getMessage());
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement num2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='1,223,343.74']")));
            num2.click();
            Thread.sleep(5000);
            System.out.println("The Number clicked Successfully");
        } catch (Exception e) {
            System.err.println("The Number is not clicked: " + e.getMessage());
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement newLayerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' new_Layer ']")));
            newLayerButton.click();
            Thread.sleep(5000);
            System.out.println("The NewLayer button clicked Successfully");
        } catch (Exception e) {
            System.err.println("The NewLayer button is not clicked: " + e.getMessage());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement oldLayerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' old_Layer ']")));
            oldLayerButton.click();
            Thread.sleep(5000);
            System.out.println("The Old Layer button clicked Successfully");
        } catch (Exception e) {
            System.err.println("The Old Layer button is not clicked: " + e.getMessage());
        }
    }

    private boolean waitForApiSuccess(String apiUrl, int timeoutInSeconds) {
        // Add logic to validate API responses (e.g., using logs, network monitoring, or REST API calls)
        System.out.println("Validating API success for: " + apiUrl);
        return true;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
