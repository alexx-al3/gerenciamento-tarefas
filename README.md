# gerenciamento-tarefas
aula de codigos com mais e outros brunchs


Desenvolver um sistema Java via console
• Criar plano de testes
• Implementar testes unitários
• Usar Git e GitHub
• Trabalhar com branchese versões
• Implementar backup e restore
• Documentar falhas e evolução do sistema

Vamos desenvolver uma aplicação em Java(console), criar e
registrar testes, plano e realizar a documentação completa.
• Testes 
• Git
• Backup 
• Versionamento 
• Manutenção de Sistemas

O sistema deverá possuir:
• Login 
• Cadastro de usuários 
• Cadastro de tarefas 
• Alteração de status 
• Relatórios simples

Passo a passo:
1. Criar o projeto Maven
2. Criar as classes iniciais (Usuários e Tarefas), com os atributos e 
métodos essenciais
3. Criar um menu interativo para uso da aplicação
System.out.println("1 - Cadastrar usuário"); 
System.out.println("2 - Login"); 
System.out.println("3 - Cadastrar tarefa"); 
System.out.println("0 - Sair")

Versionamento do sistema:
1. Crie umrepositório nogithub
2. Inicie o repositório nasua máquina local
3. Faça o envio do código criado, lembre-se de criar um
comentário adequado quereflita o queestá sendo enviado
Ex: git commit–m"feat:projetoinicial

Versionamento do sistema:
1. Crie asbranchsmainedevelop
2. Utilize a branch develop para modificare criar funcionalidades
3. Asalterações devemsermergeadasnabranch main
obs: a branch main serve apenas para receber as atualizações após o
enviocorreto para ogithub
Aula 20: Testes e Manutenção de Sistemas
7
Desenvolvimento
Sistema para gerenciamento de tarefas
Versionamento do sistema
Desenvolvimento: criação da aplicação e funcionalidades a partir de requisitos
↓
Testes: execução de testes manuais e automáticos (se houver necessidade)
↓
Deploy: envio do código para produção e disponibilização
↓
Monitoramento
↓
Correções
Aula 20: Testes e Manutenção de Sistemas
8
Testes
Casos de Teste
ID
Cenário
Resultado Esperado
CT01
CT02
CT03
...
Senha válida
Senha curta
Campo vazio
Cadastro realizado
Exibir erro
Validar campo
Aula 20: Testes e Manutenção de Sistemas
9
Testes
Registro de bugs
ID
Problema
Severidade
BUG01
...
Senha curta aceita
Alta
Aula 20: Testes e Manutenção de Sistemas
• criar casosde teste
• executarsistema
• identificar bugs
• documentardefeitos
10
Testes
Testes com JUnit
Especificar testes a partir dos cenários abaixo:
• Login
o Válido
o Inválido
o Vazio
• Tarefas
o Cadastrar
o Excluir
o duplicidade
• criar 5 testes unitários
• executartestes 
• corrigir falhas

Perfeito. Esse trabalho envolve desenvolvimento + testes + versionamento + documentação, então o ideal é montar um projeto bem organizado desde o início.

Minha sugestão é fazer um Sistema de Gerenciamento de Tarefas via Console em Java + Maven + JUnit + Git/GitHub, estruturado para atender exatamente os requisitos da aula.

Estrutura do projeto

Projeto Maven:

gerenciamento-tarefas/
│── src/
│   ├── main/
│   │   └── java/
│   │       ├── model/
│   │       │   ├── Usuario.java
│   │       │   └── Tarefa.java
│   │       ├── service/
│   │       │   ├── UsuarioService.java
│   │       │   └── TarefaService.java
│   │       ├── util/
│   │       │   └── BackupManager.java
│   │       └── Main.java
│   │
│   └── test/
│       └── java/
│           ├── UsuarioTest.java
│           └── TarefaTest.java
│
│── backup/
│── pom.xml
│── README.md
Funcionalidades obrigatórias
1. Login
Usuário entra com login e senha
Validar:
válido
inválido
vazio
2. Cadastro de usuários

Campos:

Nome
Login
Senha

Validações:

senha mínima
login duplicado
campo vazio
3. Cadastro de tarefas

Campos:

Título
Descrição
Status

Status:

PENDENTE
EM_ANDAMENTO
CONCLUIDA
4. Alteração de status

Exemplo:

Pendente → Em andamento → Concluída
5. Relatórios simples

Exibir:

Usuários cadastrados
Tarefas pendentes
Tarefas concluídas
Quantidade total
Menu do sistema

Seu menu pode ficar assim:

