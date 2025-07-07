ALTER TABLE `user_login`
    MODIFY COLUMN `id` BIGINT AUTO_INCREMENT NOT NULL;

-- Adiciona nova coluna `nome`
ALTER TABLE `user_login`
    ADD COLUMN `name` VARCHAR(100) NOT NULL AFTER `id`;

-- Modifica a coluna `role` para ENUM
ALTER TABLE `user_login`
    MODIFY COLUMN `role` ENUM('ADMIN', 'USER', 'VISIT') NOT NULL;

-- Adiciona a coluna `ativo` com valor padrão TRUE
ALTER TABLE `user_login`
    ADD COLUMN `active` BOOLEAN NOT NULL DEFAULT TRUE AFTER `role`;

-- Adiciona a coluna `data_criacao` com timestamp atual por padrão
ALTER TABLE `user_login`
    ADD COLUMN `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP AFTER `active`;

-- Adiciona a coluna `data_atualizacao` com update automático
ALTER TABLE `user_login`
    ADD COLUMN `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP AFTER `created_at`;
