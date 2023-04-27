package br.projto.demo.controller

import br.projto.demo.Greeting
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
// facilitar o recurso RESTFull com SPRING
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(): Greeting{
        return Greeting(counter.incrementAndGet(), "Hello Kotlin")
    }

    @RequestMapping("/greeting-mapping")
    fun greetingWithMapping(@RequestParam(value="name", defaultValue = "World") name: String?): Greeting {
        return Greeting(counter.incrementAndGet(), "hello $name")
    }
}