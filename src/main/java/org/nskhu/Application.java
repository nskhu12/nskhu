package org.nskhu;

import org.nskhu.model.User;
import org.nskhu.model.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            User u = new User();
            u.setBirthdayChanged(false);
            u.setName("nick");
            u.setPhoneNumber("123123");
            u.setLiabilities(BigDecimal.valueOf(100));
            u.setMonthlySalary(BigDecimal.valueOf(500));
            u.setPassword("123qwe");
            u.setBirthDay(2);
            u.setBirthMonth(3);
            u.setBirthYear(1990);
            repository.save(u);
        };
    }

}
