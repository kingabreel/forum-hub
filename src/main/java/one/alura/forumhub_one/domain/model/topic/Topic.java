package one.alura.forumhub_one.domain.model.topic;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

        @Column(nullable = false, length = 100)
        private String autor;

        @Column(name = "curso", nullable = false, length = 100)
        private String course;

    public Topic(Topic data) {
        this.title = data.getTitle();
        this.message = data.getMessage();
        this.creationDate = LocalDateTime.now();
        this.topicState = data.getTopicState();
        this.autor = data.autor;
        this.course = data.course;
    }
}
