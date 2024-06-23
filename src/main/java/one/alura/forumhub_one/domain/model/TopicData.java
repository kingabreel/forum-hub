package one.alura.forumhub_one.domain.model;

import java.time.LocalDateTime;

public record TopicData (Long id, String title, String message, LocalDateTime creationDate, String topicState, String autor, String course){
    public TopicData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getTopicState(), topic.getAutor(), topic.getCourse());
    }
}
