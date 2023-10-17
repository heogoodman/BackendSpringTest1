package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-annot.xml")
public class AnnotatedHelloBeanTest {
		@Autowired        
		Hello hello;              //지금 Hello타입인게 하나밖에없어서 이렇게만해도괜찮음
		
		@Resource(name="stringPrinter")  // StringPrinter클래스에 @Component("stringPrinter") 이부분보고 찾는것
		Printer printer;                 // 인터페이스 Printer이고 구현체가 이거라서 상위로 받는것 
		
		@Autowired
		HelloCons helloCons;
		
		@Test
		public void helloConsBean() {
			assertEquals("Hello annot생성자", helloCons.sayHello());
			helloCons.print();  // 애는 StringPrinter와 달름 메소드가 그래서바로 출력됨
		}
		
		@Test
		public void helloBean() {
			assertEquals("Hello 어노테이션", hello.sayHello());
			hello.print();
			assertEquals("Hello 어노테이션", printer.toString());
		}
}
