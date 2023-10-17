package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*; // 이렇게하면 메소드만써도 사용가능

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		//1. Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	
	@Test @Disabled 
	void 생성자주입테스트() {
		Hello bean = factory.getBean("helloC",Hello.class);
		assertEquals("Hello 생성자",bean.sayHello());
		bean.print();
		
		List<String> names = bean.getNames();
		
		assertEquals(3,names.size());
		assertEquals("SpringBoot",names.get(1)); // 리스트에 get(index)를 주면 값이 나옴 
	}
	
	@Test //@Disabled  // 일시적 실행멈춤
	void hello() {
		//1. Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
		//2. Container가 생성한 Bean을 요청하기
		Hello hello1 = (Hello)factory.getBean("hello"); // Object라서 다운캐스팅
		Hello hello2 = factory.getBean("hello", Hello.class); // 방법이 2가지 이방법을 좀더 권장
		//3. HelloBean 레퍼런스 비교하기
		System.out.println(hello1 == hello2);
//		Assertions.assertSame(hello1, hello2); // 임포트부분이 클래스까지해줘서 메소드써줘야함
		assertSame(hello1, hello2); // 싱글톤이 맞다 객체레퍼런스가 같기때문에 겟빈을 2번했지만
		
		assertEquals("Hello 스프링", hello2.sayHello()); // 두칸뛰면 에러뜸 그래서 sysout보단 이렇게하는게좋음
	    hello2.print();
		
		Printer printer = factory.getBean("strPrinter", Printer.class); // 이렇게 상위타입으로줘도됨
		assertEquals("Hello 스프링", printer.toString());
	}
}
