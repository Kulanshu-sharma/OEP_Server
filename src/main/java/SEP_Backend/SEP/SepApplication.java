package SEP_Backend.SEP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
//@EnableJpaRepositories("SEP_Backend.SEP.Repository.*")


public class SepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SepApplication.class, args);
		System.out.println("Initial Commit");
	}

}
