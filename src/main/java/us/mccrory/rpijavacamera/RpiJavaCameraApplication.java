package us.mccrory.rpijavacamera;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.enums.Exposure;

@SpringBootApplication
public class RpiJavaCameraApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpiJavaCameraApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

			// Create a Camera that saves images to the Pi's Pictures directory.
			System.out.println("Let's take a picture...");
			RPiCamera piCamera = new RPiCamera();
			piCamera.takeStill("rpi-java-camera.jpg");
			
			System.out.println("ALL DONE!");

		};
	}

}
