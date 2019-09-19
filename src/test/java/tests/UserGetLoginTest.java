package tests;

import endpoints.PetStoreUsersEndPoints;
import io.restassured.response.Response;
import models.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserGetLoginTest {


    private static final PetStoreUsersEndPoints PET_STORE_USERS_END_POINTS = new PetStoreUsersEndPoints();

    @Test(description = "Создание заявки")
    public void getUserLogin() {
        //given
        User user = User.createDefaultUser();
        //when
        Response userFromResponse = PET_STORE_USERS_END_POINTS.createUser(new User());
        //then
        int createdUserId = userFromResponse.body().as(User.class).getId();
        User createdUserFromService = PET_STORE_USERS_END_POINTS.getUsername(user.getUserName()).as(User.class);

        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(createdUserFromService.getId(), user.getId());
        assertions.assertEquals(createdUserFromService.getUserName(), user.getUserName());

    }

}
