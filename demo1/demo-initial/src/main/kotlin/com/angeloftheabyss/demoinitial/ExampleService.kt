package com.angeloftheabyss.demoinitial

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

class ExampleService : ServiceInterface {
    @Value(value = "\${service.message.text}")
    private lateinit var text : String
    override fun getHello(name : String) = "$text $name"
}
