package ApplicatoinPages;

import BasePage.basepage;
import ExcelHelper.excelHelper;
import WebPageHelper.webPageHelper;
import org.openqa.selenium.By;

import static BasePage.basepage.driver;

public class Testpage {
    basepage wc = new basepage();
    webPageHelper wph = new webPageHelper();
    excelHelper eh = new excelHelper();

    public void goToURL() throws Exception {
        String URL = eh.getSpecificColumnData("./src/test/testdata/Data.xlsx", "sheet1", "URL");
        driver.get(URL);
        wph.waitTillClickableClick(By.xpath("//h5[contains(text(),'Elements')]"));
    }
}
