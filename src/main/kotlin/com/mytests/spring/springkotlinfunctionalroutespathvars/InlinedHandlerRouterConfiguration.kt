package com.mytests.spring.springkotlinfunctionalroutespathvars

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@Configuration
class InlinedHandlerRouterConfiguration {
    @Bean
    fun myRouter(
    ) = router {
        GET("/test0/{pv0}") { ServerResponse.ok().body("test0 with  ${it.pathVariable("pv0")}") } // ok
        GET("/test1/{pv1}") { ServerResponse.ok().body("test1 with  ${it.pathVariable("pv11")}") } // ok
        GET("/test2/{pv2}") { ServerResponse.ok().body("test2") } // ok
        GET("/test3") { ServerResponse.ok().body("test0 with  ${it.pathVariable("pv3")}") } // ok
    }
}