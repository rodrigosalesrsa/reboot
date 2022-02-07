package io.github.rodrigosalesrsa;

import io.github.rodrigosalesrsa.domain.entity.Cliente;
import io.github.rodrigosalesrsa.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class RebootApplication {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @GetMapping("/hello")
    public String helloWold(){
        return applicationName;
    }

    @GetMapping("/bye")
    public String bye(){
        return "Bye, Rodrigo!";
    }

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            clientes.salvar(new Cliente("Rodrigo"));
            clientes.salvar(new Cliente("Tallyta"));

            List<Cliente> todosClientes = clientes.listarTodos();
            todosClientes.forEach(System.out::println);
        };
    }



    public static void main(String[] args) {
        SpringApplication.run(RebootApplication.class, args);
    }
}
