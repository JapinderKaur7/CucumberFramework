package dataProvider;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;



public class jsonDataReader {
	
	
	public jsonDataReader() {
	
	}
	public static JSONObject getJsonData() throws IOException, ParseException
	{
		File filename= new File("src\\test\\resources\\testDataResources\\Customer.json");
		String json= FileUtils.readFileToString(filename,"UTF-8");
		Object obj= new JSONParser().parse(json);
		JSONObject jsonObject= (JSONObject) obj;
		return jsonObject;
	}
	public static String getTestData(String input)
	{
		String testData;
		return input;
		
	}
}
