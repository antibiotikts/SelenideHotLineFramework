package api.reqres;

import api.Specifications;
import api.reqres.pojo.Register;
import api.reqres.pojo.SuccessReg;
import api.reqres.pojo.UserData;
import api.swagger.pojo.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Tests {
    @Test
    public void checkAvAndIdTests() {
        Specifications specifications = new Specifications();
        specifications.installSpecification(specifications.requestSpecification("https://reqres.in/"),
                specifications.responseSpecification200());

        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all().extract().body().jsonPath().getList("data", UserData.class);

    }

    @Test
    public void successRegTest() {
        Specifications specifications = new Specifications();
        specifications.installSpecification(specifications.requestSpecification("https://reqres.in/"),
                specifications.responseSpecification(200));

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");

        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all().extract().as(SuccessReg.class);
        Assertions.assertNotNull(successReg.getId());
        Assertions.assertNotNull(successReg.getToken());
        Assertions.assertEquals(id, successReg.getId());
        Assertions.assertEquals(token, successReg.getToken());
    }


}
