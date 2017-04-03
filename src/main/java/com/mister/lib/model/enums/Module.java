package com.mister.lib.model.enums;

import com.mister.lib.model.Team;

import java.util.HashMap;
import java.util.Map;

public enum Module {
    M442("4-4-2", new int[]{1, 2, 1, 1, 2, 1, 1, 2, 0, 0}, 2),
    M433("4-3-3", new int[]{1, 2, 1, 1, 3, 0, 0, 1, 1, 1}, 1),
    M451("4-5-1", new int[]{1, 2, 1, 1, 3, 1, 1, 1, 0, 0}, 4),
    M424("4-2-4", new int[]{1, 2, 1, 1, 2, 0, 0, 2, 1, 1}, 1),
    M352("3-5-2", new int[]{1, 3, 0, 0, 3, 1, 1, 2, 0, 0}, 2),
    M343("3-4-3", new int[]{1, 3, 0, 0, 2, 1, 1, 1, 1, 1}, 1),
    M334("3-3-4", new int[]{1, 3, 0, 0, 3, 0, 0, 2, 1, 1}, 1),
    M541("5-4-1", new int[]{1, 3, 1, 1, 2, 1, 1, 1, 0, 0}, 4),
    M532("5-3-2", new int[]{1, 3, 1, 1, 3, 0, 0, 2, 0, 0}, 4);

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

    public int[] getRoles() {
        return rolesNeeded;
    }

    public HashMap<Position, Integer> getRolesNeeded() {
        HashMap<Position, Integer> positionHash = new HashMap<>();
        Position[] positions = Position.values();
        for (int i = 0; i < rolesNeeded.length; i++) {
            positionHash.put(positions[i], rolesNeeded[i]);
        }
        return positionHash;
    }

    public boolean teamCanPlay(Team team) {
        HashMap<Position, Integer> playersPerRole = team.getPlayersPerRole();
        for (Map.Entry<Position, Integer> roleNeeded : getRolesNeeded().entrySet()) {
            if (roleNeeded.getValue() < 1) {
                continue;
            }

            if (playersPerRole.get(roleNeeded.getKey()) < roleNeeded.getValue()) {
                return false;
            }
        }
        return true;
    }

    public int getCharacter() {
        return character;
    }

    public boolean isOffensive() {
        return character == 1;
    }

    public boolean isDefensive() {
        return character == 4;
    }

    public boolean isBalanced() {
        return character == 2;
    }
}
