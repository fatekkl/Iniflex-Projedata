Aqui estão duas versões da documentação:

- **Versão amigável para não técnicos**, voltada para pessoas que não possuem conhecimento aprofundado em programação, como gerentes, clientes ou recrutadores sem background técnico.
- **Versão técnica**, com mais detalhes sobre as decisões de implementação e estrutura do código, voltada para desenvolvedores e engenheiros de software.

---

## **📄 Versão Amigável (Para Não Técnicos)**

# **Como Desenvolvi Este Projeto?**

## **Organização do Projeto**
Decidi estruturar o projeto de forma simples e intuitiva, para que qualquer pessoa, mesmo sem experiência em programação, consiga entender como ele funciona. Minha prioridade foi manter a clareza e facilitar futuras manutenções.

## **Como os Funcionários são Armazenados?**
Inicialmente, pensei em armazenar os funcionários dentro do próprio código, mas percebi que isso dificultaria a escalabilidade. Por isso, decidi criar um banco de dados real, permitindo armazenar e recuperar informações com mais facilidade.

Utilizei um sistema que faz com que o programa consiga "conversar" com o banco de dados de maneira eficiente. Dessa forma, consigo **cadastrar, atualizar e excluir funcionários**, garantindo que tudo funcione corretamente.

## **O que Eu Aprendi com Esse Projeto?**
Este desafio me permitiu aprimorar minhas habilidades com a tecnologia usada para gerenciar os dados e estruturar o sistema. Tive algumas dificuldades na configuração inicial, mas superei os obstáculos rapidamente.

Além disso, esse projeto me ajudou a consolidar conhecimentos importantes, como **organização de código, boas práticas e gerenciamento de informações de forma eficiente**.

Caso queira testar o projeto no seu computador, basta criar uma **tabela chamada "funcionarios"** no banco de dados e garantir que tudo esteja corretamente configurado.

Agradeço pela oportunidade e pelo tempo dedicado a conhecer meu trabalho! 😊🚀

---

## **💻 Versão Técnica (Para Desenvolvedores e Engenheiros de Software)**

# **Documentação do Desenvolvimento**

## **Decisão da Estrutura do Projeto**
O projeto foi estruturado de forma simples, priorizando **legibilidade e manutenibilidade**, para facilitar o entendimento, mesmo para aqueles com menor experiência técnica. Apesar de isso comprometer um pouco a estética do código, a decisão foi tomada visando a acessibilidade.

## **Arquitetura e POO (Programação Orientada a Objetos)**
Adotei boas práticas de **Programação Orientada a Objetos (POO)**, incluindo encapsulamento para proteger atributos e métodos internos das classes.

Inicialmente, considerei a criação de uma **superclasse DAO** para generalizar o acesso aos dados usando *TModels*. Porém, como o escopo do projeto é limitado a uma única tabela, mantive a classe `FuncionariosDAO`, que possui métodos específicos para manipulação dos dados de funcionários.

Outro ponto importante foi a **redução do uso de loops fora dos métodos** para melhorar a legibilidade do código. No entanto, utilizei um loop no método de **adição de funcionários** para demonstrar sua viabilidade como escolha técnica.

## **Banco de Dados e ORM**
Considerei armazenar os dados em um **Array**, mas optei pela criação de um banco de dados real para garantir persistência e escalabilidade.

O projeto utiliza **Hibernate (ORM - Object Relational Mapping)** para interagir com o banco de dados, eliminando a necessidade de SQL nativo. Para as operações CRUD (*Create, Read, Update, Delete*), empreguei **HQL (Hibernate Query Language)**, garantindo um código mais limpo e compatível com diferentes bancos de dados.

## **Principais Desafios e Soluções**
- **Configuração do Hibernate:** Alguns desafios surgiram durante a configuração do ORM, mas foram resolvidos com ajustes na configuração do `hibernate.cfg.xml` e dependências do Maven.
- **Uso de BigDecimal:** Como o campo `salario` exige precisão decimal, utilizei `BigDecimal` para operações matemáticas, evitando problemas de arredondamento.

## **Conclusão**
Esse projeto foi um excelente aprendizado prático em **Java, Hibernate e boas práticas de desenvolvimento**. Consegui resolver todas as atividades propostas e aprimorei meu conhecimento sobre integração entre aplicações e bancos de dados.

Para rodar o projeto localmente, basta criar uma tabela SQL chamada **`funcionarios`** e garantir que a configuração do Hibernate esteja correta.

Agradeço pela oportunidade e fico à disposição para esclarecer dúvidas ou discutir melhorias no código! 🚀

---

### **Resumo das Diferenças entre as Versões**
📄 **Versão amigável**: Explicações simplificadas, sem termos técnicos complexos, ideal para recrutadores não técnicos e stakeholders.  
💻 **Versão técnica**: Mais detalhes sobre arquitetura, POO, ORM e desafios técnicos enfrentados, ideal para desenvolvedores e engenheiros.

Caso precise de mais ajustes, me avise! 😊🚀