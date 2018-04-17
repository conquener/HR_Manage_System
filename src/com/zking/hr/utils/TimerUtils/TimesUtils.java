package com.zking.hr.utils.TimerUtils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.zking.hr.dao.impl.TFiles.TFilesDaoImpl;
import com.zking.hr.dao.interfaces.TFiles.ITFilesDao;
import com.zking.hr.pojo.TFiles;

public class TimesUtils implements ServletContextListener{
	private ITFilesDao filedao = new TFilesDaoImpl();
	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		Date d = new Date(System.currentTimeMillis());
		Date date = new Date(d.getYear(),d.getMonth(),d.getDate(),24,0,0);
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	        public void run() {
	        	Date date1 = new Date(System.currentTimeMillis());
	        	System.out.println("---1123");
	        	int index = filedao.updateFilesEmpSalaryStatus();
	        	System.out.println(index);
	        	if(date1.getDate()==15){
	        	}
	        }
	    },0, 3600);
	}

	public ITFilesDao getFiledao() {
		return filedao;
	}

	public void setFiledao(ITFilesDao filedao) {
		this.filedao = filedao;
	}
	
}
