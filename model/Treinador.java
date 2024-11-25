package model;

public class Treinador extends Funcionario implements Treina {

	public Treinador(int id, String nome, double salario) {
		super(id, nome, salario, TipoFuncionario.TREINADOR);
	}

	@Override
	public void ensinarTecnologia() {
		System.out.println(getNome() + " está ensinando.");
	}

	@Override
	public void motivarEquipe() {
		System.out.println(getNome() + " está motivando a equipe.");
	}

	@Override
	public void mostrarDetalhes() {
		
	}

}
