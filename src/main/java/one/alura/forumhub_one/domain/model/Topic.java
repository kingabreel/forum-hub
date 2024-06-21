package one.alura.forumhub_one.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public record Topic(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @Column(nullable = false, length = 250)
        String title,

        @Column(nullable = false, length = 350)
        String mensage,

        @Column(name = "data_criacao", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        LocalDateTime creationDate,

        @Column(name = "estado_topico", nullable = false, columnDefinition = "ENUM('ativo', 'inativo', 'fechado')")
        String topicState,

        @Column(nullable = false, length = 100)
        String autor,

        @Column(nullable = false, length = 100)
        String course
        ) {
    public Topic(String title, String message, String topicState, String autor, String course) {
        this(null, title, message, LocalDateTime.now(), topicState, autor, course);
    }
}
