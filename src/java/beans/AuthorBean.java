/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author koss
 */
public class AuthorBean {

    private int authorId;
    private String name, surname;
    private String ISSN;

    public AuthorBean(int authorId, String name, String surname, String ISSN) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.ISSN = ISSN;
    }

    static AtomicInteger idCounter = new AtomicInteger();

    private static int createID() {
        return idCounter.incrementAndGet();
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = createID();
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

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    
}
