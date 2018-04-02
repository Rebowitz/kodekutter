package com.rbais.jsongenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.rbais.jsongenerator.object.PojoTestDto;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JSonGeneratorApplicationTests {

	@Test
	public void generateTheJson(){

		//throw away code here
		/*
		 * Instantiate the object
		 * load it up with the data you want
		 * give a json file name
		 * run the test
		 * it will write it out in the 
		 * configured location	 * 
		 * 
		 */
		
		PojoTestDto ptd = new PojoTestDto();
		ptd.setPojoBooleanValue(true);
		ptd.setPojoIntegverValue(new Integer(1));
		ptd.setPojoLongValue(new Long(1));
		ptd.setPojoStringType("testString");
		
		Date date = new Date();
        ptd.setPojoDateTimeValue(date);
		
		Collection<String> testCollection = new ArrayList<String>();
		testCollection.add("String1");
		testCollection.add("String2");
		testCollection.add("String3");
	    ptd.setPojoCollection(testCollection);
	    
	    Set<String> testSet = new HashSet<String>();
	    testSet.add("String1");
	    testSet.add("String2");
	    testSet.add("String3");
	    
	    ptd.setPojoSet(testSet);
	    
 		
		   ObjectMapper objectMapper = new ObjectMapper();
		   
		        try {
		            objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ptd);
		            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		            objectMapper.writeValue(new File("F:\\rbais\\temp\\pojo_test_config.json"), ptd);
		 
		        } catch (JsonGenerationException e) {
		            e.printStackTrace();
		        } catch (JsonMappingException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		
	}
}
