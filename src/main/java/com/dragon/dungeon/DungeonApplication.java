package com.dragon.dungeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories("com.dragon.dungeon.repositories")
@EntityScan("com.dragon.dungeon.entities")
public class DungeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DungeonApplication.class, args);
	}

}
