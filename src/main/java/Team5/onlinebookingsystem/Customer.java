package Team5.onlinebookingsystem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    private String customerEmail;
    private String fullName;
    private String address1;
    private String address2;
    private String city;
    private String county;
    private String postalCode;

    public Customer( String customerEmail, String fullName,String address1, String address2, String city, String county, String postalCode) {
        this.customerEmail = customerEmail;
        this.fullName = fullName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
    }

    public Customer() {
    }

    @Id
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
