/**
 * Author: Marco Corsini
 * Assignment 2
 *
 * Activity to display the full recipe
 */
package android.example.com.recipebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        //Get the intent
        Intent intent = getIntent();
        if(intent != null) {

            //Get the extras
            Bundle extras = intent.getExtras();

            if(extras == null){
                return;
            }

            //Display data
            TextView title = findViewById(R.id.title);
            title.setText(extras.getString("name"));

            ImageView image = findViewById(R.id.image);
            Picasso.get()
                    .load(extras.getString("image"))
                    .fit()
                    .placeholder(R.drawable.ic_stat_load)
                    .error(R.drawable.ic_stat_error)
                    .into(image);

            TextView ingredients = findViewById(R.id.ingredients);
            ingredients.setText(extras.getString("ingredients"));

            TextView directions = findViewById(R.id.directions);
            directions.setText(extras.getString("directions"));
        }
    }
}
