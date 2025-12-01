package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.entity.Jobs;

public class JobDAO {
	private Connection conn;

	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addJobs(Jobs j) {
		boolean f = false;
		try {
			String sql = "INSERT INTO job(title, description, category, status, location) "
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Jobs> getAllJobs() {
		List<Jobs> list = new ArrayList<>();
		Jobs j = null;
		try {
			String sql = "SELECT * FROM job ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7)+"");
				list.add(j);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Jobs getJobById(int id) {
		Jobs j = null;
		try {
			String sql = "SELECT * FROM job WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7)+"");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return j;
	}
	
	public List<Jobs> getAllJob() {
		List<Jobs> list = new ArrayList<>();
		Jobs j = null;
		
		try {
			String sql = "SELECT * FROM job ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7)+"");
				list.add(j);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Jobs> getAllJobForUser() {
		List<Jobs> list = new ArrayList<>();
		Jobs j = null;
		
		try {
			String sql = "SELECT * FROM job WHERE status=? ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7)+"");
				list.add(j);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateJob(Jobs j) {
		boolean f = false;
		try {
			String sql = "UPDATE job SET title=?, description=?, category=?, status=?, location=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6, j.getId());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteJobs(int id) {
		boolean f = false;
		
		try {
			String sql = "DELETE FROM job WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}