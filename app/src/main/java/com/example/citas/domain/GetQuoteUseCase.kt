package com.example.citas.domain

import com.example.citas.data.QuoteRepository
import com.example.citas.data.model.QuoteModel

class GetQuoteUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}