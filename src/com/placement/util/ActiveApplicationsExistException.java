package com.placement.util;

public class ActiveApplicationsExistException extends Exception {
    public String toString() {
        return "Active applications exist – deletion not allowed";
    }
}
