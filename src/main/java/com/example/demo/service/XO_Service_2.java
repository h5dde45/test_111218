package com.example.demo.service;

import com.example.demo.domain.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class XO_Service_2 {
    private List<Integer> player = new ArrayList<>();
    private List<Integer> computer = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    private List<Integer> template = new ArrayList<>();

    public XO_Service_2() {
        for (int i = 0; i < 9; i++) {
            cards.add(new Card(i, "btn-info", "", ""));
            template.add(i);
        }
    }

    public void addPlayer(Integer id) {
        player.add(id);
        if (player.size() >= 5) {
            player.clear();
            computer.clear();
            for (int i = 0; i < 9; i++) {
                cards.get(i).setColorInfo("btn-info");
                cards.get(i).setBadge("");
                cards.get(i).setDisable("");
            }
            return;
        }
        cards.get(id).setColorInfo("btn-light");
        cards.get(id).setBadge("X");
        cards.get(id).setDisable("disabled");
        if (checkPlayer()) {
            for (Integer i:player){
                cards.get(i).setColorInfo("btn-success");
            }
            for (Integer i:computer){
                cards.get(i).setColorInfo("btn-danger");
            }
            for (Integer i:template){
                cards.get(i).setDisable("disabled");
            }
            return;
        }
        addComputer();
    }

    private boolean checkPlayer() {
        return (player.contains(0) && player.contains(1) && player.contains(2) ||
                player.contains(3) && player.contains(4) && player.contains(5) ||
                player.contains(6) && player.contains(7) && player.contains(8) ||
                player.contains(0) && player.contains(3) && player.contains(6) ||
                player.contains(1) && player.contains(4) && player.contains(7) ||
                player.contains(2) && player.contains(5) && player.contains(8));
    }

    private boolean checkComputer() {
        return (computer.contains(0) && computer.contains(1) && computer.contains(2) ||
                computer.contains(3) && computer.contains(4) && computer.contains(5) ||
                computer.contains(6) && computer.contains(7) && computer.contains(8) ||
                computer.contains(0) && computer.contains(3) && computer.contains(6) ||
                computer.contains(1) && computer.contains(4) && computer.contains(7) ||
                computer.contains(2) && computer.contains(5) && computer.contains(8));
    }

    private void addComputer() {
        List<Integer> collect = template.stream()
                .filter(integer -> !player.contains(integer))
                .filter(integer -> !computer.contains(integer))
                .collect(Collectors.toList());

        Integer id = collect.get(new Random().nextInt(collect.size()));
        computer.add(id);

        cards.get(id).setColorInfo("btn-light");
        cards.get(id).setBadge("O");
        cards.get(id).setDisable("disabled");

        if (checkComputer()) {
            for (Integer i:computer){
                cards.get(i).setColorInfo("btn-success");
            }
            for (Integer i: player){
                cards.get(i).setColorInfo("btn-danger");
            }
            for (Integer i:template){
                cards.get(i).setDisable("disabled");
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void update() {
        for (int i = 0; i < 9; i++) {
            player.clear();
            computer.clear();
            cards.get(i).setColorInfo("btn-info");
            cards.get(i).setBadge("");
            cards.get(i).setDisable("");
        }
    }
}
