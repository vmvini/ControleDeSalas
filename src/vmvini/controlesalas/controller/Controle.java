package vmvini.controlesalas.controller;



import java.sql.SQLException;
import java.util.List;

import vmvini.controlesalas.model.Usuario;

public interface Controle {

	/**
     * M�todo utilizado para cadastrar novo usu�rio.
     * @param usuario Para cadastrar um usu�rio, antes � necess�rio setar as informa��es do novo usu�rio em uma instancia de Usu�rio. Depois � preciso passar essa inst�ncia por par�metro nesse m�todo.
     * @throws OperacaoNaoPermitida Exce��o lan�ada quando o usu�rio logado no sistema ( encontrado em SessaoLogin.usuarioLogado ) n�o tem permiss�o para cadastrar o usu�rio passado por par�metro nesse m�todo.
     * @throws SQLException 
     */
    void cadastrarUsuario(Usuario usuario) throws OperacaoNaoPermitida, SQLException;
    
    
    /**
     * M�todo utilizado para remover um usu�rio.
     * @param usuario Para remover um usu�rio, deve ser passado a inst�ncia desse usu�rio.
     * @throws OperacaoNaoPermitida Usu�rio logado no sistema ( SessaoLogin.usuarioLogado ) n�o tem permiss�o para remover o usu�rio passado por par�metro. 
     * @throws SQLException 
     * @throws UsuarioNuloException Lan�ada se o SessaoLogin.usuarioLogado for nulo.
     */
    void removerUsuario(Usuario usuario) throws OperacaoNaoPermitida, SQLException, UsuarioNuloException;
    
    
    /**
     * Esse m�todo retorna a lista de usu�rios cadastrados no sistema.
     * @return retorna uma lista de usu�rios.
     * @throws OperacaoNaoPermitida Usu�rio logado n�o tem permiss�o para listar usu�rios cadastrados.
     * @throws SQLException 
     */
    List<Usuario> listarUsuarios() throws OperacaoNaoPermitida, SQLException;
    
    /**
     * Esse m�todo retorna uma instancia do usu�rio que possui a matricula passada por par�metro.
     * @param matricula atributo matricula de usu�rio.
     * @return instancia de um usu�rio
     * @throws OperacaoNaoPermitida Usu�rio logado n�o tem permiss�o para buscar usu�rios.
     * @throws SQLException
     * @throws UsuarioNaoEncontrado Lan�ada quando n�o existe usu�rio com a matricula passada por par�metro.
     */
    Usuario buscarUsuario(String matricula ) throws OperacaoNaoPermitida, SQLException, UsuarioNaoEncontrado;
    
	
}
