package com.ivotai.kotlindemo


import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {


    }

    class Person {
        var name: String
        var age: Int

        constructor(name: String, age: Int) {
            this.name = name
            this.age = age
        }

    }
}

