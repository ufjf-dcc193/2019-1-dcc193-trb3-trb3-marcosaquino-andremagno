package trb3.dcc193.trb3;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
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
		/*SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello Mundo!");*/

		
		RepositorioUsuario repositorioUsuario;
		
		RepositorioItem repositorioItem;
		
		RepositorioVinculo repositorioVinculo;
		
		RepositorioAnotacao repositorioAnotacao;
		
		RepositorioEtiqueta repositorioEtiqueta;

		ConfigurableApplicationContext entrada;
		
		entrada = SpringApplication.run(DemoApplication.class, args);

		repositorioUsuario = entrada.getBean(RepositorioUsuario.class);
		repositorioItem = entrada.getBean(RepositorioItem.class);
		repositorioVinculo = entrada.getBean(RepositorioVinculo.class);
		repositorioAnotacao = entrada.getBean(RepositorioAnotacao.class);
		repositorioEtiqueta = entrada.getBean(RepositorioEtiqueta.class);

		Usuario user1;
		Usuario user2;
		Usuario user3;
		Usuario user4;
		Usuario user5;

		Item item1;
		Item item2;
		Item item3;
		Item item4;
		Item item5;

		Vinculo vinc1;
		Vinculo vinc2;
		Vinculo vinc3;
		Vinculo vinc4;
		Vinculo vinc5;

		Anotacao anot1;
		Anotacao anot2;
		Anotacao anot3;
		Anotacao anot4;
		Anotacao anot5;

		Etiqueta etiq1;
		Etiqueta etiq2;
		Etiqueta etiq3;
		Etiqueta etiq4;
		Etiqueta etiq5;


		user1 = new Usuario("Andre", "1", "Aluno", "andre@gmail.com");
		repositorioUsuario.save(user1);
		user2 = new Usuario("Marcos", "2", "Aluno", "marcos@gmail.com");
		repositorioUsuario.save(user2);
		user3 = new Usuario("Walace", "3", "Aluno", "walace@gmail.com");
		repositorioUsuario.save(user3);
		user4 = new Usuario("Carina", "4", "Aluno", "carina@gmail.com");
		repositorioUsuario.save(user4);
		user5 = new Usuario("Angela", "5", "Aluno", "angela@gmail.com");
		repositorioUsuario.save(user5);

		

	}


}