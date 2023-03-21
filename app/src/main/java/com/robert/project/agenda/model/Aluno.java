package com.robert.project.agenda.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {
    private String nome;
    private String telefone;
    private String email;
    private int id = 0;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int identificador) {
        this.id = identificador;
    }

    public int getId() {
        return id;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
