package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 나는 xml을 대신해서 설정역할을 하는 클래스입니다. (전략3)
@ComponentScan(basePackages = {"myspring.di.annot"}) //우리가 스캔해야할 대상이될애들이 있는곳임 
public class AnnotatedHelloConfig {
		
}
