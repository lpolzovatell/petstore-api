package endpoints;

import io.restassured.response.Response;
import models.Pet.Pet;
import org.apache.http.HttpStatus;
import utils.PropertiesController;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class PetStorePetsEndPoints {
    private static final String FIND_PETS = PropertiesController.getProperty("petstore.get.petsby.status");
    private static final String ADD_NEW_PET = PropertiesController.getProperty("petstore.add.pet");
    private static final String FIND_PET_BY_ID = PropertiesController.getProperty("petstore.get.by.pet");

    public Response getPetsByStatus(String status){
        return given()
                .param("status", status)
                .when()
                .get(FIND_PETS);
    }

    public Response getStorePetById(long id) {
        return given()
                .when()
                .pathParam("petId", id)
                .get(FIND_PET_BY_ID);
    }

    public Response addPet(Pet pet) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(pet)
                .when()
                .post(ADD_NEW_PET);
        response
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
        return response;
    }

}
