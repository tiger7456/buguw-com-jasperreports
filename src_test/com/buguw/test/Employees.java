/**
 *@copyright Copyright (c) 2008 - 2020
 *@company Giantstone
 */
package com.buguw.test;

import java.util.Date;

/**
 * @author 方宗虎
 * @since 2012-5-21
 * @version 1.1.0
 */
public class Employees {
    private int id;
    private String firstName;
    private String lastName;
    private Date hireDate;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the hireDate
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employees emp = new Employees();
        emp.setFirstName(firstName);
        emp.setHireDate(hireDate);
        emp.setId(id);
        emp.setLastName(lastName);
        return emp;
    }

}
