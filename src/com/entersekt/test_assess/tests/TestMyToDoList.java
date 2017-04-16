package com.entersekt.test_assess.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cisco.hcs.rtp.test.auto.utils.logging.Logging;
import com.entersekt.test_assess.enums.PageElements;
import com.entersekt.test_assess.utils.AbstractBaseClass;
import com.entersekt.test_assess.utils.SeleniumWebDriverUtils;

/**
 * @author Garth Bosch
 * @date 11 April 2017
 */
public class TestMyToDoList extends AbstractBaseClass {

    public static Logger log = Logging.getLogger(true); // set the logger

    @Parameters({ "url",
            "filename",
            "selectedBrowserType",
            "waitTimeout",
            "addTodoItem",
            "updatedTodoItem",
            "xssVulnerabilityItem" })
    @Test(groups = { "init" })
    public void init(String url, String filename, String selectedBrowserType, int waitTimeout, String addTodoItem, String updatedTodoItem, String xssVulnerabilityItem)
            throws Exception {
        this.url = url;
        this.filename = filename;
        this.selectedBrowserType = selectedBrowserType;
        this.waitTimeout = waitTimeout;
        this.addTodoItem = addTodoItem;
        this.updatedTodoItem = updatedTodoItem;
        this.xssVulnerabilityItem = xssVulnerabilityItem;
        seleniumDriver = new SeleniumWebDriverUtils(selectedBrowserType,
                url,
                waitTimeout);
        seleniumDriver.startDriver();
        seleniumDriver.refreshPage();
        addNewItemTest();
        updateItemTest();
        deleteItemTest();
        xssVulnerabilityItemTest();
        clearDown();
    }

    public void addNewItemTest() throws Exception {
        try {
            seleniumDriver.typeByXpath(PageElements.NewItemTextBox, addTodoItem);
            seleniumDriver.enterByXpathActionBuilder(PageElements.NewItemTextBox);
            String getItemAdded = seleniumDriver.getElementTextByXpath(PageElements.ToUpdateItemLink);
            if (!getItemAdded.equals(addTodoItem)) {
                log.error("Item " + addTodoItem + " not successfully added and/or verified!");
                captureScreenshot(false, selectedBrowserType, filename);
                clearDown();
                Assert.fail();
            } else {
                log.info("Item " + addTodoItem + " successfully added and verified!");
                captureScreenshot(true, selectedBrowserType, filename);
            }
        } catch (Exception ex) {
            log.error("The test has failed with error message - " + ex.getMessage());
            clearDown();
            Assert.fail();
        }
    }

    public void updateItemTest() throws Exception {
        try {
            seleniumDriver.clickByXpath(PageElements.ToUpdateItemLink);
            seleniumDriver.typeByXpath(PageElements.UpdateItemTextBox, updatedTodoItem);
            seleniumDriver.enterByXpathActionBuilder(PageElements.UpdateItemTextBox);
            String getItemAdded = seleniumDriver.getElementTextByXpath(PageElements.ToUpdateItemLink);
            if (!getItemAdded.equals(updatedTodoItem)) {
                log.error("Item " + updatedTodoItem + " not successfully added and/or verified!");
                captureScreenshot(false, selectedBrowserType, filename);
                clearDown();
                Assert.fail();
            } else {
                log.info("Item " + updatedTodoItem + " successfully added and verified!");
                captureScreenshot(true, selectedBrowserType, filename);
            }
        } catch (Exception ex) {
            log.error("The test has failed with error message - " + ex.getMessage());
            clearDown();
            Assert.fail();
        }
    }

    public void deleteItemTest() throws Exception {
        try {
            seleniumDriver.clickByXpath(PageElements.DeleteItemButton);
            if (seleniumDriver.getPageSource().contains(updatedTodoItem)) {
                log.error("Item " + updatedTodoItem + " was not successfully deleted!");
                captureScreenshot(false, selectedBrowserType, filename);
                clearDown();
                Assert.fail();
            } else {
                log.info("Item " + updatedTodoItem + " was successfully deleted!");
                captureScreenshot(true, selectedBrowserType, filename);
            }
        } catch (Exception ex) {
            log.error("The test has failed with error message - " + ex.getMessage());
            clearDown();
            Assert.fail();
        }
    }

    public void xssVulnerabilityItemTest() throws Exception {
        try {
            seleniumDriver.typeByXpath(PageElements.NewItemTextBox, xssVulnerabilityItem);
            seleniumDriver.enterByXpathActionBuilder(PageElements.NewItemTextBox);
            String getItemAdded = seleniumDriver.getElementTextByXpath(PageElements.ToUpdateItemLink);
            if (!getItemAdded.equals(xssVulnerabilityItem)) {
                log.error("Item " + xssVulnerabilityItem + " not successfully added and/or verified!");
                captureScreenshot(false, selectedBrowserType, filename);
                clearDown();
                Assert.fail();
            } else {
                log.info("Item " + xssVulnerabilityItem + " successfully added and verified!");
                captureScreenshot(true, selectedBrowserType, filename);
            }
        } catch (Exception ex) {
            log.error("The test has failed with error message - " + ex.getMessage());
            clearDown();
            Assert.fail();
        }
    }

    public void clearDown() {
        seleniumDriver.shutDown();
    }
}