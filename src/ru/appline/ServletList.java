package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
    StringBuffer jb = new StringBuffer();
    String line;
    try {
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null){
            jb.append(line);
        }
    } catch (Exception e){
        System.out.println("Error");
    }

    JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

    request.setCharacterEncoding("UTF-8");
    Integer id = jobj.get("id").getAsInt();

    response.setContentType("application/json;charset=utf-8");
    PrintWriter pw = response.getWriter();

    if (id == 0) {

        pw.print(gson.toJson(model.getFromList()));

    }else{
        pw.print(gson.toJson(model.getFromList().get(id)));
        }
    }
}
