package br.com.henrique.sgps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SgpsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SgpsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //System.out.println(encoder.encode("admin"));

    }

}
