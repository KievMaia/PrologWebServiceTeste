package br.com.zalf.prolog.webservicetestes.exception;

public class CategoriaNaoEncontradaException extends EntidadeNaoEncontradaException{
    private static final long serialVersionUID = 1L;
    public CategoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
    public CategoriaNaoEncontradaException(final Long categoriaId){
        this(String.format("Não existe um cadastro de categoria com o codigo %d", categoriaId));
    }
}
