# Implementação de Árvores de Busca Balanceadas: AVL e Rubro-Negra

Trabalho acadêmico desenvolvido em Java para a disciplina de Estrutura de Dados Básicas 2. O objetivo é demonstrar a implementação funcional de uma Árvore AVL e de uma Árvore Rubro-Negra.

## 📋 Pré-requisitos

Para compilar e executar este projeto, é necessário ter o Java Development Kit (JDK) instalado. Recomenda-se a versão 17 ou superior.

Você pode verificar sua versão do Java com o comando:

    java -version

## 🚀 Como Executar o Projeto

Existem duas maneiras de executar o programa: através de um IDE (método recomendado) ou diretamente pelo terminal.

### Método 1: Executando por um IDE (Ex: Eclipse)

Este é o método mais simples:

1. **Clone o repositório:**
    ```bash
    git clone https://github.com/mateusfoliveira/binary-search-trees-edb2.git
    ```

2. **Abra seu IDE de preferência.**

3. **Importe o projeto:**

    Eclipse: File -> Import... -> General -> Existing Projects into Workspace -> Selecione a pasta clonada.

4. **Localize o arquivo Main.java no pacote edb2.arvores.busca.**

5. **Clique com o botão direito no arquivo Main.java e selecione "Run As" -> "Java Application".**

O menu interativo será iniciado no console do IDE.

### Método 2: Executando pelo Terminal (Compilação Manual)

Se preferir executar sem um IDE, siga estes passos a partir da pasta raiz do projeto (arvores_busca_edb2):

1. **Crie um diretório para os arquivos compilados:**
    ```bash
    mkdir bin
    ```
2. **Compile o código-fonte:** Este comando compila todos os arquivos .java da pasta src e salva os .class na pasta bin.
    ```bash
    javac -d bin -sourcepath src src/edb2/arvores/busca/*.java
    ```

3. **Execute o programa:** Este comando inicia o programa, especificando o classpath para a pasta bin e o nome completo da classe principal (Main).
    ```bash
    java -cp bin edb2.arvores.busca.Main
    ```

O menu interativo será iniciado no terminal.

## 🏗️ Estrutura do Projeto

O código-fonte está localizado na pasta src/ e segue a estrutura de pacotes edb2.arvores.busca:

* **Main.java:** Ponto de entrada do programa. Apenas inicia o Sistema.

* **Sistema.java:** Contém toda a lógica dos menus, Scanner para entrada do usuário e a interface para interagir com as árvores.

* **AvlTree.java:** Contém a implementação completa da Árvore AVL, incluindo a classe interna NodeAvl e as lógicas de inserção, remoção e balanceamento.

* **RBTree.java:** Contém a implementação da Árvore Rubro-Negra, incluindo a classe interna NodeRB (com ponteiro parent) e as lógicas de inserção e rebalanceamento.

## ⚙️ Funcionalidades

O programa apresenta um menu inicial para a escolha da árvore (AVL ou Rubro-Negra).

### Árvore AVL

1. **Inserir elemento** (com rebalanceamento)

2. **Remover elemento** (com rebalanceamento)

3. **Buscar elemento**

4. **Visualizar árvore** (impressão in-order)

### Árvore Rubro-Negra

1. **Inserir elemento** (com rebalanceamento)

2. **Buscar elemento**

3. **Visualizar árvore** (impressão in-order)

(A remoção não foi implementada para a Árvore Rubro-Negra)
