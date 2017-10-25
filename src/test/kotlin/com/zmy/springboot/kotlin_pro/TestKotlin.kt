package com.zmy.springboot.kotlin_pro

import com.zmy.springboot.kotlin_pro.enity.Book
import org.junit.Test

class TestKotlin {

    @Test
    fun testKotlin() {
        var name = listOf<Book>(Book("python", listOf("张飞", "赵云")),Book("python", listOf("刘备", "黄忠")), Book("java", listOf("李白", "马超")))
        print(name.groupBy { it.title })
    }
}