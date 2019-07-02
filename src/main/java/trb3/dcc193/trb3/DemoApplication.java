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

		item1 = new Item("A Obra");
		repositorioItem.save(item1);
		item2 = new Item("Ventos");
		repositorioItem.save(item2);
		item3 = new Item("Crônicas");
		repositorioItem.save(item3);
		item4 = new Item("Receitas caseiras");
		repositorioItem.save(item4);
		item5 = new Item("O poder de tudo");
		repositorioItem.save(item5);

		etiq1 = new Etiqueta("Casual", "Leitura leve", "www.casual.com");
		repositorioEtiqueta.save(etiq1);
		etiq2 = new Etiqueta("Culinária", "tutoriais", "www.cozinha.com");
		repositorioEtiqueta.save(etiq2);
		etiq3 = new Etiqueta("Ensino", "estudos", "www.ensino.com");
		repositorioEtiqueta.save(etiq1);
		etiq4 = new Etiqueta("Ação", "Aventuras", "www.acao.com");
		repositorioEtiqueta.save(etiq1);
		etiq5 = new Etiqueta("Esporte", "Esportes", "www.esporte.com");
		repositorioEtiqueta.save(etiq1);

		vinc1 = new Vinculo(item1, item2);
		repositorioVinculo.save(vinc1);
		vinc2 = new Vinculo(item3, item4);
		repositorioVinculo.save(vinc1);
		vinc3 = new Vinculo(item5, item2);
		repositorioVinculo.save(vinc1);
		vinc4 = new Vinculo(item3, item2);
		repositorioVinculo.save(vinc1);
		vinc5 = new Vinculo(item1, item5);
		repositorioVinculo.save(vinc1);

		anot1 = new Anotacao("Anotacao1", "Descricao1", "www.urlanotacao.com", "10/12/18", "10/03/19", user1);
		repositorioAnotacao.save(anot1);
		anot2 = new Anotacao("Anotacao2", "Descricao2", "www.urlanotacao2.com", "04/11/17", "07/05/19", user2);
		repositorioAnotacao.save(anot2);
		anot3 = new Anotacao("Anotacao3", "Descricao3", "www.urlanotacao3.com", "10/10/18", "11/04/19", user3);
		repositorioAnotacao.save(anot3);
		anot4 = new Anotacao("Anotacao4", "Descricao4", "www.urlanotacao4.com", "03/12/18", "01/02/19", user4);
		repositorioAnotacao.save(anot4);
		anot5 = new Anotacao("Anotacao5", "Descricao5", "www.urlanotacao5.com", "08/11/18", "19/05/19", user5);
		repositorioAnotacao.save(anot5);

	}


}