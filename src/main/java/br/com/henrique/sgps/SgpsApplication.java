package br.com.henrique.sgps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.DoubleStream;

@SpringBootApplication
public class SgpsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SgpsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
