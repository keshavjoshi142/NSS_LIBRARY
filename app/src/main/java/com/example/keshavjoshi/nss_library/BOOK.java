/**
 * Created by keshav joshi on 22-01-2017.
 */
package com.example.keshavjoshi.nss_library;
 class BOOK{
    public String CLASS;
    public String  CODE;
    public String  NAME;
    public String  MEDIUM;
    public long  NO;
     public  String STATUS;
    public BOOK(){}
    public BOOK(String CLASS,String CODE,String NAME,String MEDIUM,long NO){
        this.CLASS=CLASS;
        this.CODE=CODE;
        this.NAME=NAME;
        this.MEDIUM=MEDIUM;
        this.NO=NO;

    }

     public String STATUS() {
         return STATUS;
     }

     public void STATUS(String STATUS) {
         this.STATUS = STATUS;
     }

     public void CLASS(String CLASS) {
         this.CLASS = CLASS;
     }

     public void CODE(String CODE) {
         this.CODE = CODE;
     }

     public void NAME(String NAME) {
         this.NAME = NAME;
     }

     public void MEDIUM(String MEDIUM) {
         this.MEDIUM = MEDIUM;
     }

     public void NO(long NO) {
         this.NO = NO;
     }


     public String CLASS() {
         return CLASS;
     }

     public String CODE() {
         return CODE;
     }

     public String NAME() {
        return NAME;
    }



    public String MEDIUM() {
        return MEDIUM;
    }



    public long NO() {
        return NO;
    }



}

