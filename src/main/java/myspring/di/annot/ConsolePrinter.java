package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter") // 명시적선언 안해주면 자동으로 맨앞자리 소문자로 지정
public class ConsolePrinter implements Printer {
	public ConsolePrinter() {
		System.out.println(this.getClass().getName() + " 생성자 호출됨!!");
	}
	
	public void print(String message) {
		System.out.println(message);
	}
}