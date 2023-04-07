package br.com.zalf.prolog.webservicetestes.exception;

public class EmpresaNaoEncontradaException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public EmpresaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public EmpresaNaoEncontradaException(final Long empresaId) {
        this(String.format("Não existe um cadastro de empresa com o codigo %d", empresaId));
    }
}
