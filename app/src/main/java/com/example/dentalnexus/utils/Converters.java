package com.example.dentalnexus.utils;

import androidx.room.TypeConverter;
import com.example.dentalnexus.model.finances.ModePaiement;

public class Converters {

    @TypeConverter
    public static String fromModePaiement(ModePaiement mode) {
        return mode == null ? null : mode.name();
    }

    @TypeConverter
    public static ModePaiement toModePaiement(String mode) {
        return mode == null ? null : ModePaiement.valueOf(mode);
    }
}
