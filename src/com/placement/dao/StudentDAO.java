package com.placement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.placement.bean.Student;
import com.placement.util.DBUtil;

public class StudentDAO {
	
    public boolean insertStudent(Student s) throws Exception {

        String sql =
            "INSERT INTO STUDENT_TBL VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getStudentRegNo());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getBranch());
            ps.setInt(4, s.getCurrentSemester());
            ps.setBigDecimal(5, s.getCgpa());
            ps.setString(6, s.getEmail());
            ps.setString(7, s.getMobile());
            ps.setString(8, s.getStatus());

            return ps.executeUpdate() == 1;
        }
    }

  
    public Student findStudentByRegNo(String regNo) throws Exception {

        String sql =
            "SELECT * FROM STUDENT_TBL WHERE STUDENT_REG_NO = ?";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, regNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student s = new Student();
                s.setStudentRegNo(rs.getString(1));
                s.setFullName(rs.getString(2));
                s.setBranch(rs.getString(3));
                s.setCurrentSemester(rs.getInt(4));
                s.setCgpa(rs.getBigDecimal(5));
                s.setEmail(rs.getString(6));
                s.setMobile(rs.getString(7));
                s.setStatus(rs.getString(8));
                return s;
            }
        }
        return null;
    }
}
