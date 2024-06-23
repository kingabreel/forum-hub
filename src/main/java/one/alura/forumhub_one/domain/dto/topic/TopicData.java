package one.alura.forumhub_one.domain.dto.topic;

import one.alura.forumhub_one.domain.dto.answer.AnswerData;
import one.alura.forumhub_one.domain.model.answers.Answer;
import one.alura.forumhub_one.domain.model.topic.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record TopicData (
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String topicState,
        String autor,
        String course,
        List<AnswerData> answers
) {
    public TopicData(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getTopicState(),
                topic.getAutor().getLogin(),
                topic.getCourse(),
                topic.getAnswers().stream().map(AnswerData::new).collect(Collectors.toList())
        );
    }

    public static TopicData fromDB(Topic topic) {
        return new TopicData(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getTopicState(),
                topic.getAutor().getLogin(),
                topic.getCourse(),
                topic.getAnswers().stream().map(AnswerData::new).collect(Collectors.toList())
        );
    }
}

