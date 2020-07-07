package cerva.com.cerva.model;

import cerva.com.cerva.model.enuns.Origem;
import cerva.com.cerva.model.enuns.Sabor;
import cerva.com.cerva.model.validation.SKU;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Cerveja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @SKU
    @NotBlank(message = "SKU é obrigatório")
    private String sku;

    @NotBlank(message = "NOME é obrigatório")
    private String nome;

    @Size(min = 1, max = 50, message = "O tamanho da descrição deve ser entre 1 e 50")
    private String descricao;

    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor;

    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal comissao;

    @NumberFormat(pattern = "#,##0.00")
    @Column(name = "teor_alcoolico")
    private BigDecimal teorAlcoolico;

    @Column(name = "quantidade_estoque")
    @NumberFormat(pattern = "#,##0")
    private Integer quantidadeEstoque;

    @Enumerated(EnumType.STRING)
    private Origem origem;

    @Enumerated(EnumType.STRING)
    private Sabor sabor;

    @ManyToOne
    @JoinColumn(name = "codigo_estilo")
    private Estilo estilo;

    private String foto;

    @Column(name = "content_type")
    private String contentType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cerveja cerveja = (Cerveja) o;
        return Objects.equals(codigo, cerveja.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @PrePersist @PreUpdate
    private void prePersistUpdate(){
        sku = sku.toUpperCase();
    }
}