System.out.println("\n===== SISTEMA DE TAREFAS =====");
System.out.println("1 - Cadastrar usuário");
System.out.println("2 - Login");
System.out.println("3 - Cadastrar tarefa");
System.out.println("4 - Alterar status");
System.out.println("5 - Relatório");
System.out.println("6 - Backup");
System.out.println("7 - Restore");
System.out.println("0 - Sair");
Classes do sistema
Usuario

Atributos:

private String nome;
private String login;
private String senha;

Métodos:

login()
validarSenha()
Tarefa

Atributos:

private String titulo;
private String descricao;
private String status;

Métodos:

alterarStatus()
UsuarioService

Responsável por:

Cadastrar usuário
Login
Listar usuários
Validar duplicidade
TarefaService

Responsável por:

Cadastrar tarefa
Excluir tarefa
Alterar status
Gerar relatório
Plano de Testes

Tabela que você pode colocar no relatório:

ID	Cenário	Entrada	Resultado Esperado
CT01	Login válido	admin / 123456	Login realizado
CT02	Login inválido	admin / errado	Erro de login
CT03	Login vazio	""	Validar campo
CT04	Cadastro usuário	dados válidos	Usuário cadastrado
CT05	Senha curta	123	Exibir erro
CT06	Cadastro tarefa	dados válidos	Tarefa criada
CT07	Excluir tarefa	tarefa existente	Remover
CT08	Tarefa duplicada	mesmo nome	Exibir erro
Registro de Bugs

Modelo pronto:

ID	Problema	Severidade	Correção
BUG01	Senha curta aceita	Alta	Adicionada validação
BUG02	Login vazio permitido	Média	Campo obrigatório
BUG03	Tarefa duplicada	Média	Verificação criada
Testes Unitários (JUnit)

Você precisa de 5 testes unitários.

Sugestão:

UsuarioTest
Teste 1 — Login válido
@Test
void deveRealizarLoginComSucesso() {
    UsuarioService service = new UsuarioService();

    service.cadastrar("Alex", "alex", "123456");

    boolean resultado = service.login("alex", "123456");

    assertTrue(resultado);
}
Teste 2 — Login inválido
@Test
void naoDeveLogarComSenhaErrada() {
    UsuarioService service = new UsuarioService();

    service.cadastrar("Alex", "alex", "123456");

    boolean resultado = service.login("alex", "0000");

    assertFalse(resultado);
}
Teste 3 — Campo vazio
@Test
void naoDeveCadastrarCampoVazio() {
    UsuarioService service = new UsuarioService();

    Exception erro = assertThrows(
            IllegalArgumentException.class,
            () -> service.cadastrar("", "", "")
    );

    assertEquals("Campos obrigatórios", erro.getMessage());
}
TarefaTest
Teste 4 — Cadastro tarefa
@Test
void deveCadastrarTarefa() {
    TarefaService service = new TarefaService();

    service.cadastrar("Estudar Java", "JUnit");

    assertEquals(1, service.listar().size());
}
Teste 5 — Duplicidade
@Test
void naoDeveCadastrarTarefaDuplicada() {
    TarefaService service = new TarefaService();

    service.cadastrar("Estudar", "Java");

    Exception erro = assertThrows(
            IllegalArgumentException.class,
            () -> service.cadastrar("Estudar", "Java")
    );

    assertEquals("Tarefa já existe", erro.getMessage());
}
Dependência JUnit no Maven

No pom.xml:

<dependencies>

    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>

</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.2.5</version>
        </plugin>
    </plugins>
</build>

Rodar testes:

mvn test
Git e GitHub
Inicializar projeto
git init
Criar branch develop
git branch develop
git checkout develop
Primeiro commit
git add .
git commit -m "feat: projeto inicial do sistema"
Nova funcionalidade
git commit -m "feat: cadastro de usuarios"
git commit -m "feat: login do sistema"
git commit -m "feat: cadastro de tarefas"
git commit -m "test: implementacao de testes junit"
git commit -m "fix: correcao validacao login"
Merge para main
git checkout main
git merge develop
Enviar GitHub
git remote add origin URL_DO_REPOSITORIO
git push -u origin main
git push -u origin develop
Backup e Restore

Você pode fazer simples usando arquivo .txt.

Exemplo:

usuarios.txt
tarefas.txt

Backup:

salva usuários e tarefas

Restore:

lê arquivos e recupera dados

Isso atende o requisito da disciplina.

Documentação da evolução do sistema

Exemplo para relatório:

Versão 1.0
Cadastro de usuários
Login
Versão 1.1
Cadastro de tarefas
Alteração de status
Versão 1.2
Testes JUnit
Correções de bugs
Versão 1.3
Backup e Restore

Recomendo fazermos isso em etapas:

Criar projeto Maven
Fazer as classes (Usuario e Tarefa)
Criar menu console
Implementar login
Implementar tarefas
Adicionar testes JUnit
Git/GitHub
Backup/restore
Plano de testes + documentação

