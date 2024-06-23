package one.alura.forumhub_one.repository;

import one.alura.forumhub_one.domain.model.answers.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
