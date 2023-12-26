package springpractice.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;


import static org.assertj.core.api.Assertions.*;

class MyNumberFormatterTest {
    MyNumberFormatter formatter = new MyNumberFormatter();
    @Test
    void parse() throws ParseException {
        Number result = formatter.parse("1,000", Locale.JAPAN);
        assertThat(result).isEqualTo(1000L); //Longタイプ注意
    }
    @Test
    void print() {
        String result = formatter.print(1000, Locale.JAPAN);
        assertThat(result).isEqualTo("1,000");
    }
}
