package testcases;

import base.TestBase;
import config.Paths;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resouces.TestData;
import utility.GetTestData;
import java.util.List;

public class TestingForeignerPlayersCount extends TestBase {

    @BeforeMethod
    public void callJsonPathObject(){
        createJsonPathObject();
    }

    @Test
    public void validatesForeignPlayersCount(){

        String countryPath = Paths.playersCountryPath;
        List<String> countryList = jsonPath.get(countryPath);
        int noOfForeignPlayers = 0 ;
        for(String country : countryList){
            if(!(country.equalsIgnoreCase("India"))){
                noOfForeignPlayers++;
            }
        }
        if(noOfForeignPlayers==TestData.expectedForeignPlayers){
            System.out.println("RCB has "+TestData.expectedForeignPlayers+" foreign players hence Test passed");
        }
        else{
            System.out.println("RCB does not have "+TestData.expectedForeignPlayers+" foreign players hence Test failed");
        }

          Assert.assertEquals(noOfForeignPlayers,TestData.expectedForeignPlayers);


    }
}
