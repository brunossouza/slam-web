package dev.valhala.slam.utils.generators;

import java.util.UUID;

public class TokenGenerator {

    public static String create(){
        return UUID.randomUUID().toString();
    }

}
