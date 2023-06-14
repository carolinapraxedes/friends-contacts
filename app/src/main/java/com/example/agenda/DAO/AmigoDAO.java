package com.example.agenda.DAO;

import com.example.agenda.model.Amigo;

import java.util.ArrayList;
import java.util.List;

public class AmigoDAO {
    private final static List<Amigo> amigos  = new ArrayList<Amigo>();
    public void salva(Amigo amigoNovo) {
        //SALVA NUMA LISTA ESTATICA
        amigos.add(amigoNovo);
    }

    public List<Amigo> todos() {
        return new ArrayList<>(amigos);
    }
}
