package zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooUI {

    public static void main(String... args){
        SpringApplication.run(ZooUI.class, args);
        System.out.println("=============================================================");
        System.out.println("        -> http://localhost:9000/");
        System.out.println("=============================================================");
    }

}
