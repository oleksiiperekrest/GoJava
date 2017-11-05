package gojava.techskills.module7_SDK_JSON_Generics.fruit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FruitDates {

    private Date dateReceived;
    private Date dateSpoiled;

    public FruitDates(Fruit fruit) throws ParseException {
        this.dateReceived = new SimpleDateFormat("dd/MM/yyyy").parse(fruit.getDate());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateReceived);
        calendar.add(Calendar.DATE, fruit.getShelfLife());
        this.dateSpoiled = calendar.getTime();
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public Date getDateSpoiled() {
        return dateSpoiled;
    }

    public Date getSimpleDate(String date) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }
}
