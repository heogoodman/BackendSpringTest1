package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloBean") // 다르게 적용을 해보자 
public class Hello {
	
	@Value("어노테이션")  // 		<property name="name" value="스프링" /> 기존의이것과 동일함
	String name;
	
	@Autowired         
	@Qualifier("stringPrinter") // <property name="printer" ref="strPrinter"/> 기존의이것과 동일함
	Printer printer;
	
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName() + " 생성자 호출됨!!");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName() + " 오버로딩된 생성자 호출됨!!");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		System.out.println("Hello setNames() " + list);
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}