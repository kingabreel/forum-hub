package one.alura.forumhub_one.domain.model.topic;

import jakarta.persistence.*;
import lombok.*;
import one.alura.forumhub_one.domain.model.answers.Answer;
import one.alura.forumhub_one.domain.model.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topico")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Topic{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "titulo", nullable = false, length = 250)
        private String title;

        @Column(name = "mensagem", nullable = false, length = 350)
        private String message;

        @Column(name = "data_criacao", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime creationDate;

        @Column(name = "estado_topico", nullable = false, columnDefinition = "ENUM('ativo', 'inativo', 'fechado')")
        private String topicState;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "autor_id", nullable = false)
        private User autor;

        @Column(name = "curso", nullable = false, length = 100)
        private String course;

        @Column(name = "autor", nullable = false, length = 100)
        private String autorName;

        @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Answer> answers;

    public Topic(Topic data) {
        this.id = data.getId();
        this.title = data.getTitle();
        this.message = data.getMessage();
        this.creationDate = LocalDateTime.now();
        this.topicState = data.getTopicState();
        this.autor = data.autor;
        this.course = data.course;
        this.answers = data.getAnswers();
    }
}
