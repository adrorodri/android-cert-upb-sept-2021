package edu.upb.cocinaya.model

import java.io.Serializable

data class User(val username: String, var firstName: String, var lastName: String): Serializable
