package com.jill.oldschoolrunescape;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/old/highscores", method = RequestMethod.GET)
public class OSRSController  {

    /** The logger for this class */
    private static final Logger LOG = LoggerFactory.getLogger(OSRSController.class);

    private static final String HIGHSCORE_URI ="https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws";

    @GetMapping(path = "/player")
    public List<HighscoreStat> getPlayerHighscore(@RequestParam(name = "player") String player) {

        LOG.info("Received call to /old/highscore with player parameter '{}'", player);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(HIGHSCORE_URI)
                .queryParam("player", player);


        List<String> lines = Arrays.asList(new RestTemplate().getForObject(builder.toUriString(), String.class).split("\\r?\\n"));

        List<HighscoreStat> highscoreStats = new ArrayList<>();

        int skillCounter = 0;
        int maxSkillCounter = Skill.values().length;
        for (int i = 1; i < lines.size(); i++) {
            if(i >= maxSkillCounter)
                break;
            List<String> elements = Arrays.asList(lines.get(i).split("\\s*,\\s*"));
            if(elements.size() == 3) {
                highscoreStats.add(translate(skillCounter++, elements));
            }
        }

        return highscoreStats;
    }

    @GetMapping(path = "/rank")
    public List<HighscoreStat> getByRank(@RequestParam(name = "rank") int rank) {
        LOG.info("Received call to /old/highscore with rank parameter {}", rank);
        return Collections.emptyList();
    }

    private HighscoreStat translate(int position, List<String> strings) {
        return new HighscoreStat(Integer.parseInt(strings.get(1)), Long.parseLong(strings.get(2)),
                Skill.getSkill(position), Long.parseLong(strings.get(0)));
    }
}
