package com.robert.project.agenda.dao;

import com.robert.project.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<Aluno>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<Aluno>(alunos);
    }
}
