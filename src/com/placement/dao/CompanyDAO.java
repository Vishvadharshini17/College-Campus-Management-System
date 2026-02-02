package com.placement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.placement.bean.Company;
import com.placement.util.DBUtil;

public class CompanyDAO {

   
    public boolean insertCompany(Company c) throws Exception {

        String sql =
            "INSERT INTO COMPANY_TBL VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getCompanyID());
            ps.setString(2, c.getCompanyName());
            ps.setString(3, c.getJobRole());
            ps.setBigDecimal(4, c.getCtcLpa());
            ps.setString(5, c.getEligibleBranches());
            ps.setBigDecimal(6, c.getMinimumCgpa());
            ps.setDate(7, c.getDriveDate());
            ps.setString(8, c.getStatus());

            return ps.executeUpdate() == 1;
        }
    }

   
    public Company findCompanyById(String companyId) throws Exception {

        String sql =
            "SELECT * FROM COMPANY_TBL WHERE COMPANY_ID = ?";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, companyId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Company c = new Company();
                c.setCompanyID(rs.getString(1));
                c.setCompanyName(rs.getString(2));
                c.setJobRole(rs.getString(3));
                c.setCtcLpa(rs.getBigDecimal(4));
                c.setEligibleBranches(rs.getString(5));
                c.setMinimumCgpa(rs.getBigDecimal(6));
                c.setDriveDate(rs.getDate(7));
                c.setStatus(rs.getString(8));
                return c;
            }
        }
        return null;
    }
}
