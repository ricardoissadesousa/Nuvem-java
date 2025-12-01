package com.example.nuvemjava.service;


import com.example.nuvemjava.model.Usuario;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UsuarioService {

    public String salvar(Usuario usuario) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> future = db.collection("usuarios").add(usuario);
        DocumentReference docRef = future.get();
        return docRef.getId();
    }
}