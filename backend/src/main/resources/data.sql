INSERT INTO users (id, email, password, role) VALUES ('f648b5f1-91e2-4818-b99e-81d431ae1263', 'admin@admin.com', 'admin', 1);
INSERT INTO users (id, email, password, role) VALUES ('830f5b41-915c-4839-acf0-e5964ab92e0f', 'user@user.com', 'user', 0);

INSERT INTO tasks (id, title, description, priority, status, due_date, user_id) VALUES (RANDOM_UUID(), 'Comprar mantimentos', 'Comprar leite, ovos e pão no supermercado', 'MEDIUM', 'PENDING', TIMESTAMP '2025-12-18 10:00:00', 'f648b5f1-91e2-4818-b99e-81d431ae1263');
INSERT INTO tasks (id, title, description, priority, status, due_date, user_id) VALUES (RANDOM_UUID(), 'Reunião de equipe', 'Participar da reunião semanal do projeto', 'MEDIUM', 'PENDING', TIMESTAMP '2025-12-19 09:00:00', '830f5b41-915c-4839-acf0-e5964ab92e0f');
