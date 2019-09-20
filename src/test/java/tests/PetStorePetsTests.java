package tests;

import endpoints.PetStorePetsEndPoints;
import io.restassured.response.Response;
import models.Pet.Pet;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PetStorePetsTests extends BaseTest {

    private static final PetStorePetsEndPoints PET_STORE_PET_POINTS = new PetStorePetsEndPoints();

    @Test
    public void AddANewPetToTheStore() {

        Pet pet = Pet.createDefaultPet();
        Response petFromResponse = PET_STORE_PET_POINTS.addPet(pet);

        long addPetId = petFromResponse.body().as(Pet.class).getId();
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

    @Test
    public void getPetsByStatus(){
        String status = "available";// available, pending, sold
        Response response = PET_STORE_PET_POINTS.getPetsByStatus(status);
        List<Pet> pets = response.jsonPath().getList(".", Pet.class);
        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(response.getStatusCode(), 200);
        assertions.assertFalse(pets.isEmpty());
        assertions.assertAll();
    }

    @Test(description = "Обновление питомца")
    public void updatePetTest() {
        Pet pet = Pet.createDefaultPet();
        PET_STORE_PET_POINTS.addPet(pet);
        pet.setName("newPetName");

        PET_STORE_PET_POINTS.updatePet(pet);

        Pet updatedPetFromService = PET_STORE_PET_POINTS.getStorePetById(pet.getId()).as(Pet.class);
        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(updatedPetFromService.getId(), pet.getId());
        assertions.assertEquals(updatedPetFromService.getName(), pet.getName());
        assertions.assertEquals(updatedPetFromService.getStatus(), pet.getStatus());
        assertions.assertAll();
    }

    @Test(description = "Удаление питомца по ID")
    public void deletePetByIdTest() {
        Pet pet = Pet.createDefaultPet();
        PET_STORE_PET_POINTS.addPet(pet);
        long petID = pet.getId();

        PET_STORE_PET_POINTS.deletePetByID(petID);

        Response petById = PET_STORE_PET_POINTS.getStorePetById(petID);
        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(petById.getStatusCode(), 404);
        assertions.assertAll();
    }
}
