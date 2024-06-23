CREATE TABLE respostas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem VARCHAR(350) NOT NULL,
    autor_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (topic_id) REFERENCES topico(id)
);
