package com.utils;

import com.model.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipesMapper implements RowMapper<Recipe> {
        public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Recipe recipe = new Recipe();
            recipe.setId(rs.getInt("id"));
            recipe.setName(rs.getString("name"));
           /// recipe.setListIngredients((List<Ingredient>) rs.getArray("name"));

            return recipe;
        }
}