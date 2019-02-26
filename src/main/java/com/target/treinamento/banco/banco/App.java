package com.target.treinamento.banco.banco;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.xml.bind.v2.runtime.RuntimeUtil.ToStringAdapter;
import com.target.treinamento.banco.banco.dominio.Banco;
import com.target.treinamento.banco.banco.dominio.Funcionario;

import net.bytebuddy.implementation.ToStringMethod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testeBanco");
    	 
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	 
    	 entityManager.getTransaction().begin();
    	 
//    	 Funcionario funcionario = new Funcionario();
//    	 funcionario.setNome("Gaviao");
//    	 funcionario.setCargo(2);
//    	 funcionario.setDataInclusao(Calendar.getInstance());
//    	 funcionario.setIdade(22);
    	 
    	 
    	 //executar a transação
    	Funcionario func =  entityManager.find(Funcionario.class, 106L);
    	
    	System.out.println(func.getSalario());
    	System.out.println(func.toString());
    	//System.out.println(func.getBanco().getNome());
    	 
    	 entityManager.getTransaction().commit();
    	 
    	 
    	 Banco banco = entityManager.find(Banco.class, 1L);
    	 for (Funcionario f : banco.getFuncionarios()) {
    		 System.out.println(f.getNome());
    	 }
    	 
    	 entityManagerFactory.close();
    	 
    	
//    	FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
//    	
//        try 
//        {
//        	String sql = "insert into pessoas(PRIMEIRO_NOME,SEGUNDO_NOME, ENDERECO, CIDADE) "
//					+ "VALUES (?, ?, ?, ?)";
//        					// 1, 2, 3, 4
//			PreparedStatement statement = fabricaDeConexao.getPreparedStatement(sql);
//			statement.setString(1, "Pedrinho");
//			statement.setString(2, "Alfredo");
//			statement.setString(3, "Rua Bento rosa");
//			statement.setString(4, "Lajeado");
//			int retorno = statement.executeUpdate();
//			
//			if(retorno == 1) {
//				System.out.println("Sucesso!");
//			} else {
//				System.out.println("Erro ao gravar dados!");
//			}
//			
//			ResultSet resultSet = fabricaDeConexao.getPreparedStatement(
//					"SELECT P.ID, P.PRIMEIRO_NOME, "
//					+ "P.SEGUNDO_NOME, P.ENDERECO, P.CIDADE "
//					+ "FROM PESSOAS P").executeQuery();
//			
//			while(resultSet.next()) 
//			{
//				String primeiroNome = resultSet.getString("PRIMEIRO_NOME");
//				String segundoNome = resultSet.getString("SEGUNDO_NOME");
//				String endereco = resultSet.getString("ENDERECO");
//				String cidade = resultSet.getString("CIDADE");
//				Long id = resultSet.getLong("ID");
//				
//				System.out.println(id);
//				System.out.println(primeiroNome);
//				System.out.println(segundoNome);
//				System.out.println(endereco);
//				System.out.println(cidade);
//				System.out.println("####################################");
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//        
//        //Bloco que sempre será executado, independente de exception ou não.
//        finally 
//        {
//        	fabricaDeConexao.fecharConexao();
//		}
        		
    }
}
