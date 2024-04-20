# Catalog

Este é um projeto Spring Boot em Kotlin que demonstra a organização em camadas e implementa um sistema de catálogo.

### Entidades

#### User
- id: Long
- firstName: String
- lastName: String
- email: String
- password: String
- roles: List<Role>

#### Role
- id: Long
- authority: String

#### Product
- id: Long
- name: String
- description: String
- price: Double
- imgURL: String
- category: Category

#### Category
- id: Long
- name: String
- products: List<Product>

### Relacionamentos

- User 1-* Role
- Product *-1 Category


## Funcionalidades

- [x] Criar projeto Spring Boot - Kotlin
- [x] Organizar o projeto em camadas
- [x] Controlador REST
- [x] Serviço
- [x] Acesso a dados (Repository)
- [x] Criar entidades
- [X] Configurar perfil de teste do projeto
- [ ] Seeding da base de dados
- [ ] Criar web services REST
- [X] Parâmetros de rota @PathVariable
- [X] Parâmetros de requisição @RequestParam
- [X] Corpo de requisição @RequestBody
- [X] Resposta da requisição ResponseEntity<T>
- [X] Padrão DTO
- [X] CRUD completo
- [X] Tratamento de exceções
- [X] Postman (coleções, ambientes)
- [X] Dados de auditoria
- [X] Paginação de dados
- [X] Associações entre entidades (N-N)

## Dependências

- Spring Boot 3.2.4
- Kotlin 1.9.23
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Jackson Module Kotlin
- Kotlin Reflect
- Kotlin Stdlib
- H2 Database (runtime)
- PostgreSQL (runtime)
- Spring Boot Starter Test (scope test)

## Kanban

### Kanban principal

| A Fazer                    | Em Progresso                      | Concluído |
|----------------------------|-----------------------------------|-----------|
|                            |                                   | Crud      |
|                            | Testes Automatizados              |           |
| Validação e Segurança      |                                   |           |
| ORM                        |                                   |           | 
| Consulta ao Banco de Dados |                                   |           |
| Docker                     |                                   |           |
| Implantação CL/CD          |                                   |           |

### Kanban crud

| A Fazer                                              | Em Progresso | Concluído                                            |
|------------------------------------------------------|--------------|------------------------------------------------------|
|                                                      |              | Criação do projeto                                   |
|                                                      |              | Modelagem da Classe Category                         |
|                                                      |              | Modelagem da Classe Reource Category                 |
|                                                      |              | Testes no Banco H2                                   | 
|                                                      |              | Modelagem de transação no JPA                        |
|                                                      |              | _Seeding_ na base de dados                           |
|                                                      |              | Modelagem do DTO                                     |
|                                                      |              | Criação de ambiente no PostMan                       |
|                                                      |              | Implementar busca por ID                             |
|                                                      |              | Tratar excessões                                     |
|                                                      |              | Adicionar método POST                                |
|                                                      |              | Adicionar método PUT                                 |
|                                                      |              | Adicionar método DELETE                              |
|                                                      |              | Adicionar entidades para autitoria                   |
|                                                      |              | Adicionar Paginação                                  |
|                                                      |              | Criar Entidade Product                               |
|                                                      |              | Criar o mapeamento do JPA/N-N                        |
|                                                      |              | Criar o DTO do Product                               |
|                                                      |              | Adionar dos outros objetos relacionados ao Product   |
| Adicionar metodos insert, update e delete do product |              | Adicionar metodos insert, update e delete do product |

### Kanban de Testes Automatizados

| A Fazer                                                           | Em Progresso                                                                                                               | Concluído                                                                   |
|-------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
|                                                                   |                                                                                                                            | Primeiro teste na prática com JUnit                                         |
|                                                                   |                                                                                                                            | Teste deposito não deve fazer nada quando quantia for negativa              |
|                                                                   | I                                                                                                                          | mplementar padrão de projeto Factory                                        |
|                                                                   |                                                                                                                            | Teste saque total deve limpar saldo e retornar todo saldo                   |
|                                                                   |                                                                                                                            | Testes para método withdraw                                                 |
|                                                                   |                                                                                                                            | Refatoração no Pageable                                                     |
|                                                                   |                                                                                                                            | Primeiro teste de repository                                                |
|                                                                   |                                                                                                                            | Teste cenários do delete                                                    |
|                                                                   |                                                                                                                            | Implementar Fixtures no JUnit, BeforeEach                                   |
|                                                                   |                                                                                                                            | Teste save com id nulo                                                      |
|                                                                   | Começando testes de ProductService, Mockito vs MockBean                                                                    |                                                                             |
| Primeiro teste, simulando comportamento com Mockito               |                                                                                                                            |                                                                             |
| Imports estáticos do Mockito                                      |                                                                                                                            |                                                                             |
| Teste delete lança ResourceNotFoundException quando id não existe |                                                                                                                            |                                                                             |
| Teste delete lança DatabaseException quando id dependente         |                                                                                                                            |                                                                             |
| Simular comportamentos diversos com Mockito                       |                                                                                                                            |                                                                             |
| Testando findAllPaged do ProductService                           |                                                                                                                            |                                                                             |
| Testes na camada web - Legibilidade e negociação de conteúdo      |                                                                                                                            |                                                                             |
| Testando o findById                                               |                                                                                                                            |                                                                             |
| Testando o update                                                 |                                                                                                                            |                                                                             |
| Simulando outros comportamentos do ProductService                 |                                                                                                                            |                                                                             |
| Testes na camada web - Teste de integração                        |                                                                                                                            |                                                                             |
| Teste de integração para findAllPaged                             |                                                                                                                            |                                                                             |
| Teste de integração na camada web findAll                         |                                                                                                                            |                                                                             |
| Teste de integração na camada web update                          |                                                                                                                            |                                                                             |

