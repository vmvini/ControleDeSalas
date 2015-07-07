package vmvini.controlesalas.controller;

import java.util.List;

import vmvini.controlesalas.model.Usuario;

public class ProfessorControle implements Controle {
    
    
    public void cadastrarUsuario(Usuario usuario) throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Voc� n�o pode cadastrar usuarios");
    }
    
    public void removerUsuario(Usuario usuario) throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Voc� n�o pode remover usuarios");
    }
    
    public List<Usuario> listarUsuarios() throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Voc� n�o listar usuarios");
    }
    
    public Usuario buscarUsuario(String matricula ) throws OperacaoNaoPermitida{
        throw new OperacaoNaoPermitida("Voc� n�o pode buscar usuario");
    }
}
