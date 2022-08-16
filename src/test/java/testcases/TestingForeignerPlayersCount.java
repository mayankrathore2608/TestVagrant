package testcases;

import base.TestBase;
import com.jayway.jsonpath.JsonPath;
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

        String path = "$.player.country";
        List<String> countryList = jsonPath.get(path);
        int noOfForeignPlayers = 0 ;

        for(String country : countryList){
            if(!country.equalsIgnoreCase("India"))
                noOfForeignPlayers++;
        }

        Assert.assertEquals(noOfForeignPlayers,4);

    }
}
