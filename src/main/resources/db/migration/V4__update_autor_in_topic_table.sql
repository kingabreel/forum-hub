ALTER TABLE topico ADD COLUMN autor_id BIGINT;

UPDATE topico t
    JOIN usuario u ON t.autor = u.login
    SET t.autor_id = u.id;

ALTER TABLE topico ADD CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES usuario(id);
