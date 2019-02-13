package com.example.stl.json;

import java.util.List;

public class PuppyResponse {
     public static String status;
     public static List<String> message;


     PuppyResponse(String status, List<String> message) {
         this.status = status;
         this.message = message;

     }

    public static String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
