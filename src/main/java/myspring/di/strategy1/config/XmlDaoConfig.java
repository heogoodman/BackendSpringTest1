package myspring.di.strategy1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.dao.UserDaoImpl;
import myspring.di.strategy1.service.UserServiceImpl;

@Configuration
public class XmlDaoConfig {
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public UserServiceImpl userServiceDao() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserdao(userDao());
		return userServiceImpl;
	}
	
	
}
