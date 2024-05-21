package lk.ijse.gdse.HelloShoeShopManagementSystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloShoeShopManagementSystemApplication {

	@Bean
	public ModelMapper modelMapper (){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloShoeShopManagementSystemApplication.class, args);
	}

}
