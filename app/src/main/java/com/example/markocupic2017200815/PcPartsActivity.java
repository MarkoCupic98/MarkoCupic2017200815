package com.example.markocupic2017200815;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PcPartsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<PcPart> pcParts;
    private static String JSON_URL = "https://my-pcparts-api.herokuapp.com/category";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_parts);

        recyclerView = findViewById(R.id.partsList);
        pcParts = new ArrayList<>();

        extractParts();
    }

    private void extractParts() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject pcPartObject = response.getJSONObject(i);

                        PcPart pcPart = new PcPart();
                        pcPart.setName(pcPartObject.getString("name"));
                        pcPart.setDescription(pcPartObject.getString("description"));
                        pcPart.setWhereToBuy(pcPartObject.getString("whereToBuy"));
                        pcPart.setImage(pcPartObject.getString("image"));
                        pcPart.setUrlSite(pcPartObject.getString("urlSite"));

                        pcParts.add(pcPart);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(), pcParts);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);
    }
}