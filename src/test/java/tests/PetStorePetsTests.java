package tests;

import endpoints.PetStorePetsEndPoints;
import io.restassured.response.Response;
import models.Pet.Pet;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class PetStorePetsTests extends BaseTest {

    private static final PetStorePetsEndPoints PET_STORE_PET_POINTS = new PetStorePetsEndPoints();

    @Test
    public void AddANewPetToTheStore() {

        Pet pet = Pet.createDefaultPet();
        Response petFromResponse = PET_STORE_PET_POINTS.addPet(pet);
        SoftAssert assertions = new SoftAssert();
    }

    @Test
    public void getPetsByStatus(){
        String status = "available";// available, pending, sold
        Response response = PET_STORE_PET_POINTS.getPetsByStatus(status);
        List<Pet> pets = new ArrayList<>();
        pets = response.jsonPath().getList(".", Pet.class);

        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(response.getStatusCode(), 200);
        assertions.assertTrue(pets.size() > 6000);
        assertions.assertAll();
    }
}
