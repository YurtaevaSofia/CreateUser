
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.UnsupportedEncodingException;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.testng.Assert.assertEquals;

public class TestingClass {


    @Test(dataProvider = "create", dataProviderClass = Provider.class)
    public void createUserTest(TestObject object) throws UnsupportedEncodingException {

        RestAssured.baseURI = "http://users.bugred.ru";


        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(object);

        Response response = given().
                    header("Content-Type", JSON).
                    body(json).
                    when().
                    post("/tasks/rest/createuser").
                    then().
                    statusCode(200).
                    contentType("application/json").
                    extract().
                    response();

            String responseBody = response.asString();
            System.out.printf("\nRESPONSE: " + responseBody);

            String name = decode(response.jsonPath().getString("name"));
            assertEquals(name, object.name, "Not equal name");

            String email = decode(response.jsonPath().getString("email"));
            assertEquals(email, object.email.toLowerCase(), "Not equal email");

            String hobby = decode(response.jsonPath().getString("hobby"));
            assertEquals(hobby, object.hobby, "Not equal hobby");

            String phone = decode(response.jsonPath().getString("phone"));
            assertEquals(phone, object.phone, "Not equal phone");

            // В ответе не приходит inn

//            String inn = decode(response.jsonPath().getString("inn"));
//            assertEquals(inn, object.inn, "Not equal inn");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public String decode(String input) throws UnsupportedEncodingException {

        byte[] arr = input.getBytes("UTF-8");
        String result = new String(arr, "UTF-8");
        return result;
    }

}

