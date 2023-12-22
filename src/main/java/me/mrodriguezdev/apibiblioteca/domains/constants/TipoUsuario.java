package me.mrodriguezdev.apibiblioteca.domains.constants;

public enum TipoUsuario {
    USUARIO(1),
    PERSONAL(2),
    ADMIN(3);

    private final Integer valor;

    TipoUsuario(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }
}
