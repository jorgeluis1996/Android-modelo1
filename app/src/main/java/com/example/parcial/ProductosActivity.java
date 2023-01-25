package com.example.parcial;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.parcial.adapters.ProductoAdapter;
import com.example.parcial.databinding.ActivityProductosBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductosActivity extends AppCompatActivity implements ProductoAdapter.OnItemClickListener {
    private ActivityProductosBinding binding;
    ArrayList arrayList = new ArrayList<HashMap<String,String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        leerDatos();
    }




    private void leerDatos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://servicios.campus.pe/servicioproductostodos.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS",response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOSERROR",error.getMessage());
            }

        });
        queue.add(stringRequest);
    }
    private void llenarLista(String response) {

        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0; i< jsonArray.length(); i++ ){
                String idproducto = jsonArray.getJSONObject(i).getString("idproducto");
                String nombre = jsonArray.getJSONObject(i).getString("nombre");
                String precio = jsonArray.getJSONObject(i).getString("precio");
                String detalle = jsonArray.getJSONObject(i).getString("detalle");
                String imagenchica = jsonArray.getJSONObject(i).getString("imagenchica");
                HashMap<String,String> map = new HashMap<>();
                map.put("idproducto",idproducto);
                map.put("nombre",nombre);
                map.put("detalle",detalle);
                map.put("precio",precio);
                map.put("imagenchica",imagenchica);
                arrayList.add(map);
            }


            ProductoAdapter productoAdapter = new ProductoAdapter(arrayList);
            binding.rvProductos.setAdapter(productoAdapter);

            binding.rvProductos.setLayoutManager(new GridLayoutManager(this, 1));

            productoAdapter.setOnItemClickListener(this);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(int position) {
        //Log.d("POS-ACTI",String.valueOf(position));
        HashMap<String,String> map = (HashMap<String,String>) arrayList.get(position);
        String detalle = map.get("detalle");
        Toast.makeText(this, detalle, Toast.LENGTH_SHORT).show();


    }
}