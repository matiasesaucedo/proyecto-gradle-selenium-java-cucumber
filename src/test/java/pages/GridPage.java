package pages;

public class GridPage extends BasePage {
    private String cell = "/";
    private String mainTable = "//*[@id=\"mytable\"]";

    public GridPage(){
        super(driver);
    }
    public void navigateToGrid(){
        navigateTo("https://testpages.eviltester.com/styled/tag/table.html");
    }
    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }
    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }
}
