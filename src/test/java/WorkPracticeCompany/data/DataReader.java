package WorkPracticeCompany.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;

public class DataReader {
	//To make it read from jason file to 
	//string we use standard encoding format 
	//utf 8 so we need to mention that in our code to make it read

	public List<HashMap<String, String>> getJsonDataToMapForConversion() throws IOException {
		String jsonContent = FileUtils.readFileToString(new 
				File(System.getProperty("user.dir")+"//src//test//java//"
						+ "WorkPracticeCompany//data//"
						+ "PurchaseOrder.json"), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = 
				mapper.readValue(jsonContent, new 
						TypeReference<List<HashMap<String, String>>>(){
	});
return data;
}
	}
