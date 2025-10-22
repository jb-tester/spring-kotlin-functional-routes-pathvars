package com.mytests.spring.springkotlinfunctionalroutespathvars

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@Configuration
class SameClassHandlerRouterConfiguration {
    @Bean
    fun myRouter(
    ) = router {
        // correct case:
        GET(pattern = "/test8/{pv8}", f = ::processTest8)  // ok
        // not matching path var names in url and handler:
        GET(pattern = "/test9/{pv9}", f = ::processTest9) // ok
        // missing path var in handler:
        GET(pattern = "/test9/{pv10}", f = ::processTest10) // ok
        // handler consumes path variable that is missing in endpoint url:
        GET(pattern = "/test9", f = ::processTest11) // ok
    }

    fun processTest8(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test8 with path var = ${it.pathVariable("pv8")}")
    }

    fun processTest9(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test9 with path var = ${it.pathVariable("pv99")}")
    }

    fun processTest10(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test10")
    }

    fun processTest11(it: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("test11 with path var = ${it.pathVariable("pv11")}")
    }
}