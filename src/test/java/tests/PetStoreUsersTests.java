package tests;

import endpoints.PetStoreUsersEndPoints;
import io.restassured.response.Response;

import models.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetStoreUsersTests extends BaseTest {

    private static final PetStoreUsersEndPoints PET_STORE_USERS_END_POINTS = new PetStoreUsersEndPoints();

    @Test(description = "Создание пользователя")
    public void createUser(){
        //given
        User user = User.createUser();
        //when
        PET_STORE_USERS_END_POINTS.createUser(user);
        //then
        User createdUserFromService = PET_STORE_USERS_END_POINTS.getUsername(user.getUsername()).as(User.class);

        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(createdUserFromService.getFirstName(), user.getFirstName());
        assertions.assertEquals(createdUserFromService.getLastName(), user.getLastName());
        assertions.assertEquals(createdUserFromService.getUserStatus(), user.getUserStatus());
        assertions.assertEquals(createdUserFromService.getEmail(), user.getEmail());
        assertions.assertEquals(createdUserFromService.getPhone(), user.getPhone());
        assertions.assertAll();
    }

    @Test(description = "Удаление пользователя")
    public void deleteOrder(){
        //given
        User user = User.createUser();
        PET_STORE_USERS_END_POINTS.createUser(user);
        String username = user.getUsername();
        //when
        PET_STORE_USERS_END_POINTS.deleteUserByUsername(username);
        //then
        Response userByUsername = PET_STORE_USERS_END_POINTS.getUsername(username);
        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(userByUsername.getStatusCode(), 404);
        assertions.assertAll();
    }

}
