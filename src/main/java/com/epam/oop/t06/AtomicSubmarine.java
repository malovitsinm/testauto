package com.epam.oop.t06;

import com.epam.oop.t07.MarineAnnotation;

@MarineAnnotation(someValue = 13, author = "Malovicin M")
public class AtomicSubmarine {
    public String embark(){
        EngineSystems engine = new EngineSystems();
        return engine.initEngienes();
    }

    class EngineSystems {
        private String initEngienes(){
            return "Full speed to the sunset!";
        }
    }

}
