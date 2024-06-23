package one.alura.forumhub_one.domain.model;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicData(
        @NotNull
        Long id,
        String title,
        String message,
        String topicState
) {}
