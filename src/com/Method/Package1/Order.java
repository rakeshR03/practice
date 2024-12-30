package com.Method.Package1;

public class Order {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.getInvoice(); // public
        invoice.fetchInvoice(); // default
        invoice.showInvoice(); // protected
    }
}
