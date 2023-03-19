package com.robert.project.agenda.ui.activity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.robert.project.agenda.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaDeAlunosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Robert", "Lucas"));
        ListView listDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, alunos));
    }
}
