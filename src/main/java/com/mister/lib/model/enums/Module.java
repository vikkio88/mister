package com.mister.lib.model.enums;

public enum Module {
    M442("4-4-2", new int[]{1, 1, 3, 1, 1, 2, 1, 0, 2, 0}, 2),
    M433("4-3-3", new int[]{1, 1, 2, 1, 0, 3, 0, 1, 1, 1}, 1),
    M451("4-5-1", new int[]{1, 1, 2, 1, 1, 3, 1, 0, 1, 0}, 4),
    M424("4-2-4", new int[]{1, 1, 2, 1, 0, 2, 0, 1, 2, 1}, 1),
    M352("3-5-2", new int[]{1, 0, 3, 0, 1, 3, 1, 0, 2, 0}, 2),
    M343("3-4-3", new int[]{1, 0, 3, 0, 1, 2, 1, 1, 1, 1}, 1),
    M334("3-3-4", new int[]{1, 0, 3, 0, 0, 3, 0, 1, 2, 1}, 1),
    M541("5-4-1", new int[]{1, 1, 3, 1, 1, 2, 1, 0, 1, 0}, 4),
    M532("5-3-2", new int[]{1, 1, 3, 1, 0, 3, 0, 0, 2, 0}, 4);

    private String name;
    private int[] rolesNeeded;
    private int character;

    Module(String name, int[] rolesNeeded, int character) {
        this.name = name;
        this.rolesNeeded = rolesNeeded;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public int[] getRolesNeeded() {
        return rolesNeeded;
    }

    public int getCharacter() {
        return character;
    }
}
