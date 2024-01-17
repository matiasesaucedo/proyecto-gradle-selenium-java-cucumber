package steps;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.GridPage;

public class GridTestSteps {
    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage(){
//        Thread.sleep(1000); "Agregar al public void... throws InterruptedException"
        grid.navigateToGrid();
    }
    @Then("^I can return to value i wanted$")
    public void returnValue(){
        String value = grid.getValueFromGrid(4, 2);
        System.out.println(value);
        Assert.assertEquals("33.3",value);
    }

    @Then("^I can validate the table is displayed$")
    public void tableIsDisplayed(){
        Assert.assertTrue("El elemento esta siendo mostrado", grid.cellStatus());
//        Assert.assertFalse("El elemento no esta siendo mostrado", grid.cellStatus());
    }



}
