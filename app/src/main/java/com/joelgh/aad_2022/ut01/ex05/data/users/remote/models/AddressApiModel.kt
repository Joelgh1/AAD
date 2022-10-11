package com.joelgh.aad_2022.ut01.ex05.data.users.remote.models

data class AddressApiModel(val street: String, val suite: String, val city: String, val zipcode: String, val geo: GeoApiModel)