package com.company.hellospring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class UserDAOClient {
	//UserDAO 테스트
	UserDAO dao;
	UserDTO dto;
	
	@Before
	public void before() {
		dao = new UserDAO();
		dto = new UserDTO();
		dto.setId("wona23");
		dto.setPassword("1234");
	}
	
	@Ignore @Test
	public void insertTest() {
		assertEquals(1, dao.insertUser(dto));
	}
	
	@Test
	public void getUserTest() {
		assertEquals("1234", dao.getUser(dto).getPassword());
	}
	
	@Test
	public void getUsersTest() {
		assertEquals("test",dao.getUsers().get(0).getId());
		//assertNotNull(dao.getUsers().get(0).getId());
	}
}
