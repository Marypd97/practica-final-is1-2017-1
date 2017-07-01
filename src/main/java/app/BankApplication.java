package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import config.WebConfig;
import domain.BaseEntity;
import repository.AlumnoRepository;

@Import(WebConfig.class)
@EnableWebMvc
@EnableAutoConfiguration
@EntityScan(basePackageClasses=BaseEntity.class)
//@SpringBootApplication
public class BankApplication {

//	@Autowired
	AlumnoRepository alumnoRepository;
//	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BankApplication.class, args);
	}
}
