package com.jill.oldschoolrunescape;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class HighscoreStat extends BaseStat {

    @NotNull
    private Skill skill;

    @Max(2000000)
    private long rank;

    HighscoreStat(@Min(1L) @Max(99L) int level, @Max(200000000L) long experience, Skill skill, long rank) {
        super(level, experience);
        this.skill = skill;
        this.rank = rank;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("skill", skill)
                .append("rank", rank)
                .toString();
    }
}
