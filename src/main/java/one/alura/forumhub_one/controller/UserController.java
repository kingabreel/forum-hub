package one.alura.forumhub_one.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.alura.forumhub_one.domain.model.user.User;
import one.alura.forumhub_one.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid User data){
        System.out.println("ok");
        userService.create(data);

        return ResponseEntity.ok().build();
    }
}
