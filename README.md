# **📌 Projeto - Gerenciamento de Funcionários**  

Este projeto é um sistema para **cadastrar, atualizar e excluir funcionários** em um banco de dados, utilizando **Java, Hibernate e MySQL**.  

---

## **📄 Versão Amigável (Para Não Técnicos)**  

### **📌 Como Desenvolvi Este Projeto?**  

#### **Organização do Projeto**  
Decidi estruturar o projeto de forma **simples e intuitiva**, para que qualquer pessoa, mesmo sem experiência em programação, consiga entender como ele funciona. Minha prioridade foi manter a **clareza e facilitar futuras manutenções**.  

#### **Como os Funcionários são Armazenados?**  
Inicialmente, pensei em armazenar os funcionários dentro do próprio código, mas percebi que isso dificultaria a escalabilidade. Por isso, decidi criar um **banco de dados real**, permitindo armazenar e recuperar informações com mais facilidade.  

Utilizei um sistema que faz com que o programa consiga **"conversar" com o banco de dados de maneira eficiente**. Dessa forma, consigo **cadastrar, atualizar e excluir funcionários**, garantindo que tudo funcione corretamente.  

#### **O que Eu Aprendi com Esse Projeto?**  
Este desafio me permitiu aprimorar minhas habilidades com **bancos de dados, Hibernate e organização de código**.  
Tive algumas dificuldades na configuração inicial, mas superei os obstáculos rapidamente.  

Além disso, esse projeto me ajudou a consolidar conhecimentos importantes, como **boas práticas e gerenciamento eficiente de informações**.  

Caso queira testar o projeto no seu computador, basta seguir as instruções abaixo.  

Agradeço pela oportunidade e pelo tempo dedicado a conhecer meu trabalho! 😊🚀  

---

## **💻 Versão Técnica (Documentação para Desenvolvedores)**  

### **📌 Documentação do Desenvolvimento**  

#### **Decisão da Estrutura do Projeto**  
O projeto foi estruturado de forma **simples**, priorizando **legibilidade e manutenibilidade**, para facilitar o entendimento, mesmo para aqueles com menor experiência técnica.  

#### **Arquitetura e POO (Programação Orientada a Objetos)**  
Adotei boas práticas de **POO (Programação Orientada a Objetos)**, incluindo **encapsulamento** para proteger atributos e métodos internos das classes.  

Inicialmente, considerei a criação de uma **superclasse DAO** para generalizar o acesso aos dados usando *TModels*. Porém, como o escopo do projeto é limitado a uma única tabela, mantive a classe **`FuncionariosDAO`**, que possui métodos específicos para manipulação dos dados.  

Outro ponto importante foi a **redução do uso de loops fora dos métodos** para melhorar a legibilidade do código. No entanto, utilizei um loop no método de **adição de funcionários** para demonstrar sua viabilidade como escolha técnica.  

#### **Banco de Dados e ORM**  
Optei pela criação de um **banco de dados MySQL** para garantir persistência e escalabilidade.  

O projeto utiliza **Hibernate (ORM - Object Relational Mapping)** para interagir com o banco de dados, eliminando a necessidade de SQL nativo. Para as operações **CRUD** (*Create, Read, Update, Delete*), empreguei **HQL (Hibernate Query Language)**, garantindo um código mais limpo e compatível com diferentes bancos de dados.  

#### **Principais Desafios e Soluções**  
- **Configuração do Hibernate:** Ajustei a configuração do `hibernate.cfg.xml` e as dependências do Maven para garantir compatibilidade.  
- **Uso de BigDecimal:** Como o campo `salario` exige precisão decimal, utilizei `BigDecimal` para evitar problemas de arredondamento.  

#### **Conclusão**  
Esse projeto foi um excelente aprendizado prático em **Java, Hibernate e boas práticas de desenvolvimento**. Consegui resolver todas as atividades propostas e aprimorei meu conhecimento sobre **integração entre aplicações e bancos de dados**.  

Para rodar o projeto localmente, siga as instruções abaixo.  

---

## **🚀 Como Rodar o Projeto**  

### **1️⃣ Pré-requisitos**  
Antes de iniciar, certifique-se de ter os seguintes requisitos instalados:  
- **JDK 22** ([Baixar JDK](https://adoptium.net/))  
- **Maven** ([Baixar Maven](https://maven.apache.org/download.cgi))  
- **MySQL** ([Baixar MySQL](https://dev.mysql.com/downloads/installer/))  
- **IntelliJ IDEA** (ou outra IDE compatível)  

---

### **2️⃣ Configurar o Banco de Dados**  
1. **Abra o MySQL e crie o banco de dados**:  
   ```sql
   CREATE DATABASE protherainiflex;
   ```
2. **Certifique-se de que o usuário `root` tem permissão para acessar**:  
   ```sql
   GRANT ALL PRIVILEGES ON protherainiflex.* TO 'root'@'localhost' IDENTIFIED BY 'S0O&(H93v@k2';
   FLUSH PRIVILEGES;
   ```
3. **Verifique se a tabela `funcionarios` foi criada automaticamente** (Hibernate está configurado para `update`).  

---

### **3️⃣ Configurar o Projeto**
1. **Clone o repositório**:  
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. **Acesse a pasta do projeto**:  
   ```bash
   cd Iniflex-Projedata
   ```
3. **Verifique se o arquivo `hibernate.cfg.xml` está configurado corretamente** (usuário, senha, URL do banco).

---

### **4️⃣ Rodar o Projeto**
💻 **No terminal ou IntelliJ**, execute os seguintes comandos:

#### **Opção 1: Via Maven (Recomendado)**
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="org.example.Principal"
```

#### **Opção 2: Via IntelliJ IDEA**
1. **Abra o IntelliJ IDEA** e importe o projeto como um projeto **Maven**.  
2. **Vá até a classe `Principal.java` e clique em "Run"**.  

---

### **5️⃣ Possíveis Erros e Soluções**
✅ **Erro: "Access denied for user 'root'@'localhost'"**  
➡ Solução: Verifique se o usuário e senha estão corretos no `hibernate.cfg.xml`.  

✅ **Erro: "Table 'protherainiflex.funcionarios' doesn't exist"**  
➡ Solução: Certifique-se de que o banco foi criado e o Hibernate está configurado para `update`.  

✅ **Erro: "ClassNotFoundException: com.mysql.cj.jdbc.Driver"**  
➡ Solução: Rode `mvn clean install` para garantir que as dependências foram baixadas corretamente.  

---

## **📜 Resumo das Diferenças entre as Versões**
📄 **Versão amigável**: Explicações simplificadas, sem termos técnicos complexos, ideal para recrutadores não técnicos e stakeholders.  
💻 **Versão técnica**: Mais detalhes sobre arquitetura, POO, ORM e desafios técnicos enfrentados, ideal para desenvolvedores e engenheiros.  

Agora o projeto está pronto para ser executado! 🚀  
Se precisar de mais ajustes, me avise! 😃
