package tests;

import endpoints.PetStorePetsEndPoint;
import io.restassured.response.Response;
import models.Pet.Pet;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetStorePetsTests extends BaseTest {

    private static final PetStorePetsEndPoint PET_STORE_PET_POINTS = new PetStorePetsEndPoint();

    @Test
    public void AddANewPetToTheStore() {

        Pet pet = Pet.createDefaultPet();
        Response petFromResponse = PET_STORE_PET_POINTS.addPet(pet);
        SoftAssert assertions = new SoftAssert();

    }
}
