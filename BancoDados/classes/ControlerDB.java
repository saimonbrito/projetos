package classes;

import java.sql.*;

public class ControlerDB{
	
	public static void inserir(String nome, String matricula){
		try{
			String sqlQuery = "INSERT INTO alunos VALUES (?,?,?)";
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);			
			
			pst.setString(1, "0");
			pst.setString(2, nome);
			pst.setString(3, matricula);
			pst.executeUpdate();			
			
			System.out.println("### Registro realizado com sucesso. ###");
			
		}catch(SQLException e){
			System.out.println("Erro:\n" + e);
		}
	}

	public static void buscar(String pesquisar){
		try{
			String sqlQuery = "SELECT * FROM alunos WHERE id = ?";
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);			
			pst.setString(1, pesquisar);
			ResultSet resultado = pst.executeQuery();
			if(resultado.next()){
				System.out.println("### Resultado da Pesquisa ###");
				System.out.println("# Nome.....: " + resultado.getString("nome"));
				System.out.println("# Matricula: " + resultado.getString("matricula"));
				System.out.println("#############################");
			}else{
				System.out.println("Registro não encontrado.");
			}
		}catch(SQLException e){
			System.out.println("Erro:\n" + e);
		}
	}

	public static void alterar(String id, String nome, String matricula){
		try {

            String sqlQuery = "UPDATE alunos SET nome = ?, matricula = ? WHERE id = " + id;
            PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);

            pst.setString(1, nome);
            pst.setString(2, matricula);

            int resultado = pst.executeUpdate();
			
			if(resultado > 0){
				System.out.println("### Registro alterado com sucesso. ###");
			}else{
				System.out.println("### Nenhum registro alterado. ###");
			}            

        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }
	}
	
	public static void eliminar(String id){
		try{
			String sqlQuery = "DELETE FROM alunos WHERE id = ?";
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);			
			
			pst.setString(1, id);
			
			int resultado = pst.executeUpdate();
			
			if(resultado > 0){
				System.out.println("### Registro eliminado com sucesso. ###");
			}else{
				System.out.println("### Nenhum registro eliminado. ###");
			} 
		}catch(SQLException e){
			System.out.println("Erro:\n" + e);
		}
	}
	
	public static void mostrarTodos(){
		try{
			String sqlQuery = "SELECT * FROM alunos";
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);
			ResultSet resultado = pst.executeQuery();
			System.out.println("### Resultado da Pesquisa ###");
			System.out.println();
			while(resultado.next()){
				
				System.out.println("# Nome.....: " + resultado.getString("nome"));
				System.out.println("# Matricula: " + resultado.getString("matricula"));
				System.out.println();
			}
		}catch(SQLException e){
			System.out.println("Erro:\n" + e);
		}
	}
}