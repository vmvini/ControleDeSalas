package vmvini.controlesalas.controller;

public class OperacaoNaoPermitida extends Exception {
    
    OperacaoNaoPermitida(String message){
        super(message);
    }
    
}
