package one.alura.forumhub_one.service;

import one.alura.forumhub_one.domain.model.topic.Topic;
import one.alura.forumhub_one.domain.dto.topic.TopicDataList;
import one.alura.forumhub_one.domain.dto.topic.UpdateTopicData;
import one.alura.forumhub_one.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository repository;

    public void save(Topic topic) {
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

    public Topic getTopic(Long id) {
        return repository.getReferenceById(id);
    }
}
