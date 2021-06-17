package com.utils;

import com.dao.RecipeDAO;
import com.model.Ingredient;
import com.model.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class RecipeJDBCTemplate implements RecipeDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(int id, String name) {
        String SQL = "insert into RECIPES (id,name) values (?,?)";

        jdbcTemplateObject.update( SQL, id, name);
        System.out.println("Created Record Name = " + name);
    }

    @Override
    public Recipe getRecipe(Integer id) {
        String SQL = "select * from RECIPES where id = ?";
        Recipe recipe = jdbcTemplateObject.queryForObject(
                SQL, new Object[]{id}, new RecipesMapper());

        return recipe;
    }

    @Override
    public void deleteRecipe(Integer id) {
        String deleteQuery = "delete from RECIPES where id = ?";
        jdbcTemplateObject.update(deleteQuery, id);
    }

    @Override
    public void deleteAll() {
        String deleteQuery = "TRUNCATE TABLE RECIPES;";
        jdbcTemplateObject.update(deleteQuery);
    }


    @Override
    public List<Recipe> listRecipe() {
        String SQL = "select * from RECIPES";
        List <Recipe> recipes = jdbcTemplateObject.query(SQL, new RecipesMapper());
        return recipes;
    }


    public String test(){
        return "test";
    }
}
