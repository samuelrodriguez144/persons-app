package com.guren.personsapp.network

import com.github.kittinunf.fuel.core.HeaderValues
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting
import com.guren.personsapp.BuildConfig

sealed class APIClient : FuelRouting {

    class GetPerson(override val body: String?,
                    override val bytes: ByteArray?) : APIClient()

    override val basePath: String
        get() {
            return when (this) {
                is GetPerson -> BuildConfig.BASE_URL
                else -> BuildConfig.BASE_URL

            }

        }

    override val headers: Map<String, HeaderValues>?
        get() {
            return when (this) {
                is GetPerson -> emptyMap()
                else -> emptyMap()

            }
        }

    override val method: Method
        get() {
            return when (this) {
                is GetPerson -> Method.GET
                else -> Method.POST
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() {
            return when (this) {
                is GetPerson -> emptyList()

            }
        }

    override val path: String
        get() {
            return when (this) {
                is GetPerson -> "aaaa"
                else -> ""
            }
        }

}