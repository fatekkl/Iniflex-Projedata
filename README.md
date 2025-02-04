# Documentando o desenvolvimento

## Como decidi a estrutura do projeto?

Optei por uma estrutura mais simplória e clara por não querer me estender,
por mais que isso fique meio "feio" no código.

## Sobre as classes e POO

Como o projeto não possui grande estrutura, segui as boas práticas e conceitos básicos, como a privatização de elementos
que só vão ser usados dentro da classe para prevenção de erros

Em certo momento pensei em criar uma superclasse DAO para utilizar TModels, isso simplificaria caso houvesse mais de uma
tabela, o que não é o caso. Então mantive somente a classe Funcionarios DAO com metódos que funcionam especificamente
para a tabela de funcionarios para economizar tempo e simplificar o entendimento.

Evitei o uso de loops fora dos metódos para facilitar o entendimento caso o recrutador não possua grande conhecimento em
Tecnologia.
Porém utilizei somente em um dos casos(adicionar funcionarios) para mostrar que é algo que era possivel e foi uma
escolha.

## Sobre o SQL

Durante a descrição da atividade, fiquei em dúvida se seria necessário criar uma tabela ou um Array poderia servir,
decidi criar a tabela por achar mais interessante e caso eu não fosse aceito na entrevista, pelo menos vai ter sido um
aprendizado.

Utilizei consultas HQL(Hibernate Query Language) para me comunicar com a tabela e fazer operações básicas como
inserir,ler,atualizar e deletar dados da tabela, utilizei a biblioteca Hibernate.

# Conclusões

Em suma, achei um desafio interessante que me fez interagir mais de perto com Java e tive pequenos empecilhos na
configuração do Hibernate, interagir com os BigDecimals foi mais fácil do que imaginei pois eram operações básicas como
adição e divisão. Acredito que consegui resolver todas as atividades solicitadas e aprendi bastante em pouco tempo, tenho muito interesse nessa vaga e gostei muito desse pequeno projeto, caso queiram rodar localmente, não esqueçam de criar uma tabela SQL com o nome funcionarios e consultar se está tudo certo, Obrigado pela oportunidade!

