package bg.alexander.formatters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component("dateFormatter")
public class DateFormatter implements Formatter<Date> {

	@Autowired
    private MessageSource messageSource;
	
	@Override
	public String print(Date date, Locale locale) {
		SimpleDateFormat formatter = createDateFormat(locale);
		return formatter.format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		Date d = createDateFormat(locale).parse(text);
		return d;
	}

	private SimpleDateFormat createDateFormat(final Locale locale) {
        final String format = this.messageSource.getMessage("date.format.java", null, locale);
        final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat;
    }
	
}
