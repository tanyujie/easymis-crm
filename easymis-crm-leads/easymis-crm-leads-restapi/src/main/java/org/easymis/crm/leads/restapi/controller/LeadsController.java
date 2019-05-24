package org.easymis.crm.leads.restapi.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/crm/leads")
public class LeadsController {
    @Autowired
    private LeadsService leadsService;

    @RequestMapping("/{id}")
    public CompletableFuture<String> findById(@PathVariable String id) {
        return CompletableFuture.supplyAsync(() -> leadsService.findOne(id))
                .thenApply(user ->{
                    return new Gson().toJson(user);
                });
    }
}
