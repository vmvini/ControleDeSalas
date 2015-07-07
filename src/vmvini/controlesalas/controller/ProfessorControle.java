package vmvini.controlesalas.controller;

import java.util.List;

import vmvini.controlesalas.model.Usuario;

public class ProfessorControle implements Controle {
    
    
    public void cadastrarUsuario(Usuario usuario) throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Você não pode cadastrar usuarios");
    }
    
    public void removerUsuario(Usuario usuario) throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Você não pode remover usuarios");
    }
    
    public List<Usuario> listarUsuarios() throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Você não listar usuarios");
    }
    
    public Usuario buscarUsuario(String matricula ) throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Você não pode buscar usuario");
    }
}
