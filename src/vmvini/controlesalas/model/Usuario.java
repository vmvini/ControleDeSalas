package vmvini.controlesalas.model;

public class Usuario {

	private String login;
    private String senha;
    private String email;
    private String unidadeAcademica;
    private TipoUsuario tipo;
    private String matricula;
    
    public Usuario(){
        
    }
    public Usuario(int tipo){
        this.tipo = TipoUsuario.getTipo(tipo);
    }
    
    public Usuario(String login, String senha, String email, String unidadeAcademica, int tipo, String matricula){
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.unidadeAcademica = unidadeAcademica;
        this.tipo = TipoUsuario.getTipo(tipo);
        this.matricula = matricula;
    }
    
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getUnidadeAcademica(){
        return this.unidadeAcademica;
    }
    public void setUnidadeAcademica(String unidadeAcademica){
        this.unidadeAcademica = unidadeAcademica;
    }
    public TipoUsuario getTipoUsuario(){
        return this.tipo;
    }
    public void setTipoUsuario(TipoUsuario tipo){
        this.tipo = tipo;
    }
    public String getMatricula(){
        return this.matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }    
    
         
	
}
