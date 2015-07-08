package vmvini.controlesalas.controller;

import java.sql.SQLException;

import vmvini.controlesalas.dao.DAOSistema;
import vmvini.controlesalas.model.Usuario;

public class SessaoLogin {

	private static Usuario usuarioLogado;
    private static Controle controle;
    
    private static final DAOSistema dao = new DAOSistema();
   
    
    
    protected SessaoLogin(){
        
    }
    /**
     * Coloca usuario como logado e cria um controle para esse tipo de usu�rio.
     * @param usuario
     * @throws SQLException 
     */
    private static void iniciarSessao(Usuario usuario) throws SQLException{
        if(usuarioLogado == null){
            usuarioLogado = usuario;
            Controle c = ControleFabrica.criarControle(usuarioLogado.getTipoUsuario());
            controle = c;
        }
    }
    
    /**
     * Realiza o login de usu�rio no sistema. Caso n�o ocorra nada de errado, a sess�o � iniciada.
     * @param nome
     * @param senha
     * @throws LoginValidacaoException
     * @throws SQLException 
     */
    public static void logar(String nome, String senha) throws LoginValidacaoException, SQLException{
        Usuario u = dao.login(nome, senha);
        iniciarSessao(u);
    }
    
    /**
     * Serve para cadastrar o primeiro administrador do sistema. Esse m�todo deve ser usado quando a exce��o NaoTemAdminException for lan�ada. 
     * @param nome
     * @param senha
     * @param unidadeAcademica
     * @param email
     * @param matricula
     * @throws SQLException 
     */
    public static void cadastrarAdmin(String nome, String senha, String unidadeAcademica, String email, String matricula) throws SQLException{
        
       dao.cadastrarAdmin(nome, senha, unidadeAcademica, email, matricula);
    }
    
    /**
     * Esse m�todo deve ser o primeiro a ser executado no sistema. Verifica se o sistema tem administrador.
     * @throws NaoTemAdminException Se essa exce��o for lan�ada, deve ser tratada usando o m�todo cadastrarAdmin da classe SessaoLogin.
     * @throws SQLException 
     */
    public static void temAdmin() throws NaoTemAdminException, SQLException{
        dao.temAdmin();
    }
    
    /**
     * Para realizar opera��es do usu�rio, � preciso acessar seu objeto de controle atrav�s desse m�todo.
     * @return retorna o objeto de controle que foi gerado para o usu�rio logado.
     * @throws ControleNuloException 
     */
    public static Controle getControl() throws ControleNuloException{
        if(controle == null) throw new ControleNuloException("� preciso logar no sistema para ter acesso ao controle");
        return controle;
    }
    
    /**
     * 
     * @return retorna o usu�rio logado no sistema.
     * @throws UsuarioNuloException 
     */
    public static Usuario getUsuarioLogado() throws UsuarioNuloException{
        if(usuarioLogado == null) throw new UsuarioNuloException("N�o existe usu�rio logado no sistema");
        return usuarioLogado;
    }
    
    /**
     * Usado para fechar a sess�o de um usu�rio logado.
     */
    public static void logout(){
        controle = null;
        usuarioLogado = null;
    }
	
}
