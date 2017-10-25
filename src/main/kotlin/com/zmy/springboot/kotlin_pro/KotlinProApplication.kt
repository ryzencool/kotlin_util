package com.zmy.springboot.kotlin_pro

import com.zmy.springboot.kotlin_pro.enity.User
import com.zmy.springboot.kotlin_pro.repository.UserRepository
import io.netty.channel.Channel
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableWebFlux
class KotlinProApplication {

    @Bean
    fun commandLineRunner(userRepository: UserRepository): CommandLineRunner = CommandLineRunner {
//        kotlin.io
        userRepository.deleteAll().subscribe(null, null,
                {
                    userRepository.save(User("zhang", "wuji", "1")).subscribe(
                            {
                                print(it.toString())
                            }
                    )
                }
        )
    }
}


fun main(args: Array<String>) {
    SpringApplication.run(KotlinProApplication::class.java, *args)
}
