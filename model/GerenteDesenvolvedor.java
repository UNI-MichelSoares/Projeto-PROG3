package model;

public class GerenteDesenvolvedor extends Funcionario implements Gerencia, Desenvolve{

	public GerenteDesenvolvedor(int id, String nome, double salario) {
		super(id, nome, salario, TipoFuncionario.GERENTE_DESENVOLVEDOR);
	}

	@Override
	public void codar() {
		System.out.println(getNome() + " está codando.");
	}

	@Override
	public void resolverProblemas() {
		System.out.println(getNome() + " está resolvendo problemas.");
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
