import React, { FormEvent, useEffect, useState } from "react";
import "./App.css";
import { IRecipe } from "./IRecipe";
import RecipeComponent from "./RecipeComponent";

function App() {
    const [recipesFound, setRecipesFound] = useState<IRecipe[]>([]);
    const [recipesSearch, setRecipesSearch] = useState("");

    const searchRecipes = async (query: string): Promise<IRecipe[]> => {
        const result = await fetch(`http://localhost:3001/?search=${query}`);
        return (await result.json()).results;
    };

    const search = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const form = event.target as HTMLFormElement;
        const input = form.querySelector("#searchText") as HTMLInputElement;
        setRecipesSearch(input.value);
    };

    useEffect(() => {
        (async () => {
            const query = encodeURIComponent(recipesSearch);
            if (query) {
                const response = await searchRecipes(query);
                setRecipesFound(response);
            }
        })();
    }, [recipesSearch]);

    return (
        <div className="App">
            <h1>Recipe Search</h1>
            <form className="searchForm" onSubmit={(event) => search(event)}>
                <input id="searchText" type="text" />
                <button> Search</button>
            </form>
            {recipesSearch && <p>Results for {recipesSearch}... </p>}
            <div className="recipe-container">
                {recipesFound.length &&
                    recipesFound.map((recipe) => (
                        <RecipeComponent
                            key={recipe.title}
                            recipe={recipe}
                        ></RecipeComponent>
                    ))}
            </div>
        </div>
    );
}

export default App;
