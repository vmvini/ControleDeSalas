package vmvini.controlesalas.controller;

import java.sql.SQLException;
import java.util.List;

import vmvini.controlesalas.dao.ConstrutorDaoDB;
import vmvini.controlesalas.dao.ConstrutorDaoInterface;
import vmvini.controlesalas.dao.UsuarioDAO;
import vmvini.controlesalas.model.TipoUsuario;
import vmvini.controlesalas.model.Usuario;

public class AdminControle implements Controle {
 
    ConstrutorDaoInterface construtorDao;
    UsuarioDAO usuarioDao;
    
    public AdminControle() throws SQLException{
        construtorDao = new ConstrutorDaoDB();
        usuarioDao =  construtorDao.criarUsuarioDAO(TipoUsuario.ADMIN);
    }
    
    public void cadastrarUsuario(Usuario usuario) throws SQLException{
        usuarioDao.cadastrarUsuario(usuario);
    }
    
    public void removerUsuario(Usuario usuario) throws OperacaoNaoPermitida, SQLException, UsuarioNuloException{
        
        if(usuario.getTipoUsuario().equals(TipoUsuario.ADMIN)){
            if(!SessaoLogin.getUsuarioLogado().getMatricula().equals(usuario.getMatricula()))
                throw new OperacaoNaoPermitida("Você não pode removar outro administrador");
            else{
                usuarioDao.removerUsuario(usuario);
                SessaoLogin.logout();
            }
        }
        else
         usuarioDao.removerUsuario(usuario);
        
        
    }
    
    public List<Usuario> listarUsuarios() throws SQLException{
        return usuarioDao.listarUsuarios();
    }
    
    public Usuario buscarUsuario(String matricula ) throws SQLException, UsuarioNaoEncontrado{
        return usuarioDao.buscarUsuario(matricula);
    }
    
}
