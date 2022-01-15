package com.company;

import com.company.Exception.ActiveException;

public abstract class PassiveObject extends ActiveException {
    public String name="нет имени";
    public String getName() {
        return name;
    }

}
