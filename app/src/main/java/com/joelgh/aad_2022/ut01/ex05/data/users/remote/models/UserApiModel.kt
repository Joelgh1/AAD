package com.joelgh.aad_2022.ut01.ex05.data.users.remote.models

data class UserApiModel(val id: Int, val name: String, val username: String, val email: String, val address: AddressApiModel, val phone: String, val website: String, val company: CompanyApiModel)