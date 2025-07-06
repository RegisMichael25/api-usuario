INSERT INTO `user_login` (`nome`, `login`, `password`, `role`)
VALUES
    ('Administrador', 'admin@example.com', '$2a$10$Dow1wDgf6iFbTT3VryS5wOxv3euqZ0kYAtZ7NRIJzXzn0uUtb1ZFi', 'ADMIN'),
    ('Usuário Comum', 'user@example.com', '$2a$10$Dow1wDgf6iFbTT3VryS5wOxv3euqZ0kYAtZ7NRIJzXzn0uUtb1ZFi', 'USER'),
    ('Visitante', 'visit@example.com', '$2a$10$Dow1wDgf6iFbTT3VryS5wOxv3euqZ0kYAtZ7NRIJzXzn0uUtb1ZFi', 'VISIT');
