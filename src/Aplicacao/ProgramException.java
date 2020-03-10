package Aplicacao;

import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.conta;
import modelo.excecoes.excecoesDominio;

public class ProgramException {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 

		try {
			System.out.println("Programa para ler os dados de uma conta bancária, realizar um saque nesta conta, mostrar o novo saldo");
			System.out.println("Saque não pode ocorrer:"); 
			System.out.println("- Se não houver saldo na conta");
			System.out.println("- Valor saque superior ao limite de saque.");
			System.out.println();
			
			System.out.println("Entre com os dados da conta");
			System.out.print("Conta Número: ");
			int numero = sc.nextInt();
			System.out.print("Titular da Conta: ");
			sc.nextLine();
			String titular = sc.nextLine(); 			
			System.out.print("Saldo Inicial: ");
			Double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double limiteSaque = sc.nextDouble();
			System.out.println();
			
			conta cta = new conta(numero, titular, saldo, limiteSaque);
						
			System.out.print("Valor a ser sacado: ");
			Double saque = sc.nextDouble();
			
			cta.saque(saque); 
			
			System.out.println("Novo Saldo: " + cta);
		
		} 		
		catch (excecoesDominio e) {
			System.out.println("Erro na conta: " + e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Erro inexperado ");
		}
		
		sc.close();
		

	}

}
