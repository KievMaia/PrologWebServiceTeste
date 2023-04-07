package br.com.zalf.prolog.webservicetestes.movimento._model.entity;

import br.com.zalf.prolog.webservicetestes.processoMovimento._model.entity.ProcessoMovimento;
import br.com.zalf.prolog.webservicetestes.produto._model.entity.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
@Entity
@Table(name = "movimento")
public class Movimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "cod_processo", nullable = false)
    private ProcessoMovimento processo;
    
    @ManyToOne
    @JoinColumn(name = "cod_produto", nullable = false)
    private Produto produto;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;
    
    @Column(length = 255)
    private String especie;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
}
