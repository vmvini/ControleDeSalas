package vmvini.controlesalas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vmvini.controlesalas.controller.LoginValidacaoException;
import vmvini.controlesalas.controller.NaoTemAdminException;
import vmvini.controlesalas.model.TipoUsuario;
import vmvini.controlesalas.model.Usuario;

public class DAOSistema {

	 private Connection con;
	    private String url = "jdbc:postgresql://localhost/controleDeSala";
	    private String user = "postgres";
	    private String password = "iniv10x";
	    private Statement statement;

	    public DAOSistema(){
	        try{
	            con = DriverManager.getConnection(url, user, password);
	        }
	        catch(SQLException e){
	            
	        }
	        
	    }
	    
	    /**
	     * Método usado para cadastrar o primeiro administrador do sistema. 
	     * @param nome
	     * @param senha
	     * @param unidadeAcademica
	     * @param email
	     * @param matricula
	     * @throws SQLException 
	     */
	    public void cadastrarAdmin(String nome, String senha, String unidadeAcademica, String email, String matricula) throws SQLException{
	        
	        String query = "insert into usuario (login, password, unidadeacademica, email, matricula, tipo) values (?,?,?,?,?, ?)";
	        PreparedStatement s = con.prepareStatement(query);
	        s.setString(1, nome);
	        s.setString(2, senha);
	        s.setString(3, unidadeAcademica);
	        s.setString(4, email);
	        s.setString(5, matricula);
	        s.setInt(6, TipoUsuario.ADMIN.getCODE());
	        s.executeUpdate();
	        s.close();
	        
	    }
	    
	    /**
	     * 
	     * Faz a validação de login. Verifica se existe usuário com login e senha fornecidos.
	     * @param nome
	     * @param senha
	     * @return retorna uma instancia do usuário validado.
	     * @throws LoginValidacaoException
	     * @throws SQLException 
	     */
	    public Usuario login(String nome, String senha) throws LoginValidacaoException, SQLException{
	        
	        String query = "select * from usuario where login = ? and password = ?";
	        PreparedStatement s = con.prepareStatement(query);
	        s.setString(1, nome);
	        s.setString(2, senha);
	        ResultSet r = s.executeQuery();
	        if(!r.next())
	            throw new LoginValidacaoException("Usuario ou Senha incorretos");
	        
	        Usuario u = new Usuario();
	        u.setEmail(r.getString("email"));
	        u.setLogin(r.getString("login"));
	        u.setMatricula(r.getString("matricula"));
	        u.setSenha(r.getString("password"));
	        u.setTipoUsuario( TipoUsuario.getTipo( r.getInt("tipo") ) );
	        u.setUnidadeAcademica(r.getString("unidadeacademica"));
	        return u;
	        
	    }
	    
	    /**
	     * Método que verifica se o sistema possui administrador cadastrado.
	     *
	     * @throws SQLException
	     * @throws NaoTemAdminException 
	     */
	    public void temAdmin() throws SQLException, NaoTemAdminException{
	        String query = "select * from usuario where tipo =  ?";
	        PreparedStatement s = con.prepareStatement(query);
	        s.setInt(1, TipoUsuario.ADMIN.getCODE());
	        ResultSet r = s.executeQuery();
	        if(!r.next())
	            throw new NaoTemAdminException("Não existe administrador cadastrado no sistema. Você deve cadastrar um");
	        
	        
	    }
	    
	
}
