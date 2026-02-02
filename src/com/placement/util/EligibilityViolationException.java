package com.placement.util;

public class EligibilityViolationException extends Exception {
    public String toString() {
        return "Student does not satisfy eligibility criteria";
    }
}
