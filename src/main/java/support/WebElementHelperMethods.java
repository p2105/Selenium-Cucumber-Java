package support;

import managers.FileReaderManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * The type Web element helper methods.
 */
public class WebElementHelperMethods {

    /**
     * The Driver.
     */
    protected WebDriver driver;

    /**
     * Instantiates a new Web element helper methods.
     *
     * @param driver the driver
     */
    public WebElementHelperMethods(final WebDriver driver) {
        this.driver = driver;
    }

    private static final int ELEMENT_WAIT_TIMEOUT_IN_SECONDS = FileReaderManager.getConfigReader().getMaxWaitInSeconds();
    private static final int PAGE_WAIT_TIMEOUT_IN_SECONDS = 60;

    // Click element

    /**
     * Click element.
     *
     * @param by the by
     */
    protected void clickElement(final By by){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(by);
        driver.findElement(by).click();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Click element.
     *
     * @param element the element
     */
    protected void clickElement(final WebElement element){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(element);
        element.click();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Set text.
     *
     * @param by  the by
     * @param txt the txt
     */
// Set Text
    protected void setText(final By by, final String txt){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(by);
        driver.findElement(by).sendKeys(txt);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Set text.
     *
     * @param element the element
     * @param txt     the txt
     */
    protected void setText(final WebElement element, final String txt){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(element);
        element.sendKeys(txt);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Is Element Present

    /**
     * Is element present boolean.
     *
     * @param element - {@link WebElement}.
     * @return true if element present; else false.
     */
    protected boolean isElementPresent(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        try {
            element.getTagName();
        } catch (final NoSuchElementException ignored) {
            Log.debug("Exiting function with NoSuchElementException returning false - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
            return false;
        } catch (final StaleElementReferenceException ignored) {
            Log.debug("Exiting function with StaleElementReferenceException returning false - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
            return false;
        }
        return true;
    }

    /**
     * Is element present boolean.
     *
     * @param by - {@link WebElement} as {@link By} object.
     * @return true if element present; else false.
     */
    protected boolean isElementPresent(final By by){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return this.driver.findElements(by).size() > 0;
    }

    // Is Element Visible

    /**
     * Is element visible boolean.
     *
     * @param element - {@link WebElement}.
     * @return true if element visible; else false.
     */
    protected boolean isElementVisible(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return element.isDisplayed();
    }

    /**
     * Is element visible boolean.
     *
     * @param by - {@link WebElement} as {@link By} object.
     * @return true if element visible; else false.
     */
    protected boolean isElementVisible(final By by) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return this.driver.findElement(by).isDisplayed();
    }

    // Is Any Text Present

    /**
     * Is any text present boolean.
     *
     * @param element - {@link WebElement}.
     * @return true if any text present; else false.
     */
    protected boolean isAnyTextPresent(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final String text = element.getText();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return StringUtils.isNotBlank(text);
    }

    /**
     * Is any text present boolean.
     *
     * @param by - {@link WebElement} as {@link By} object.
     * @return true if any text present; else false.
     */
    protected boolean isAnyTextPresent(final By by) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return isAnyTextPresent(this.driver.findElement(by));
    }

    // Wait For Element

    /**
     * Wait for {@link WebElement} is present. maxWait (in seconds)
     * property defined in src/configs/Configuration.properties.
     *
     * @param element - {@link WebElement}.
     */
    protected void waitForElement(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        this.waitForElement(element, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Wait for {@link WebElement} is present.
     *
     * @param element          - {@link WebElement}.
     * @param timeoutInSeconds - How long the {@link WebDriver} wait for element.
     */
    protected void waitForElement(final WebElement element, final int timeoutInSeconds) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Wait for {@link WebElement} is present. maxWait (in seconds)
     * property defined in src/configs/Configuration.properties.
     *
     * @param by - {@link WebElement} as {@link By} object.
     */
    protected void waitForElement(final By by) {
//        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(by, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
//        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Wait for {@link WebElement} is present.
     *
     * @param by               - {@link WebElement} as By object.
     * @param timeoutInSeconds - How long the {@link WebDriver} wait for element.
     */
    protected void waitForElement(final By by, final int timeoutInSeconds) {
//        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Wait For Element Is Invisible

    /**
     * Wait for {@link WebElement} is invisible. maxWait (in seconds)
     * property defined in src/configs/Configuration.properties.
     *
     * @param by - {@link WebElement} as {@link By} object.
     */
    protected void waitForElementIsInvisible(final By by) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final WebDriverWait wait = new WebDriverWait(this.driver, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Wait For Page Load

    /**
     * Wait for page load. 60 seconds, value defined in this class.
     */
    public void waitForPageLoad() {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForPageLoad(PAGE_WAIT_TIMEOUT_IN_SECONDS);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Wait for page load.
     *
     * @param timeoutInSeconds - How long the {@link WebDriver} wait for page load.
     */
    public void waitForPageLoad(final int timeoutInSeconds) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(By.tagName("html"), timeoutInSeconds);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Mouseover

    /**
     * Hover over {@link WebElement}.
     *
     * @param element - {@link WebElement}.
     */
    protected void mouseover(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final Actions builder = new Actions(this.driver);
        builder.moveToElement(element).build().perform();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Hover over {@link WebElement}.
     *
     * @param by - {@link WebElement} as {@link By} object.
     */
    protected void mouseover(final By by) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        mouseover(this.driver.findElement(by));
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Drag And Drop

    /**
     * Drag and drop from a specified {WebElement} to coordinates.
     *
     * @param element - {WebElement}.
     * @param xOffset - How many pixel move element left or right. A negative value is left.
     * @param yOffset - How many pixel move element up or down. A negative value is up.
     */
    protected void dragAndDrop(final WebElement element, final int xOffset, final int yOffset) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final Actions builder = new Actions(this.driver);
        final Action dragAndDrop = builder.clickAndHold(element).moveByOffset(xOffset, yOffset).release().build();
        dragAndDrop.perform();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Drag and drop from a specified {@link WebElement} to coordinates.
     *
     * @param by      - {@link WebElement} as {@link By} object.
     * @param xOffset - How many pixel move element left or right. A negative value is left.
     * @param yOffset - How many pixel move element up or down. A negative value is up.
     */
    protected void dragAndDrop(final By by, final int xOffset, final int yOffset) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        dragAndDrop(this.driver.findElement(by), xOffset, yOffset);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Switch Window

    /**
     * Switch to a open window.
     *
     * @param url - A part of the URL from the window you want switch.
     */
    public void switchWindow(final String url) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        sleep(2000);
        String currentHandle = null;
        final Set<String> handles = this.driver.getWindowHandles();
        if (handles.size() > 1) {
            currentHandle = this.driver.getWindowHandle();
        }
        if (currentHandle != null) {
            for (final String handle : handles) {
                this.driver.switchTo().window(handle);
                if (this.driver.getCurrentUrl().contains(url) && currentHandle.equals(handle) == false) {
                    break;
                }
            }
        } else {
            for (final String handle : handles) {
                this.driver.switchTo().window(handle);
                if (this.driver.getCurrentUrl().contains(url)) {
                    break;
                }
            }
        }
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Is Readonly

    /**
     * Is readonly boolean.
     *
     * @param element - {@link WebElement}.
     * @return If element read only true; else false.
     */
    protected boolean isReadonly(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return Boolean.valueOf(element.getAttribute("readonly")).booleanValue();
    }

    /**
     * Is readonly boolean.
     *
     * @param by - {@link WebElement} as {@link By}.
     * @return If element read only true; else false.
     */
    protected boolean isReadonly(final By by) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return isReadonly(this.driver.findElement(by));
    }

    // Get Element Position

    /**
     * Gets element position.
     *
     * @param element - {@link WebElement}.
     * @return Get position of element as {@link Point} object.
     */
    protected Point getElementPosition(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return element.getLocation();
    }

    /**
     * Gets element position x.
     *
     * @param element - {@link WebElement}.
     * @return Get distance to left of element.
     */
    protected int getElementPositionX(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final Point pos = getElementPosition(element);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return pos.getX();
    }

    /**
     * Gets element position y.
     *
     * @param element - {@link WebElement}.
     * @return Get distance to top of element.
     */
    protected int getElementPositionY(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final Point pos = getElementPosition(element);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return pos.getY();
    }

    // Backspace Input Clear

    /**
     * Clear input with backspace key.
     *
     * @param element - {@link WebElement}.
     */
    protected void backspaceInputClear(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final int numberOfCharacters = element.getAttribute("value").length();
        for (int i = 0; i <= numberOfCharacters; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Clear input with backspace key.
     *
     * @param element            - {@link WebElement}.
     * @param numberOfCharacters - How many characters will delete.
     */
    protected void backspaceInputClear(final WebElement element, final int numberOfCharacters) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        for (int i = 0; i <= numberOfCharacters; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Scroll

    /**
     * Scroll in current window.
     *
     * @param x - How many pixel scroll left or right. A negative value is left.
     * @param y - How many pixel scroll up or down. A negative value is up.
     */
    public void scroll(final int x, final int y) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final JavascriptExecutor js = (JavascriptExecutor) this.driver;
        for (int i = 0; i <= x; i = i + 50) {
            js.executeScript("scroll(" + i + ",0)");
        }
        for (int j = 0; j <= y; j = j + 50) {
            js.executeScript("scroll(0," + j + ")");
        }
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Highlight WebElement

    /**
     * Highlight a {@link WebElement}.
     *
     * @param element - {@link WebElement}.
     * @return {JavascriptExecuter} object.
     */
    protected JavascriptExecutor highlightElementPermanently(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return js;
    }

    /**
     * Highlight a {@link WebElement} for 3 seconds.
     *
     * @param element - {@link WebElement}.
     */
    protected void highlightElement(final WebElement element) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final String originalStyle = element.getAttribute("style");
        final JavascriptExecutor js = highlightElementPermanently(element);
        sleep(3000);
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Zoom

    /**
     * Zoom current window +1.
     */
    public void zoomPlus() {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Actions actions = new Actions(this.driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).perform();
        actions = new Actions(this.driver);
        actions.keyUp(Keys.CONTROL).perform();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Zoom current window -1.
     */
    public void zoomMinus() {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Actions actions = new Actions(this.driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).perform();
        actions = new Actions(this.driver);
        actions.keyUp(Keys.CONTROL).perform();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Take A Screenshot

    /**
     * Take a screenshot.
     *
     * @param path - Directory and name of screenshot.
     */
    public void takeScreenshot(final String path) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    // Alert

    /**
     * Is alert present boolean.
     *
     * @return true if alert present; else false.
     */
    public boolean isAlertPresent() {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        try {
            final Alert alert = this.driver.switchTo().alert();
            Log.debug("Alert Text : " + alert.getText());
        } catch (final NoAlertPresentException nape) {
            Log.debug("Exiting function by returning false - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
            return false;
        }
        Log.debug("Exiting function by returning true - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return true;
    }

    /**
     * Gets alert text.
     *
     * @return Get text from alert.
     */
    public String getAlertText() {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final Alert alert = this.driver.switchTo().alert();
        String alertText = alert.getText();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName()
                + " returning " + alertText);
        return alertText;
    }

    /**
     * Accept alert.
     */
    public void acceptAlert() {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final Alert alert = this.driver.switchTo().alert();
        alert.accept();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Cancel alert.
     */
    public void dismissAlert() {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        final Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    private void sleep(final int millis) {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            // Nothing happens.
        }
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

}