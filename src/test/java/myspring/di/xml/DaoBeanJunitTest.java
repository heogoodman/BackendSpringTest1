package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserServiceImpl;

public class DaoBeanJunitTest {

	BeanFactory factory;
	
	@BeforeEach
	void init() {
		factory = new GenericXmlApplicationContext("classpath:spring-beans2.xml");
	}
	
	@Test
	void 테스트() {
		UserServiceImpl user1 = (UserServiceImpl)factory.getBean("userServiceImpl");
		assertEquals("홍길동", user1.getUser(0).getName());
//		assertEquals(2, user1.getUserList().size());
	}
	
}
