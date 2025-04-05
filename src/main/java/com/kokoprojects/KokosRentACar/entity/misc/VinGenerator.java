package com.kokoprojects.KokosRentACar.entity.misc;

import java.util.Random;

public class VinGenerator {
    private static final String VIN_CHARS = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
    private static final int VIN_LENGTH = 17;
    private static final Random Random = new Random();

    public static String generateVin(){
        StringBuilder vin = new StringBuilder();
        for(int i =0;i < VIN_LENGTH; i++){
            vin.append(VIN_CHARS.charAt(Random.nextInt(VIN_CHARS.length())));
        }
        return vin.toString();
    }
}
