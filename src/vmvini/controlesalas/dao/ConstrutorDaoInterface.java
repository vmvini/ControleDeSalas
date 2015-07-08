package vmvini.controlesalas.dao;

import java.sql.SQLException;

import vmvini.controlesalas.model.TipoUsuario;

public interface ConstrutorDaoInterface {

	/**
     * Serve para criar um objeto que implemente a interface UsuarioDAO.
     * @param tipoUsuario � um enum que representa o tipo do usu�rio logado no sistema.( Administrador | Assistente de Salas | Professor ). Cada tipo de usu�rio possui um UsuarioDAO associado.
     * @return retorna um objeto que implementa a interface UsuarioDAO
     * @throws SQLException 
     */
    UsuarioDAO criarUsuarioDAO(TipoUsuario tipoUsuario) throws SQLException;
}
