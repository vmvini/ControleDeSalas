package vmvini.controlesalas.controller;



import java.sql.SQLException;
import java.util.List;

import vmvini.controlesalas.model.Usuario;

public interface Controle {

	/**
     * Método utilizado para cadastrar novo usuário.
     * @param usuario Para cadastrar um usuário, antes é necessário setar as informações do novo usuário em uma instancia de Usuário. Depois é preciso passar essa instância por parâmetro nesse método.
     * @throws OperacaoNaoPermitida Exceção lançada quando o usuário logado no sistema ( encontrado em SessaoLogin.usuarioLogado ) não tem permissão para cadastrar o usuário passado por parâmetro nesse método.
     * @throws SQLException 
     */
    void cadastrarUsuario(Usuario usuario) throws OperacaoNaoPermitida, SQLException;
    
    
    /**
     * Método utilizado para remover um usuário.
     * @param usuario Para remover um usuário, deve ser passado a instância desse usuário.
     * @throws OperacaoNaoPermitida Usuário logado no sistema ( SessaoLogin.usuarioLogado ) não tem permissão para remover o usuário passado por parâmetro. 
     * @throws SQLException 
     * @throws UsuarioNuloException Lançada se o SessaoLogin.usuarioLogado for nulo.
     */
    void removerUsuario(Usuario usuario) throws OperacaoNaoPermitida, SQLException, UsuarioNuloException;
    
    
    /**
     * Esse método retorna a lista de usuários cadastrados no sistema.
     * @return retorna uma lista de usuários.
     * @throws OperacaoNaoPermitida Usuário logado não tem permissão para listar usuários cadastrados.
     * @throws SQLException 
     */
    List<Usuario> listarUsuarios() throws OperacaoNaoPermitida, SQLException;
    
    /**
     * Esse método retorna uma instancia do usuário que possui a matricula passada por parâmetro.
     * @param matricula atributo matricula de usuário.
     * @return instancia de um usuário
     * @throws OperacaoNaoPermitida Usuário logado não tem permissão para buscar usuários.
     * @throws SQLException
     * @throws UsuarioNaoEncontrado Lançada quando não existe usuário com a matricula passada por parâmetro.
     */
    Usuario buscarUsuario(String matricula ) throws OperacaoNaoPermitida, SQLException, UsuarioNaoEncontrado;
    
	
}
