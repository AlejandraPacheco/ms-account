package com.example.msaccount.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/accounts")
class AccountController {
    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(AccountController::class.java)
        val accounts = listOf("135791113", "24681012", "123456789")
    }
    @Value("\${server.port}")
    lateinit var port: String

    @GetMapping("/test")
    fun test(): String {
        return "Account server port: $port";
    }

    @GetMapping("/list")
    fun getAccounts(): List<String> {
        return accounts;
    }

    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: Int): String {
        return accounts[id];
    }
}