package model;

public class Gerente extends Funcionario implements Gerencia{

	public Gerente(int id, String nome, double salario) {
		super(id, nome, salario, TipoFuncionario.GERENTE);

	}

	@Override
	public void organizarEquipe() {
		System.out.println(getNome() + " está organizando a equipe.");
	}

	@Override
	public void conduzirReunioes() {
		System.out.println(getNome() + " está conduzindo uma reunião.");
	}

	@Override
	public void mostrarDetalhes() {
		
	}

}
