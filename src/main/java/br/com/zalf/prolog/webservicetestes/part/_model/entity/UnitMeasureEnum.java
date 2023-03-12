package br.com.zalf.prolog.webservicetestes.part._model.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

public enum UnitMeasureEnum {

    MT {
        @NotNull
        @Override
        public String toDatabaseValue() {
            return UnitMeasureEnum.MT.toString();
        }
    },
    CM {
        @NotNull
        @Override
        public String toDatabaseValue() {
            return UnitMeasureEnum.CM.toString();
        }
    },
    MM {
        @NotNull
        @Override
        public String toDatabaseValue() {
            return UnitMeasureEnum.MM.toString();
        }
    };

    @NotNull
    public abstract String toDatabaseValue();

    @NotNull
    public static UnitMeasureEnum fromDatabaseValue(@Nullable final String databaseValue) {
        final var values = UnitMeasureEnum.values();
        for (final UnitMeasureEnum value : values) {
            if (value.toDatabaseValue().equals(databaseValue)) {
                return value;
            }
        }
        throw new IllegalStateException("No TireStatus available for value %s.".formatted(databaseValue));
    }
}
