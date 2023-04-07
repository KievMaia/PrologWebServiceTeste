package br.com.zalf.prolog.webservicetestes.exception;

public class ItemNaoEncontradoException extends EntidadeNaoEncontradaException{
    private static final long serialVersionUID = 1L;
    public ItemNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    public ItemNaoEncontradoException(final Long itemId){
        this(String.format("Não existe um cadastro de item com o codigo %d", itemId));
    }
}
