package com.ems.daoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ems.dao.TotalConsumptionDao;
import com.ems.entity.LastOneDayList;
import com.ems.entity.NowData;
import com.ems.util.MongoDBUtil;

@Repository("totalConsumptionDao")
public class TotalConsumptionDaoImpl implements TotalConsumptionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public LastOneDayList getElectricity(String type) {
		// TODO Auto-generated method stub
		String timeStart = MongoDBUtil.getTimeStart(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		System.out.println("type==="+type);
		List<String> listTagId = new ArrayList<String>();
		
		String sql = "select a.tagId from device_propertie_tag as a inner join device_propertie as c on a.devicePropertieID=c.devicePropertieID where c.energyConsumptionType=?";
	
		listTagId = jdbcTemplate.queryForList(sql, new Object[] { type }, String.class);
		System.out.println("listTagId==="+listTagId.toString());
		
		LastOneDayList lastOneDayList = MongoDBUtil.getElectricityLastOneDayTotalFormStatstics("statistics", timeStart,listTagId);

		System.out.println(lastOneDayList.toString());
		return lastOneDayList;
	}



	@Override
	public NowData getNowdata(String type) {
		// TODO Auto-generated method stub
		String timeStart = MongoDBUtil.getTimeStart(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		System.out.println("type==="+type);
		List<String> listTagId = new ArrayList<String>();
		String sql = "select a.tagId from device_propertie_tag as a inner join device_propertie as c on a.devicePropertieID=c.devicePropertieID where c.energyConsumptionType=?";
		
		listTagId = jdbcTemplate.queryForList(sql, new Object[] { type }, String.class);
		System.out.println("listTagId==="+listTagId.toString());
		
		String timeLastHour = MongoDBUtil.getLastOneHour(timeStart, 1);
        System.out.println(timeLastHour);
		
		NowData nowData = MongoDBUtil.getElectricityNowTotalFormStatstics("statistics", timeLastHour,listTagId);
		
		System.out.println("nowData:::"+nowData.toString());
		return nowData;
	}

}
