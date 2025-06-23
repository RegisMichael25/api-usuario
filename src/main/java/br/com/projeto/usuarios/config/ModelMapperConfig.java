package br.com.projeto.usuarios.config;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // Conversor String -> LocalDate
        Converter<String, LocalDate> stringToLocalDate = ctx -> {
            if (ctx.getSource() == null || ctx.getSource().isEmpty()) {
                return null;
            }
            return LocalDate.parse(ctx.getSource(), formatter);
        };

        // Conversor LocalDate -> String
        Converter<LocalDate, String> localDateToString = ctx -> {
            if (ctx.getSource() == null) {
                return null;
            }
            return ctx.getSource().format(formatter);
        };

        mapper.typeMap(String.class, LocalDate.class).setConverter(stringToLocalDate);
        mapper.typeMap(LocalDate.class, String.class).setConverter(localDateToString);

        return mapper;
    }
}
