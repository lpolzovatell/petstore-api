package tests;

import endpoints.PetStoreUsersEndPoints;
import io.restassured.response.Response;
import models.Order;
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
        assertions.assertEquals(createdUserFromService.getFirstName(), user.getFirstName());
        assertions.assertEquals(createdUserFromService.getLastName(), user.getLastName());
        assertions.assertEquals(createdUserFromService.getEmail(), user.getEmail());
        assertions.assertEquals(createdUserFromService.getPassword(), user.getPassword());
        assertions.assertEquals(createdUserFromService.getPhone(), user.getPhone());
        assertions.assertEquals(createdUserFromService.getUserStatus(), user.getUserStatus());
        assertions.assertAll();
    }
//
//    @Test
//    public void readOrder() {
//        //given
//        User user = User.createDefaultUser();
//        Response orderFromResponse = PET_STORE_USERS_END_POINTS.createUser(user);
//        int createUserId = orderFromResponse.body().as(User.class).getId();
//        //when
//        User createdUserFromServiceObject = PET_STORE_USERS_END_POINTS.getUsername(user.getUserName()).as(User.class);
//        //then
//
//        SoftAssert assertions = new SoftAssert();
//        assertions.assertEquals(orderFromResponse.getStatusCode(), 200);
//        assertions.assertEquals(createdUserFromServiceObject.getId(), user.getId());
//        assertions.assertEquals(createdUserFromServiceObject.getUserName(), user.getUserName());
//        assertions.assertEquals(createdUserFromServiceObject.getFirstName(), user.getFirstName());
//        assertions.assertEquals(createdUserFromServiceObject.getLastName(), user.getLastName());
//        assertions.assertEquals(createdUserFromServiceObject.getEmail(), user.getEmail());
//        assertions.assertEquals(createdUserFromServiceObject.getPassword(), user.getPassword());
//        assertions.assertEquals(createdUserFromServiceObject.getPhone(), user.getPhone());
//        assertions.assertEquals(createdUserFromServiceObject.getUserStatus(), user.getUserStatus());
//        assertions.assertAll();
//    }
//
//    @Test
//    public void deleteOrder() {
//        //given
//        User user = User.createDefaultUser();
//        Response orderFromResponse = PET_STORE_USERS_END_POINTS.createUser(user);
//        int createdOrderId = orderFromResponse.body().as(Order.class).getId();
//        //when
//        PET_STORE_USERS_END_POINTS.createUser(User.createDefaultUser());
//        //then
//        Response orderById = PET_STORE_USERS_END_POINTS.getUsername(user.getUserName());
//        SoftAssert assertions = new SoftAssert();
//        assertions.assertEquals(orderById.getStatusCode(), 404);
//        assertions.assertAll();
//    }
///*
    @Test
    public void verifyGetResponseTime() {
        //given
        Order order = Order.createDefaultOrder();
        Response orderFromResponse = PET_STORE_USERS_END_POINTS.createOrder(order);
        int createdOrderId = orderFromResponse.body().as(Order.class).getId();
        //when
        Response createdOrderFromServiceObject = PET_STORE_USERS_END_POINTS.getStoreOrderById(createdOrderId);
        //then
        PET_STORE_USERS_END_POINTS.verifyResponseTime(createdOrderFromServiceObject, 1000L);
    }*/
}
