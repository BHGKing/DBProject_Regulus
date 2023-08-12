package com.library.steps;

import com.library.pages.AM_UI_DB_categoriesPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AM_UI_DB_categoriesStepDefs {
    LoginPage loginPage=new LoginPage();
    AM_UI_DB_categoriesPage amUiDbCategoriesPage=new AM_UI_DB_categoriesPage();
    @Given("the {string} on the home page")
    public void the_on_the_home_page(String string) {
        loginPage.login(string);

    }
    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String string) {
    amUiDbCategoriesPage.Booklink.click();

    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        amUiDbCategoriesPage.BookCategores.click();

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        Select select=new Select(amUiDbCategoriesPage.BookCategores);
        List<String> actualcategories=new ArrayList<>();
        for (WebElement option : select.getOptions()) {
            actualcategories.add(option.getText());
        }
        actualcategories.remove(0);
        DB_Util.createConnection();
        DB_Util.runQuery("Select * from book_categories");
        List<String> expectedcategories=DB_Util.getColumnDataAsList(3);
        Assert.assertEquals(actualcategories,expectedcategories);
        System.out.println(expectedcategories);
        System.out.println(actualcategories);


        DB_Util.destroy();


    }

}
