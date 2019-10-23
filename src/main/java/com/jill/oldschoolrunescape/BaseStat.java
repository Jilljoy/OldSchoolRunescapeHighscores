package com.jill.oldschoolrunescape;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

/**
 * The base stat for all Old School Runescape skills
 */
public class BaseStat {

    /** The level of the stat */
    @Min(1L)
    @Max(99L)
    private int level;

    /** The experience of the stat */
    @Max(200000000L)
    private long experience;

    /**
     * Constructs a new base stat
     * @param level the level of the stat
     * @param experience the experience of the stat
     */
    BaseStat(@Min(1L) @Max(99L) int level, @Max(200000000L) long experience) {
        this.level = level;
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("level", level)
                .append("experience", experience)
                .toString();
    }
}
