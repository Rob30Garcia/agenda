package com.robert.project.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.robert.project.agenda.R;
import com.robert.project.agenda.dao.AlunoDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaDeAlunosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista da Alunos");

        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(view -> {
            startActivity(new Intent(ListaDeAlunosActivity.this, FormularioAlunoActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        AlunoDAO dao = new AlunoDAO();

        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Robert", "Lucas"));
        ListView listDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, dao.todos()));
    }
}
