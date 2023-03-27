package api.swagger.pojo;

import api.Specifications;
import api.swagger.pojo.pet.Category;
import api.swagger.pojo.pet.Pet;
import api.swagger.pojo.pet.Tag;
import api.swagger.pojo.user.SuccessReg;
import api.swagger.pojo.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tests {
    private final String URL = "https://petstore.swagger.io/v2/";

    @BeforeEach
    public void initial() {
        Specifications specifications = new Specifications();
        specifications.installSpecification(specifications.requestSpecification(URL),
                specifications.responseSpecification(200));
    }

    @Test
    @Disabled
    public void addPetPhoto() {
        Specifications specifications = new Specifications();
        specifications.installSpecification(specifications.requestSpecification(URL),
                specifications.responseSpecification(200));

        given().multiPart("file", new File("C:/Users/Antibiotik/Pictures/234421380.jpg"))
                .when()
                .post("pet/{petId}/uploadImage", 1).then().log().all();
    }

    @Test
    public void addPet() {
        Category category = new Category(0, "dog");
        ArrayList<Tag> teg = new ArrayList<Tag>(Collections.singletonList(new Tag(0, "str")));
        ArrayList<String> photoUrls = new ArrayList<String>(Collections.singletonList("qwq"));
        Pet pet = new Pet(0, category, "doggie", photoUrls, teg, "available" );

        Pet successAddPet = given().body(pet).when().post("pet").then().extract().as(Pet.class);

        Assertions.assertEquals(pet.getStatus(), successAddPet.getStatus());
        Assertions.assertEquals(pet.getCategory().getName(), successAddPet.getCategory().getName());
        Assertions.assertEquals(pet.getPhotoUrls(), successAddPet.getPhotoUrls());
        Assertions.assertEquals(pet.getTags().get(0).getName(), successAddPet.getTags().get(0).getName());
    }

    @Test
    public void createListUser() {
        SuccessReg sampleSuccessReg = new SuccessReg(200, "unknown", "ok");
        User user = new User(0, "bobi","bob","tesla", "bob@g.com", "ff","333",0);
        List<User> userList = Collections.singletonList(user);

        SuccessReg successReg = given().body(userList).when().post("user/createWithList").then().extract().as(SuccessReg.class);
    }

    @Test
    public void createArrayUser() {
        SuccessReg sampleSuccessReg = new SuccessReg(200, "unknown", "ok");

        User user = new User(0, "bobi","bob","tesla", "bob@g.com", "ff","333",0);
        User[] users = {user};

        SuccessReg successReg = given().body(users).when().post("user/createWithArray").then().extract().as(SuccessReg.class);

        Assertions.assertEquals(sampleSuccessReg.getType(), successReg.getType());
        Assertions.assertEquals(sampleSuccessReg.getCode(), successReg.getCode());
    }
    
    @Test
    public void updatePet() {
        Category category = new Category(0, "dog");
        ArrayList<Tag> teg = new ArrayList<Tag>(Collections.singletonList(new Tag(0, "str")));
        ArrayList<String> photoUrls = new ArrayList<String>(Collections.singletonList("qwq"));
        Pet pet = new Pet(0, category, "doggie", photoUrls, teg, "available" );

        Pet successAddPet = given().body(pet).when().put("pet").then().extract().as(Pet.class);

        Assertions.assertEquals(pet.getStatus(), successAddPet.getStatus());
        Assertions.assertEquals(pet.getCategory().getName(), successAddPet.getCategory().getName());
        Assertions.assertEquals(pet.getPhotoUrls(), successAddPet.getPhotoUrls());
        Assertions.assertEquals(pet.getTags().get(0).getName(), successAddPet.getTags().get(0).getName());
    }
}
