package one.alura.forumhub_one.repository;

import one.alura.forumhub_one.domain.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAllByOrderByTitleAsc(Pageable pagination);
}
