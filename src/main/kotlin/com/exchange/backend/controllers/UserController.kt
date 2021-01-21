package com.exchange.backend.controllers

import com.exchange.backend.exceptions.ConflictException
import com.exchange.backend.exceptions.ErrorResponseBody
import com.exchange.backend.exceptions.NotFoundException
import com.exchange.backend.model.User
import com.exchange.backend.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

class PostRegisterUserInput (var email: String, var password: String)
class Id(var id: Long)
class GetUserResponse(var email:String, var id: Long)

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/{id}")
    fun user(@PathVariable id: Long): GetUserResponse {
        var user = userRepository.findUserById(id)
        if(user == null) {
            throw NotFoundException(ErrorResponseBody("User not found!"))
        }
        return GetUserResponse(user.email, user.id)
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerUser(@RequestBody req: PostRegisterUserInput): Id {
        var alreadyExists = userRepository.findByEmail(req.email)
        if(alreadyExists != null) {

            throw ConflictException(ErrorResponseBody("User with this email address already exists!"))
        }
        var user = userRepository.save(User(id=0,email=req.email, password=req.password))
        return Id(user.id)
    }
}