package com.rbais.jsongenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * This app is meant for a java object to be loaded up
 * a file name given in the config
 * and it will generate the JSON representation of it.
 * Step two is to pull from a DB and write it out.
 * 
 */

@SpringBootApplication
public class JSonGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(JSonGeneratorApplication.class, args);
	}
}
