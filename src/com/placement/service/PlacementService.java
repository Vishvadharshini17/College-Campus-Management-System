package com.placement.service;

import com.placement.bean.*;
import com.placement.dao.*;
import com.placement.util.*;

import java.sql.Date;
import java.util.List;

public class PlacementService {

    private StudentDAO studentDAO = new StudentDAO();
    private CompanyDAO companyDAO = new CompanyDAO();
    private ApplicationDAO applicationDAO = new ApplicationDAO();

    public boolean registerNewStudent(Student s)
            throws ValidationException, Exception {

        if (s.getStudentRegNo() == null || s.getStudentRegNo().isEmpty())
            throw new ValidationException();

        s.setStatus("ACTIVE");
        return studentDAO.insertStudent(s);
    }

   
    public boolean registerCompanyDrive(Company c)
            throws ValidationException, Exception {

        if (c.getCompanyID() == null || c.getCompanyID().isEmpty())
            throw new ValidationException();

        c.setStatus("OPEN");
        return companyDAO.insertCompany(c);
    }

    
    public Student viewStudentDetails(String regNo) throws Exception {
        return studentDAO.findStudentByRegNo(regNo);
    }

   
    public Company viewCompanyDetails(String companyId) throws Exception {
        return companyDAO.findCompanyById(companyId);
    }

  
    public boolean applyForCompany(String regNo, String companyId, Date appliedDate)
            throws ValidationException, EligibilityViolationException, Exception {

        Student s = studentDAO.findStudentByRegNo(regNo);
        Company c = companyDAO.findCompanyById(companyId);

        if (s == null || c == null)
            throw new ValidationException();

        if (!c.getEligibleBranches().contains(s.getBranch()))
            throw new EligibilityViolationException();

        if (s.getCgpa().compareTo(c.getMinimumCgpa()) < 0)
            throw new EligibilityViolationException();

        Application a = new Application();
        a.setStudentRegNo(regNo);
        a.setCompanyID(companyId);
        a.setAppliedDate(appliedDate);
        a.setApplicationStatus("APPLIED");

        return applicationDAO.insertApplication(a);
    }

    
    public List<Application> listApplicationsByStudent(String regNo)
            throws Exception {
        return applicationDAO.findApplicationsByStudent(regNo);
    }
}
