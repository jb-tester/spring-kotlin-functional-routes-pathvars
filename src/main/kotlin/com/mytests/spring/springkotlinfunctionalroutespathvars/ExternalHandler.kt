package com.mytests.spring.springkotlinfunctionalroutespathvars

import org.springframework.stereotype.Service
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse

@Service
class ExternalHandler {
    fun processTest4(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test4 with path var = ${it.pathVariable("pv4")}")}
    fun processTest5(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test5 with path var = ${it.pathVariable("pv55")}")} // no error but should be
    fun processTest6(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test6")}
    fun processTest7(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test7 with path var = ${it.pathVariable("pv7")}")} // no error but should be

}