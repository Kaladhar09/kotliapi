package com.example.Kotli.controller

import com.example.Kotli.entity.User
import com.example.Kotli.repository.UserRepository
//import java.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun getAllUsers(): List<User> = userRepository.findAll()

    @PostMapping
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User> {
        val savedUser = userRepository.save(user)
        return ResponseEntity.ok(savedUser)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            ResponseEntity.ok(user.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @Valid @RequestBody userDetails: User
    ): ResponseEntity<User> {
        val existingUser = userRepository.findById(id)
        return if (existingUser.isPresent) {
            val updatedUser = existingUser.get().copy(
                email = userDetails.email,
                selectedCategory = userDetails.selectedCategory,
                selectedCountry = userDetails.selectedCountry
            )
            ResponseEntity.ok(userRepository.save(updatedUser))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
