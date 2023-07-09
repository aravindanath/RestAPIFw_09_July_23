package libaray;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class BaseAPI {

    public Response response;
    public String body;
    public static Configuration configuration;


    public BaseAPI() {
        configuration = Configuration.builder()
                .jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider()).build();
    }


    public String getStringFromResponse(Response response, String key) {
        JsonPath jp = new JsonPath(response.asString());
        return  jp.getString(key);
    }

    public Object getStringFromResponse(Response response, String key, int index) {
        JsonPath jp = new JsonPath(response.asString());
        return jp.getList(key).get(index);
    }


    public String getJsonStringFromYaml(String filename,String key){
        Map<String, Object> jsonMap = null;

        try{

            String filePath = System.getProperty("user.dir")+
                    File.separator+"payLoad"+File.separator+filename+".yaml";
            Reader reader = new FileReader(filePath);
            Yaml yaml = new Yaml();
            jsonMap = yaml.load(reader);
        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonMap.get(key).toString();
    }


    public String setBodyValue(String setBody, String key, String value){
        DocumentContext documentContext = com.jayway.jsonpath.JsonPath.using(configuration).parse(setBody);
        body =  documentContext.set(key, value).jsonString();
       return body;
    }

    public String getValue(String key){
        String filepath = System.getProperty("user.dir")+File.separator+"config.properties";
        String value = null;
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(filepath);
             prop.load(fis);
            value = prop.getProperty(key);
        }catch (Exception e){
            e.printStackTrace();
        }
     return value;
    }

    public String generateEmail(){
        Faker faker = new Faker();
       return faker.name().firstName().concat("@testmail.com");
    }

    public void assertStatusCode(Response response,int expectedStatusCode){
         int statusCode = response.getStatusCode();
         Assert.assertEquals(statusCode,expectedStatusCode,"Test FAILED");
    }
}