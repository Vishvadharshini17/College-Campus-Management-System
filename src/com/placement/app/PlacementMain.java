package com.placement.app;

import com.placement.bean.*;
import com.placement.service.PlacementService;
import com.placement.util.*;

import java.sql.Date;
import java.util.Scanner;

public class PlacementMain {

    private static PlacementService service = new PlacementService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  
        System.out.println("--- Campus Placement Management Console ---");

        try {
            Student s = service.viewStudentDetails("21CSE001");

            if (s != null) {
                System.out.println("\nSTUDENT FOUND");
                System.out.println("Reg No : " + s.getStudentRegNo());
                System.out.println("Name   : " + s.getFullName());
                System.out.println("Branch : " + s.getBranch());
                System.out.println("CGPA   : " + s.getCgpa());
            } else {
                System.out.println("STUDENT NOT FOUND");
            }
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }

       
        try {
            Company c = service.viewCompanyDetails("CMP001");

            if (c != null) {
                System.out.println("\nCOMPANY FOUND");
                System.out.println("Company : " + c.getCompanyName());
                System.out.println("Role    : " + c.getJobRole());
                System.out.println("Status  : " + c.getStatus());
            } else {
                System.out.println("COMPANY NOT FOUND");
            }
           
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
        try {
        	java.sql.Date appliedDate = new 
        			java.sql.Date(System.currentTimeMillis()); 

            boolean ok = service.applyForCompany(
                    "21CSE001",
                    "CMP001",
                    appliedDate
            );

            System.out.println(ok
                    ? "\nAPPLICATION SUBMITTED"
                    : "\nAPPLICATION FAILED");

        } catch (EligibilityViolationException e) {
            System.out.println("Eligibility Error: " + e.toString());
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.toString());
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }

        sc.close();   
    }
}
