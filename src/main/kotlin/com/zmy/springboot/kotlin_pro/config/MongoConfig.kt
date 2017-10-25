package com.zmy.springboot.kotlin_pro.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

@Configuration
class MongoConfig {

    private val host = "localhost"

    private val port = "27017"

    fun reactiveMongoClient() = MongoClients.create("mongodb://" + this.host)

    fun reactiveMongoTemplate() = ReactiveMongoTemplate(reactiveMongoClient(), "kotlin_pro")


}