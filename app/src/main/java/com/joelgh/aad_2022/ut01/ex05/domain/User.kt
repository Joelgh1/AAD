package com.joelgh.aad_2022.ut01.ex05.domain

class User (val id: Int, val name: String, val username: String){

    @Override
    override fun toString(): String {
        var sb: StringBuilder = StringBuilder()
        sb.append("ID: ")
        return super.toString()
    }
}