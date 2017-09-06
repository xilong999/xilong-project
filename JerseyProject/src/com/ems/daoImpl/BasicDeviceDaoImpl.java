package com.ems.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ems.dao.BasicDeviceDao;
import com.ems.entity.BasicDevice;

@Repository("basicDeviceDao")
public class BasicDeviceDaoImpl implements BasicDeviceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * public List<BasicDevice> getMutilTag(final String deviceId) {
	 * System.out.println("deviceId===" + deviceId); String sql =
	 * "select d1.tagId,d1.deviceId,d3.deviceName,d2.devicePropertie from device_propertie_tag d1 ,device_propertie d2,device d3 where d1.deviceId= '"
	 * + deviceId + "' and d3.deviceId = '" + deviceId +
	 * "' and d1.devicePropertieId = d2.ID"; List<BasicDevice> bds = null; try {
	 * bds = jdbcTemplate.query(sql, new RowMapper<BasicDevice>() { public
	 * BasicDevice mapRow(java.sql.ResultSet rs, int rowNum) throws SQLException
	 * { BasicDevice bd = new BasicDevice(); bd.setTagId(rs.getString("tagId"));
	 * bd.setDeviceId(rs.getString("deviceId"));
	 * bd.setDeviceName(rs.getString("deviceName"));
	 * bd.setDevicePropertie(rs.getString("devicePropertie"));
	 * 
	 * return bd; } }); } catch (Exception e) { e.printStackTrace(); } return
	 * bds; }
	 */

/*	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BasicDevice> getMutilTag(final String deviceId) {
		String sql = "select d1.tagId,d1.deviceId,d3.deviceName,d2.devicePropertie from device_propertie_tag d1 ,device_propertie d2,device d3 where d1.deviceId= ? and d3.deviceId = ? and d1.devicePropertieId = d2.ID";
		List<BasicDevice> bds = new ArrayList<BasicDevice>();

		bds = jdbcTemplate.query(sql, new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, deviceId);
				ps.setString(2, deviceId);
			}
		}, new ResultSetExtractor() {

			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<BasicDevice> list = new ArrayList<BasicDevice>();
				while (rs.next()) {
					BasicDevice bd = new BasicDevice();
					bd.setTagId(rs.getString("tagId"));
					bd.setDeviceId(rs.getString("deviceId"));
					bd.setDeviceName(rs.getString("deviceName"));
					bd.setDevicePropertie(rs.getString("devicePropertie"));
					list.add(bd);
				}
				return list;
			}
		});
		return bds;
	}*/

	public List<BasicDevice> getMutilTag(final String deviceId) {

		String sql = "select d1.tagId,d1.deviceId,d3.deviceName,d2.devicePropertie from device_propertie_tag d1 ,device_propertie d2,device d3 where d1.deviceId= ? and d3.deviceId = ? and d1.devicePropertieId = d2.ID";
		List<BasicDevice> bds ;

		final Object[] params = new Object[] { deviceId ,deviceId};

		bds = jdbcTemplate.query(sql, params, new RowMapper<BasicDevice>() {

			public BasicDevice mapRow(ResultSet rs, int index) throws SQLException {
				BasicDevice bd = new BasicDevice();
				bd.setTagId(rs.getString("tagId"));
				bd.setDeviceId(rs.getString("deviceId"));
				bd.setDeviceName(rs.getString("deviceName"));
				bd.setDevicePropertie(rs.getString("devicePropertie"));
				return bd;
			}
		});
		return bds;
	}
}
