package com.angeloftheabyss.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class RestApplication

fun main(args: Array<String>) {
	runApplication<RestApplication>(*args)
}
