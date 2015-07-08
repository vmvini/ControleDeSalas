package vmvini.controlesalas.dao;

import java.sql.SQLException;
import java.util.List;

import vmvini.controlesalas.controller.UsuarioNaoEncontrado;
import vmvini.controlesalas.model.Usuario;

/**
 * Interface que define quais funcionalidades um DAO de usu�rio deve possuir.
 * @author vmvini
 */
public interface UsuarioDAO {

	/**
     * Persiste um novo usu�rio no banco de dados.
     * @param usuario
     * @throws SQLException 
     */
    public void cadastrarUsuario(Usuario usuario) throws SQLException;
    
    /**
     * Remove um usu�rio do banco de dados.
     * @param usuario
     * @throws SQLException 
     */
    public void removerUsuario(Usuario usuario) throws SQLException;
    
    /**
     * Lista os usu�rios existentes no banco de dados.
     * @return retorna uma lista de usu�rios.
     * @throws SQLException 
     */
    public List<Usuario> listarUsuarios() throws SQLException;
    
    /**
     * 
     * @param matricula
     * @return retorna um usu�rio que possui a matricula passada por par�metro.
     * @throws SQLException
     * @throws UsuarioNaoEncontrado 
     */
    public Usuario buscarUsuario(String matricula) throws SQLException, UsuarioNaoEncontrado;
	
}
