package one.alura.forumhub_one.domain.dto.answer;

import one.alura.forumhub_one.domain.model.answers.Answer;

public class AnswerData {
    private Long id;
    private String message;
    private String autor;

    public AnswerData(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.autor = answer.getAutor().getLogin();
    }

    public Long getId() { return id; }
    public String getMessage() { return message; }
    public String getAutor() { return autor; }
}

