package com.example.mvvmbasics.data

class FakeDatabase private constructor(){

    var quoteDao = FakeQuoteDao()
    private set

    // Singelton initiation...
    companion object {
        @Volatile private var instace: FakeDatabase? = null

        fun getInstance() = instace ?: synchronized(this) {
            instace ?: FakeDatabase().also { instace = it }
        }
    }
}