# Sistema de Gerenciamento de Tarefas

Projeto desenvolvido em **Java (Console)** utilizando **Maven**, com foco em **Testes, Versionamento, Manutenção de Sistemas e Refatoração**, conforme os requisitos da disciplina.

---

## Objetivo do Projeto

Desenvolver uma aplicação Java para gerenciamento de tarefas contendo:

- Cadastro de usuários
- Login
- Cadastro de tarefas
- Alteração de status
- Relatórios simples
- Testes unitários com JUnit
- Tratamento de erros e Exceptions
- Versionamento com Git/GitHub
- Refatoração do código

---

## Tecnologias Utilizadas

- Java 20
- Maven
- JUnit 5
- Git
- GitHub
- VS Code

---

## Estrutura do Projeto

```txt
gerenciamento-tarefas
│── pom.xml
│── README.md
│
└── src
    ├── main
    │   └── java
    │       ├── Main.java
    │       │
    │       ├── model
    │       │   ├── Usuario.java
    │       │   ├── Tarefa.java
    │       │   ├── StatusTarefa.java
    │       │   └── Login.java
    │       │
    │       ├── service
    │       │   ├── UsuarioService.java
    │       │   ├── TarefaService.java
    │       │   └── LoginService.java
    │       │
    │       ├── exception
    │       │   ├── CampoInvalidoException.java
    │       │   ├── UsuarioDuplicadoException.java
    │       │   ├── TarefaDuplicadaException.java
    │       │   └── TarefaNaoEncontradaException.java
    │       │
    │       └── util
    │           └── BackupManager.java
    │
    └── test
        └── java
            ├── UsuarioTest.java
            └── TarefaTest.java
```

---

## Funcionalidades

### Cadastro de Usuário
Permite cadastrar novos usuários no sistema.

**Validações:**
- Campos obrigatórios
- Login não duplicado
- Senha mínima de 4 caracteres

---

### Login
Permite autenticação de usuários.

**Cenários:**
- Login válido
- Login inválido
- Campo vazio

---

### Cadastro de Tarefas
Permite cadastrar tarefas com:

- Título
- Descrição
- Status inicial (`PENDENTE`)

**Validações:**
- Campos obrigatórios
- Tarefa duplicada não permitida

---

### Alteração de Status
Permite alterar status da tarefa para:

- `PENDENTE`
- `EM_ANDAMENTO`
- `CONCLUIDA`

---

### Relatório
Exibe todas as tarefas cadastradas contendo:

- Título
- Descrição
- Status

---

### Exclusão de Tarefa
Permite remover uma tarefa cadastrada.

---

## Tratamento de Erros

O sistema possui tratamento de exceções personalizadas para evitar falhas durante a execução.

### Exceptions Implementadas

| Exception | Finalidade |
|-----------|-------------|
| CampoInvalidoException | Campos vazios ou inválidos |
| UsuarioDuplicadoException | Login já cadastrado |
| TarefaDuplicadaException | Cadastro duplicado |
| TarefaNaoEncontradaException | Busca de tarefa inexistente |

---

## Casos de Teste

| ID | Cenário | Resultado Esperado |
|----|----------|--------------------|
| CT01 | Login válido | Login realizado |
| CT02 | Login inválido | Exibir erro |
| CT03 | Login vazio | Login negado |
| CT04 | Cadastro de tarefa | Tarefa criada |
| CT05 | Tarefa duplicada | Bloquear cadastro |

---

## Testes Unitários (JUnit)

O projeto contém **5 testes unitários** implementados.

### UsuarioTest

- `testeLoginValido()`
- `testeLoginInvalido()`
- `testeLoginVazio()`

### TarefaTest

- `testeCadastrarTarefa()`
- `testeDuplicidadeTarefa()`

---

## Registro de Bugs

| ID | Problema | Severidade | Status |
|----|-----------|------------|--------|
| BUG01 | Classe `Tarefa.Java` não compilava | Alta | Corrigido |
| BUG02 | Import `model.Tarefa` não resolvido | Alta | Corrigido |

---

## Refatoração Aplicada

Foram realizadas melhorias no código visando manutenção e legibilidade:

- Separação de responsabilidades
- Redução de código duplicado
- Criação de métodos privados
- Refatoração do `Main`
- Melhor organização do `switch-case`
- Implementação de Exceptions customizadas
- Tratamento de entradas inválidas

---

## Como Executar o Projeto

### Executar aplicação

Execute a classe:

```txt
Main.java
```

---

### Executar Testes

No VS Code:

1. Abrir `src/test/java`
2. Executar os testes JUnit
3. Verificar se todos passam

Resultado esperado:

```txt
5 tests passed
```

---

## Versionamento Git

Fluxo utilizado:

```txt
main
└── develop
```

### Commits realizados

```bash
feat: projeto inicial
feat: cadastro de usuarios e login
feat: gerenciamento de tarefas
test: adiciona testes unitarios
refactor: simplifica main e separa responsabilidades
fix: corrige compilacao da classe tarefa
```

---

## Autor

Projeto desenvolvido para fins acadêmicos na disciplina de **Testes e Manutenção de Sistemas**.

**Aluno:** Alex Alves