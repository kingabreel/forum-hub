package one.alura.forumhub_one.service;

import one.alura.forumhub_one.domain.dto.topic.TopicData;
import one.alura.forumhub_one.domain.dto.user.UserData;
import one.alura.forumhub_one.domain.model.answers.Answer;
import one.alura.forumhub_one.domain.model.topic.Topic;
import one.alura.forumhub_one.domain.dto.topic.TopicDataList;
import one.alura.forumhub_one.domain.dto.topic.UpdateTopicData;
import one.alura.forumhub_one.domain.model.user.User;
import one.alura.forumhub_one.repository.AnswerRepository;
import one.alura.forumhub_one.repository.TopicRepository;
import one.alura.forumhub_one.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public void save(Topic topic) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        var user = userRepository.findByLogin(userDetails.getUsername());

        topic.setAutor((User) user);
        topic.setAutorName(((User) user).getLogin());

        repository.save(topic);
    }

    public Topic update(UpdateTopicData data) {
        var topic = repository.getReferenceById(data.id());

        if (data.title() != null) topic.setTitle(data.title());
        if (data.message() != null) topic.setMessage(data.message());
        if (data.topicState() != null) topic.setTopicState(data.topicState());

        return topic;
    }

    public Page<TopicDataList> getAllTopics(Pageable pagination) {
        var page = repository.findAllByOrderByTitleAsc(pagination).map(TopicDataList::new);

        return page;
    }

    public void deleteTopic(Long id) {
        repository.deleteById(id);
    }

    public TopicData getTopic(Long id) {
        return TopicData.fromDB(repository.getReferenceById(id));
    }

    public void saveAnswer(Long id, Answer answer) {
        Topic topic = repository.getReferenceById(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        var user = userRepository.findByLogin(userDetails.getUsername());

        answer.setAutor((User) user);

        answer.setTopic(topic);

        answerRepository.save(answer);
    }
}
