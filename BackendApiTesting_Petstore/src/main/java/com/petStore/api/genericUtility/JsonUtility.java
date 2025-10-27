package com.petStore.api.genericUtility;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JsonUtility {

	/**
	 * Get the json data based on json complex path
	 * @param resp
	 * @param jsonXpath
	 */
	public Object getDataOnJsonPath(Response resp,String jsonXpath) {
		List<Object> list = JsonPath.read(resp.asString(), jsonXpath);
		return (String) list.get(0).toString();
	}
	
	/**
	 * Get the xml data based on xml complex path
	 * @param resp
	 * @param xmlXpath
	 * @return
	 */
	public String getDataOnXmlPath(Response resp,String xmlXpath) {
		return resp.xmlPath().get(xmlXpath);
	}
	
	
	/**
	 *verifies the data in response
	 * @param resp
	 * @param jsonXpath
	 * @param expectedData
	 * @return
	 */
	public boolean verifyDataOnJsonPath(Response resp,String jsonXpath,String expectedData) {
		List<String> list = JsonPath.read(resp.asString(), jsonXpath);
		boolean flag = false;
		for(String str:list) {
			if(str.equals(expectedData)) {
				System.out.println(expectedData + " is present");
				flag = true;
			}
			if(flag==false) {
				System.out.println(expectedData + " is not present");
			}
		}
		return flag;
	}
}
