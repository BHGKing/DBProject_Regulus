package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AM_UI_DB_categoriesPage {
    public AM_UI_DB_categoriesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='#books']")
    public WebElement Booklink;
    @FindBy(xpath ="//select[@id='book_categories']" )
    public WebElement BookCategores;

}
