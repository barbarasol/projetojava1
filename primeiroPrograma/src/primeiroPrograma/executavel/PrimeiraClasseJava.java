package primeiroPrograma.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import primeiroPrograma.classes.Aluno;
import primeiroPrograma.classes.Disciplina;
import primeiroPrograma.classes.Secretario;
import primeiroPrograma.constantes.StatusAluno;
import primeiroPrograma.interfaces.PermitirAcesso;

public class PrimeiraClasseJava {
	public static void main(String[] args) {
		
		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a senha");
		
		PermitirAcesso permitirAcesso = new Secretario(login, senha);
		
		if(permitirAcesso.autenticar()) {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
	
		
		for (int qtd = 1; qtd <=5; qtd++) {
			
		String nome = JOptionPane.showInputDialog("Qual o nome do aluno "+qtd+ "?");
		/*String idade = JOptionPane.showInputDialog("Qual a idade?");
		String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento?");
		String rg = JOptionPane.showInputDialog("Qual o registro geral?");
		String cpf = JOptionPane.showInputDialog("Qual o cpf?");
		String mae = JOptionPane.showInputDialog("Qual o nome da mae?");
		String pai = JOptionPane.showInputDialog("Qual o nome do pai?");
		String dataMatricula = JOptionPane.showInputDialog("Qual a data da matricula?");
		String serie = JOptionPane.showInputDialog("Qual a serie matriculado?");
		String escola = JOptionPane.showInputDialog("Qual o nome da escola?");*/
			
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome(nome);
		/*aluno1.setIdade(Integer.valueOf(idade));
		aluno1.setDataNascimento(dataNascimento);
		aluno1.setRegistroGeral(rg);
		aluno1.setNumeroCpf(cpf);
		aluno1.setNomeMae(mae);
		aluno1.setNomePai(pai);
		aluno1.setDataMatricula(dataMatricula);
		aluno1.setSerieMatriculado(serie);
		aluno1.setNomeEscola(escola);*/
	
		for(int pos = 1; pos <= 4; pos++) {
			String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina "+pos+ "?");
			String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina "+pos+ "?");
			
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(Double.valueOf(notaDisciplina));
			
			aluno1.getDisciplinas().add(disciplina);
		}
		
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
		
		if (escolha == 0) {
			
			int continuarRemover = 0; 
			int posicao = 1;
			while(continuarRemover == 0) {
				String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1,2,3 ou 4?");
				aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
				posicao ++;
				continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
			}
		}
		
		alunos.add(aluno1);
	}
	
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
	
	for (Aluno aluno : alunos) {
		if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
			maps.get(StatusAluno.APROVADO).add(aluno);
		}else 
		if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
			maps.get(StatusAluno.RECUPERACAO).add(aluno);
		}else{
			maps.get(StatusAluno.REPROVADO).add(aluno);
			}
	}
	
	System.out.println("------------- Lista dos Aprovados ----------------");
	for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
		System.out.println("Nome = " + aluno.getNome() +" Resultado = "+ aluno.getAlunoAprovado() + " com média de = "+ aluno.getMediaNota());
	}

	System.out.println("------------- Lista dos Reprovados ----------------");
	for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
		System.out.println("Nome = " + aluno.getNome() +" Resultado = "+ aluno.getAlunoAprovado() + " com média de = "+ aluno.getMediaNota());
	}

	System.out.println("------------- Lista dos em Recuperação ----------------");
	for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
		System.out.println("Nome = " + aluno.getNome() +"Resultado = "+ aluno.getAlunoAprovado() + " com média de = "+ aluno.getMediaNota());
	}
		
	}else {
		JOptionPane.showMessageDialog(null, "Acesso não permitido");
	}
	}
}
