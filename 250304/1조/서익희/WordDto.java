package main;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class WordDto {
	private String engword;
	private String krmean;
	private Date inidate;
	public String getEngword() {
		return engword;
	}
	public void setEngword(String engword) {
		this.engword = engword;
	}
	public String getKrmean() {
		return krmean;
	}
	public void setKrmean(String krmean) {
		this.krmean = krmean;
	}
	
	public void prt() {
		System.out.println("영어: "+this.engword);
		System.out.println("뜻 "+this.krmean);
		System.out.println("날짜"+this.inidate);
	}
	public Date getInidate() {
		return inidate;
	}
	public void setInidate(Date date) {
		this.inidate = date;
	}
}
