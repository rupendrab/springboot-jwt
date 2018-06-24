package com.nouhoun.springboot.jwt.integration.adhoc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test01
{
    public static void main(String[] args)
    {
        System.out.println("Start-1");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("Start-2");
        String encoded = encoder.encode("XY7kmzoNzl100");
        System.out.println(encoder.matches("jwtpass", "$2a$10$J8LToGM/yoqQ7.pqCYH1COYmTz7YWAXpl1d43xbBvik.NnJAy4gAC"));
        System.out.println("Start-3");
        System.out.println(encoded);
        System.out.println("Start-4");
    }

}
