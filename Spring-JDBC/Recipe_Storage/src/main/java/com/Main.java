package com;

import com.config.SpringJdbcConfig;
import com.model.Recipe;
import com.utils.RecipeJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;


public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        RecipeJDBCTemplate recipeJDBCTemplate = (RecipeJDBCTemplate) context.getBean("recipeJDBCTemplate");

        System.out.println(recipeJDBCTemplate.test());

        System.out.println("------Records Creation--------" );
        recipeJDBCTemplate.create(0,"Borshch");
        recipeJDBCTemplate.create(1,"Soup");
        recipeJDBCTemplate.create(2,"Omlette");
//
        System.out.println("------Listing Multiple Records--------" );
        List<Recipe> recipes = recipeJDBCTemplate.listRecipe();

        for (Recipe recipe : recipes) {
            System.out.print(" ID : " + recipe.getId() );
            System.out.print(", Name : " + recipe.getName() );
        }

        System.out.println("\n");

        System.out.println("------Listing delete Records--------" );
        recipeJDBCTemplate.deleteRecipe(1);

       recipes = recipeJDBCTemplate.listRecipe();

        for (Recipe recipe : recipes) {
            System.out.print(" ID : " + recipe.getId() );
            System.out.print(", Name : " + recipe.getName() );
        }


        System.out.println("------Listing getRecipe Record--------" );
        Recipe recipeId2 = recipeJDBCTemplate.getRecipe(2);
        System.out.println("recipeId2 name = " + recipeId2.getName() + " id = " + recipeId2.getId());



        System.out.println("------Listing deleteAll Record--------" );
        recipeJDBCTemplate.deleteAll();

        recipes = recipeJDBCTemplate.listRecipe();

        for (Recipe recipe : recipes) {
            System.out.print(" ID : " + recipe.getId() );
            System.out.print(", Name : " + recipe.getName() );
        }
    }
}