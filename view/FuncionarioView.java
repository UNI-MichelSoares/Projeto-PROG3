package view;

import controller.FuncionarioController;
import model.TipoFuncionario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionarioView {

    private FuncionarioController controller;
    private Scanner scanner;

    public FuncionarioView(FuncionarioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("3. Editar funcionário");
            System.out.println("4. Excluir funcionário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarFuncionario();
                case 2 -> listarFuncionarios();
                case 3 -> editarFuncionario();
                case 4 -> excluirFuncionario();
                case 0 -> System.out.println("Encerrando o programa.");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void cadastrarFuncionario() {
        try {
            System.out.print("Digite o ID do funcionário: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o salário do funcionário: ");
            double salario = scanner.nextDouble();

            System.out.print("Digite o tipo do funcionário (DESENVOLVEDOR, GERENTE, TREINADOR, GERENTE_DESENVOLVEDOR): ");
            String tipoStr = scanner.next();
            TipoFuncionario tipo = TipoFuncionario.valueOf(tipoStr.toUpperCase());

            controller.cadastrarFuncionario(id, nome, salario, tipo);
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Tipo de funcionário inválido. Tente novamente.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar os dados corretamente.");
            scanner.nextLine();
        }
    }

    public void editarFuncionario() {
        try {
            System.out.print("Digite o ID do funcionário que deseja editar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o novo nome do funcionário: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o novo salário do funcionário: ");
            double salario = scanner.nextDouble();

            controller.editarFuncionario(id, nome, salario);
            System.out.println("Funcionário editado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar os dados corretamente.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirFuncionario() {
        try {
            System.out.print("Digite o ID do funcionário que deseja excluir: ");
            int id = scanner.nextInt();

            controller.excluirFuncionario(id);
            System.out.println("Funcionário excluído com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listarFuncionarios() {
    	controller.listarFuncionarios().forEach(funcionario -> 
        System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome() + ", Salário: R$ " + funcionario.getSalario() + ", Tipo: " + funcionario.getTipo())
    );
    }
}
