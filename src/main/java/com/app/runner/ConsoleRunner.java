package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repository.ProductRepository;
import com.app.repository.ProductRepository.MyData;
import com.app.repository.ProductRepository.MyView;

@Component
public class ConsoleRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		//save operations
		/*List<Product> prds = Arrays.asList(
					new Product("A", "A-45", "Wipro", 1.1),
				    new Product("B", "B-45", "Microsoft", 2.2),
				    new Product("C", "C-65", "IGate", 3.2),
				    new Product("D", "D-15", "Infosis", 4.2),
				    new Product("E", "E-75", "Accenture", 2.2)
				);
		repo.saveAll(prds);*/
		
		
		//Static Projection operations for selected variables
		
		/*repo.findByProdCost(3.2)
		.forEach(p->System.out.println(p.getProdCode()
				 +","
				 +p.getProdModel())
				);
		repo.findByProdCode("A")
		.forEach(p->System.out.println(p.getProdCost()
				  +","
				  +p.getProdVendor())
				);*/
		
		//Dynamic Projection operations for selected variables
		
		repo.findByProdCost(4.2, MyData.class)
		.forEach(p->System.out.println(p.getProdCode()));
		
		repo.findByProdCode("A", MyView.class)
		.forEach(p->System.out.println(p.getProdCost()));
	}

}
