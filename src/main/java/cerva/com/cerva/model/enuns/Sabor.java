package cerva.com.cerva.model.enuns;

public enum Sabor {
    ADOCICADA ("Adocicada"),
    AMARGA ("Amarga"),
    FORTE ("Forte"),
    FRUTADA ("Frutada"),
    SUAVE ("Suave");

    private String descricao;

    Sabor(String sabor){
        this.descricao = sabor;
    }

    public String getDescricao() {
        return descricao;
    }
}
