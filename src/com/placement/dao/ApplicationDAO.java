package com.placement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.placement.bean.Application;
import com.placement.util.DBUtil;

public class ApplicationDAO {

    public boolean insertApplication(Application a) throws Exception {

        String sql =
          "INSERT INTO APPLICATION_TBL " +
          "(APPLICATION_ID, STUDENT_REG_NO, COMPANY_ID, APPLIED_DATE, APPLICATION_STATUS) " +
          "VALUES (APPLICATION_SEQ.NEXTVAL, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, a.getStudentRegNo());
            ps.setString(2, a.getCompanyID());
            ps.setDate(3, a.getAppliedDate());
            ps.setString(4, a.getApplicationStatus());

            return ps.executeUpdate() == 1;
        }
    }

  
    public List<Application> findApplicationsByStudent(String regNo)
            throws Exception {

        String sql =
            "SELECT * FROM APPLICATION_TBL WHERE STUDENT_REG_NO = ?";

        List<Application> list = new ArrayList<>();

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, regNo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Application a = new Application();
                a.setApplicationID(rs.getInt(1));
                a.setStudentRegNo(rs.getString(2));
                a.setCompanyID(rs.getString(3));
                a.setAppliedDate(rs.getDate(4));
                a.setApplicationStatus(rs.getString(5));
                a.setInterviewDate(rs.getDate(6));
                a.setInterviewSlot(rs.getString(7));
                a.setInterviewPanel(rs.getString(8));
                a.setFinalOutcome(rs.getString(9));
                list.add(a);
            }
        }
        return list;
    }
}
