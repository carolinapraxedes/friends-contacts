package com.example.agenda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.DAO.AmigoDAO;
import com.example.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAmigosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //exibiçao da view. A class R é para acessar os resources
        setContentView(R.layout.activity_lista_amigos);
        setTitle("Lista de amigos");

        FloatingActionButton BotaoNovoAmigo = findViewById(R.id.activity_main_fab_novo_amigo);
        BotaoNovoAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaAmigosActivity.this,
                        FormularioAmigoActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        AmigoDAO dao = new AmigoDAO();

        ListView listaAmigos = findViewById(R.id.activity_main_listaAmigos);
        listaAmigos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}

