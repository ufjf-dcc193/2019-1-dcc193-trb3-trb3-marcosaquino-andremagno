package trb3.dcc193.trb3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "trb3.dcc193.trb3")
@ComponentScan(basePackages = {"trb3.*"})
@EnableJpaRepositories(basePackages = "trb3.dcc193.trb3")
@EnableTransactionManagement
public class DemoApplication {
		
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello Mundo!");

		















	}

}