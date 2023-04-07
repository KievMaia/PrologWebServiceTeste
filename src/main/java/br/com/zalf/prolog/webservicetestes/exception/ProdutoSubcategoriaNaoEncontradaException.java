package br.com.zalf.prolog.webservicetestes.exception;

public class ProdutoSubcategoriaNaoEncontradaException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;
    public ProdutoSubcategoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
    public ProdutoSubcategoriaNaoEncontradaException(final Long produtoSubcategoriaId){
        this(String.format("Não existe um cadastro de subcategoria com o codigo %d", produtoSubcategoriaId));
    }
}
