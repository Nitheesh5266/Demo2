package DemoMaven.DemoMaven;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookDetails {

    @Test(enabled = false)
    public void iterateHeaders() {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        Headers allHeaders = response.headers();

        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() +
                               " Value: " + header.getValue());
        }
    }

    @Test(enabled = true)
    public void getBooksDetails() {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET);

        int code = response.getStatusCode();
        System.out.println("Response code: " + code);
        System.out.println("Response Status: " + response.getStatusLine());

        // ✅ TestNG Assertion
        Assert.assertEquals(code, 200);
        System.out.println("Status code is matching");
    }
}