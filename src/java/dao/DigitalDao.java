/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Digital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.tools.Diagnostic;

/**
 *
 * @author Mai Minh Hieu
 */
public class DigitalDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//khi no doc ham nay thi no se hieu bien cua minh la top 1 thi co ham getter tuong duong la getTop1

    public Digital getTop1() {
        //lấy bài viết gần nhất
        try {
            String query = "select *from digital where timePost=(\n"
                    + "select max(timePost) from digital)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Digital d = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                return d;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Digital> getTop5() {
        try {
            String query = "select top 5 *from digital where timePost not in(\n"
                    + "select max(timePost) from digital)\n"
                    + "order by timePost desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            List<Digital> list= new ArrayList<>();
            while (rs.next()) {                
                Digital d = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

}
