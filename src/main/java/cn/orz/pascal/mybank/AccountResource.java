package cn.orz.pascal.mybank;

import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    AccountService accountService;

    @POST
    public void create() {
        accountService.create(0);
    }

    @GET
    public List<Account> list() {
        return accountService.findAll();
    }
    
    @POST
    @Path("/deposit/{id}/{amount}")
    public Account deposit(@PathParam("id") UUID id, @PathParam("amount") long amount){
        System.out.println(id + ":" + amount);
        return accountService.deposit(id, amount);
    }
    
    @POST
    @Path("/withdraw/{id}/{amount}")
    public Account withdraw(@PathParam("id") UUID id, @PathParam("amount") long amount){
        System.out.println(id + ":" + amount);
        return accountService.withdraw(id, amount);
    }
}
