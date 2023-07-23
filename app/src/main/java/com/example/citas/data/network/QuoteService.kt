package com.example.citas.data.network

import com.example.citas.core.RetrofitHelper
import com.example.citas.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes() : List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}