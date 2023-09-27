package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		
		String [] candidatos = {"maria", "Joao", "Pedro", "Marcia", "Fabio"};
		for (String candidato: candidatos)
			{
			entrandoEmContato(candidato);
			}
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuaTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuaTentando = !atendeu;
			
			if (continuaTentando)
			{
				tentativasRealizadas ++;
			}
			else
			{
				System.out.println("Contato realizado");
			}
		}while(continuaTentando && tentativasRealizadas < 3);
	}
	
	static boolean atender() {
		return new Random().nextInt(3) == 1;
		
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"maria", "Joao", "Pedro", "Marcia", "Fabio"};
		
		System.out.println("Imprimindo a lista de Candidatos");
		
		for (int lista = 0; lista < candidatos.length; lista ++)
		{
			System.out.println("O candidato de numero: " + (lista + 1) + " é:"+ candidatos[lista]);
			
		}
		
		
	}
	
	static void selecaoCandidatos() {
		
		String [] candidatos = {"maria", "Joao", "Pedro", "Marcia", "Fabio", "Ana"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		
		while (candidatosSelecionados < 5 && candidatoAtual<candidatos.length)
		{
			String candidato = candidatos[candidatoAtual];
			double  salarioPretendido = valorPretendido();
			
			System.out.println("O Candidato" + candidato +" solicitou o salario: "+salarioPretendido);
			
			if (salarioBase >= salarioPretendido) {
				System.out.println("O Candidato" + candidato +" foi selecionado ");
				
				candidatosSelecionados ++;				
			}
			
			candidatoAtual ++;
		}
		
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800.0,2200.0);
	}
	
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		
		if (salarioBase > salarioPretendido)
		{
			System.out.println("Ligar para o Candidato");
		}
		else if (salarioBase == salarioPretendido)
		{
			System.out.println("Ligar para o Candidato com contra proposta");
		}
		else if (salarioBase < salarioPretendido)
		{
			System.out.println("Aguardando demais candidatos");
		}
		
	}
}
