import React from "react";
import { IRecipe } from "./IRecipe";

const RecipeComponent = (props: { recipe: IRecipe }) => {
    const { recipe } = props;
    return (
        <div className="recipe">
            <div className="title">
                <img
                    src={"http://localhost:3000/placeholder.jpg"}
                    alt={recipe.title}
                />
                <p>{recipe.title}</p>
            </div>
            {recipe.ingredients && (
                <ul>
                    {recipe.ingredients.split(",").map((ingredients) => (
                        <li>{ingredients}</li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default RecipeComponent;
