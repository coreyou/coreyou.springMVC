package basic.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自行定義的資料轉換器，
 * 另外要定義在springConfig.xml中
 * 
 * @author coreyou
 *
 */
public class StringToDateConverter implements Converter<String, Date> {
	
	private String datePattern;
	
	@Override
	public Date convert(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(this.getDatePattern());
			return dateFormat.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("日期轉換失敗");
			return null;
		}
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

}
