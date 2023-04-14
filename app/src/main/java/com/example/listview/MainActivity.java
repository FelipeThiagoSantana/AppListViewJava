package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String [] itens = {
            "Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Costa do Sauípe",
            "Ilheus", "Porto Seguro", "Tiradentes",
            "Praga", "Santiago", "Zurique", "Caribe",
            "Maragogi", "Praia do Gunga", "Aruba", "Budapeste"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listaLocais);

        //Criando um adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                //modelos de lista do propio android
                android.R.layout.simple_list_item_1,
                //Identificador ou Id do Layout para selecionar o elemento de interface para ser usdo
                android.R.id.text1,
                itens );

            //Adiciona adaptador para a lista
            listLocais.setAdapter(adaptador);

            //Adicionar clique na lista
           listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                   Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
               }
           });
    }
}