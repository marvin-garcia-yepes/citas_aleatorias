package com.example.citas.data

import com.example.citas.data.model.QuoteModel
import com.example.citas.data.model.QuoteProvider
import com.example.citas.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response= api.getQuotes()
        QuoteProvider.quotes=response
        return response
    }
}