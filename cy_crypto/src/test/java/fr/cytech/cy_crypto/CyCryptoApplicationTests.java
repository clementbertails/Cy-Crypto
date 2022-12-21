package fr.cytech.cy_crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.cytech.cy_crypto.model.Role;
import fr.cytech.cy_crypto.services.MailService;
import fr.cytech.cy_crypto.services.UserService;

@SpringBootTest
class CyCryptoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@Test
	void testFindUserByAttribute() {
		assertEquals(null, userService.findAllByAttribute("role", "test"));
		assertEquals(null, mailService.findAllByAttribute("bite", "test"));
		assertFalse(userService.findAllByAttribute("role", Role.USER).isEmpty());
		assertFalse(userService.findAllByAttribute("role", Role.ADMIN).isEmpty());
		assertFalse(userService.findAllByAttribute("role", 0).isEmpty());
	}

	@Test
	void testfindUser() {
		assertEquals(null, userService.find("testUwU"));
		assertFalse(userService.find(1) == null);
		assertTrue(userService.find(new java.util.Date()) == null);
		assertFalse(userService.find("clement.bertails@gmail.com") == null);
		assertTrue(userService.find("") == null);
		assertFalse(userService.find("espath") == null);
		assertTrue(userService.find("test") != null);
		assertFalse(userService.findAll().isEmpty());
	}

	@Test 
	void testFindMailByAttribute(){
		assertTrue(mailService.findAllByAttribute("user", userService.find("espath")) == null);
		assertTrue(mailService.findAllByAttribute("UwU", userService.find("3")) == null);
		assertTrue(mailService.findAllByAttribute("test", userService.find("")) == null);
		assertTrue(mailService.findAllByAttribute("sender", "test") == null);
		assertTrue(mailService.findAllByAttribute("receivers", userService.find(1)).isEmpty());
		assertFalse(mailService.findAllByAttribute("receivers", userService.find(4)).isEmpty());
		assertFalse(mailService.findAllByAttribute("sender", userService.find(1)).isEmpty());
		assertTrue(mailService.findAllByAttribute("sender", userService.find(4)).isEmpty());
		assertTrue(mailService.findAllByAttribute("date", "test") == null);
		// assertTrue(mailService.findAllByAttribute("date", new java.util.Date().getTime()).isEmpty());
		// assertFalse(mailService.findAllByAttribute("date", new Date(2022-12-02)).isEmpty());
	}

	@Test
	void testFindMail(){
		assertTrue(mailService.find(0) == null);
		assertFalse(mailService.find(1) == null);
		assertFalse(mailService.findAll().isEmpty());
	}

}