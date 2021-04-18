package primeiroPrograma.executavel;

import primeiroPrograma.classes.Aluno;
import primeiroPrograma.classes.Diretor;
import primeiroPrograma.classes.Pessoa;
import primeiroPrograma.classes.Secretario;

public class TestandoClassesFilhas {
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Alex JDev - Treinamento");
		aluno.setNomeEscola("Jdev - Treinamento");
		aluno.setIdade(16);
		
		Diretor diretor = new Diretor();
		diretor.setRegistroGeral("45873674903");
		diretor.setIdade(50);
		diretor.setNome("André");
		
		Secretario secretario = new Secretario();
		secretario.setExperiencia("Administração");
		secretario.setIdade(18);
		secretario.setNome("João");
		
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
		
		System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.msgMaiorIdade());
		System.out.println(diretor.pessoaMaiorIdade());
		System.out.println(secretario.pessoaMaiorIdade());
		
		System.out.println("Salário Aluno é = " + aluno.salario());
		
	
		teste(aluno);
		teste(diretor);
		teste(secretario);
		
		
		System.out.println("Salário Diretor é = " + diretor.salario());
		System.out.println("Salário Secretario é = " + secretario.salario());
	}
	
	
	
	
	
	public static void teste(Pessoa pessoa) {
	 System.out.println("Essa pessoa tem salario = " + pessoa.salario());
	}
}


