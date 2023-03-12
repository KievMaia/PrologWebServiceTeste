package br.com.zalf.prolog.webservicetestes.exception;

public class PartNaoEncontradaException extends EntidadeNaoEncontradaException{
    private static final long serialVersionUID = 1L;
    public PartNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
    public PartNaoEncontradaException(final Long partId){
        this(String.format("Não existe um cadastro de peça com o codigo %d", partId));
    }
}
