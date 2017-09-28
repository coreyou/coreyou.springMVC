package basic.converter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自行定義的屬性編輯器
 * 
 * @author coreyou
 *
 */
public class DateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(text);
			setValue(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
