package com.guren.personsapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
import com.guren.personsapp.misc.showAlertProgressDialog
import com.guren.personsapp.model.PersonsModel
import com.guren.personsapp.network.APIClient


class PersonViewModel  : ViewModel() {


    var personMutableLiveData = MutableLiveData<ArrayList<PersonsModel>>()

    fun fetchPersons(ctx: Context){

        val loader = showAlertProgressDialog(ctx)

        Fuel.request(APIClient.GetPerson(body = "",bytes = null))
            .responseObject(PersonsModel.Deserializer()) { request, response, result ->

                result.fold(success = { personModel ->
                    personMutableLiveData.value = personModel
                    if (loader.isShowing) loader.dismiss()
                }, failure = { error ->
                    if (loader.isShowing) loader.dismiss()
                    Log.d("PersonViewModel", "fetchPersons: error")
                    personMutableLiveData.value = arrayListOf()

                })

            }
    }

    fun getPersons(): MutableLiveData<ArrayList<PersonsModel>>{
        return personMutableLiveData
    }

}