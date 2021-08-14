package com.guren.personsapp.ui.module

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guren.personsapp.R
import com.guren.personsapp.databinding.ActivityPersonDetailsBinding

import com.guren.personsapp.model.PersonsModel
import com.guren.personsapp.util.Constants
import java.util.*

class PersonDetailsActivity : AppCompatActivity() {

    private lateinit var item: PersonsModel
    private lateinit var binding: ActivityPersonDetailsBinding
    private var birthDay = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)

        binding = ActivityPersonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        item = intent.getParcelableExtra(Constants.EXTRA_ITEM_DATA)!!

        setUpViews()
    }

    private fun setUpViews(){

        binding.tvFirstname.text = item.firstName
        binding.tvLastname.text = item.lastName
        binding.tvBirthday.text = item.birthDay
        binding.tvAddress.text = item.address
        binding.tvEmailAddress.text = item.emailAddress
        binding.tvMobileNumber.text = item.mobileNumber
        binding.tvContactPerson.text = item.contactPerson
        binding.tvContactPersonNumber.text = item.contactPersonNumber
        birthDay = item.birthDay

        val arrBirthDay = birthDay.split("-")

        binding.tvAge.text = getAge(arrBirthDay[2].toInt(),
                                    arrBirthDay[1].toInt(),
                                    arrBirthDay[0].toInt())


    }

    private fun getAge(year: Int, month: Int, day: Int): String {

        val dob: Calendar = Calendar.getInstance()
        val today: Calendar = Calendar.getInstance()
        dob.set(year, month, day)
        var age: Int = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        val ageInt = age
        return ageInt.toString()
    }

}