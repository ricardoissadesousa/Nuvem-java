package com.example.nuvemjava.service;

import com.exemplo.firebase.model.Usuario;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UsuarioService {

    public String salvar(Usuario usuario) throws InterruptedException, ExecutionException {
        // Lógica de conexão com o banco fica isolada aqui
        Firestore db = FirestoreClient.getFirestore();

        // Salva na coleção "usuarios"
        ApiFuture<DocumentReference> future = db.collection("usuarios").add(usuario);

        // Aguarda o resultado
        DocumentReference docRef = future.get();

        return docRef.getId();
    }
}
