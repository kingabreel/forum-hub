package one.alura.forumhub_one.domain.dto.topic;

import one.alura.forumhub_one.domain.dto.answer.AnswerData;
import one.alura.forumhub_one.domain.model.answers.Answer;
import one.alura.forumhub_one.domain.model.topic.Topic;

import java.util.List;
import java.util.stream.Collectors;

public class TopicDataList  {
    private Long id;
    private String title;
    private String message;
    private String topicState;
    private String autor;
    private String course;
    private List<AnswerData> answers;

    public TopicDataList(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.topicState = topic.getTopicState();
        this.autor = topic.getAutor().getLogin();
        this.course = topic.getCourse();
        this.answers= topic.getAnswers().stream()
                .map(AnswerData::new)
                .collect(Collectors.toList());
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getTopicState() { return topicState; }
    public String getAutor() { return autor; }
    public String getCourse() { return course; }
    public List<AnswerData> getAnswers() { return answers; }
}
