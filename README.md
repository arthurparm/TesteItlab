# Teste ItLab - Feito por Arthur Paraiso Martins

- Usei o IntelliJ, não sei como ficaria no eclipse, mas acredito que seja bem parecido. 


---

## Funcionalidades

1. **Recebimento de Notas Fiscais:**
    - Recebe notas fiscais via API REST exposta pelo sistema.
    - Processa e valida as notas.

2. **Processamento de Boletos:**
    - Consome boletos relacionados às notas fiscais por meio de tópicos Kafka.
    - Envia os boletos para um microserviço interno de cobrança via Kafka.

3. **Persistência de Dados:**
    - Armazena notas fiscais e boletos em um banco de dados local H2.

4. **Resiliência e Notificação:**
    - Garante que erros sejam tratados e reportados adequadamente ao cliente.

---

## Tecnologias Utilizadas

- **Java 17** com **Spring Boot 3.4.0**
- **Kafka (Docker)** para troca de mensagens (produtor/consumidor)
- **Banco H2** para persistência local
- **Maven** para gerenciamento de dependências
- **Docker Compose** para orquestração do ambiente
- **Lombok** para simplificação do código
- **APIs REST** para comunicação externa

---

## Como executar?

1- Certificar-se que esta com a versão 17 do Java.

2- Para execução do docker certifique-se que o package foi gerado.Uma alternativa é usar o comando -> **mvn package -DskipTests -f pom.xml** 

3- Execute o dockerfile e o docker compose acompanhada no projeto.

4- O projeto estará disponivel na porta 8080 e o Kafka na 9092. **Se certifique que está com essas portas disponiveis para evitar problemas.**

---

## O que esperar?

- Terá duas rotas disponiveis **/boleto** e **/notafiscal**.
- Primeiro devemos enviar a nota na rota **"/notafiscal"**, o sistema irá ler, salvar no banco de dados e enviar a um prodecer que ira incluir no topico a sua nota, te retornando como foi a execução e retornado um erro em caso de falha.
- Apos isso use a rota  **/boleto** para obter o boleto daquela nota, simulando com um mock a validação.
- No projeto acompanha exemplos validos utilizados no postman.