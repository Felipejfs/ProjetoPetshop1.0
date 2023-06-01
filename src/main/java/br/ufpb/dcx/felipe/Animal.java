package br.ufpb.dcx.felipe;

public class Animal {
    private String nome;
    private String especie;
    private String raca;

    public Animal(String nome, String especie, String raca) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Espécie: " + especie + ", Raça: " + raca;
    }
}






