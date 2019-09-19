package endpoints;

import io.restassured.response.Response;
import models.Pet.Pet;
import org.apache.http.HttpStatus;
import utils.PropertiesController;

import static io.restassured.RestAssured.given;

public class PetStorePetsEndPoint {

    private static final String ADD_NEW_PET = PropertiesController.getProperty("petstore.add.pet");
    private static final String FIND_PET_BY_ID = PropertiesController.getProperty("petstore.get.by.pet");

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

    public Response getStorePetById(int id) {
        return given()
                .when()
                .pathParam("petId", id)
                .get(FIND_PET_BY_ID);
    }
}
