package myspring.di.strategy1.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy1.dao.annot.UserDao;
import myspring.di.strategy1.service.annot.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-annot2.xml")
public class AnnotatedDaoBeanTest {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Resource(name="userDaoImpl")
	UserDao userDao;
	
	@Test
	void 테스트() {
		assertEquals("홍길동", userServiceImpl.getUser(0).getName());
		assertEquals(2, userServiceImpl.getUserList().size());
	}
}
