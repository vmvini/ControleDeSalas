package vmvini.controlesalas.dao;

import java.sql.SQLException;

import vmvini.controlesalas.model.TipoUsuario;

public class ConstrutorDaoDB implements ConstrutorDaoInterface {
    
    public UsuarioDAO criarUsuarioDAO(TipoUsuario tipoUsuario) throws SQLException{
        if(tipoUsuario.equals(TipoUsuario.ADMIN))
            return new AdminDaoConcreto();
        else if(tipoUsuario.equals(TipoUsuario.ASSISTENTE))
            return new AssistenteDaoConcreto();
        return new ProfessorDaoConcreto();
    }
    
    
    
}