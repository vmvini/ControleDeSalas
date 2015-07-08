package vmvini.controlesalas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vmvini.controlesalas.controller.UsuarioNaoEncontrado;
import vmvini.controlesalas.model.TipoUsuario;
import vmvini.controlesalas.model.Usuario;

public class UsuarioDaoPadrao implements UsuarioDAO {
    
    protected Connection con;
    protected String url = "jdbc:postgresql://localhost/controleDeSala";
    protected String user = "postgres";
    protected String password = "iniv10x";
    protected Statement statement;

    public UsuarioDaoPadrao() throws SQLException{
        con = DriverManager.getConnection(url, user, password);
        statement = con.createStatement();
    }
    
    public void cadastrarUsuario(Usuario usuario) throws SQLException{
        String query = "insert into usuario (login, password, email, matricula, unidadeacademica, tipo) values (?,?,?,?,?,?)";
        PreparedStatement s = con.prepareStatement(query);
        s.setString(1, usuario.getLogin());
        s.setString(2, usuario.getSenha());
        s.setString(3, usuario.getEmail());
        s.setString(4, usuario.getMatricula());
        s.setString(5, usuario.getUnidadeAcademica());
        s.setInt(6, usuario.getTipoUsuario().getCODE());
        s.executeUpdate();
        s.close();
        
    }
    
    public void removerUsuario(Usuario usuario) throws SQLException{
        String query = "delete from usuario where matricula = ?";
        PreparedStatement s = con.prepareStatement(query);
        s.setString(1, usuario.getMatricula());
        s.executeUpdate();
        s.close();
    }
    
    public List<Usuario> listarUsuarios() throws SQLException{
        List<Usuario> lista = new ArrayList();
        Usuario u = new Usuario();
        String query = "select * from usuario";
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(query);
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
        String query = "select * from usuario where matricula = ?";
        PreparedStatement s = con.prepareStatement(query);
        s.setString(1, matricula);
        ResultSet r = s.executeQuery();
        
           // 
        
        while(r.next()){
            
            u.setEmail(r.getString("email"));
            u.setLogin(r.getString("login"));
            u.setSenha(r.getString("password"));
            u.setMatricula(r.getString("matricula"));
            u.setUnidadeAcademica(r.getString("unidadeacademica"));
            u.setTipoUsuario( TipoUsuario.getTipo( r.getInt("tipo") ) );
        }
        
        if(u.getMatricula() == null)
            throw new UsuarioNaoEncontrado("Nao existe usuario com essa matricula");
        
        return u;
    }
    
    
    
}
