package com.ems.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;


import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class DataToMongodb {
	static DBCollection collection;

	public static void main(String[] args) throws ParseException {

		// 创建连接的客户端
		MongoClient client = new MongoClient("localhost", 27017);

		// 获取数据库对象
		// MongoDatabase db = client.getDatabase("test_mongo");
		DB db = client.getDB("test_update3");

		// 获取操作的集合对象（表）
		// MongoCollection<Document> collection = db.getCollection("student");
		collection = db.getCollection("1");

		// DBObject user = new BasicDBObject();
		//
		// user.put("tagId", "00000001");
		// user.put("deviceId ", "002");
		// user.put("propertie", "温度");
		// user.put("timeStart", "2017-08-10 12:00:00");
		// user.put("timeEnd", "2017-08-10 12:59:59");
		//
		//
		// DBObject user2 = new BasicDBObject();
		// user2.put("08:00:00", "80");
		// user2.put("08:01:00", "90");
		// user.put("devicePropertiesValue", user2);
		//
		// MongoDBUtil.insertDocument("student", user);

		//String json = "{\"TagId\":\"0013\",\"deviceId\":\"0147\",\"propertie\":\"温度\",\"devicePropertieValue\":\"100摄氏度\",\"devicePropertieUpdateTime\":\"20170602\"}";

//		String tagId = "00000001";
//		String diviceId = "002";
//		String propertie = "温度";
//		String devicePropertieValue = "90";

		Date d = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String updateTime = sdf.format(d);
		// System.out.println(updateTime);
		/*
		 * 拿到当前时间updateTime，和当前时间的毫秒值updateTimeMillionSeconds。
		 */
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String updateTime = dateFormat.format(d);
		//
		// System.out.println(updateTime);
		//
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// long updateTimeMillionSeconds = sdf.parse(updateTime).getTime();//
		// 毫秒值
		// System.out.println("毫秒数= ："+updateTimeMillionSeconds);

		/*
		 * 用上面拿到的时间去在mongoDB中查找对应的document。
		 */
//		String timeStart = "2017-08-10 12:00:00";
//		String timeEnd = "2017-08-10 12:59:59";
//
//		String timeBetween = "2017-08-10 14:59:00";

//		// 起始时间
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		long start = sdf.parse(timeStart).getTime();// 毫秒值
//		System.out.println("毫秒数= ：" + start);
//
//		// 末尾时间
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		long end = sdf2.parse(timeEnd).getTime();// 毫秒值
//		System.out.println("毫秒数= ：" + end);
//
//		// 中间时差
//		long gap = end - start;
//		System.out.println("gap= :" + gap);
//
//		// 中间时间
//		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		long between = sdf3.parse(timeBetween).getTime();// 毫秒值
//		System.out.println("毫秒数= ：" + between);
//
//		if (start <= between && between <= end) {
//			System.out.println("进来了");
//		} else {
//			System.out.println("扯淡了");
//		}

		/*
		 * timeStart是每个document的唯一不同的属性， 拿到当前传入的数据updateTime中到小时的位置：2017-08-10
		 * 12 然后拼接字符串在后面拼接":00:00",拼接后为：2017-08-10 12:00:00 然后按照这个拼接后的字符串查询
		 * 
		 * 如果有，就插入到这个document中的子属性中、 如果没有，就插入一条新的document
		 */
//		 String s = timeBetween.substring(0, 13);
//		 System.out.println(s);
//		 String all = s.concat(":00:00");
//		 System.out.println(all);
//		
//		 BasicDBObject queryObject = new BasicDBObject("timeStart",all);
//		 DBObject obj = collection.findOne(queryObject);
//		 System.out.println(obj);
//		
//		 if(obj != null){
//		 System.out.println("恭喜你，mongoDB中找到这条记录，插入内嵌数据");
//		 BasicDBObject u= new BasicDBObject()
//		 .append("$set",new
//		 BasicDBObject().append("devicePropertiesValue."+timeBetween, "80"));
//		 collection.update(obj, u);
//		 } else {
//		 System.out.println("mongoDB里面没有这条document，得重新插入一条");
//		
//		 DBObject user = new BasicDBObject();
//		
//		 user.put("tagId", tagId);
//		 user.put("deviceId ", diviceId);
//		 user.put("propertie", propertie);
//		 user.put("timeStart", all);
//		
//		 DBObject user2 = new BasicDBObject();
//		 user2.put(timeBetween, devicePropertieValue);
//		 user.put("devicePropertiesValue", user2);
//		
//		 //collection.save(user);
//		 MongoDBUtil.insertDocument("users", user);
//		
//		
//		 }

		/*
		 * 查询一条documnet $eq
		 */
		// BasicDBObject gt = new BasicDBObject("$eq","2017-08-10 13:00:00");
		// BasicDBObject queryObject = new BasicDBObject("timeStart",gt);
		// Cursor cursor = collection.find(queryObject);
		// while(cursor.hasNext()){
		// DBObject obj = cursor.next();
		// System.out.println(obj.toString());
		// }

		/*
		 * 单个document的所有value的总和
		 */
//		BasicDBObject queryObject = new BasicDBObject("timeStart",
//				"2017-08-10 13:00:00");
//		DBObject obj = collection.findOne(queryObject);
//		System.out.println(obj);
//
//		System.out.println(obj.get("devicePropertiesValue"));
//		BasicDBObject data = (BasicDBObject) obj.get("devicePropertiesValue");
//		// System.out.println(data.get("2017-08-10 13:02:00"));
//
//		int value1 = 0;
//		int value2 = 0;
//		for (int i = 0; i <= 9; i++) {
//			// System.out.println(data.get("2017-08-10 13:0"+i+":00"));
//			if (data.get("2017-08-10 13:0" + i + ":00") != null) {
//				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
//				String values = (String) data.get("2017-08-10 13:0" + i + ":00");
//				System.out.println(values);
//
//				int result = Integer.parseInt(values);
//				value1 += result;
//			}
//		}
//		System.out.println("****************************************");
//		for (int i = 10; i <= 60; i++) {
//			// System.out.println(data.get("2017-08-10 13:"+i+":00"));
//			if (data.get("2017-08-10 13:" + i + ":00") != null) {
//				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
//				String values = (String) data.get("2017-08-10 13:" + i + ":00");
//				System.out.println(values);
//
//				int result = Integer.parseInt(values);
//				value2 += result;
//			}
//		}
//
//		System.out.println("-----------------------------------------");
//		System.out.println(value1);
//		System.out.println(value2);
//		System.out.println("-----------------------------------------");
//		int totalValue = value1 + value2;
//		System.out.println("这个document的总的数值为：" + totalValue);
		
		
//		String timeStart2 = "2017-08-10 13:00:00";
//		DataToMongodb.getOneDocumentTotalValue("users", timeStart2);
//		
//		System.out.println("------------------------------------分界线------------------------------------------");
//		
//		double collectionTotalValue = DataToMongodb.getCollectionTotalValue("users");
//		System.out.println("====================================最终结果==========================================");
//		System.out.println("整张表的所有value之和为: collectionTotalValue = "+collectionTotalValue);
		
		/*
		 * 测试MongoDBUtil工具类的代码
		 */
//		String timeStart2 = "2017-08-10 13:00:00";
//		MongoDBUtil.getOneDocumentTotalValue("users", timeStart2);
//		
//		System.out.println("------------------------------------分界线------------------------------------------");
//		
//		double collectionTotalValue = MongoDBUtil.getCollectionTotalValue("users","00000001");
//		System.out.println("====================================最终结果==========================================");
//		System.out.println("整张表的所有value之和为: collectionTotalValue = "+collectionTotalValue);
		
		/*
		 * 测试往内嵌属性中增加一条信息
		 */
//		String timeStart = "2017-08-10 12:00:00";
//		String timeEnd = "2017-08-10 12:59:59";
//		
//		String tagId = "00000001";
//		String deviceId = "002";
//		String propertie = "用电量";
//		String devicePropertieValue = "90";
//
//		// opc传进来的时间
//		String timeBetween = "2017-08-10 24:51:00";
		//DataToMongodb.insertChildDocument("users", timeBetween, devicePropertieValue, tagId, deviceId, propertie);
		
//		String timeStart3 = "2017-09-10 02:00:00";
		//double avgValue = DataToMongodb.getOneDocumentAvgValue("00000001", timeStart3);
		//System.out.println(avgValue);
		
		//DataToMongodb.getOneDocumentMaxValue("00000001", timeStart3);
		
		//DataToMongodb.getOneDocumentMinValue("1", timeStart3);
		
		//MongoDBUtil.getCollectionTotalValue("00000001", "00000001");
		
		//MongoDBUtil.getCollectionTotalAvgValue("00000001", "00000001");
		
		
//		for(int j = 1000; j <= 9000; j++){
//    		String json = "{\"tagId\":\"5\",\"devicePropertieValue\":\"127\",\"devicePropertieUpdateTime\":\""+j+"-10-12 01:09:56\",\"cycleTime\":\"2\"}";
////        	String json = "{\"TagId\":\"001\",\"deviceId\":\"002\",\"deviceProperties\":\"温度\",\"devicePropertieValue\":\"100摄氏度\",\"devicePropertieUpdateTime\":\"20170602\"}";
//    		JSONObject json_test = JSONObject.fromObject(json);
//    		//System.out.println("deviceId:"+json_test.get("deviceId"));
//    		System.out.println("aaa:"+json_test);
//    		
//    		String tagId = json_test.getString("tagId");
//    		String devicePropertieUpdateTime = json_test.getString("devicePropertieUpdateTime");
//    		String devicePropertieValue = json_test.getString("devicePropertieValue");
//    		String deviceId = "999999999";
//    		String devicePropertieName = "哈哈";
//    		String devicePropertieID = "000000000";
//    		String energyConsumptionType = "hehe";
//    		String energyConsumptionChildType = "heheda";
//    		
//    		MongoDBUtil.insertChildDocument(tagId, devicePropertieUpdateTime, devicePropertieValue, tagId, deviceId, devicePropertieName, devicePropertieID, energyConsumptionType, energyConsumptionChildType);
//
//    	}
		
		String timeStart4 = "2017-10-14 09:09:00";
		//DataToMongodb.insertStatsticsDocument("statistics", timeStart4, "1");
		
		

	}
	
	
	public static void insertStatsticsDocument(String collectionName, String devicePropertieUpdateTime, String tagId,String statisticsCollectionName){
		
		
		int year = Integer.parseInt(devicePropertieUpdateTime.substring(0, 4));
		System.out.println(year);
		
		int month = Integer.parseInt(devicePropertieUpdateTime.substring(5, 7));
		System.out.println(month);

		int date = Integer.parseInt(devicePropertieUpdateTime.substring(8, 10));
		System.out.println(date);
		
		int hourOfDay = Integer.parseInt(devicePropertieUpdateTime.substring(11, 13));
		System.out.println(hourOfDay);
		
		int minute = Integer.parseInt(devicePropertieUpdateTime.substring(14, 16));
		System.out.println(minute);
		
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, date, hourOfDay, minute);
		System.out.println("当前时间假设为：");
		String nowTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(c.getTime());  
	    System.out.println(nowTime);
	    System.out.println("***********************************************************");
		
		c.add(Calendar.HOUR_OF_DAY, -1);
		System.out.println("上一个小时的时间为：");
		String lastOneHour = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(c.getTime());  
	    System.out.println(lastOneHour);
		
		 String s = lastOneHour.substring(0, 13);
		 System.out.println(s);
		 String timeStart = s.concat(":00:00");
		 System.out.println(timeStart);
		
		 // 插入timeStart的时候，需要修改时间， 时间更改为：2017-08-10 14:00:00
		 //BasicDBObject queryObject = new BasicDBObject("timeStart",all);
		 //DBObject obj = MongoDBUtil.getMongoCollection(collectionName).findOne(queryObject);
		 //System.out.println(obj);
		 
		 
		 BasicDBObject timeStartObject = new BasicDBObject("timeStart",timeStart);
		 BasicDBObject tagIdObj = new BasicDBObject("tagId",tagId);
	    
		 BasicDBObject andObj = new BasicDBObject("$and",Arrays.asList(timeStartObject,tagIdObj));
		 
		 Cursor cursor = collection.find(andObj);
	     while(cursor.hasNext()){
	    	 	DBObject obj = cursor.next();
	    	 	System.out.println(obj.toString());
	    	 	
	    	 	System.out.println("查找到对应tagId的上一小时的数据了");
	    	 	
//	    	 	MongoDBUtil.getCollectionTotalValue("1", "1");
	    	 	
	    	 	Double totalValue = MongoDBUtil.getOneDocumentTotalValue(tagId, timeStart);
	    	 	Double avgValue = MongoDBUtil.getOneDocumentAvgValue(tagId, timeStart);
	    	 	Double maxValue = MongoDBUtil.getOneDocumentMaxValue(tagId, timeStart);
	    	 	Double minValue = MongoDBUtil.getOneDocumentMinValue(tagId, timeStart);
	    	 	
	    	 	System.out.println("单document统计的数据为：" + totalValue);
				System.out.println("单document平均值：" + avgValue);
				System.out.println("单document最大值：" + maxValue);
				System.out.println("单document最小值：" + minValue);
	    	 	
//	    	 	DBObject statisticsData = new BasicDBObject();
//	    	 	statisticsData.put("tagId", tagId);
//	    	 	
//	    	 	statisticsData.put("timeStart", timeStart);
//	    	 	statisticsData.put("totalValue", totalValue);
//	    	 	statisticsData.put("avgValue", avgValue);
//	    	 	statisticsData.put("maxValue", maxValue);
//	    	 	statisticsData.put("minValue", minValue);
//	    	 	MongoDBUtil.getMongoCollection(collectionName).save(statisticsData);
	   		
//	   		 if(obj != null){
//	   			 System.out.println("恭喜你，mongoDB中已经有这条记录了!!!!!!!!!!!!!!!!!!!!!!");
//	   			 
//	   		 } else {
//	   			 System.out.println("mongoDB里面没有这条document，得重新插入一条");
//	   			
//	   			 DBObject user = new BasicDBObject();
//	   			
//	   			 user.put("tagId", tagId);
//	   			 user.put("deviceId ", deviceId);
//	   			 user.put("devicePropertieName", devicePropertieName);
//	   			 user.put("devicePropertieID", devicePropertieID);
//	   			 user.put("energyConsumptionType", energyConsumptionType);
//	   			 user.put("energyConsumptionChildType", energyConsumptionChildType);
//	   			 user.put("timeStart", all);
//	   			 user.put("totalValue", totalValue);
//	   			 user.put("avgValue", avgValue);
//	   			 user.put("maxValue", maxValue);
//	   			 user.put("minValue", minValue);
//	   			 //System.out.println(user);	
//	   			 MongoDBUtil.getMongoCollection(collectionName).save(user);
//	   			 //MongoDBUtil.insertDocument(collectionName, user);
//	   		
//	   		 }
//	    	 	
	    	 	
	        }
		 
}
	
	
	
	/**
	 * 往内嵌属性中增加一条信息，参数传入collectionName，原始的那条document，类型为为DBObject，要插入的BasicDBObject类型信息。
	 * 
	 * @param collectionName
	 * @param OldDocument
	 */
	public static void insertChildDocument(String collectionName, String devicePropertieUpdateTime, 
			String devicePropertieValue, String tagId, String deviceId, String devicePropertieName,
			String devicePropertieID, String energyConsumptionType, String energyConsumptionChildType){
		 String s = devicePropertieUpdateTime.substring(0, 13);
		 System.out.println(s);
		 String all = s.concat(":00:00");
		 System.out.println(all);
		
		 // 插入timeStart的时候，需要修改时间， 时间更改为：2017-08-10 14:00:00
		 BasicDBObject queryObject = new BasicDBObject("timeStart",all);
		 DBObject obj = collection.findOne(queryObject);
		 System.out.println(obj);
		 
		 /*
		  * 修改插入时间，时间原本格式为：2017-08-10 14:59:56
		  * 插入到内嵌应该更改为：14:59:00
		  */
		 String time = devicePropertieUpdateTime.substring(11, 16);
		 String embededTime = time+":00";
		 System.out.println(embededTime);
		
		 if(obj != null){
		 System.out.println("恭喜你，mongoDB中找到这条记录，插入内嵌数据");
		 BasicDBObject u= new BasicDBObject().append("$set",new BasicDBObject()
		 				.append("devicePropertiesValue."+embededTime, devicePropertieValue));
		 collection.update(obj, u);
		 } else {
		 System.out.println("mongoDB里面没有这条document，得重新插入一条");
		
		 DBObject user = new BasicDBObject();
		
		 user.put("tagId", tagId);
		 user.put("deviceId ", deviceId);
		 user.put("devicePropertieName", devicePropertieName);
		 user.put("devicePropertieID", devicePropertieID);
		 user.put("energyConsumptionType", energyConsumptionType);
		 user.put("energyConsumptionChildType", energyConsumptionChildType);
		 user.put("timeStart", all);
		
		 DBObject user2 = new BasicDBObject();
		 user2.put(embededTime, devicePropertieValue);
		 user.put("devicePropertiesValue", user2);
		 //System.out.println(user);	
		 collection.save(user);
		 //MongoDBUtil.insertDocument(collectionName, user);
		
		 }
	}
	
	
	/**
	 * 返回单个document的所有value值总和
	 * totalValue
	 *  
	 * @param collectionName
	 * @return
	 */
	public static double getOneDocumentTotalValue(String collectionName, String timeStart){
//		String timeStart1 = "2017-08-10 13:00:00";
		
		BasicDBObject queryObject = new BasicDBObject("timeStart", timeStart);
		DBObject obj = collection.findOne(queryObject);
		System.out.println(obj);

		System.out.println(obj.get("devicePropertiesValue"));
		BasicDBObject data = (BasicDBObject) obj.get("devicePropertiesValue");
		// System.out.println(data.get("2017-08-10 13:02:00"));
		
		//System.out.println(timeStart1.substring(0, 15));
		String front1 = timeStart.substring(11, 15); // 13:0
		String front2 = timeStart.substring(11, 14); // 13:
		System.out.println("front1="+front1);
		System.out.println("front2="+front2);
		
		//System.out.println(data.get("13:02:00"));
		System.out.println("============================================================");
		int value1 = 0;
		int value2 = 0;
		for (int i = 0; i <= 9; i++) {
			 //System.out.println(data.get(front1 + i +":00"));
			if (data.get(front1 + i + ":00") != null) {
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front1 + i + ":00");
				System.out.println(values);

				int result = Integer.parseInt(values);
				value1 += result;
			}
		}
		System.out.println("****************************************");
		for (int i = 10; i <= 60; i++) {
			// System.out.println(data.get("2017-08-10 13:"+i+":00"));
			if (data.get(front2 + i + ":00") != null) {
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front2 + i + ":00");
				System.out.println(values);

				int result = Integer.parseInt(values);
				value2 += result;
			}
		}

		System.out.println("-----------------------------------------");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println("-----------------------------------------");
		int totalValue = value1 + value2;
		System.out.println("这个document的总的数值为：" + totalValue);
		return totalValue;
	}
	
	/**
	 * 返回单个document的所有value值的平均值
	 * avg
	 * 
	 * @param collectionName
	 * @param timeStart
	 * @return
	 */
	public static double getOneDocumentAvgValue(String collectionName, String timeStart){
//		String timeStart1 = "2017-08-10 13:00:00";
		
		BasicDBObject queryObject = new BasicDBObject("timeStart", timeStart);
		DBObject obj = collection.findOne(queryObject);
		System.out.println(obj);

		System.out.println(obj.get("devicePropertiesValue"));
		BasicDBObject data = (BasicDBObject) obj.get("devicePropertiesValue");
		// System.out.println(data.get("2017-08-10 13:02:00"));
		
		//System.out.println(timeStart1.substring(0, 15));
		String front1 = timeStart.substring(11, 15); // 13:0
		String front2 = timeStart.substring(11, 14); // 13:
		System.out.println("front1="+front1);
		System.out.println("front2="+front2);
		
		//System.out.println(data.get("13:02:00"));
		System.out.println("============================================================");
		int value1 = 0;
		int value2 = 0;
		int flag = 0;
		for (int i = 0; i <= 9; i++) {
			 //System.out.println(data.get(front1 + i +":00"));
			if (data.get(front1 + i + ":00") != null) {
				flag++;
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front1 + i + ":00");
				System.out.println(values);

				int result = Integer.parseInt(values);
				value1 += result;
			}
		}
		System.out.println("****************************************");
		for (int i = 10; i <= 60; i++) {
			// System.out.println(data.get("2017-08-10 13:"+i+":00"));
			if (data.get(front2 + i + ":00") != null) {
				flag++;
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front2 + i + ":00");
				System.out.println(values);

				int result = Integer.parseInt(values);
				value2 += result;
			}
		}

		System.out.println("-----------------------------------------");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println("-----------------------------------------");
		double totalValue = value1 + value2;
		System.out.println("这个document的总的数值为：" + totalValue);
		System.out.println("flag = " + flag);
		double avgValue = totalValue / flag;
		System.out.println("avgtValue = " + avgValue);
		return avgValue;
		
	}
	
	/**
	 * 返回单个document的所有value值的最大值
	 * max
	 * 
	 * @param collectionName
	 * @param timeStart
	 * @return
	 */
	public static double getOneDocumentMaxValue(String collectionName, String timeStart){
//		String timeStart1 = "2017-08-10 13:00:00";
		
		BasicDBObject queryObject = new BasicDBObject("timeStart", timeStart);
		DBObject obj = collection.findOne(queryObject);
		System.out.println(obj);

		System.out.println(obj.get("devicePropertiesValue"));
		BasicDBObject data = (BasicDBObject) obj.get("devicePropertiesValue");
		// System.out.println(data.get("2017-08-10 13:02:00"));
		
		//System.out.println(timeStart1.substring(0, 15));
		String front1 = timeStart.substring(11, 15); // 13:0
		String front2 = timeStart.substring(11, 14); // 13:
		System.out.println("front1="+front1);
		System.out.println("front2="+front2);
		
		//System.out.println(data.get("13:02:00"));
		System.out.println("============================================================");
		int value1 = 0;
		int value2 = 0;
		int flag = 0;
		double max1 = 0, max2 = 0;
		
		for (int i = 0; i <= 9; i++) {
			 //System.out.println(data.get(front1 + i +":00"));
			if (data.get(front1 + i + ":00") != null) {
				flag++;
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front1 + i + ":00");
				System.out.println(values);

				double result = Integer.parseInt(values);
				
				if(flag == 1){
					max1 = result;
				}
				
				if(result > max1){
					max1 = result;
				}
				
			}
		}
		System.out.println("****************************************");
		int flag2 = 0;
		for (int i = 10; i <= 60; i++) {
			// System.out.println(data.get("2017-08-10 13:"+i+":00"));
			if (data.get(front2 + i + ":00") != null) {
				flag++;
				flag2++;
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front2 + i + ":00");
				System.out.println(values);

				int result = Integer.parseInt(values);
				
				if(flag2 == 1){
					max2 = result;
				}
				if(result > max2){
					max2 = result;
				}
			}
		}

		System.out.println("-----------------------------------------");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println("-----------------------------------------");
		double totalValue = value1 + value2;
		System.out.println("这个document的总的数值为：" + totalValue);
		System.out.println("flag = " + flag);
		
		System.out.println("max1 = " + max1);
		System.out.println("max2 = " + max2);
		double max = max1 > max2 ? max1 : max2;
		System.out.println("max = " + max);
		return max;
	}
	
	/**
	 * 返回单个document的所有value值的最小值
	 * min
	 * 
	 * @param collectionName
	 * @param timeStart
	 * @return
	 */
	public static double getOneDocumentMinValue(String collectionName, String timeStart){
//		String timeStart1 = "2017-08-10 13:00:00";
		
		BasicDBObject queryObject = new BasicDBObject("timeStart", timeStart);
		DBObject obj = collection.findOne(queryObject);
		System.out.println(obj);

		System.out.println(obj.get("devicePropertiesValue"));
		BasicDBObject data = (BasicDBObject) obj.get("devicePropertiesValue");
		// System.out.println(data.get("2017-08-10 13:02:00"));
		
		//System.out.println(timeStart1.substring(0, 15));
		String front1 = timeStart.substring(11, 15); // 13:0
		String front2 = timeStart.substring(11, 14); // 13:
		System.out.println("front1="+front1);
		System.out.println("front2="+front2);
		
		//System.out.println(data.get("13:02:00"));
		System.out.println("============================================================");
		int value1 = 0;
		int value2 = 0;
		int flag = 0;
		double min1 = 0, min2 = 0;
		for (int i = 0; i <= 9; i++) {
			 //System.out.println(data.get(front1 + i +":00"));
			if (data.get(front1 + i + ":00") != null) {
				flag++;
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front1 + i + ":00");
				System.out.println(values);

				int result = Integer.parseInt(values);
				
				if(flag == 1){
					min1 = result;
				}
				
				if(result < min1){
					min1 = result;
				}
				
			} else {
				min1 = -999999;
			}
		}
		System.out.println("****************************************");
		int flag2 = 0;
		for (int i = 10; i <= 60; i++) {
			// System.out.println(data.get("2017-08-10 13:"+i+":00"));
			if (data.get(front2 + i + ":00") != null) {
				flag++;
				flag2++;
				// System.out.println(data.get("2017-08-10 13:"+i+":00"));
				String values = (String) data.get(front2 + i + ":00");
				System.out.println(values);

				int result = Integer.parseInt(values);
				
				if(flag2 == 1){
					min2 = result;
				}
				if(result < min2){
					min2 = result;
				}
			}
		}
		double min;
		System.out.println("-----------------------------------------");
		
		System.out.println("flag = " + flag);
		
		System.out.println("min1 = " + min1);
		System.out.println("min2 = " + min2);
		
		if(min1 == -999999){
			min = min2;
		} else {
			min = min1 > min2 ? min2 : min1;
		}
		
	
		
		System.out.println("min = " + min);
		return min;
	}
	
	

	/**
	 * 返回整个collection的所有value值的总和
	 * 
	 * @param collectionName
	 * @param timeStart
	 * @return
	 */
	public static double getCollectionTotalValue(String collectionName) {
		Pattern queryPattern = Pattern.compile("00000001", Pattern.CASE_INSENSITIVE);
        BasicDBObject queryObject = new BasicDBObject("tagId",queryPattern);
        Cursor cursor = collection.find(queryObject);
        
        double collectionTotalValue = 0;
        while(cursor.hasNext()){
        	DBObject obj = cursor.next();
        	//System.out.println(obj.toString());
        	System.out.println(obj.get("timeStart"));
        	String timeStart = (String) obj.get("timeStart");
        	
        	BasicDBObject data = (BasicDBObject) obj.get("devicePropertiesValue");
        	System.out.println(data);
    		System.out.println(data.get("13:02:00"));
    		
    		//for(int )
    		double result = DataToMongodb.getOneDocumentTotalValue("00000001", timeStart);
    		collectionTotalValue += result;
    		
    		System.out.println("collectionTotalValue = " + collectionTotalValue);
        	
        } 
		return collectionTotalValue;
	}
	
	/**
	 * 返回整个collection的所有value值的总平均值
	 * collectionTotalAvgValue
	 * 
	 * @param collectionName
	 * @param timeStart
	 * @return
	 */
	public static double getCollectionTotalAvgValue(String collectionName, String tagId) {
		Pattern queryPattern = Pattern.compile(tagId, Pattern.CASE_INSENSITIVE);
        BasicDBObject queryObject = new BasicDBObject("tagId",queryPattern);
        Cursor cursor = collection.find(queryObject);
        
        double collectionTotalValue = 0;
        int flag = 0;
        while(cursor.hasNext()){
        	DBObject obj = cursor.next();
        	//System.out.println(obj.toString());
        	System.out.println(obj.get("timeStart"));
        	String timeStart = (String) obj.get("timeStart");
        	
        	BasicDBObject data = (BasicDBObject) obj.get("devicePropertiesValue");
        	System.out.println(data);
    		//System.out.println(data.get("13:02:00"));
    		
    		double result = MongoDBUtil.getOneDocumentTotalValue("00000001", timeStart);
    		flag++;
    		collectionTotalValue += result;
    		
    		System.out.println("collectionTotalValue = " + collectionTotalValue);
        	
        } 
        System.out.println("flag = " + flag);
        double collectionTotalAvgValue = collectionTotalValue / flag;
        System.out.println("collectionTotalAvgValue = " + collectionTotalAvgValue);
		return collectionTotalAvgValue;
	}

}
