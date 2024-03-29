package com.codescreen;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.with;

/**
 * Add your test cases here to test that the Employee API endpoints are all working properly.
 *
 * We provide one test case below to show you how to authenticate with the API and use the Rest Asssured library.
 */

@Order(1) //Do not edit the value of this Order annotation.
public class EmployeeAPITest {

  private static final String API_KEY = "41ce3d6c-1a01-4ba8-8edc-0224229e5136";

  @BeforeAll
  static void setup() {
    RestAssured.baseURI = "https://assessments.codescreen.com/api/employees";
  }

  @Test
  public void testCreate() {
    String email = "jon.smith" + UUID.randomUUID() + "@example.com";
    with().body(new Employee(email, "Jon Smith", "Software Developer"))
            .header("X-API-KEY", API_KEY)
            .when()
            .request("POST")
            .then()
            .statusCode(201);
  }

  private static class Employee {
    private String email;
    private String name;
    private String title;

    public Employee(String email, String name, String title) {
      this.email = email;
      this.name = name;
      this.title = title;
    }

    public String getEmail() {
      return email;
    }

    public String getName() {
      return name;
    }

    public String getTitle() {
      return title;
    }

  }

}
