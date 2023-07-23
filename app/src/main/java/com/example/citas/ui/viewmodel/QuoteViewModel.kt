package com.example.citas.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citas.data.model.QuoteModel
import com.example.citas.data.model.QuoteProvider
import com.example.citas.domain.GetQuoteUseCase
import com.example.citas.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    var isLoading = MutableLiveData<Boolean>()
    val getQuoteUseCase = GetQuoteUseCase()
    var gerRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuoteUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = gerRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}
