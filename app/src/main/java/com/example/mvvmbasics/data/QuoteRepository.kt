package com.example.mvvmbasics.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instace: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) = instace ?: synchronized(this) {
            instace ?: QuoteRepository(quoteDao).also { instace = it }
        }
    }
}