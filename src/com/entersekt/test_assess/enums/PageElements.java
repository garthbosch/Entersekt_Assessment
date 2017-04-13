package com.entersekt.test_assess.enums;

import java.io.Serializable;

/**
 * @author Garth Bosch
 * @date 11 April 2017
 */
public enum PageElements implements Serializable {
    /**
     * *** For all pages ****
     */
    NewItemTextBox("//div[@class='item-new']/input[@class='input']", "New Item Text Box"),
    ToUpdateItemLink("//div[@class='item']/a[@class='update-link']", "To Update Item Link"),
    UpdateItemTextBox("//form[@class='update-form']/input[@class='update-input']", "Update Item Text Box"),
    DeleteItemButton("//div[@class='item']/a[@class='del-btn']", "Delete Item Button");

    private final String elementId;

    private final String elementNameOnPage;

    PageElements(String elementId, String elementNameOnPage) {
        this.elementId = elementId;
        this.elementNameOnPage = elementNameOnPage;
    }

    public String getElementId() {
        return elementId;
    }

    public String getElementNameOnPage() {
        return elementNameOnPage;
    }
}