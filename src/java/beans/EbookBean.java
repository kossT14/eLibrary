/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author koss
 */
public class EbookBean {

    private final String ISSN;
    private String title;
    private int noOfPages;
    private double price;
    private float rating;

    public EbookBean(String title, int noOfPages, double price) {
        this.ISSN = setISSN();
        this.title = title;
        this.noOfPages = noOfPages;
        this.price = price;
        this.rating = 0;
    }

    public final String setISSN() {

        // ISBN will have this format: ISSN-L L1L2B1B2-B3V1V2C         
        double L1 = Math.random() * 10;
        double L2 = Math.random() * 10;
        double B1 = Math.random() * 10;
        double B2 = Math.random() * 10;
        double B3 = Math.random() * 10;
        double V1 = Math.random() * 10;
        double V2 = Math.random() * 10;

        // Check that L1L2 > 0  
        if ((int) L1 == 0 && (int) L2 == 0) {
            L2++;
        }
        // Check that B1B2B3 >= 100         
        if ((int) B1 == 0) {
            B1++;
        }
        // Check that V1V2 > 0          
        if ((int) V1 == 0 && (int) V2 == 0) {
            V2++;
        }
        // Compute check digit with hashOp method       
        double C = (hashOp((int) L1) + L2 + hashOp((int) B1)
                + B2 + hashOp((int) B3) + V1 + hashOp((int) V2)) % 10;

        return "ISSN-L " + (int) L1 + (int) L2 + (int) B1 + (int) B2 + "-"
                + (int) B3 + (int) V1 + (int) V2 + (int) C;
    }

    public static int hashOp(int i) {
        // used to determine C
        int doubled = 2 * i;
        if (doubled >= 10) {
            doubled = doubled - 9;
        }
        return doubled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
