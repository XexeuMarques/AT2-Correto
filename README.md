## Como Usar o Sistema
### Compilar o Projeto:

Va até a pasta raiz do projeto e compile todos os arquivos .java. Isso pode ser feito executando o seguinte comando no terminal:

```
javac -d bin -sourcepath src src/view/MainView2.java
```

O diretório src contém os arquivos .java, e o diretório bin conterá os arquivos compilados.

### Executar o Sistema:

Após a compilação, você pode executar o sistema com o seguinte comando:

```
java -cp bin view.MainView2
```

---

## Aspectos

O projeto foi organizado no padrão **MVC** (Model-View-Controller), que separa a lógica de negócio, a apresentação e o gerenciamento de dados de maneira modular e independente. Isso melhora a escalabilidade e a manutenção do código

- **Model**: As classes `ContaBancaria` e `Cliente` representam os objetos principais do sistema, cada um contendo atributos e métodos relacionados à manipulação de dados.
- **View**: A classe `MainView2` é responsável pela interface de texto (console/terminal) que interage com o usuário.
- **Controller**: A classe ``ContaClienteController`` centraliza a lógica de negócio, como o gerenciamento de funcionários e avaliações.

### Estrutura de Pastas:

- **src/model**: Contém as classes de dados (`ContaBancaria`, `Cliente`).
- **src/view**: Contém a interface de interação com o usuário (`MainView`).
- **src/controller**: Contém a lógica de negócios e as operações *CRUD* (`ContaClienteController`).


### **Controle de Erros e Validação**:
- O CPF é validado para garantir que tenha 11 dígitos.
- As operações financeiras (saque e transferência) só são realizadas se houver saldo suficiente.

---

## Tópicos abordados pelo professor na ultima aula
### **Construtores**

Os **construtores** são métodos especiais usados para inicializar objetos. No código, cada classe (`ContaBancaria` e `Cliente`), Neste projeto, usamos construtores sobrecarregados para as classes, quando criado o objeto, e necessário obrigatoriamente a preencher os dados
#### **Construtores na Classe `ContaBancaria`:

- **Construtor com Todos os Atributos**

```java
public Funcionario(String nome, String cargo, double salario)](<public ContaBancaria(int numero, double limite) {
    this.numero = numero;
    this.limite = limite;
    this.saldo = 0.0; // Inicializa o saldo com 0
}
```

- O construtor da classe `ContaBancaria` recebe o número da conta e o limite. O saldo é inicializado automaticamente como zero.
#### **Construtores na Classe `Cliente`:

```java
public Avaliacao(double nota, LocalDate data)](<public Cliente(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
}
```

- O construtor da classe `Cliente` inicializa o cliente com nome e CPF

### **Métodos Getters e Setters**

Os **getters** e **setters** são métodos usados para acessar e modificar os atributos de um objeto. Eles seguem a convenção de encapsulamento, o que significa que os atributos são privados e acessados de maneira controlada.

**Exemplo do `ContaBancaria`**:

```java
public String getNome() {
    return nome;
}

public String getCargo() {
    return cargo;
}

public double getSalario() {
    return salario;
}public int getNumero() {
    return numero;
}

public double getSaldo() {
    return saldo;
}

public void setSaldo(double saldo) {
    this.saldo = saldo;
}>
```

- `getNumero()`: Retorna o número da conta.
- `getSaldo()`: Retorna o saldo da conta.
- `setSaldo()`: Define o novo valor de saldo da conta.
Esses métodos fornecem o controle adequado sobre os atributos privados das classes, garantindo que os dados sejam manipulados de maneira controlada.
### **Modificadores de Acesso** (encapsulação)

Os **modificadores de acesso** controlam a visibilidade de classes, atributos e métodos. Eles garantem a encapsulação, limitando o acesso direto a certos componentes do código.

**Os modificadores de acesso usados no projeto são:**:

- **`private`**: Define que o atributo ou método só pode ser acessado dentro da própria classe. Utilizamos este modificador nos atributos `nome`, `cpf`, `numero`, `saldo`, e `limite` para garantir a integridade dos dados.
- **`public`**: Define que o método ou classe pode ser acessado de qualquer parte do código. Todos os métodos principais do projeto (`getters`, `setters`, e métodos no controller) são públicos, pois devem ser acessíveis de diferentes partes do sistema.

---

## Uma pequena ideia de defesa do codigo:

Este sistema foi desenvolvido com uma arquitetura simples e modular baseada no padrão **MVC**, promovendo separação de responsabilidades e facilitando a escalabilidade e manutenção. A implementação de **construtores** flexíveis e **modificadores de acesso** garante a integridade dos dados, permitindo apenas operações controladas no sistema .

- **Separação de responsabilidades**: Cada classe tem uma responsabilidade única, o que melhora a manutenibilidade do código. O padrão MVC foi utilizado para manter a lógica de negócios separada da interface de usuário e dos modelos de dados.
- **Encapsulamento**: O uso de modificadores de acesso como `private` e a criação de métodos `get` e `set` garantem que os atributos das classes sejam protegidos e acessados de forma controlada. Isso impede a modificação direta dos atributos de fora das classes, preservando a integridade dos dados.
- **Boa prática de encapsulamento**: O uso de getters e setters permite um acesso seguro aos atributos das classes, evitando modificações diretas indesejadas.
- **Construtores sobrecarregados**: O uso de construtores simplifica a criação de objetos, permitindo inicializar atributos automaticamente. Ao criar uma conta, o saldo é definido como zero, enquanto o cliente é associado corretamente a partir de seu nome e CPF.
- **Validação de CPF**: Garantimos que o CPF seja sempre válido (11 dígitos) antes de criar um cliente, o que impede erros de inserção de dados incorretos no sistema.
- **Controle de fluxo e validação de operações financeiras**: Métodos como `sacar`, `depositar` e `transferir` incluem verificações de saldo e regras de negócio, o que evita comportamentos indesejados, como sacar mais do que o saldo disponível.
- **Facilidade de expansão**: O código pode ser facilmente expandido. O projeto foi desenvolvido com uma estrutura flexível, facilitando a adição de novas funcionalidades no futuro, como histórico de transações, novos tipos de contas, etc. ou adicionando persistência de dados com SQLite

O código também foi desenhado para ser **claro e eficiente**, dividido em pequenos trechos de lógica clara, o que facilita o entendimento e a manutenção por outros desenvolvedores. O sistema utiliza métodos de fácil compreensão, e o tratamento de erros é feito de forma simples e eficaz.

Este projeto de sistema bancário foi implementado com foco em boas práticas, seguindo o padrão MVC e respeitando os princípios de encapsulamento e validação. Ele oferece uma estrutura sólida para gerenciamento de contas bancárias e operações financeiras básicas, com possibilidade de expansão e melhorias.
