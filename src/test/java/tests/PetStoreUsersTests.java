package tests;

import endpoints.PetStoreUsersEndPoints;
import io.restassured.response.Response;

import models.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetStoreUsersTests extends BaseTest {

    private static final PetStoreUsersEndPoints PET_STORE_USERS_END_POINTS = new PetStoreUsersEndPoints();

    @Test(description = "Создание пользователя")
    public void createUserTest(){
        //given
        User user = User.createUser();
        //when
        PET_STORE_USERS_END_POINTS.createUser(user);
        //then
        User createdUserFromService = PET_STORE_USERS_END_POINTS.getUserByUsername(user.getUsername()).as(User.class);

        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(createdUserFromService.getFirstName(), user.getFirstName());
        assertions.assertEquals(createdUserFromService.getLastName(), user.getLastName());
        assertions.assertEquals(createdUserFromService.getUserStatus(), user.getUserStatus());
        assertions.assertEquals(createdUserFromService.getEmail(), user.getEmail());
        assertions.assertEquals(createdUserFromService.getPhone(), user.getPhone());
        assertions.assertAll();
    }

    @Test(description = "Удаление пользователя")
    public void deleteOrderTest(){
        //given
        User user = User.createUser();
        PET_STORE_USERS_END_POINTS.createUser(user);
        String username = user.getUsername();
        //when
        PET_STORE_USERS_END_POINTS.deleteUserByUsername(username);
        //then
        Response userByUsername = PET_STORE_USERS_END_POINTS.getUserByUsername(username);
        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(userByUsername.getStatusCode(), 404);
        assertions.assertAll();
    }

    @Test(description = "Поиск пользователя")
    public void getUserByUserNameTest(){
        //given
        User user = User.createUser();
        PET_STORE_USERS_END_POINTS.createUser(user);
        //when
        User createdUserFromService = PET_STORE_USERS_END_POINTS.getUserByUsername(user.getUsername()).as(User.class);
        //then
        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(createdUserFromService.getFirstName(), user.getFirstName());
        assertions.assertEquals(createdUserFromService.getUsername(), user.getUsername());
        assertions.assertEquals(createdUserFromService.getLastName(), user.getLastName());
        assertions.assertEquals(createdUserFromService.getUserStatus(), user.getUserStatus());
        assertions.assertEquals(createdUserFromService.getEmail(), user.getEmail());
        assertions.assertEquals(createdUserFromService.getPhone(), user.getPhone());
        assertions.assertEquals(createdUserFromService.getPassword(), user.getPassword());
        assertions.assertEquals(createdUserFromService.getId(), user.getId());
        assertions.assertAll();
    }

    @Test(description = "Logout")
    public void logoutTest() {
        PET_STORE_USERS_END_POINTS.logout();
    }

    @Test(description = "Обновление пользователя")
    public void updateUserByUsernameTest(){
        User user = User.createUser();
        PET_STORE_USERS_END_POINTS.createUser(user);
        String username = user.getUsername();
        user.setUsername("newUsername");

        PET_STORE_USERS_END_POINTS.updateUserByUsername(user, username);

        User updatedUserFromService = PET_STORE_USERS_END_POINTS.getUserByUsername(user.getUsername()).as(User.class);
        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(updatedUserFromService.getUsername(), user.getUsername());
        assertions.assertEquals(updatedUserFromService.getFirstName(), user.getFirstName());
        assertions.assertEquals(updatedUserFromService.getLastName(), user.getLastName());
        assertions.assertEquals(updatedUserFromService.getUserStatus(), user.getUserStatus());
        assertions.assertEquals(updatedUserFromService.getEmail(), user.getEmail());
        assertions.assertEquals(updatedUserFromService.getPhone(), user.getPhone());
        assertions.assertAll();
    }
}
