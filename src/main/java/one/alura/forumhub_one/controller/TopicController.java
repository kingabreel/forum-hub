package one.alura.forumhub_one.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.alura.forumhub_one.domain.model.answers.Answer;
import one.alura.forumhub_one.domain.model.topic.Topic;
import one.alura.forumhub_one.domain.dto.topic.TopicData;
import one.alura.forumhub_one.domain.dto.topic.TopicDataList;
import one.alura.forumhub_one.domain.dto.topic.UpdateTopicData;
import one.alura.forumhub_one.domain.model.user.User;
import one.alura.forumhub_one.repository.UserRepository;
import one.alura.forumhub_one.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicController {

    @Autowired
    private TopicService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid Topic data, UriComponentsBuilder uriBuilder){
        User autor = (User) userRepository.findByLogin(data.getAutor().getLogin());

        if(autor == null){
            throw new UsernameNotFoundException("Usuário não encontrado:" + data.getAutor().getLogin());
        }

        data.setAutor(autor);
        data.setAutorName(autor.getLogin());

        var topic = new Topic(data);

        service.save(topic);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicData(data));
    }

    @GetMapping
    public ResponseEntity<Page<TopicDataList>> list(@PageableDefault(size = 10, sort = {"title"}) Pageable pagination) {
        var page = service.getAllTopics(pagination);

        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity getTopic(@PathVariable Long id){
        var topic = service.getTopic(id);

        return ResponseEntity.ok(topic);
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity createAnswer(@RequestBody Answer answer, @PathVariable Long id){
        service.saveAnswer(id, answer);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateTopicData data){
        Topic topic = service.update(data);

        return ResponseEntity.ok(new TopicData(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        service.deleteTopic(id);

        return ResponseEntity.noContent().build();
    }
}
