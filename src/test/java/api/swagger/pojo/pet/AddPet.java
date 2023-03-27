package api.swagger.pojo.pet;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.http.ContentType;

import java.io.File;

public class AddPet {
    private int petId;
    private MultiPartSpecification file;

    public AddPet(int petId, String filePath) {
        this.petId = petId;
    }
}
