package resources;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonToString {
	
	public static List<HashMap<String, String>> getJsonData(String path) throws IOException
	{
		String readFileToString = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(readFileToString, new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;
	}

}
