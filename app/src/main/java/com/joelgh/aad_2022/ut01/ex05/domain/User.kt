package com.joelgh.aad_2022.ut01.ex05.domain

import android.provider.ContactsContract.CommonDataKinds.Phone

data class User (val id: Int, val name: String, val username: String, val email: String, val address: Address, val phone: String, val website: String, val company: Company)