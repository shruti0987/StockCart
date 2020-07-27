package com.example.demo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.aspectj.lang.annotation.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.ResponseEntity;

import controller.UserController;
import exception.UserNotFoundException;
import model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserJUnitTest{

	private User u;
	private static UserController uc;

	@BeforeClass
	public static void setUpClass() {
		uc = new UserController();
	}

	@Before
	public void setUpMethod() {
		u = new User(1001,"firstname1", "lastname1", "firstname1","firstname1");

	}

	@Test
	public void getUserByIdTest()throws UserNotFoundException {
		ResponseEntity<User> u2 = uc.getUsersById(1001);
		assertThat(u, is(u2));
	}


	@AfterClass
	public static void TearDownClass() {
		uc = null;
	}
}