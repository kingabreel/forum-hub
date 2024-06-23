package one.alura.forumhub_one.service;

import one.alura.forumhub_one.domain.model.user.User;
import one.alura.forumhub_one.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void create(User data){
        String passwordEncoded = passwordEncoder.encode(data.getPassword());
        data.setPassword(passwordEncoded);

        repository.save(data);
    }
}