### Kanban de Validações e segurança

| A Fazer                                                                                               | Em Progresso | Concluído |
|-------------------------------------------------------------------------------------------------------|--------------|-----------|
| Implementando entidades User e Role                                                                   |              |           |
| Mapeamentos objeto-relacional, seed do banco                                                          |              |           |
| Criação do CRUD de usuários                                                                           |              |           |
| Implementação do Bean Validation                                                                      |              |           |
| Testando anotações básicas                                                                            |              |           |
| Tratando exceção MethodArgumentNotValidException                                                      |              |           |
| Adição de resposta customizada para erro de validação                                                 |              |           |
| Implementando um ConstraintValidator customizado                                                      |              |           |
| Implementação do UserUpdateValidator                                                                  |              |           |
| Implementação de Token JWT, autenticação e autorização                                                |              |           |
| Implementação de OAuth2                                                                               |              |           |
| Implementação do processo de login                                                                    |              |           |
| Implementação do checklist do Spring Security                                                         |              |           |
| Implementação do OAuth2 authorization server                                                          |              |           |
| Externalizar configuração, variáveis de ambiente                                                      |              |           |
| Adicionar informações ao token                                                                        |              |           |
| Implementação do OAuth2 resource server                                                               |              |           |
| Implementação da configuração especial para o banco H2                                                |              |           |

### Kanban de ORM

| A Fazer                                                                                               | Em Progresso | Concluído |
|-------------------------------------------------------------------------------------------------------|--------------|-----------|
| Implementando entidades User e Role                                                                   |              |           |
| Mapeamentos objeto-relacional, seed do banco                                                          |              |           |
| Criação do CRUD de usuários PARTE 1                                                                   |              |           |
| Implementação do Bean Validation                                                                      |              |           |
| Testando anotações básicas                                                                            |              |           |
| Tratando exceção MethodArgumentNotValidException                                                      |              |           |
| Adição de resposta customizada para erro de validação                                                 |              |           |
| Implementando um ConstraintValidator customizado                                                      |              |           |
| Implementação do UserUpdateValidator                                                                  |              |           |
| Implementação de Token JWT, autenticação e autorização                                                |              |           |
| Implementação de OAuth2                                                                               |              |           |
| Implementação do processo de login                                                                    |              |           |
| Implementação do checklist do Spring Security                                                         |              |           |
| Implementação do OAuth2 authorization server                                                          |              |           |
| Externalizar configuração, variáveis de ambiente                                                      |              |           |
| Adicionar informações ao token                                                                        |              |           |
| Implementação do OAuth2 resource server                                                               |              |           |
| Implementação da configuração especial para o banco H2                                                |              |           |
| Implementar User, Role                                                                                |              |           |
| Implementar Course                                                                                    |              |           |
| Implementar Offer                                                                                     |              |           |
| Implementar Resource                                                                                  |              |           |
| Implementar Section                                                                                   |              |           |
| Implementar Enrollment, EnrollmentPK                                                                  |              |           |
| Implementar Enrollment seed                                                                           |              |           |
| Implementar Offer sem timezone                                                                        |              |           |
| Implementar Lesson, Content, Task                                                                     |              |           |
| Implementar Lesson seed                                                                               |              |           |
| Fazer correções adicionais no código                                                                  |              |           |
| Preparando para a segunda parte do capítulo - autorizações                                            |              |           |
| Criando os repositories                                                                               |              |           |
| Incluir exceções, validação e segurança ao projeto                                                    |              |           |
| Implementar busca de usuário por id                                                                   |              |           |
| Implementar autorização customizada em nível de serviço                                               |              |           |
| Implementar conteúdo customizado para usuário logado                                                  |              |           |
| Implementar Refresh token                                                                             |              |           |
| Implementar Pré-autorizando métodos por perfil de usuário                                             |              |           |

### Kanban Consulta ao Banco de Dados

