package com.example.carrinho_de_compras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.add_item);
        Button Save = findViewById(R.id.btn_save);

        lv = findViewById(R.id.lv);

        ArrayList<String> listaNomes = new ArrayList<>();

        //add - adicionar novo elemento à lista
        listaNomes.add("Carne");
        listaNomes.add("Refrigerante");
        listaNomes.add("Macarrão");
        listaNomes.add("Tomate");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, listaNomes
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        "Elemento clicado " + i + " --> " + listaNomes.get(i),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaNomes.add(input.getText().toString());
                adapter.notifyDataSetChanged();
                input.setText("");
            }
        });

        /*
        //get - retorna o valor de uma posição na lista
        int numeroSelecionado = listaNumeros.get(0); //numeroSelecionado = 10

        //remove - eliminar um elemento da lista
        listaNumeros.remove(0); //remove da lista número 10

        //size - devolve números de elementos na lista
        int tamanho = listaNumeros.size(); // tamanho = 4

        //clear
        listaNumeros.clear(); // retirar todos os elementos da lista
         */

    }
}