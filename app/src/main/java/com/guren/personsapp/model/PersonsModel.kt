package com.guren.personsapp.model

import android.os.Parcelable
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonsModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("birthday")
    val birthDay: String,
    @SerializedName("email_address")
    val emailAddress: String,
    @SerializedName("mobile_number")
    val mobileNumber: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("contact_person")
    val contactPerson: String,
    @SerializedName("contact_person_number")
    val contactPersonNumber: String
): Parcelable {
    class Deserializer: ResponseDeserializable<ArrayList<PersonsModel>> {
        override fun deserialize(content: String): ArrayList<PersonsModel> = Gson().fromJson(content, ArrayList<PersonsModel>()::class.java)

    }

}