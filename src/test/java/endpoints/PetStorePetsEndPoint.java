package endpoints;

import io.restassured.response.Response;
import models.Pet.Pet;
import org.apache.http.HttpStatus;
import utils.PropertiesController;

import static io.restassured.RestAssured.given;

public class PetStorePetsEndPoint {

    private static final String ADD_NEW_PET = PropertiesController.getProperty("petstore.add.pet");

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
        return null;
    }
}
