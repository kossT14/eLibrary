/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author koss
 */
public class Author {

    private int authorId;
    private String name, surname;
    private boolean isValid;

    public Author(int authorId, String name, String surname) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
    }
    
    public Author(){
        super();
        this.authorId = ID.createID();
    }

    

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
        
    public Map<String, String> validate(Author aut) {
        Map<String, String> errors = new HashMap<>();

        //1 ISSN is required
        if (!(aut.getName().equals(""))) {
            aut.setIsValid(true);
        } else {
            aut.setIsValid(false);
            errors.put("name_error", "Name is required!");
        }
        //2 book name longer than 10 chars
        if (aut.getSurname().equals("")) {
            aut.setIsValid(false);
            errors.put("surname_error", "Surname is required!");
        } else {
            aut.setIsValid(true);
        }
        return errors;
    }

    
}
