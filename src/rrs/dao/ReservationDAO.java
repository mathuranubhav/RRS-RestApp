package rrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rrs.exceptions.AppException;
import rrs.model.Reservation;
import rrs.utils.DBUtil;

public class ReservationDAO {

	public List<Reservation> getAll() throws AppException {
		List<Reservation> resList = new ArrayList<Reservation>();
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM reservations");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Reservation res = new Reservation();
				
				res.setId(rs.getInt("ID"));
				res.setFirstName(rs.getString("FIRST_NAME"));
				res.setLastName(rs.getString("LAST_NAME"));
				res.setEmail(rs.getString("EMAIL"));
				res.setPhone(rs.getString("PHONE"));
				res.setPartySize(rs.getInt("PARTYSIZE"));
				res.setSpecialNeed(rs.getString("SPECIALNEED"));
				res.setDate(rs.getString("DATE"));
				res.setTime(rs.getString("TIME"));
				res.setConfNo(rs.getString("CONFNO"));
				res.setTableNo(rs.getInt("TABLENO"));
	
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
	

	public Reservation getReservation(int resId) throws AppException {
		Reservation res = new Reservation();
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM reservations WHERE ID=?");
			ps.setInt(1, resId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				res.setId(rs.getInt("ID"));
				res.setFirstName(rs.getString("FIRST_NAME"));
				res.setLastName(rs.getString("LAST_NAME"));
				res.setEmail(rs.getString("EMAIL"));
				res.setPhone(rs.getString("PHONE"));
				res.setPartySize(rs.getInt("PARTYSIZE"));
				res.setSpecialNeed(rs.getString("SPECIALNEED"));
				res.setDate(rs.getString("DATE"));
				res.setTime(rs.getString("TIME"));
				res.setConfNo(rs.getString("CONFNO"));
				res.setTableNo(rs.getInt("TABLENO"));
			}
			else {
				throw new AppException("Reservation with ID=" + resId + " does not exist in the system.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error in fetching record from database.", e.getCause());
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return res;
	}
	
	public Reservation addReservation(Reservation res) throws AppException {
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			System.out.println("Entered debugging");
			System.out.println(res.getFirstName());
			System.out.println(res.getLastName());
			System.out.println(res.getEmail());
			System.out.println(res.getPhone());
			System.out.println(res.getPartySize());
			System.out.println(res.getSpecialNeed());
			System.out.println(res.getDate());
			System.out.println(res.getTime());
			System.out.println(res.getConfNo());
			
			ps = con.prepareStatement("INSERT INTO res_db.reservations (FIRST_NAME, LAST_NAME, EMAIL, PHONE, PARTYSIZE, SPECIALNEED, DATE, TIME, CONFNO, TABLENO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			System.out.println(res.getFirstName());
			ps.setString(1, res.getFirstName());
			ps.setString(2, res.getLastName());
			ps.setString(3, res.getEmail());
			ps.setString(4, res.getPhone());
			ps.setInt(5, res.getPartySize());
			ps.setString(6, res.getSpecialNeed());
			ps.setString(7, res.getDate());
			ps.setString(8, res.getTime());
			ps.setString(9, res.getConfNo());
			ps.setInt(10, res.getTableNo());
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next())
			{
				res.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error in adding reservations to the database.", e.getCause());
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return res;
	}
	public Reservation deleteReservation(Reservation res) throws AppException {
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("DELETE FROM res_db.reservations WHERE CONFNO=?",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, res.getConfNo());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if(rs.next())
			{
				res.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error in deleting reservations from the database.", e.getCause());
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return res;
	}
	public Reservation updateReservation(Reservation res) throws AppException {
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			System.out.println("Entered debugging");
			System.out.println(res.getId());
			System.out.println(res.getFirstName());
			System.out.println(res.getLastName());
			System.out.println(res.getEmail());
			System.out.println(res.getPhone());
			System.out.println(res.getPartySize());
			System.out.println(res.getSpecialNeed());
			System.out.println(res.getDate());
			System.out.println(res.getTime());
			System.out.println(res.getConfNo());
			
			ps = con.prepareStatement("UPDATE res_db.reservations SET FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PHONE=?, PARTYSIZE=?, SPECIALNEED=?, DATE=?, TIME=?, CONFNO=?, TABLENO=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			System.out.println(res.getFirstName());
			ps.setString(1, res.getFirstName());
			ps.setString(2, res.getLastName());
			ps.setString(3, res.getEmail());
			ps.setString(4, res.getPhone());
			ps.setInt(5, res.getPartySize());
			ps.setString(6, res.getSpecialNeed());
			ps.setString(7, res.getDate());
			ps.setString(8, res.getTime());
			ps.setString(9, res.getConfNo());
			ps.setInt(10, res.getTableNo());
			ps.setInt(11, res.getId());
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next())
			{
				res.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error in updating reservations to the database.", e.getCause());
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return res;
	}	
}
