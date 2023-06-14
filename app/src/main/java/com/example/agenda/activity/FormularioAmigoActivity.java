package com.example.agenda.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.DAO.AmigoDAO;
import com.example.agenda.R;
import com.example.agenda.model.Amigo;

public class FormularioAmigoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_amigo);
        setTitle("Adicionar novo amigo");

        AmigoDAO dao = new AmigoDAO();


        final EditText campoNome = findViewById(R.id.activity_main_formulario_amigo_nome);
        final EditText campoTelefone = findViewById(R.id.activity_main_formulario_amigo_telefone);
        final EditText campoEmail = findViewById(R.id.activity_main_formulario_amigo_email);

        Button botsoaSalvar = findViewById(R.id.activity_main_formulario_botao_salvar);
        botsoaSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();


                Amigo amigoNovo = new Amigo(nome, telefone, email);
                dao.salva(amigoNovo);

                Toast.makeText(FormularioAmigoActivity.this,
                        "Amigo registrado com Sucesso",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(FormularioAmigoActivity.this,
                        ListaAmigosActivity.class));
                finish();
            }
        });
    }
}