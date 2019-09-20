package tests;

import endpoints.PetStoreUsersEndPoints;
import io.restassured.response.Response;
import models.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserGetLoginTest extends BaseTest{

    private  final String ANSWER_REGISTRATION = "logged in user session:";
    private static final PetStoreUsersEndPoints PET_STORE_USERS_END_POINTS = new PetStoreUsersEndPoints();

    @Test(description = "Авторизация пользователя")
    public void userAuthorization() {
        //given
        User user = User.createUser();
        //when
        Response userFromResponse = PET_STORE_USERS_END_POINTS.sendUserToServis(user);

        String responseFromService = userFromResponse.body().asString();

        SoftAssert assertions = new SoftAssert();
        assertions.assertEquals(responseFromService, ANSWER_REGISTRATION + Long.parseLong(responseFromService.replace(ANSWER_REGISTRATION, "")));
    }

}
