package cerva.com.cerva.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Estilo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Size(min = 1,max = 80,message = "Campo nome de estilo deve ser informado")
    private String nome;

    @OneToMany(mappedBy = "estilo")
    private List<Cerveja> cervejas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estilo estilo = (Estilo) o;
        return Objects.equals(codigo, estilo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
