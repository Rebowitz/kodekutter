package com.rbais.abstractpojotester;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractPojoTesterApplicationTests {
	
	AbstractPojoTester apt = new AbstractPojoTester();

  @Test
  public void contextLoads() {
  }
  
    
    @Test
    public void TestPojos() throws  IOException, ClassNotFoundException {
      
    Resource resource = new ClassPathResource("pojo_test_config.json");  
    InputStream inputStream = resource.getInputStream();
    StringWriter writer = new StringWriter();
    IOUtils.copy(inputStream, writer, "UTF-8");
    String theString = writer.toString();

    Gson gson = new Gson();
    Type pojoType = new TypeToken<List<HashMap<String, Object>>>() {
    }.getType();

    List<HashMap<String, Object>> listOfDtos = gson.fromJson(theString, pojoType);

    Iterator<HashMap<String, Object>> iter = listOfDtos.iterator();

    while (iter.hasNext()) {
      HashMap<String, Object> pojoMap = (HashMap<String, Object>) iter.next();
      
      String clazz = (String) pojoMap.get("classname");
      System.out.println(clazz);

      Class<?> classname = Class.forName((String) pojoMap.get("classname"));

      apt.testThePOJO(classname, pojoMap);

    }

  }
}
