
package model;

public class Customer {
    private int customer_id;
    private String customer_fname;
    private String customer_lname;
    private String  customer_email; 
    private String customer_password;
    private String customer_street;
    private String customer_city;
    private String customer_state;
    private int customer_zipcode;
    
    public Customer(){customer_id=0;};

    public Customer(int customer_id, String customer_fname, String customer_lname, String customer_email, String customer_password, String customer_street, String customer_city, String customer_state, int customer_zipcode) {
        this.customer_id = customer_id;
        this.customer_fname = customer_fname;
        this.customer_lname = customer_lname;
        this.customer_email = customer_email;
        this.customer_password = customer_password;
        this.customer_street = customer_street;
        this.customer_city = customer_city;
        this.customer_state = customer_state;
        this.customer_zipcode = customer_zipcode;
    }

    public int getCustomer_zipcode() {
        return customer_zipcode;
    }

    public void setCustomer_zipcode(int customer_zipcode) {
        this.customer_zipcode = customer_zipcode;
    }

    public String getCustomer_lname() {
        return customer_lname;
    }

    public void setCustomer_lname(String customer_lname) {
        this.customer_lname = customer_lname;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_street() {
        return customer_street;
    }

    public void setCustomer_street(String customer_street) {
        this.customer_street = customer_street;
    }

    public String getCustomer_city() {
        return customer_city;
    }

    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }

    public String getCustomer_state() {
        return customer_state;
    }

    public void setCustomer_state(String customer_state) {
        this.customer_state = customer_state;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_fname() {
        return customer_fname;
    }

    public void setCustomer_fname(String customer_fname) {
        this.customer_fname = customer_fname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{customer_id=").append(customer_id);
        sb.append(", customer_fname=").append(customer_fname);
        sb.append(", customer_lname=").append(customer_lname);
        sb.append(", customer_email=").append(customer_email);
        sb.append(", customer_password=").append(customer_password);
        sb.append(", customer_street=").append(customer_street);
        sb.append(", customer_city=").append(customer_city);
        sb.append(", customer_state=").append(customer_state);
        sb.append(", customer_zipcode=").append(customer_zipcode);
        sb.append('}');
        return sb.toString();
    }
    


}

