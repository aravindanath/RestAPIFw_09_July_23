package modules;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import libaray.BaseAPI;

import static io.restassured.RestAssured.given;

public class Users extends BaseAPI
{


    public Response addUser(){
        RestAssured.baseURI = getValue("baseURL");
        RestAssured.basePath = endPoints.Users.addUser_endPoint.ADD_USER_END_POINT.toString();
        body = getJsonStringFromYaml("Users","json_add_user");
        body = setBodyValue(body,"email",generateEmail());

        response = given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(body)
                .post();
        response.prettyPrint();
        return response;

    }


    public Response login(String email, String password){
        RestAssured.baseURI = getValue("baseURL");
        RestAssured.basePath = endPoints.Users.logInUser_endPoint.LOG_IN_USER_END_POINT.toString();
        body = getJsonStringFromYaml("Users","json_LogIn_user");
        body = setBodyValue(body,"email",email);
        body = setBodyValue(body,"password",password);

        response = given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(body)
                .post();
        response.prettyPrint();
        return response;

    }



    public Response getUserProfile(String token){
        RestAssured.baseURI = getValue("baseURL");
        RestAssured.basePath = endPoints.Users.getUserProfile_endPoint.GET_USER_PROFILE_END_POINT.toString();
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .log()
                .all()
                .get();
        response.prettyPrint();
        return response;

    }
}
