package vmvini.controlesalas.view;

import java.sql.SQLException;
import java.util.Scanner;

import vmvini.controlesalas.controller.ControleNuloException;
import vmvini.controlesalas.controller.LoginValidacaoException;
import vmvini.controlesalas.controller.NaoTemAdminException;
import vmvini.controlesalas.controller.OperacaoNaoPermitida;
import vmvini.controlesalas.controller.SessaoLogin;
import vmvini.controlesalas.controller.UsuarioNaoEncontrado;
import vmvini.controlesalas.controller.UsuarioNuloException;
import vmvini.controlesalas.model.TipoUsuario;
import vmvini.controlesalas.model.Usuario;

public class ControleDeSalas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        telaInicial();
   }
    
    
     public static void logar(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Faça login no sistema: ");
        System.out.println("Login: ");
        String login = ler.next();
        System.out.println("Senha: ");
        String senha = ler.next();
        try{
            SessaoLogin.logar(login, senha);
            System.out.println("Seja bem vindo: " + SessaoLogin.getUsuarioLogado().getLogin());
            exibirOpcoesTelaInicial();
            
        }
        catch(SQLException e){
            //System.out.println("login erro. sql");
            System.out.println(e.getMessage());
        }
        catch(LoginValidacaoException e){
            //System.out.println("usuario ou senha incorreto. tente novamente: ");
            System.out.println(e.getMessage());
            logar();
        }
        catch(UsuarioNuloException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    
    public static void criarAdmin(){
        System.out.println("Digite os dados necessários:");
        Scanner ler = new Scanner(System.in);
        System.out.println("Login: ");
        String login = ler.next();
        System.out.println("Senha: ");
        String senha = ler.next();
        System.out.println("Matricula: ");
        String matricula = ler.next();
        System.out.println("Unidade Academica: ");
        String unidadeAcademica = ler.next();
        System.out.println("Email: ");
        String email = ler.next();
        
        try{
            //String nome, String senha, String unidadeAcademica, String email, String matricula
            SessaoLogin.cadastrarAdmin(login, senha, unidadeAcademica, email, matricula);
            System.out.println("admin criado com sucesso");
            logar();
        }
        catch(SQLException e){
           // System.out.println("erro sql: cadastrarAdmin");
            System.out.println(e.getMessage());
        }
        
            
    }
    
    public static TipoUsuario lerOpcaoTipoUsuario(){
        Scanner ler = new Scanner(System.in);
        switch(ler.nextInt()){
            case 1: 
                return TipoUsuario.PROFESSOR;
            case 2:
                return TipoUsuario.ASSISTENTE;
            case 3: 
                return TipoUsuario.ADMIN;
            default:
                System.out.println("comando invalido. digite novamente: ");
                return lerOpcaoTipoUsuario();
                    
        }
    }
    
    public static void cadastrar(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Insira os dados do novo usuario");
        System.out.println("Login: ");
        String login = ler.next();
        System.out.println("Senha: ");
        String senha = ler.next();
        System.out.println("Matricula: ");
        String matricula = ler.next();
        System.out.println("Unidade Academica: ");
        String unidadeAcademica = ler.next();
        System.out.println("Email: ");
        String email = ler.next();
        System.out.println("tipo de usuario. escolha o respectivo codigo: ");
        System.out.println("[3]Administrador");
        System.out.println("[2]Assistente de salas");
        System.out.println("[1]Professor");
        TipoUsuario tipo = lerOpcaoTipoUsuario();
        Usuario novo = new Usuario();
        novo.setEmail(email);
        novo.setLogin(login);
        novo.setMatricula(matricula);
        novo.setSenha(senha);
        novo.setTipoUsuario(tipo);
        novo.setUnidadeAcademica(unidadeAcademica);
        
        
        try{
            SessaoLogin.getControl().cadastrarUsuario(novo);
            System.out.println("Usuario cadastrado com sucesso");
            exibirOpcoesTelaInicial();
            
        }
        catch(ControleNuloException e){
            System.out.println(e.getMessage());
        }
        catch(SQLException e){
           // System.out.println("erro cadastrar usuario: sql");
            System.out.println(e.getMessage());
        }
        catch(OperacaoNaoPermitida e){
            //System.out.println("Cadastrar usaurio : operacao nao permitida. talvez vc nao tenha permissao\npara adicionar esse usuario");
            System.out.println(e.getMessage());
            exibirOpcoesTelaInicial();
        
        }
        
        
        
    }
    
    
    public static void remover(){
        Scanner ler = new Scanner(System.in);
        System.out.println();
        System.out.println("digite a matricula do usuario: ");
        String matricula = ler.next();
       
        try{
            Usuario u = SessaoLogin.getControl().buscarUsuario(matricula);
            SessaoLogin.getControl().removerUsuario(u); 
            System.out.println("Usuario removido com sucesso");
            System.out.println();
            if(SessaoLogin.getUsuarioLogado() != null)
                exibirOpcoesTelaInicial();
            
            
        }
        catch(UsuarioNuloException e){
            
            System.out.println(e.getMessage());
            telaInicial();
        }
        catch(ControleNuloException e){
            System.out.println(e.getMessage());
        }
        
        catch(SQLException e){
            //System.out.println("erro recuperar usuario por matricula sql");
            System.out.println(e.getMessage());
            //exibirOpcoesTelaInicial();
        }
        catch(OperacaoNaoPermitida e){
            //System.out.println("Voce nao pode remover esse usuario");
            System.out.println(e.getMessage());
            exibirOpcoesTelaInicial();
        }
        catch(UsuarioNaoEncontrado e){
            //System.out.println("Nao existe usuario com matricula = " + matricula);
            System.out.println(e.getMessage());
            exibirOpcoesTelaInicial();
        }
   }
    
    public static void lerOpcaoEscolhida(){
        Scanner ler = new Scanner(System.in);
        switch(ler.nextInt()){
            case 1: cadastrar();
                    break;
            case 2: remover();
                    break;
            case 3: SessaoLogin.logout();
                    logar();
                    break;
            case 4: 
                    System.out.println("Fim");
                    System.exit(0);
                
            default: 
                    System.out.println("comando invalido. Digite novamente");
                    lerOpcaoEscolhida();
            
        }
    }
    
    public static void exibirOpcoesTelaInicial(){
        System.out.println();
        
        System.out.println("Escolha uma das opcoes, digitando o respectivo codigo");
        System.out.println("[1]Cadastrar um usuario");
        System.out.println("[2]Remover um usuario");
        System.out.println("[3]Logout");
        System.out.println("[4]Fechar");
        
        lerOpcaoEscolhida();
    }
    
    public static void telaInicial() {
        System.out.println("alocação de salas");
       
        try{
            SessaoLogin.temAdmin();
            logar();
           
            
        }
        catch(SQLException e){
            //System.out.println("erro sql: iniciar sistema");
            System.out.println(e.getMessage());
        }
        catch(NaoTemAdminException e){
           // System.out.println("É a primeira vez executando. favor criar um usuário admin");
            System.out.println(e.getMessage());
            criarAdmin();
            
        }
        
        
    }
    
    
}
