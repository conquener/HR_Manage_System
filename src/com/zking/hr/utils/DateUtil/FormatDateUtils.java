package com.zking.hr.utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class FormatDateUtils {
	/**
	 * �����ṩ�����ڸ�ʽ������ת������Ӧ��ʽ
	 * @param format
	 * @param date
	 * @return String
	 */
	public static String format(String format,Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * ���ݵ�ǰʱ�����id�ķ���
	 * @param prefix
	 * @return String
	 */
	public static String createDateID(String prefix){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
		String id = prefix + sdf.format(new Date());
		Random r = new Random();
		char[] c = new char[4];
		for (int i = 0;i< c.length;i++) {
			c[i] = (char) (r.nextInt(25)+65);
		}
//		new String(c);
		id += new String(c);
		return id;
	}
	
	/**
	 * sqlʱ��ת��Ϊutils��ʱ��
	 * @param sqldate
	 * @return java.utils.Date
	 */
	public static Date sqlChangeUtils(java.sql.Date sqldate){
		java.util.Date d=new java.util.Date (sqldate.getTime());
		return d;
	}
	
	/**
	 * utils��ʱ��ת��Ϊsqlʱ��
	 * @param utilsdate
	 * @return java.sql.Date
	 */
	public static java.sql.Date utilsChangesql(Date utilsdate){
		java.sql.Date sqlDate=new java.sql.Date(utilsdate.getTime());
		return sqlDate;
	}
	/**
	 * �ַ���ת��Ϊutilsʱ��
	 * @param s
	 * @return java.utils.Date
	 */
	public static Date stringChangeutils(String s){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = null;
		   char[] c=new char[s.length()];
			boolean matches=false;
			for(int i=0;i<c.length;i++){
				if(c[i]==':'){
					matches=true;
					System.out.println(i);
					break;
				}
			}
		    try {
		    	if(matches){
				date = (Date) format1.parseObject(s);
				}else{
				date = (Date) format2.parseObject(s);
					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		   return date;
		
	}
	/**
	 * �ַ���ת��Ϊsqlʱ��
	 * @param s
	 * @return java.utils.Date
	 */
	public static java.sql.Date stringChangesql(String s){
		Date d=stringChangeutils(s);
		java.sql.Date sqldate=utilsChangesql(d);
		return sqldate;
	}
//	public static void main(String[] args) {
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date d=new Date("1232-02-13 11:11:11");
//		System.out.println(format1.format(d));
//		java.sql.Timestamp sd=new Timestamp(System.currentTimeMillis());
//		sd.setYear(d.getYear());
//		sd.setMonth(d.getMonth());
////		sd.setDate(d.getDate());
//		sd.setHours(d.getHours());
//		sd.setMinutes(d.getMinutes());
//		sd.setSeconds(d.getSeconds());
//		System.out.println(sd);
//	}

}
