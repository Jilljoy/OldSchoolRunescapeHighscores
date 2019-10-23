package com.jill.oldschoolrunescape;

public enum Skill {
    ATTACK(0),
    AGILITY(16),
    CONSTRUCTION(22),
    COOKING(7),
    CRAFTING(12),
    DEFENCE(1),
    FARMING(19),
    FIREMAKING(11),
    FISHING(10),
    FLETCHING(9),
    HERBLORE(15),
    HITPOINTS(3),
    HUNTER(21),
    MAGIC(6),
    MINING(14),
    PRAYER(5),
    RANGED(4),
    RUNECRAFT(20),
    SLAYER(18),
    SMITHING(13),
    STRENGTH(2),
    THIEVING(17),
    WOODCUTTING(8);

    private int apiPosition;

    Skill(int apiPosition) {
        this.apiPosition = apiPosition;
    }

    public static Skill getSkill(int apiPosition) {
        return Skill.values()[apiPosition];
    }

    public int getApiPosition() {
        return apiPosition;
    }
}
