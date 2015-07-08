package vmvini.controlesalas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vmvini.controlesalas.controller.UsuarioNaoEncontrado;
import vmvini.controlesalas.model.TipoUsuario;
import vmvini.controlesalas.model.Usuario;

public class AssistenteDaoConcreto extends UsuarioDaoPadrao {
    
    
    public AssistenteDaoConcreto() throws SQLException{
        
    }
    
    
    public List<Usuario> listarUsuarios() throws SQLException{
        List<Usuario> lista = new ArrayList();
        Usuario u = new Usuario();
        String query = "select * from usuario where tipo = ?";
        PreparedStatement s = con.prepareStatement(query);
        s.setInt(1, TipoUsuario.PROFESSOR.getCODE());
        ResultSet r = s.executeQuery();
        while(r.next()){
            u.setEmail(r.getString("email"));
            u.setLogin(r.getString("login"));
            u.setSenha(r.getString("password"));
            u.setMatricula(r.getString("matricula"));
            u.setUnidadeAcademica(r.getString("unidadeacademica"));
            u.setTipoUsuario( TipoUsuario.getTipo( r.getInt("tipo") ) );
            lista.add(u);
        }
        return lista;
    }
    
    public Usuario buscarUsuario(String matricula) throws SQLException, UsuarioNaoEncontrado{
        Usuario u = new Usuario();
        String query = "select * from usuario where tipo = ? and matricula = ?";
        PreparedStatement s = con.prepareStatement(query);
        s.setInt(1, TipoUsuario.PROFESSOR.getCODE());
        s.setString(2, matricula);
        ResultSet r = s.executeQuery();
        while(r.next()){
            u.setEmail(r.getString("email"));
            u.setLogin(r.getString("login"));
            u.setSenha(r.getString("password"));
            u.setMatricula(r.getString("matricula"));
            u.setUnidadeAcademica(r.getString("unidadeacademica"));
            u.setTipoUsuario( TipoUsuario.getTipo( r.getInt("tipo") ) );
            
        }
        
        if(u.getMatricula() == null){
            
            throw new UsuarioNaoEncontrado("Nao existe usuario com essa matricula");
        }
        
        return u;
    }
    
    
}
