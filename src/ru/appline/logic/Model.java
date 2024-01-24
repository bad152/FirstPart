package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();
    private final Map<Integer, User> model;



    public static Model getInstance(){
        return instance;
    }

    private Model(){
        model = new HashMap<>();


        model.put(1, new User( "Tigran", "Mantashyan", 200000));
        model.put(2, new User("Andrey", "Smokov", 500000));
        model.put(3, new User("Fedor", "Buldin", 300000));
        model.put(4, new User("Fernand", "Elprimo", 100000));
    }

    public void add(User user, int id){

        model.put(id, user);
    }

    public void show(int id){

        model.get(id);
    }


    public void dell(Integer id) {
        model.remove(id);
    }

    public void update(Integer id, String name, String surname, double salary) {
       model.put(id, new User(name, surname, salary));

    }

    public Map<Integer, User> getFromList(){
        return model;
    }
}
