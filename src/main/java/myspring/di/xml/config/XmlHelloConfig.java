package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class XmlHelloConfig {

	
	@Bean
	public Printer strPrinter() { // method이름이 Bean의 id가되서 퀄리파이어안해도됨
		return new StringPrinter();
	}
	
	@Bean
	public Printer conPrinter() {
		return new ConsolePrinter();
	}
	
	@Bean  //Bean은 어노테이션을 전혀하지않아야하기때문에 어노테이션사용안한 xml패키지의 클래스를 사용한거임
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("Java컨피그");
		hello.setPrinter(strPrinter()); // strPrinter를 의존하고싶으면 이걸쓰는거임
		return hello;
	}
	
	
	
}
