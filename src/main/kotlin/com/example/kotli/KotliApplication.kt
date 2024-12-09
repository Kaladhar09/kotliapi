package com.example.kotli

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotliApplication

fun main(args: Array<String>) {
	runApplication<KotliApplication>(*args)
}
