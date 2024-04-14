# Projeto StylistPro

## Integrantes
Jaqueline Martins - RM551744 - DevOps & Cloud Computing <br>
Mariana Bastos    - RM97510  - Java Advanced <br>
Matheus Oliveira  - RM551155 - Mobile Development/Database <br>
Victor Freitas    - RM99928  - Advanced Business with C#/Quality Assurance<br>
Breno Giacoppini  - RM98695  - Artificial Intelligence <br>


### Passo a passo para rodar a aplicação

1. Clone o repositório:

    ```bash
    git clone https://github.com/Mari-Bastet/JAVACHALLENGEFINAL.git
    ```

2. Importe o projeto na IDE de sua preferência
   ![image](https://github.com/Mari-Bastet/JAVACHALLENGEFINAL/assets/82931897/fbc29d9e-e3c6-462e-ac69-9dfbbf20821c)

3. Rode a Classe "ChallengeApplication.java"
![image](https://github.com/Mari-Bastet/JAVACHALLENGEFINAL/assets/82931897/2908161a-c66a-4491-9dae-ed100b67961e)

### Endpoints da API
Arquivo contendo todos os endpoints feitos e testados até o momento no Postman se encontram na pasta "Documentacao".

- CLIENTES E COMPRAS <br>
 Método: GET <br>
 link: localhost:8080/clientes <br>
 Descrição: Retorna todos os clientes e suas respectivas compras (se houverem compras feitas). <br>

 - CLIENTE POR ID <br>
 Método: GET <br>
 link: localhost:8080/clientes/{id_cliente} <br>
 Descrição: Retorna o cliente de ID informado. <br>


- ADICIONAR CLIENTE <br>
 Método: POST <br>
 link: localhost:8080/clientes/adicionar <br>
 Modelo JSON: ``` {
    "nome":"Calma",
    "email":"tranquilo@email.com",
    "data_nascimento":"01/10/2003",
    "endereco":"Rua tranquilo"
} ``` <br>
 Descrição: Cadastro de cliente. <br>

- PRODUTOS POR COMPRA <br>
 Método: GET <br>
 link: localhost:8080/compras/prodCompra/{id_compra} <br>
 Descrição: Retorna todas as compras e seus respectivos produtos. <br>

 - PRODUTOS POR COMPRA <br>
 Método: GET <br>
 link: localhost:8080/feedbacks/{id_cliente} <br>
 Descrição: Retorna todos os feedbacks do cliente de ID informado. <br>
  
