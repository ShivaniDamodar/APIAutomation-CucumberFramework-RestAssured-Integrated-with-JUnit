package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.ContentType;



public class CommonUtilities {
	public RequestSpecification reqspec;
	public ResponseSpecification respspec;

	public String getPropertyValue(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\shivani.damodar\\personal-workspace\\APIFrameworkCucumber\\src\\test\\java\\utilities\\config.properties");

		prop.load(fis);

		return prop.getProperty(key);

	}

	public RequestSpecification RequestSpecification() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.text"));
		reqspec = new RequestSpecBuilder().setBaseUri(getPropertyValue("baseURI")).setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build(); 
		return reqspec;
	}

	public ResponseSpecification ResponseSpecification() {
		respspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		return respspec;
	}

	/*
	 * public static void main(String [] args) throws IOException { CommonUtilities
	 * cu = new CommonUtilities();
	 * System.out.println(cu.getPropertyValue("baseURI")); }
	 */

}
