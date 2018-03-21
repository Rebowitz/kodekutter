/**
 * 
 */
package com.rbais.abstractpojotester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.test.util.ReflectionTestUtils;

import com.google.gson.Gson;

/**
 * @author Robert B. Andrews
 * $Rev$
 * $Date$
 *
 */

public class AbstractPojoTester {
  
  Gson gson = new Gson();
  String json = null;
  Double dble = null;
  Long testLong = null;
  
  HashMap<String,Object> trueTypes = new HashMap<String,Object>();
    
  public void testThePOJO(Class c, Map<String,Object> fieldList){  
    trueTypes.clear();   //this will contain data from previous pojo if more than one
    Object plainPOJO = null;
    Object plainPOJODuplicate = null;  //used to test HashCode and Equals code later 
    try {  
     plainPOJO = c.newInstance();
     plainPOJODuplicate = c.newInstance();
    } catch (InstantiationException e) {  
      e.printStackTrace();  
    } catch (IllegalAccessException e) {  
      e.printStackTrace();  
    }  
       
    Method[] methods = c.getMethods();

    Set<String> keySet = fieldList.keySet();
    for(String fieldname : keySet){
      for(Method meth : methods){
        String methName =   meth.getName();
          
        //skip all setters so we dont run tests twice
        //and hashcode, equals and to string methods
        if(!methName.startsWith("get")){ continue; }
          
        if(methName.substring(3).equalsIgnoreCase(fieldname)){
          Class<?> returnType = meth.getReturnType();

        if(returnType.getTypeName().matches("java.lang.String")){  
          ReflectionTestUtils.invokeSetterMethod(plainPOJO,fieldname,fieldList.get(fieldname),String.class);
          ReflectionTestUtils.invokeSetterMethod(plainPOJODuplicate,fieldname,fieldList.get(fieldname),String.class);                    
          trueTypes.put(fieldname, fieldList.get(fieldname));
        }else if(returnType.getTypeName().matches("java.lang.Boolean")){  
          ReflectionTestUtils.invokeSetterMethod(plainPOJO,fieldname,fieldList.get(fieldname),Boolean.class);
          ReflectionTestUtils.invokeSetterMethod(plainPOJODuplicate,fieldname,fieldList.get(fieldname),Boolean.class);                    
          trueTypes.put(fieldname, fieldList.get(fieldname));
        }else if(returnType.getTypeName().matches("java.util.Date")){ //expecting java.util.date
          dble = (Double) fieldList.get(fieldname);
          testLong = dble.longValue();
          Date parsedDateTime = new Date(testLong);
          ReflectionTestUtils.invokeSetterMethod(plainPOJO,fieldname,parsedDateTime,Date.class);
          ReflectionTestUtils.invokeSetterMethod(plainPOJODuplicate,fieldname,parsedDateTime,Date.class);                    
          trueTypes.put(fieldname, parsedDateTime); 
        }else if(returnType.getTypeName().matches("java.lang.Long")){
          dble = (Double) fieldList.get(fieldname);
          testLong = dble.longValue();
          ReflectionTestUtils.invokeSetterMethod(plainPOJO,fieldname,testLong,Long.class);
          ReflectionTestUtils.invokeSetterMethod(plainPOJODuplicate,fieldname,testLong,Long.class);                    
          trueTypes.put(fieldname, testLong);  
        }else if(returnType.getTypeName().matches("java.lang.Integer")){
          dble = (Double) fieldList.get(fieldname);
          Integer intejer = dble.intValue();
          ReflectionTestUtils.invokeSetterMethod(plainPOJO,fieldname,intejer,Integer.class);
          ReflectionTestUtils.invokeSetterMethod(plainPOJODuplicate,fieldname,intejer,Integer.class);                    
          trueTypes.put(fieldname, intejer);  
        }else if(returnType.getTypeName().matches("java.util.List")){
          List<?> listString = (List<?>) fieldList.get(fieldname);
          ReflectionTestUtils.invokeSetterMethod(plainPOJO,fieldname,listString,List.class);
          ReflectionTestUtils.invokeSetterMethod(plainPOJODuplicate,fieldname,listString,List.class);                    
          trueTypes.put(fieldname, listString);               
        }else{  
          //oops!! fail assertion  
          assertTrue(false);  
        } 
      }
    }
  }
        
  //testing the getter methods  
  for(String key : trueTypes.keySet()){  
    if(key.equals("className")){continue;}  
      Object fieldObj = trueTypes.get(key);  
      if(fieldObj instanceof String){  
        assertEquals((String) fieldObj, ReflectionTestUtils.invokeGetterMethod(plainPOJO, key));  
      }else if(fieldObj instanceof Boolean){  
        assertEquals(((Boolean) fieldObj).booleanValue(),ReflectionTestUtils.invokeGetterMethod(plainPOJO,key));  
      }else if(fieldObj instanceof Date){  
        assertEquals((Date) fieldObj, ReflectionTestUtils.invokeGetterMethod(plainPOJO, key));  
      }else if(fieldObj instanceof Long){  
        assertEquals((Long) fieldObj, ReflectionTestUtils.invokeGetterMethod(plainPOJO, key));  
      }else if(fieldObj instanceof Integer){  
        assertEquals((Integer) fieldObj, ReflectionTestUtils.invokeGetterMethod(plainPOJO, key));  
      }else if(fieldObj instanceof List<?>){              
        assertEquals((List<?>) fieldObj, ReflectionTestUtils.invokeGetterMethod(plainPOJO, key));  
      }else{  
        assertTrue(false);  
      }  
    }  
        
    assertTrue(plainPOJO.equals(plainPOJODuplicate) && plainPOJODuplicate.equals(plainPOJO));
    assertTrue(plainPOJO.hashCode() == plainPOJODuplicate.hashCode());
  }
}
