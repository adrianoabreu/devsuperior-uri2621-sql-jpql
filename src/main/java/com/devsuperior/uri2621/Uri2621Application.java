package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("*** Resultado SQL ***");		
		List<ProductMinProjection> list = repository.search1(10, 20, "P");
		List<ProductMinDTO> resultSQL = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		
		for(ProductMinDTO obj : resultSQL) {
			System.out.println(obj);
		}
		
		System.out.println("/n");
		
		System.out.println("*** Resultado JPQL ***");
		List<ProductMinDTO> resultJPQL = repository.search2(10, 20, "P");

		for(ProductMinDTO obj : resultJPQL) {
			System.out.println(obj);
		}
		
	}
}
