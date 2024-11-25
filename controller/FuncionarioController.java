package controller;

import model.Desenvolvedor;
import model.Funcionario;
import model.FuncionarioRepository;
import model.Gerente;
import model.GerenteDesenvolvedor;
import model.TipoFuncionario;
import model.Treinador;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
	private List<Funcionario> funcionarios;
	private FuncionarioRepository funcionarioRepository;
	
	public FuncionarioController() {
		this.funcionarioRepository = new FuncionarioRepository();
		this.funcionarios = new ArrayList<>(funcionarioRepository.carregarFuncionarios());
	}

	public void cadastrarFuncionario(int id, String nome, double salario, TipoFuncionario tipo) {
		Funcionario funcionario;
		
		switch (tipo) {
		case DESENVOLVEDOR:
			funcionario = new Desenvolvedor(id, nome, salario);
			break;
		case GERENTE:
			funcionario = new Gerente(id, nome, salario);
			break;
		case TREINADOR:
			funcionario = new Treinador(id, nome, salario);
			break;
		case GERENTE_DESENVOLVEDOR:
			funcionario = new GerenteDesenvolvedor(id, nome, salario);
			break;
		default:
            throw new IllegalArgumentException("Tipo de funcionário inválido: " + tipo);
		}
		
		funcionarios.add(funcionario);
		funcionarioRepository.salvarFuncionarios(funcionarios);
	}
	
	public List<Funcionario> listarFuncionarios() {
		return List.copyOf(funcionarios);
	}
	
	public void editarFuncionario(int id, String novoNome, double novoSalario) {
		Funcionario funcionario = buscarFuncionarioPorId(id);
		
		if (funcionario == null) {
	        throw new IllegalArgumentException("Funcionário com id " + id + " não encontrado.");
	    }
		else {
			funcionario.setNome(novoNome);
			funcionario.setSalario(novoSalario);
			funcionarioRepository.salvarFuncionarios(funcionarios);
		}
	    
	}
	
	public void excluirFuncionario(int id) {
		Funcionario funcionario = buscarFuncionarioPorId(id);
		
		if (funcionario == null) {
	        throw new IllegalArgumentException("Funcionário com id " + id + " não encontrado.");
	    }
		else {
			funcionarios.remove(funcionario);
			funcionarioRepository.salvarFuncionarios(funcionarios);
		}
	}
	
	private Funcionario buscarFuncionarioPorId(int id) {
        return funcionarios.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
	
}
