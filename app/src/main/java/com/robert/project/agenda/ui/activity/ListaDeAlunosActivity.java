package com.robert.project.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.robert.project.agenda.R;
import com.robert.project.agenda.dao.AlunoDAO;
import com.robert.project.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaDeAlunosActivity extends AppCompatActivity {
    public static final String TTTULO_APPBAR = "Lista de Alunos";
    public final AlunoDAO dao = new AlunoDAO();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TTTULO_APPBAR);
        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(view -> {
            abreFormularioAlunoActivity();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    private void configuraLista() {
        ListView listDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        final List<Aluno> alunos = dao.todos();
        listDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, dao.todos()));
        listDeAlunos.setOnItemClickListener((adapterView, view, position, id) -> {
            Aluno alunoEscolhido = alunos.get(position);
            Log.i("idAluno", String.valueOf(alunoEscolhido.getId()));
            Intent vaiParaFormularioActivity = new Intent(ListaDeAlunosActivity.this, FormularioAlunoActivity.class);
            vaiParaFormularioActivity.putExtra("aluno", alunoEscolhido);
            startActivity(vaiParaFormularioActivity);
        });
    }
}
