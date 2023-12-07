package com.example.adminside.model;

public class UserBookingsModel {

    private int bookingID;
    private String bookingDate;
    private String bookedBy;
    private String bookStartTime;
    private String bookEndTime;
    private String bookedFor;
    private int bookedById;
    private String price;
    private String payment;

    public UserBookingsModel(int bookingID, String bookingDate, String bookedBy, String bookStartTime, String bookEndTime, String bookedFor, int bookedById, String price, String payment) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.bookedBy = bookedBy;
        this.bookStartTime = bookStartTime;
        this.bookEndTime = bookEndTime;
        this.bookedFor = bookedFor;
        this.bookedById = bookedById;
        this.price = price;
        this.payment = payment;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getBookStartTime() {
        return bookStartTime;
    }

    public void setBookStartTime(String bookStartTime) {
        this.bookStartTime = bookStartTime;
    }

    public String getBookEndTime() {
        return bookEndTime;
    }

    public void setBookEndTime(String bookEndTime) {
        this.bookEndTime = bookEndTime;
    }

    public String getBookedFor() {
        return bookedFor;
    }

    public void setBookedFor(String bookedFor) {
        this.bookedFor = bookedFor;
    }

    public int getBookedById() {
        return bookedById;
    }

    public void setBookedById(int bookedById) {
        this.bookedById = bookedById;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}
