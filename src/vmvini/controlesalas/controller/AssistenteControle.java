package vmvini.controlesalas.controller;

import java.sql.SQLException;
import java.util.List;

import vmvini.controlesalas.dao.ConstrutorDaoDB;
import vmvini.controlesalas.dao.ConstrutorDaoInterface;
import vmvini.controlesalas.dao.UsuarioDAO;
import vmvini.controlesalas.model.TipoUsuario;
import vmvini.controlesalas.model.Usuario;

public class AssistenteControle implements Controle {
    
    ConstrutorDaoInterface construtorDao;  
    UsuarioDAO usuarioDao;
    
    public AssistenteControle() throws SQLException{
        construtorDao = new ConstrutorDaoDB();
        usuarioDao = construtorDao.criarUsuarioDAO(TipoUsuario.ASSISTENTE);
    }
    
    public void cadastrarUsuario(Usuario usuario) throws OperacaoNaoPermitida, SQLException{
        if(!usuario.getTipoUsuario().equals(TipoUsuario.PROFESSOR)){
            throw new OperacaoNaoPermitida("Você não pode adicionar esse tipo de usuario");
        }
        usuarioDao.cadastrarUsuario(usuario);
        
    }
    
    public void removerUsuario(Usuario usuario) throws OperacaoNaoPermitida, SQLException{
        if(!usuario.getTipoUsuario().equals(TipoUsuario.PROFESSOR)){
            throw new OperacaoNaoPermitida("Você não pode remover esse tipo de usuario");
        }
        usuarioDao.removerUsuario(usuario);
    }
    
    public List<Usuario> listarUsuarios() throws SQLException{
        return usuarioDao.listarUsuarios();
    }
    
    public Usuario buscarUsuario(String matricula ) throws SQLException, UsuarioNaoEncontrado{
        return usuarioDao.buscarUsuario(matricula);
    }
    
}
