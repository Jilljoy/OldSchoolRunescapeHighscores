package com.jill.oldschoolrunescape;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class OSRSController  {

    private static final String HIGHSCORE_URI ="https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws";

    @GetMapping("/old/highscore")
    public List<HighscoreStat> getPlayerHighscore(@RequestParam(name = "player") String player) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(HIGHSCORE_URI)
                .queryParam("player", player);

        List<String> lines = Arrays.asList(restTemplate.getForObject(builder.toUriString(), String.class).split("\\r?\\n"));

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

    private HighscoreStat translate(int position, List<String> strings) {
        return new HighscoreStat(Integer.parseInt(strings.get(1)), Long.parseLong(strings.get(2)),
                Skill.getSkill(position), Long.parseLong(strings.get(0)));
    }
}
