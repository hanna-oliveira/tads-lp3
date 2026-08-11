package br.edu.ifsp.orderflow.domain;

public class Cliente {
    private final String id;
    private final String nome;
    private final String email;

    //construtor
    public Cliente (String id , String nome , String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getId() {return this.id;}
    public String getNome() {return this.nome;}
    public String getEmail() {return this.email;}

    @Override
    public String toString () {
        return this.nome + " <" + this.email + ">";
    }
}