| A Fazer                                                                                               | Em Progresso | Concluído |
|-------------------------------------------------------------------------------------------------------|--------------|-----------|
| Implementar Query methods                                                                             |              |           |
| Resolver problema N+1 consultas com Spring Data JPA                                                   |              |           |
| Filtrar produtos, INNER JOIN, IN                                                                      |              |           |
| Filtrar produtos, DISTINCT, IS NULL                                                                   |              |           |
| Filtrar produto, FNC, LIKE, LOWER, CONCAT, Trim                                                       |              |           |
| Filtrar produtos, COALESCE, List                                                                      |              |           |
| Resolver o problema N mais 1 consultas                                                                |              |           |

### Kanban Implantação

| A Fazer                                                                                               | Em Progresso | Concluído |
|-------------------------------------------------------------------------------------------------------|--------------|-----------|
| Implementar Imagem, container, registry                                                               |              |           |
| Implementar Docker ps, images, pull, start, stop                                                      |              |           |
| Implementar Instancia de um container Postgres                                                        |              |           |
| Criar arquivo Dockerfile                                                                              |              |           |
| Analisar volumes no Docker                                                                            |              |           |
| Enviar imagens para o DockerHub                                                                       |              |           |
| Começar a implantação manual                                                                          |              |           |
| Criar Perfis de projeto, variáveis de ambiente                                                        |              |           |
| Gerar imagem com Dockerfile                                                                           |              |           |
| Instanciar um container no modo dev                                                                   |              |           |
| Criar cadastro na Amazon AWS e usuário IAM                                                            |              |           |
| Criar instância EC2                                                                                   |              |           |
| Acessar instância EC2 via SSH e instalar Docker                                                       |              |           |
| Criar base de dados no Amazon RDS                                                                     |              |           |
| Conectar e instanciar a base de dados                                                                 |              |           |
| Instanciar um container para conectar ao banco do RDS                                                 |              |           |
| Instanciar o container no EC2                                                                         |              |           |
| Implementar CI CD na AWS com Github Actions                                                           |              |           |
| Criar conexão e Cloud Shell                                                                           |              |           |
| Criar Rede                                                                                            |              |           |
| Criar Banco de dados RDS                                                                              |              |           |
| Implementar a administração do banco de dados                                                         |              |           |
| Implementar aplicação Elastic Beanstalk e bucket S3                                                   |              |           |
| Enviar build zero para nuvem                                                                          |              |           |
| Implementar build zero no Elastic Beanstalk                                                           |              |           |
| Criar environment no Elastic Beanstalk                                                                |              |           |
| Configurar variáveis de ambiente adicionais                                                           |              |           |
| Configurar environment secrets no Github                                                              |              |           |
| Incluir pipeline Github Actions                                                                       |              |           |
| Exterminar os recursos da AWS                                                                         |              |           |
| A Fazer                                                                                              | Em Progresso | Concluído |
|------------------------------------------------------------------------------------------------------|--------------|-----------|
| Implementar Imagem, container, registry                                                             |              |           |
| Implementar Docker ps, images, pull, start, stop                                                    |              |           |
| Implementar Instancia de um container Postgres                                                       |              |           |
| Criar arquivo Dockerfile                                                                             |              |           |
| Analisar volumes no Docker                                                                           |              |           |
| Enviar imagens para o DockerHub                                                                     |              |           |
| Começar a implantação manual                                                                        |              |           |
| Criar Perfis de projeto, variáveis de ambiente                                                      |              |           |
| Gerar imagem com Dockerfile                                                                         |              |           |
| Instanciar um container no modo dev                                                                 |              |           |
| Criar cadastro na Amazon AWS e usuário IAM                                                          |              |           |
| Criar instância EC2                                                                                  |              |           |
| Acessar instância EC2 via SSH e instalar Docker                                                      |              |           |
| Criar base de dados no Amazon RDS                                                                   |              |           |
| Conectar e instanciar a base de dados                                                               |              |           |
| Instanciar um container para conectar ao banco do RDS                                                |              |           |
| Instanciar o container no EC2                                                                       |              |           |
| Implementar CI CD na AWS com Github Actions                                                         |              |           |
| Criar conexão e Cloud Shell                                                                         |              |           |
| Criar Rede                                                                                          |              |           |
| Criar Banco de dados RDS                                                                            |              |           |
| Implementar a administração do banco de dados                                                       |              |           |
| Implementar aplicação Elastic Beanstalk e bucket S3                                                  |              |           |
| Enviar build zero para nuvem                                                                        |              |           |
| Implementar build zero no Elastic Beanstalk                                                          |              |           |
| Criar environment no Elastic Beanstalk                                                               |              |           |
| Configurar variáveis de ambiente adicionais                                                         |              |           |
| Configurar environment secrets no Github                                                            |              |           |
| Incluir pipeline Github Actions                                                                     |              |           |
| Exterminar os recursos da AWS                                                                       |              |           |

