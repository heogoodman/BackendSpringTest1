package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 이부분은 Junit의 init()부분의 new Generic 컨테이너생성이부분임
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
		
	@Autowired
	Hello hello; // Hello라는 타입을 찾아서 hello라는 id에 인젝션시켜줌 hello1 이라치면못찾음
	                  //일부로 아이디에 맞췄음 
	@Autowired  // 기본적으로 Hello 타입을찾고 그이후 오른쪽으로id 변수를 찾음  // 타입기반찾기 Autowired
	@Qualifier("helloC")
	Hello hello2; //위에 Qualifier를 사용해서 이렇게하면 변수명은 맘대로하고 아이디를 줄수있다 
	
	@Resource(name = "helloC")  // 이런식으로 속성에 아예 id를 넣어서 가능하게함  
	Hello hello3;
	
	@Autowired
	@Qualifier("strPrinter")   // Printer 타입인애가 StringPrinter, ConsolePrinter 두명이라 반드시 써줘야함 Qualifier
	Printer printer;
	
	@Test
	public void helloC() {
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
	}
	
	@Test //@Disabled
	public void hello() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
	}
		
}