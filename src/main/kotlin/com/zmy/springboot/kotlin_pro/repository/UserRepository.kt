package com.zmy.springboot.kotlin_pro.repository

import com.zmy.springboot.kotlin_pro.enity.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveMongoRepository<User, String> {

}