package model;

public abstract class Funcionario {
	private int id;
	private String nome;
	private double salario;
	private TipoFuncionario tipo;
	
	// Construtor
	public Funcionario(int id, String nome, double salario, TipoFuncionario tipo) {
		this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.tipo = tipo;
	}
	
	// Getters
	public String getNome() {
		return nome;
	}
	public double getSalario() {
		return salario;
	}
	public int getId() {
		return id;
	}
	public TipoFuncionario getTipo() {
		return tipo;
	}
	
	// Setters
	public void setId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID não pode ser negativo.");
		}
		this.id = id;
	}
	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário não preenchido.");
        }
        this.nome = nome;
	}
	public void setSalario(double salario) {
		if (salario <= 0) {
			throw new IllegalArgumentException("Salário não pode ser negativo ou zero.");
		}
		this.salario = salario;
	}
	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo;
	}
	
	// Outros métodos
	public void receberAumento(double aumento) {
		if (aumento <= 0) {
			throw new IllegalArgumentException("Aumento não pode ser negativo ou zero.");
		}
		this.salario += aumento;
	}
	public abstract void mostrarDetalhes();
	
	// Métodos de arquivo
	public String toFileString() {
		return getId() + ";" + getTipo() + ";" + getNome() + ";" + getSalario();
	}
	
	public static Funcionario fromFileString(String line) {
		String[] data = line.split(";");
		
		if (data.length != 4) {
			throw new IllegalArgumentException("Linha de dados inválida para criação de funcionário: " + line);
		}
		
		try {
			int id = Integer.parseInt(data[0]);
			TipoFuncionario tipo = TipoFuncionario.valueOf(data[1]);
            String nome = data[2];
            double salario = Double.parseDouble(data[3]);
            
            switch (tipo) {
            case DESENVOLVEDOR:
            	return new Desenvolvedor(id, nome, salario);
            case GERENTE:
            	return new Gerente(id, nome, salario);
            case TREINADOR:
            	return new Treinador(id, nome, salario);
            case GERENTE_DESENVOLVEDOR:
            	return new GerenteDesenvolvedor(id, nome, salario);
            default:
                throw new IllegalArgumentException("Tipo de funcionário desconhecido.");
            }
            
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato numérico inválido em: " + line, e);
        }
	}
}
