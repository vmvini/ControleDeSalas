package vmvini.controlesalas.model;

import java.util.HashMap;
import java.util.Map;

public enum TipoUsuario {
	 ADMIN(3, "administrador"), ASSISTENTE(2,"assistente de salas"), PROFESSOR(1, "professor");
	    
	    
	    
	    private static final Map<Integer, TipoUsuario> tipoUsuario = new HashMap<Integer, TipoUsuario>();
	    /**
	     * O código abaixo é utilizado para que o método getTipo funcione.
	     * ele pega os valores (o codigo int) de cada tipo ENUM e registra junto ao tipo ENUM
	     * em um HashMap
	     * 
	     */
	    static{
	        for (TipoUsuario tipo : TipoUsuario.values()){
	            tipoUsuario.put(tipo.code, tipo);
	        }
	    }
	   /**
	    * Retorna o tipo enum de usuario respectivo a um código int.
	    * @param code inteiro que representa o tipo de usuario
	    * @return TipoUsuario 
	    */
	    public static TipoUsuario getTipo(int code){
	        TipoUsuario tipo  = tipoUsuario.get(Integer.valueOf(code));
	        return tipo;
	    }
	    
	    public int code;
	    public String desc;
	    
	    TipoUsuario(int code, String desc){
	        this.code = code;
	        this.desc = desc;
	    }
	    
	    public int getCODE(){
	        return this.code;
	    }
	    
	    public String getDesc(){
	        return this.desc;
	    }
}
