package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionarioRepository {
	private final String arquivoFuncionarios = "funcionarios.txt";
	
	public void salvarFuncionarios(List<Funcionario> funcionarios) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoFuncionarios))) {
			for(Funcionario funcionario : funcionarios) {
				writer.write(funcionario.toFileString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao salvar funcionários: " + e.getMessage());
		}
	}
	
	public List<Funcionario> carregarFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(arquivoFuncionarios))) {
			String linha;
			
			while ((linha = reader.readLine()) != null) {
				funcionarios.add(Funcionario.fromFileString(linha));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de funcionários não encontrado. Será criado um novo arquivo ao salvar um funcionário.");
		} catch (IOException e) {
			System.out.println("Erro ao carregar funcionários: " + e.getMessage());
		}
		
		return Collections.unmodifiableList(funcionarios);
	}
}
