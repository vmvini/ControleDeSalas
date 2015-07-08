package vmvini.controlesalas.dao;

import java.sql.SQLException;
import java.util.List;

import vmvini.controlesalas.controller.UsuarioNaoEncontrado;
import vmvini.controlesalas.model.Usuario;

/**
 * Interface que define quais funcionalidades um DAO de usuário deve possuir.
 * @author vmvini
 */
public interface UsuarioDAO {

	/**
     * Persiste um novo usuário no banco de dados.
     * @param usuario
     * @throws SQLException 
     */
    public void cadastrarUsuario(Usuario usuario) throws SQLException;
    
    /**
     * Remove um usuário do banco de dados.
     * @param usuario
     * @throws SQLException 
     */
    public void removerUsuario(Usuario usuario) throws SQLException;
    
    /**
     * Lista os usuários existentes no banco de dados.
     * @return retorna uma lista de usuários.
     * @throws SQLException 
     */
    public List<Usuario> listarUsuarios() throws SQLException;
    
    /**
     * 
     * @param matricula
     * @return retorna um usuário que possui a matricula passada por parâmetro.
     * @throws SQLException
     * @throws UsuarioNaoEncontrado 
     */
    public Usuario buscarUsuario(String matricula) throws SQLException, UsuarioNaoEncontrado;
	
}
