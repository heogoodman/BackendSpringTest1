package myspring.di.strategy3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.strategy1.service.annot.UserService;
import myspring.di.strategy1.service.annot.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AnnotatedScan.class,
						loader = AnnotationConfigContextLoader.class)
public class AnnotatedScanTest {
	@Autowired
	UserService userServiceImpl;
	
	@Test
	public void dao() {
		System.out.println(userServiceImpl.getUserList());
		
		assertEquals("홍길동", userServiceImpl.getUser(0).getName());
		assertEquals(2, userServiceImpl.getUserList().size());
	}

}
