package rrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rrs.exceptions.AppException;
import rrs.model.Settings;
import rrs.utils.DBUtil;

public class SettingsDAO {

	public List<Settings> getAll() throws AppException {
		List<Settings> resList = new ArrayList<Settings>();
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM res_db.appsettings");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Settings res = new Settings();

				res.setOrgName(rs.getString("ORG_NAME"));
				res.setOrgPhone(rs.getString("ORG_PHONE"));
				res.setOrgEmail(rs.getString("ORG_EMAIL"));
				res.setOrgAddress(rs.getString("ORG_ADDRESS"));
				res.setOrgOpenDays(rs.getString("ORG_OPENDAYS"));
				res.setOrgTimings(rs.getString("ORG_TIMINGS"));
				res.setOrgTableNo(rs.getInt("ORG_TABLENO"));
				res.setOrgAutoAssign(rs.getString("ORG_AUTOASSIGN"));
				res.setOrgUsername(rs.getString("ORG_USERNAME"));
				res.setOrgPassword(rs.getString("ORG_PASSWORD"));

	
				resList.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error in fetching records from database.", e.getCause());
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return resList;
	}
	

	public Settings updateSettings(Settings res) throws AppException {
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
	
			
			System.out.println(res.getOrgName());
			System.out.println(res.getOrgPhone());
			System.out.println(res.getOrgEmail());
			System.out.println(res.getOrgAddress());
			System.out.println(res.getOrgOpenDays());
			System.out.println(res.getOrgTimings());
			System.out.println(res.getOrgTableNo());
			System.out.println(res.getOrgAutoAssign());
			System.out.println(res.getOrgUsername());
			System.out.println(res.getOrgPassword());			
			

			
			ps = con.prepareStatement("UPDATE res_db.appsettings SET ORG_NAME=?,ORG_PHONE=?,ORG_EMAIL=?,ORG_ADDRESS=?,ORG_OPENDAYS=?,ORG_TIMINGS=?,ORG_TABLENO=?,ORG_AUTOASSIGN=?,ORG_USERNAME=?,ORG_PASSWORD=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, res.getOrgName());
			ps.setString(2, res.getOrgPhone());
			ps.setString(3, res.getOrgEmail());
			ps.setString(4, res.getOrgAddress());
			ps.setString(5, res.getOrgOpenDays());
			ps.setString(6, res.getOrgTimings());
			ps.setInt(7, res.getOrgTableNo());
			ps.setString(8, res.getOrgAutoAssign());
			ps.setString(9, res.getOrgUsername());
			ps.setString(10, res.getOrgPassword());			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error in adding Settings to the database.", e.getCause());
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return res;
	}
}
