package classes;

import java.sql.*;

public class Conexao{

// Conex�o Local
public static Connection conectar(){		
	try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/curso_db?useTimezone=true&serverTimezone=UTC", "root", "vertrigo");
			//System.out.println("Conectado !!!");
			return conexao;
		} catch (SQLException e) {
			System.out.println("Erro na conex�o:\n" + e);
		}
		return null;
	}
}

// LEMBRE DE COLOCAR A SENHA DO SEU SERVIDOR LOCAL  NA STRING DE CONEX�O, COMO INDICA A SEGUIR:

// mysql://localhost/curso_db?useTimezone=true&serverTimezone=UTC", "root", "SUA_SENHA_AQUI"