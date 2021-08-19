package phoneappli.people.gateway

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.WebSession
import reactor.core.publisher.Mono

@RestController
class TestController {
    @GetMapping(value = ["/token"])
    fun getHome(@RegisteredOAuth2AuthorizedClient authorizedClient: OAuth2AuthorizedClient): Mono<*>? {
        return Mono.just(authorizedClient.accessToken.tokenValue)
    }

    @GetMapping("/")
    fun index(session: WebSession): Mono<*>? {
        return Mono.just(session.id)
    }
}
