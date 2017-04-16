package ru.stqa.rest.appmanager;

import com.jayway.restassured.RestAssured;

/**
 * Created by User on 26.02.2017.
 */
public class ApplicationManager {

    private RestHelper restHelper;

    public RestHelper rest() {
        if (restHelper == null) {
            restHelper = new RestHelper();
        }
        return restHelper;

    }

}
