/**
 * Author: Marco Corsini
 * Assignment 2
 */
package android.example.com.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView _RecyclerView;
    private RecipeListAdapter _Adapter;
    private LinkedList<Recipe> _recipes = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load recipes
        _recipes = DataProvider.getRecipes();

        //Locate the recycle View object
        _RecyclerView = findViewById(R.id.recyclerview);
        //Instantiate the adapter
        _Adapter = new RecipeListAdapter(this, _recipes);
        //Setup Recycle view
        _RecyclerView.setAdapter(_Adapter);
        _RecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
