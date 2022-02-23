<p align="center">
    <h1 align="center">TASK MANAGER - CRUD EM JSF</h1>
    <br>
</p>

Esse projeto contém o desafio da ESIG proposto em Fevereiro de 2022.
A aplicação exemplo consiste em criar um simples gerenciador de tarefas
com as seguintes funcionalidades:
- Criar uma tarefa: Realizado
- Atualizar a tarefa: Realizado
- Remover a tarefa: Realizado
- Listar tarefas: Parcialmente realizado (A filtragem não foi implementada).

*A funcionalidade para alterar a situação tarefa de "em andamento" para "concluída" foi implementada.

ITENS UTILIZADOS
------------

a) Criar uma aplicação Java Web utilizando JavaServer Faces (JSF): Realziado
-Além da utilização do primefaces e outras bibliotecas para ajudar na organização do front-end, a aplicação teve como base principal 3 classes:
####Task.java:
Classe que contém todos os atributos relacionados ao objeto tarefa. Além dos getters and setters de uma das variáveis, também contém notações importantes
para sinalizar ao JPA/Hibernate que essa classe é o Model utilizado para criar as tabelas, onde um desses sinalizadores (@Entity, @Table, @Column) deixa a responsabilidade da chave primária
inteiramente para o banco de dados (@Id, @GeneratedValue).
####TaskDao.java
Camada de persistência (Date Access Object), utilizando o padrão de projeto Singleton, utilizando um administrador de entidade único para lidar com o banco de dados
e delineia cada uma das operações do CRUD, além de outras funções como public Task findTask(Long id) e public void setAsCompleted(Task task). Dessa é possível
que todos os dados possam ser manipulados de maneira mais segura.
####TaskMBean.java
Essa camada está entre os acessos da classe TaskDao e as interações do usuário com a tela. Nela definimos os comportamentos dos métodos utilizados no task.xhtml (interface do usuário).

b) Utilizar persistência em um banco de dados PostgreSQL: Realizado
Foi utilizado Postgress na configuração do Hibernate como mostrado no tópico "Database" na sessão Configuração.

###Itens opcionais:

c) Utilizar JPA: Realizado.
Foi utilizado Hibernate (uma das distribuições do JPA) para fazer a gestão dos objetos junto ao banco. Além das informações citadas no "Task.java", vemos que a classe 
HibernateUtil.java apresenta de maneira estática a fabricação de entidade de administração, entidade essa que é única em todo o sistema (padrão Singleton supracitado), com um
construtor privado para garantir que não exista outra instância no sistema afim de comprometer o bom funcionamento do banco de dados.



CONFIGURAÇÃO
-------------
### Database

Edite o arquivo `src/META-INF/presistence.xml` com conteúdo real de um banco.

``` 
 <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/NomeDoBanco" ></property>
 <property name="javax.persistence.jdbc.user" value="SeuUsuario" />
 <property name="javax.persistence.jdbc.password" value="SuaSenha" />
```
Para que isso, instale o Postgres e também o pgAdming4 para facilitar o manuseio do banco.
Vide sessão 3 da instalação.

INSTALAÇÃO
-------------
### 1 - Realizar o clone da aplicação.
Você deve copiar toda a aplicação para seu computador.
Utilizando o bash em um diretório, utilize o comando:
~~~
https://github.com/raulmss/taskManager.git
~~~

###2 - Postgress e pgAdmin4
Caso você não o tenha, basta acessar [https://www.postgresql.org/](https://www.postgresql.org/download/), selecionar o sistema operacional desejado e seguir o passos de instalação.
###3 - Instale a IDE Eclipse para Java EE.

-Caso você não o tenha, basta acessar [https://www.eclipse.org/](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers) e instalar a aplicação.
Assim que instalar a IDE, você deverá instalar o Apache 8.5 diretamente na ferramenta para utilizar o sistema.

-Para abrir o projeto, vá até file>import>Maven>Existing Maven Project>Selecione a posta na qual projeto se encontra>Finish.

-Dentro do Eclipse, siga o caminho:
Window > Preferencies > Server > Runtime Enviroments > Add > Apache > Apache Tomcat v8.5 > Next > Download and Install > Selecione jdk 1.8 no campo JRE > Finish
(Quando o arquivo estiver aberto na IDE, vá até a aba servers, botão direito sobre o Apache e certifique-se que o projeto está atribuido ao Tomcat8.5)
Pronto! O servidor está instalado.
Agora basta executar como servidor e selecionar o Tomcat.


