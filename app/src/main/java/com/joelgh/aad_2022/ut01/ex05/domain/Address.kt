package com.joelgh.aad_2022.ut01.ex05.domain

import okhttp3.CipherSuite

data class Address(val street: String, val suite: String, val city: String, val zipcode: String, val geo: Geo)