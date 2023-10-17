package myspring.di.strategy3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"myspring.di.strategy1.dao.annot","myspring.di.strategy1.service.annot"})
public class AnnotatedScan {

}
