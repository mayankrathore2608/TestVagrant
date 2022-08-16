package testcases;

import base.TestBase;
import config.Paths;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resouces.TestData;
import utility.GetTestData;
import java.util.List;

public class TestingAtleastOneWicketKeeper extends TestBase {

    @BeforeMethod
    public void callJsonPathObject() {
        createJsonPathObject();
    }

    @Test
    public void validatesAtleastOneWicketkeeper() {
        String rolePath = Paths.playersRolePath;
        List<String> rolesList = jsonPath.get(rolePath);
        int noOfWK = 0;
        for (String role : rolesList) {
            if (role.equalsIgnoreCase("Wicket-keeper")) {
                noOfWK++;
                break;
            }
        }
        if (noOfWK >= TestData.expectedNoOfWicketkeeper) {
            System.out.println("RCB has atleast "+ TestData.expectedNoOfWicketkeeper+" wicket keeper , hence Test Passed");
        } else {
            System.out.println("RCB does not have atleast "+ TestData.expectedNoOfWicketkeeper +" wicket keeper , hence Test Failed");
        }

    }


}