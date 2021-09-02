import java.util.Scanner;
import java.sql.*;
import classes.*;

public class DataBase{
	
	public static void main(String args[]){
		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		String id = "";
		String nome = "";
		String matricula = "";
		
		do{
			System.out.println("\nEscolha uma Opção:\n");
			System.out.println(" 1. Inserir Registro");
			System.out.println(" 2. Buscar Registro");
			System.out.println(" 3. Alterar Registro");
			System.out.println(" 4. Eliminar Registro");
			System.out.println(" 5. Mostrar Todos os Registro");
			System.out.println(" 6. Sair");
			System.out.print(" Opção: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao){
				default:
				break;
				case 1:
					System.out.println("\nRegistrar Aluno\n");
					System.out.print(" Nome: ");
					nome = entrada.nextLine();
					System.out.print(" Matricula: ");
					matricula = entrada.nextLine();
					ControlerDB.inserir(nome, matricula);
				break;
				case 2:
					System.out.println("\nDigite o ID para Buscar\n");
					System.out.print(" ID: ");
					id = entrada.nextLine();
					ControlerDB.buscar(id);
				break;
				case 3:
					System.out.println("\nAlterar Registro\n");
					System.out.print(" ID: ");
					id = entrada.nextLine();
					System.out.print(" Novo Nome: ");
					nome = entrada.nextLine();
					System.out.print(" Nova Matricula: ");
					matricula = entrada.nextLine();
					ControlerDB.alterar(id, nome, matricula);
				break;
				case 4:
					System.out.println("\nDigite o ID para Eliminar\n");
					System.out.print(" ID: ");
					id = entrada.nextLine();
					ControlerDB.eliminar(id);
				break;
				case 5:
					System.out.println("\nMostrar Todos os Registro\n");
					ControlerDB.mostrarTodos();
				break;
			}
		}while(opcao != 6);
	}
}

