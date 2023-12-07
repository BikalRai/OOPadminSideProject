package com.example.adminside.model;

public class BookingModel {
    private int bookingID;
    private String bookingDate;
    private String bookedBy;
    private String bookingStart;
    private String bookingEnd;
    private String bookedFor;
    private int bookedById;
    private String price;
    private String payment;

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

    public String getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(String bookingStart) {
        this.bookingStart = bookingStart;
    }

    public String getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(String bookingEnd) {
        this.bookingEnd = bookingEnd;
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
