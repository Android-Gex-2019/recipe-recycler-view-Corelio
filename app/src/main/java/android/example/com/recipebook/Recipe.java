/**
 * Author: Marco Corsini
 * Assignment 2
 *
 * Code from the repository - no changes made
 */
package android.example.com.recipebook;

/**
 * Create a recipe object that contains:
 * Name, Description, image, ingredients, and directions
 */
public class Recipe {
    public Recipe(String name, String description, String image, String ingredients, String directions) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String name;
    public String description;
    public String image;
    public String ingredients;
    public String directions;
}
