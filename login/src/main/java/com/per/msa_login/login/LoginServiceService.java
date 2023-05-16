package com.per.msa_login.login;

import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ibm.cardinal.util.CardinalException;
import com.ibm.cardinal.util.SerializationUtil;

@Component
@Path("/loginServiceService")
public class LoginServiceService {

    private static final Logger klu__logger = LoggerFactory.getLogger(LoginServiceService.class);

    @Resource(name = "loginService")
    private LoginService loginService;

    @POST
    @Path("/selectLoginProccess")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectLoginProccess(
            @FormParam("map") String map,
            @Context HttpServletResponse servletResponse) {
        // convert reference ID(s) stored in "map" to physical/proxy object(s)
        LoginDTO map_fpar = (LoginDTO) SerializationUtil.decodeWithDynamicTypeCheck(map);

        Map<String, Object> response;

        try {
            response = loginService.selectLoginProccess(map_fpar);
        } catch (Throwable t) {
            String msg = "Call to method selectLoginProccess() of loginService raised exception: " + t.getMessage();
            klu__logger.warn(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();

        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();
        klu__logger.info("[CalendarService] Returning JSON object: " + jsonobj.toString());
        return Response
                .status(Response.Status.OK)
                .entity(jsonobj.toString())
                .build();
    }
}
