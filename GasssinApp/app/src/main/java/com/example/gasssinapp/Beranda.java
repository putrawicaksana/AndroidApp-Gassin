package com.example.gasssinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Beranda extends AppCompatActivity implements ProductAdapter.OnItemClickListener
{
    private Animation topAnim;
    private ImageView gassinshots, sample1;
    private ImageButton profile;
    private TextView sloganshots;

    private String url = Constant.URL+ "karya.php";

    List<Product> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        //animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        //declare
        gassinshots = findViewById(R.id.gassinshot);
        sloganshots = findViewById(R.id.sloganshot);
        profile = findViewById(R.id.profile);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();
        loadProducts();
        /*
        gassinshots.setAnimation(topAnim);
        sample1.setAnimation(topAnim);
        sloganshots.setAnimation(topAnim);
        */
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent4 = new Intent(Beranda.this, Profile.class);
                startActivity(intent4);
            }
        });
    }
    private void loadProducts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new Product(
                                        product.getInt("id"),
                                        product.getString("title"),
                                        product.getString("shortdesc"),
                                        product.getString("user"),
                                        product.getString("platform"),
                                        product.getString("image")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            ProductAdapter adapter = new ProductAdapter(Beranda.this, productList);
                            recyclerView.setAdapter(adapter);
                            ProductAdapter.setOnItemClickListener(Beranda.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    @Override
    public void onItemClick(int position) {
        Intent popintent = new Intent(this, Pop.class);

        startActivity(popintent);
    }
}
