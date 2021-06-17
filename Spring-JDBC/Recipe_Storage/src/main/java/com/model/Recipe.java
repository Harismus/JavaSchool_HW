package com.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> listIngredients = new ArrayList<>();
    private Integer id;

    public Recipe(String name, List<Ingredient> listIngredients) {
        this.name = name;
        this.listIngredients.addAll(listIngredients);
    }

    public Recipe() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListIngredients(List<Ingredient> listIngredients) {
        this.listIngredients = listIngredients;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getListIngredients() {
        return listIngredients;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
