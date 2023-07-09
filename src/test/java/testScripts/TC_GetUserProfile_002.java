package testScripts;

import io.restassured.response.Response;
import libaray.BaseAPI;
import modules.Users;
import org.testng.annotations.Test;

public class TC_GetUserProfile_002 {


    @Test
    public void TC_GetUserProfile_002(){
        String email,password="myPassword";
        BaseAPI baseAPI = new BaseAPI();
        Users users = new Users();
        Response resp  = users.addUser();
        email =  baseAPI.getStringFromResponse(resp, "user.email");
        System.out.println("Email: " + email);
        baseAPI.assertStatusCode(resp,201);

        String token = baseAPI.getStringFromResponse(resp, "token");
        System.out.println("token: " + token);

        users.getUserProfile(token);



    }

}
