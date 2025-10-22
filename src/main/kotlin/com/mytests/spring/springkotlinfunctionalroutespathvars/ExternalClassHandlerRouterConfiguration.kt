package com.mytests.spring.springkotlinfunctionalroutespathvars

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.router

@Configuration
class ExternalClassHandlerRouterConfiguration(val extHandler: ExternalHandler) {
    @Bean
    fun myRouter() = router {
        // correct case:
        GET(pattern = "/test4/{pv4}", f = extHandler::processTest4)
        // not matching path var names in url and handler:
        GET(pattern = "/test5/{pv5}", f = extHandler::processTest5) // warning here is ok, but there is no error in handler
        // missing path var in handler:
        GET(pattern = "/test6/{pv6}", f = extHandler::processTest6) // warning here is ok
        // handler consumes path variable that is missing in endpoint url:
        GET(pattern = "/test7", f = extHandler::processTest7) // error should be shown in handler, but isn't
    }
}