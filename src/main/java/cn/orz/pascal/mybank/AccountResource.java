package cn.orz.pascal.mybank;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountResource {

    @Inject
    AccountService accountService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public void create() {
        accountService.create(0);
    }
}
