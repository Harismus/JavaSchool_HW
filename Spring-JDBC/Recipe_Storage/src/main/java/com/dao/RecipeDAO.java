package com.dao;

import com.model.Recipe;

import javax.sql.DataSource;
import java.util.List;

public interface RecipeDAO {

    public void setDataSource(DataSource ds);

    public void create(int id, String name);

    public Recipe getRecipe(Integer id);

    public void deleteRecipe(Integer id);

    public void deleteAll();

    public List<Recipe> listRecipe();


}
