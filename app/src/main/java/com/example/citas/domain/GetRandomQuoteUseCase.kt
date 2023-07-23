package com.example.citas.domain

import com.example.citas.data.model.QuoteModel
import com.example.citas.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNomber= (quotes.indices).random()
            return quotes[randomNomber]
        }
        return null
    }
}