package com.isu.model;

public enum Role {
    STUDENT,
    MAGE,
    ADMIN;

    public int toInt() {
        switch (this) {
            case STUDENT: return 1;
            case MAGE: return 2;
            case ADMIN: return 3;
        }

        return 0;
    }

    public static Role fromInt(int role) {
        for (Role candidate : Role.values()) {
            if (candidate.toInt() == role) {
                return candidate;
            }
        }

        // must never happen
        return null;
    }
}
