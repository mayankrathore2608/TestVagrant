package base;

import io.restassured.path.json.JsonPath;
import resouces.TestData;
import utility.GetTestData;

public class TestBase {

    public static JsonPath jsonPath = null;

    public static void createJsonPathObject() {
        try {
            if (jsonPath == null) {
                jsonPath = new JsonPath(GetTestData.getJsonString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}