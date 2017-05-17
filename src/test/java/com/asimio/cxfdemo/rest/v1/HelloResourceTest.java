package com.asimio.cxfdemo.rest.v1;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.asimio.cxfdemo.main.DemoCxfApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DemoCxfApplication.class })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloResourceTest {

	private static final String API_PATH = "/api";
	private static final String MSG_TEMPLATE = "Hello %s. Version %s - passed in %s";

	@LocalServerPort
	private int port;

	@Before
	public void setup() {
		RestAssured.port = this.port;
	}

	@Test
	public void shouldRetrieveNameVersion1InURL() {
		String name = "world";
		RestAssured.
			given().
				accept(ContentType.JSON).
			when().
				get(String.format("%s/v1/hello/{name}", API_PATH), name).
			then().
				statusCode(HttpStatus.SC_OK).
				contentType(ContentType.JSON).
				body("msg", Matchers.equalTo(String.format(MSG_TEMPLATE, name, 1, "URL")));
	}

	@Test
	public void shouldRetrieveNameVersion1InAcceptHeader() {
		String name = "world";
		RestAssured.
			given().
				accept("application/vnd.asimio-v1+json").
			when().
				get(String.format("%s/hello/{name}", API_PATH), name).
			then().
				statusCode(HttpStatus.SC_OK).
				contentType("application/vnd.asimio-v1+json").
				body("msg", Matchers.equalTo(String.format(MSG_TEMPLATE, name, 1, "Accept Header")));
	}

	@Test
	public void retrieveShouldResultIn404Version1InURL() {
		String name = "404";
		RestAssured.
			when().
				get(String.format("%s/v1/hello/{name}", API_PATH), name).
			then().
				statusCode(HttpStatus.SC_NOT_FOUND);
	}

	@Test
	public void retrieveShouldResultIn404Version1InAcceptHeader() {
		String name = "404";
		RestAssured.
			given().
				accept("application/vnd.asimio-v1+json").
			when().
				get(String.format("%s/hello/{name}", API_PATH), name).
			then().
				statusCode(HttpStatus.SC_NOT_FOUND);
	}
}