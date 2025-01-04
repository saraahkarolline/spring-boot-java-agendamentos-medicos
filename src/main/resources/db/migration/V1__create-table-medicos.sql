CREATE TABLE medicos (
    id BIGSERIAL PRIMARY KEY,    
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL unique,
    crm VARCHAR(6) NOT NULL unique,
    especialidade VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    uf VARCHAR(2) NOT NULL,
    cidade VARCHAR(100) NOT NULL

);