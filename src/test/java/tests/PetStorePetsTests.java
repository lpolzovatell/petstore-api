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

        int addPetId = petFromResponse.body().as(Pet.class).getId();
        Pet addPetFromService = PET_STORE_PET_POINTS.getStorePetById(addPetId).as(Pet.class);

        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(addPetFromService.getId(), pet.getId());
        assertions.assertEquals(addPetFromService.getName(), pet.getName());
        assertions.assertEquals(addPetFromService.getTags(), pet.getTags());
        assertions.assertEquals(addPetFromService.getStatus(), pet.getStatus());
        assertions.assertEquals(addPetFromService.getCategory(), pet.getCategory());
        assertions.assertEquals(addPetFromService.getPhotoUrls(), pet.getPhotoUrls());
        assertions.assertAll();

    }
}
