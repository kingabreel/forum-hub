package one.alura.forumhub_one.controller;

import jakarta.validation.Valid;
import one.alura.forumhub_one.domain.model.user.User;
import one.alura.forumhub_one.domain.dto.user.UserData;
import one.alura.forumhub_one.domain.dto.token.JwtData;
import one.alura.forumhub_one.infra.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserData data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        System.out.println(data.login() + " + " + data.password());

        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.newToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtData(tokenJWT));

    }
}
