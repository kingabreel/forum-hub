package one.alura.forumhub_one.repository;

import one.alura.forumhub_one.domain.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
