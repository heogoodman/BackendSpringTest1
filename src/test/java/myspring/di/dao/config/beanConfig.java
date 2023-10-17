package myspring.di.dao.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy1.config.XmlDaoConfig;
import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = XmlDaoConfig.class)
public class beanConfig {

		@Autowired
		UserDao userdao;
		
		@Autowired
		UserServiceImpl userServiceImpl;
		
		@Test
		public void dao() {
			assertEquals("홍길동", userServiceImpl.getUser(0).getName());
			assertEquals(2, userServiceImpl.getUserList().size());
		}
	
}
