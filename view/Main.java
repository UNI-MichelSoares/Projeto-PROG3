package view;

import controller.FuncionarioController;

public class Main {

	public static void main(String[] args) {
		FuncionarioController controller = new FuncionarioController();
		
		FuncionarioView view = new FuncionarioView(controller);
		
		view.exibirMenu();
	}

}
