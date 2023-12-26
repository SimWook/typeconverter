package springpractice.typeconverter.formatter;

import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import springpractice.typeconverter.converter.IpPortToStringConverter;
import springpractice.typeconverter.converter.StringToIpPortConverter;
import springpractice.typeconverter.type.IpPort;

import static org.assertj.core.api.Assertions.assertThat;

class FormattingConversionServiceTest {
    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //converter登録
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        //formatter登録
        conversionService.addFormatter(new MyNumberFormatter());

        //converter使用
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        //formatter使用
        assertThat(conversionService.convert(1000,String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);
    }
}
