package testScripts;

import io.restassured.response.Response;
import libaray.BaseAPI;
import modules.Users;
import org.testng.annotations.Test;

public class TC_AddUsed_001 {


    @Test
    public void TC_AddUsed_001(){
        BaseAPI baseAPI = new BaseAPI();
        Users users = new Users();
        Response resp  = users.addUser();
        baseAPI.assertStatusCode(resp,201);

    }

}
