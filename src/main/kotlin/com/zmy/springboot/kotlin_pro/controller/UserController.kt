package com.zmy.springboot.kotlin_pro.controller

import com.zmy.springboot.kotlin_pro.enity.User
import com.zmy.springboot.kotlin_pro.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/all")
    fun findAll(): Flux<User>? = userRepository.findAll()


}