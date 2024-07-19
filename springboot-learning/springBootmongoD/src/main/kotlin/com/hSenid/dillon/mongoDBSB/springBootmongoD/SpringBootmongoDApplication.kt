package com.hSenid.dillon.mongoDBSB.springBootmongoD

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringBootmongoDApplication{

	@GetMapping("api/hello/")
	fun hello() = "Helloing there"


}



fun main(args: Array<String>) {
	runApplication<SpringBootmongoDApplication>(*args)
}
