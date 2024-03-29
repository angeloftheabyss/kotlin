package com.angeloftheabyss.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping(value = ["/customer/{id}"])
    fun getCustomer(@PathVariable id : Int) : ResponseEntity<Customer?> {
        val customer = customerService.getCustomer(id)
        val status = if (customer == null) HttpStatus.NOT_FOUND else
            HttpStatus.OK
        return ResponseEntity(customer, status)
    }

    @GetMapping(value = ["/customers"])
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String): List<Customer> {
        return customerService.searchCustomer(nameFilter)
    }

    @PostMapping(value = ["/customer/"])
    fun createCustomer (@RequestBody customer: Customer): ResponseEntity<Unit?>{
        customerService.createCustomer(customer)
        return ResponseEntity(null, HttpStatus.CREATED)
    }

    @DeleteMapping(value = ["/customer/{id}"])
    fun deleteCustomer(@PathVariable id: Int): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (customerService.getCustomer(id) != null) {
            customerService.deleteCustomer(id)
            status = HttpStatus.OK
        }
        return ResponseEntity(Unit, status)
    }

    @PutMapping(value = ["/customer/{id}"])
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer):
    ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if(customerService.getCustomer(id) != null){
            customerService.updateCustomer(id, customer)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }
}

