# Teste ItLab - Feito por Arthur Paraiso Martins

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

## 🛠️ Tecnologias Utilizadas

- **Java** com **Spring Boot**
- **Kafka** para troca de mensagens (produtor/consumidor)
- **Banco de Dados H2** para persistência local
- **Maven** para gerenciamento de dependências
- **Docker Compose** para orquestração do ambiente
- **Lombok** para simplificação do código
- **APIs REST** para comunicação externa

---

## 🏗️ Estrutura do Projeto

### **Camadas do Projeto**
- **Controller**: Controla as requisições REST (ex.: `NotaFiscalController`).
- **Service**: Contém a lógica de negócios (ex.: `NotaFiscalService`).
- **Model**: Representa os objetos de domínio (`NotaFiscal` e `Boleto`).
- **Repository**: Interage com o banco de dados usando Spring Data.
- **Kafka Services**: Configurações, produtores e consumidores para integração com Kafka.

### **Componentes Externos**
- ERP do cliente (API REST)
- Validador do governo (API REST)
- Microserviço de clientes (API REST)
- Microserviço de cobrança (Kafka)

---

## 📂 Estrutura de Arquivos