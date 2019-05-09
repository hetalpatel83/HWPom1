package NewNopCommercePom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPage extends Utils
{
        @Test
        public void priceCurrency(){
            //code to perform hovering task on Apparels
            mouseOverHover(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));

            //Click on Clothing
            clickElementBy(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[2]/a"));

            //Click on Currency
            clickElementBy(By.xpath("//*[@id=\"customerCurrency\"]"));

            //Click on Euro
            selectByText(By.xpath("//*[@id=\"customerCurrency\"]"), "Euro");

            //Click on Sort Currency
            clickElementBy(By.xpath("//*[@id=\"customerCurrency\"]"));

            //Click on USD
            selectByText(By.xpath("//*[@id=\"customerCurrency\"]"), "US Dollar");

            //Check for $ value
            //Get Text of $ value
            boolean present = false;
            List<WebElement> activeList = driver.findElements(By.className("actual-price"));
            //List<WebElement> activeList = driver.findElements(By.cssSelector("span.actual-price"));
            for(WebElement element : activeList){
                String str = element.getText();

                for ( int i =0; i<str.length(); i++) {
                    char ch = str.charAt(i);
                    if (ch == '$') {
                        present = true;
                        //index = i;
                    }
                }
                if ( present == true){
                    System.out.println("$" + " is present in the array list");
                    // break;
                }else{
                    System.out.println("The $ is not present at the array list");
                }
            }

        }

        @Test
        public void priceHighToLow(){
            //code to perform hovering task
            mouseOverHover(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));

            //Click on Cell Phones
            clickElementBy(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[2]/a"));

            //Click on Sort Order
            clickElementBy(By.xpath("//*[@id=\"products-orderby\"]"));

            //Click High to Low
            selectByText(By.xpath("//*[@id=\"products-orderby\"]"), "Price: High to Low");

            //Get Text of $ value
            ArrayList<Float> priceList = new ArrayList<Float> ();
            ArrayList<Float> sortList = new ArrayList<Float>();

            List<WebElement> activeList = driver.findElements(By.className("actual-price"));
            //List<WebElement> activeList = driver.findElements(By.cssSelector("span.actual-price"));
            for(WebElement element : activeList){
                String str = element.getText();
                str = str.replaceAll("[^\\d.]", "");
                priceList.add(Float.valueOf(str));
                sortList.add(Float.valueOf(str));
            }
            System.out.println(priceList);
            // Sorting in decreasing (descending) order*/
            Collections.sort(sortList, Collections.reverseOrder());

            //Arrays.sort(priceList);
            System.out.println(sortList);
            System.out.println(priceList.equals(sortList));
        }
}

