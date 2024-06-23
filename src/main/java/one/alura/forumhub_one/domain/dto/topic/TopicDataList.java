package one.alura.forumhub_one.domain.dto.topic;

import one.alura.forumhub_one.domain.model.topic.Topic;

public record TopicDataList (Long id, String title, String message, String topicState, String autor, String course) {
    public TopicDataList(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getTopicState(), topic.getAutor(), topic.getCourse());
    }
}
