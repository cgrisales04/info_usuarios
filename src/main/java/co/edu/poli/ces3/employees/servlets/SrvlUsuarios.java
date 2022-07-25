package co.edu.poli.ces3.employees.servlets;

import co.edu.poli.ces3.employees.entities.Response;
import co.edu.poli.ces3.employees.entities.Usuarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

@WebServlet(name = "SrvlUsuarios", value = "/SrvlUsuarios")
public class SrvlUsuarios extends HttpServlet {
    private GsonBuilder gsonBuilder;
    private Gson gson;

    public SrvlUsuarios(){
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public static ArrayList<Usuarios> USUARIOS = new ArrayList<>(Arrays.asList(
            new Usuarios(1,"Cristian","Grisales","20",
                    "1000640464", 1,1,1),
            new Usuarios(2,"Yaider","Cordoba","21",
                    "12345672", 1,1,1)
    ));

    public static Response response = new Response();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/json");
        this.setAccessControlHeaders(response);
        if(request.getParameter("id_usuario") == null){
            out.print(gson.toJson(this.USUARIOS));
        }else{
            Usuarios usuario = this.buscarUsuario(Integer.parseInt(request.getParameter("id_usuario")));
            out.print(gson.toJson(usuario));
        }
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setAccessControlHeaders(response);
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/json");
        JsonObject body = this.getParamsFromPost(request);
        int max = 1000000000, min = 100;
        Random rd = new Random();

        Usuarios usuario = new Usuarios(
                (rd.nextInt(max - min) + min),
                body.get("nombre").getAsString(),
                body.get("apellido").getAsString(),
                body.get("edad").getAsString(),
                body.get("identificacion").getAsString(),
                body.get("id_tipo_usuario_fk").getAsInt(),
                body.get("id_genero_fk").getAsInt(),
                body.get("id_tipo_identificacion_fk").getAsInt()
        );
        this.USUARIOS.add(usuario);
        out.print(gson.toJson(usuario));
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setAccessControlHeaders(response);
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/json");
        JsonObject body = this.getParamsFromPost(request);

        if(request.getParameter("id_usuario") == null) {
            this.response.setMessage("Parameter id_usuario required");
            this.response.setStatus(false);
            out.print(gson.toJson(this.response));
        }

        Usuarios validateUser = validatedExistenceUser(request.getParameter("id_usuario"));
        if (validateUser == null){
            this.response.setMessage("Usuario not exists");
            this.response.setStatus(false);
            out.print(gson.toJson(this.response));
            return;
        }

        Usuarios usuario = new Usuarios(
                Integer.parseInt(request.getParameter("id_usuario")),
                body.get("nombre").getAsString(),
                body.get("apellido").getAsString(),
                body.get("edad").getAsString(),
                body.get("identificacion").getAsString(),
                body.get("id_tipo_usuario_fk").getAsInt(),
                body.get("id_genero_fk").getAsInt(),
                body.get("id_tipo_identificacion_fk").getAsInt()
        );

        this.USUARIOS.set(USUARIOS.indexOf(validateUser), usuario);

        Usuarios select_usuario_update = this.buscarUsuario(Integer.parseInt(request.getParameter("id_usuario")));
        out.print(gson.toJson(select_usuario_update));
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setAccessControlHeaders(response);
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/json");

        if (request.getParameter("id_usuario") == null) {
            this.response.setMessage("Parameter id_usuario required");
            this.response.setStatus(false);
            out.print(gson.toJson(this.response));
            return;
        }

        Usuarios validateUser = validatedExistenceUser(request.getParameter("id_usuario"));
        if (validateUser == null){
            this.response.setMessage("Usuario not exists");
            this.response.setStatus(false);
            out.print(gson.toJson(this.response));
            return;
        }

        this.USUARIOS.remove(USUARIOS.indexOf(validateUser));
        this.response.setMessage("Usuario "+ validateUser.getNombre()  +" identificado con numero "+
                                    validateUser.getIdentificacion() + " se elimino.");
        this.response.setStatus(true);
        out.print(gson.toJson(this.response));
        out.flush();
    }

    private Usuarios validatedExistenceUser(String id_usuario){
        return this.buscarUsuario(Integer.parseInt(id_usuario));
    }

    private Usuarios buscarUsuario(int id_usuario){
        return this.USUARIOS.stream()
                .filter(cadaUsuario -> cadaUsuario.getId_usuario() == id_usuario)
                .findAny()
                .orElse(null);
    }

    private JsonObject getParamsFromPost(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = reader.readLine();
        }
        reader.close();

        return JsonParser.parseString(sb.toString()).getAsJsonObject();
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
    }

}
