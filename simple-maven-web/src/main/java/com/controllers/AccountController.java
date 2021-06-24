package com.controllers;

import com.model.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;
    @GetMapping(value = "/open-account")
    public String openAccountForm (){
        System.out.println("AccountController.openAccountForm");
        return "accountForm";
    }

    @PostMapping(value = "/open-account")
    public String save (Account account){
        System.out.println( "AccountController.save" );
        accountService.open(account);
        return "redirect:/accounts/"+account.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.setDisallowedFields("id");
        binder.setRequiredFields("name", "balance");
    }



    @GetMapping("/accounts/{accountId}")
    public String show(@PathVariable("accountId") long accountId, ModelMap
            model) {
        Account account = accountService.findOne( accountId );


        model.put("account", account);
        return "accountDetails";
    }
}
