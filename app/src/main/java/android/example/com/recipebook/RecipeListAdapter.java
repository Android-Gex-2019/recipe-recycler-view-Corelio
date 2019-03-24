/**
 * Author: Marco Corsini
 * Assignment 2
 *
 * Adapter for the Recipe List
 */
package android.example.com.recipebook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;


public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private LinkedList<Recipe> _recipes;
    private LayoutInflater _Inflater;
    private Context _context;

    //Constructor
    public RecipeListAdapter(Context context, LinkedList<Recipe> recipes){
        _context = context;
        _Inflater = LayoutInflater.from(context);
        this._recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View _ItemView = _Inflater.inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(_ItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        Recipe _Current = _recipes.get(position);
        holder.titleItemView.setText(_Current.name);
        holder.descItemView.setText(_Current.description);
    }

    @Override
    public int getItemCount() {
        return _recipes.size();
    }

    class RecipeViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public final TextView titleItemView;
        public final TextView descItemView;
        final RecipeListAdapter _Adapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            titleItemView = itemView.findViewById(R.id.item_title);
            descItemView = itemView.findViewById(R.id.item_desc);
            this._Adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Recipe recipe = _recipes.get(getLayoutPosition());
            Intent intent = new Intent(_context, RecipeActivity.class);

            intent.putExtra("name", recipe.name);
            intent.putExtra("description", recipe.description);
            intent.putExtra("image", recipe.image);
            intent.putExtra("ingredients", recipe.ingredients);
            intent.putExtra("directions", recipe.directions);

            _context.startActivity(intent);
        }
    }
}
