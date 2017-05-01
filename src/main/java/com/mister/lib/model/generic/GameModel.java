package com.mister.lib.model.generic;

import java.io.Serializable;

public abstract class GameModel implements Model, Serializable {
    @Override
    public String getSaveFileName() {
        return String.format("%s.%s", this.getClass().getSimpleName().toLowerCase(), "data");
    }
}
