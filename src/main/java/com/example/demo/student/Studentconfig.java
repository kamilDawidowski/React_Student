//package com.example.demo.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
////ładowanie aplikacji danymi
//@Configuration
//public class Studentconfig {
//    @Bean
//    CommandLineRunner commandLineRunner(
//            StudentRepository repository) {
//        return args -> {
//            Student marysia = new Student(
//                    "dsdsds",
//                    "dfsdfs",
//                    "Marysia",
//                    "defeedf",
//                    LocalDate.of(1998, Month.APRIL, 12)
//            );
//            Student janek = new Student(
//                    "dsdsds",
//                    "dfsdfs",
//                    "Janek",
//                    "defeedf",
//                    LocalDate.of(1999, Month.APRIL, 29)
//            );
//            repository.saveAll(List.of(marysia, janek)
//            );
//
//        };
//    }
//}
