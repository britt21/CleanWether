package com.mobile.wethercompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.wethercompose.data.response.wether_response.WetherResponse
import com.mobile.wethercompose.domain.WetherRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WetherViewModel @Inject constructor(
   private val wetherRepo: WetherRepo
): ViewModel() {


    val liveWether = MutableStateFlow<WetherResponse?>(null)
    val loading = MutableStateFlow<Boolean>(false)
    var error : MutableStateFlow<String?> =  MutableStateFlow<String?>(null)


    fun getwether(city: String,appid: String){
        loading.value = true
        viewModelScope.launch {
            try {

                val response = wetherRepo.getWether(city,appid)

                println("APICALL: "+response.message())
                println("APICALL: "+response.body())
                println("APICALL: "+response.code())
                if (!response.isSuccessful){
                  error.value = response.message()
                }else{
                    liveWether.value = response.body()
                }
                loading.value = false

            }catch (e: Exception){
                error.value = e.localizedMessage
                loading.value = false

                println("FATAL: "+e.localizedMessage)



            }
        }
    }


}