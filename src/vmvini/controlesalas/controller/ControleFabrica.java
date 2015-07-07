package vmvini.controlesalas.controller;

import java.sql.SQLException;

import vmvini.controlesalas.model.TipoUsuario;

public class ControleFabrica {
	   
    /**
     * Cria um objeto que implementa a interface Controle.
     * @param t tipo de usuário enum. 
     * @return retorna um objeto que implementa a interface Controle, que pode ser AdminControle, AssistenteControle ou ProfessorControle.
     * @throws SQLException 
     */
    public static Controle criarControle(TipoUsuario t) throws SQLException{
        
        if(t.equals(TipoUsuario.ADMIN))
            return new AdminControle();
        else if(t.equals(TipoUsuario.ASSISTENTE))
            return new AssistenteControle();
        else
            return new ProfessorControle();
        
    }
    
    
}
