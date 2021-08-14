package com.guren.personsapp.ui.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guren.personsapp.R
import com.guren.personsapp.databinding.ActivityPersonsBinding
import com.guren.personsapp.model.PersonsModel
import com.guren.personsapp.ui.adapter.PersonAdapter
import com.guren.personsapp.viewmodel.PersonViewModel
import java.io.IOException
import java.lang.Exception

class PersonsActivity : AppCompatActivity() {


    private lateinit var binding: ActivityPersonsBinding
    private lateinit var viewModel: PersonViewModel
    private lateinit var adapter: PersonAdapter


    private var jsonFileString : String = ""
    var personItems = mutableListOf<PersonsModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Initializing home view model */
        viewModel =
            ViewModelProvider(this).get(PersonViewModel::class.java)

        binding = ActivityPersonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jsonFileString = getJsonDataFromAsset(this, "personJson.json")
        val gson = Gson()
        val obj = object : TypeToken<MutableList<PersonsModel>>() {}.type
        personItems = gson.fromJson(jsonFileString,obj)



        initViewModel()
        setUpViews()


    }
    private fun initViewModel(){

//        try {
//            viewModel.fetchPersons(this)
//        }
//        catch (e:Exception){
//            Toast.makeText(this, "Error: ${e.toString()}", Toast.LENGTH_SHORT).show()
//        }
//
//        try{
//            viewModel.getPersons().observe(this,{  personModel ->
//                personItems.addAll(personModel)
//                adapter.clearList()
//                adapter.update(personItems)
//            })
//        }
//        catch (e:Exception){
//            Toast.makeText(this, "Error: ${e.toString()}", Toast.LENGTH_SHORT).show()
//        }




    }

    /** load data from the asset */
    private fun getJsonDataFromAsset(context: Context, fileName: String): String {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return ""
        }
        return jsonString
    }

    private fun setUpViews(){

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        adapter = PersonAdapter(this,personItems)
        binding.personsRV.layoutManager = linearLayoutManager
        binding.personsRV.adapter = adapter

    }
}