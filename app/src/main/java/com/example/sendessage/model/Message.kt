package com.example.sendessage.model

import java.io.Serializable

data class Message (val id:Int, val content: String, val sender:Person, val receiver:Person):
    Serializable