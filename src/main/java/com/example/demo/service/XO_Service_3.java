package com.example.demo.service;

import com.example.demo.domain.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class XO_Service_3 {
    private List<Integer> player = new ArrayList<>();
    private List<Integer> computer = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    private List<Integer> template = new ArrayList<>();

    public XO_Service_3() {
        for (int i = 0; i < 9; i++) {
            cards.add(new Card(i, "btn-info", "", ""));
            template.add(i);
        }
    }

    public void addPlayer(Integer id) {
        player.add(id);
        cards.get(id).setColorInfo("btn-light");
        cards.get(id).setBadge("X");
        cards.get(id).setDisable("disabled");
        if (checkPlayer()) {
            for (Integer i : player) {
                cards.get(i).setColorInfo("btn-success");
            }
            for (Integer i : computer) {
                cards.get(i).setColorInfo("btn-danger");
            }
            for (Integer i : template) {
                cards.get(i).setDisable("disabled");
            }
            return;
        }
        if (player.size() == 5) {
            player.clear();
            computer.clear();
            for (int i = 0; i < 9; i++) {
                cards.get(i).setColorInfo("btn-info");
                cards.get(i).setBadge("");
                cards.get(i).setDisable("");
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
                player.contains(2) && player.contains(5) && player.contains(8)) ||
                player.contains(0) && player.contains(4) && player.contains(8) ||
                player.contains(2) && player.contains(4) && player.contains(6);
    }

    private boolean checkComputer() {
        return (computer.contains(0) && computer.contains(1) && computer.contains(2) ||
                computer.contains(3) && computer.contains(4) && computer.contains(5) ||
                computer.contains(6) && computer.contains(7) && computer.contains(8) ||
                computer.contains(0) && computer.contains(3) && computer.contains(6) ||
                computer.contains(1) && computer.contains(4) && computer.contains(7) ||
                computer.contains(2) && computer.contains(5) && computer.contains(8)) ||
                computer.contains(0) && computer.contains(4) && computer.contains(8) ||
                computer.contains(2) && computer.contains(4) && computer.contains(6);
    }

    private void addComputer() {
        int id = 0;
        boolean playerFlag = true;
        if (player.size() == 1) {
            if (player.contains(4)) {
                int[] ints = {0, 2, 6, 8};
                int i = new Random().nextInt(ints.length);
                id = ints[i];
                computer.add(id);
            } else {
                id = 4;
                computer.add(id);
            }
        }
//        if (player.size() == 2) {
//            if (player.contains(4)) {
//                //============
//                if (computer.contains(0) && player.contains(2)) {
//                    id = 3;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(0) && player.contains(8)  && playerFlag) {
//                    id = 3;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(0) && player.contains(6)  && playerFlag) {
//                    id = 1;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(2) && player.contains(8)  && playerFlag) {
//                    id = 1;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(2) && player.contains(6)  && playerFlag) {
//                    id = 1;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(2) && player.contains(0)  && playerFlag) {
//                    id = 5;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(8) && player.contains(6)  && playerFlag) {
//                    id = 5;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(8) && player.contains(0)  && playerFlag) {
//                    id = 5;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(8) && player.contains(2)  && playerFlag) {
//                    id = 7;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(6) && player.contains(0)  && playerFlag) {
//                    id = 7;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(6) && player.contains(2)  && playerFlag) {
//                    id = 7;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//                if (computer.contains(6) && player.contains(8)  && playerFlag) {
//                    id = 3;
//                    computer.add(id);
//                    playerFlag = false;
//                }
//            }
//        }
        if (player.size() >= 2) {

//            =======================
            if (computer.contains(0) && computer.contains(4) && !player.contains(8) ) {
                id = 8;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(0) && computer.contains(8) && !player.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(4) && computer.contains(8) && !player.contains(0) && playerFlag) {
                id = 0;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(2) && computer.contains(4) && !player.contains(6) && playerFlag) {
                id = 6;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(2) && computer.contains(6) && !player.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(4) && computer.contains(6) && !player.contains(2) && playerFlag) {
                id = 2;
                computer.add(id);
                playerFlag = false;
            }

//            ===============================
            if (computer.contains(0) && computer.contains(1) && !player.contains(2) && playerFlag) {
                id = 2;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(0) && computer.contains(2) && !player.contains(1) && playerFlag) {
                id = 1;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(1) && computer.contains(2) && !player.contains(0) && playerFlag) {
                id = 0;
                computer.add(id);
                playerFlag = false;
            }

            if (computer.contains(3) && computer.contains(4) && !player.contains(5) && playerFlag) {
                id = 5;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(3) && computer.contains(5) && !player.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(4) && computer.contains(5) && !player.contains(3) && playerFlag) {
                id = 3;
                computer.add(id);
                playerFlag = false;
            }

            if (computer.contains(6) && computer.contains(7) && !player.contains(8) && playerFlag) {
                id = 8;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(6) && computer.contains(8) && !player.contains(7) && playerFlag) {
                id = 7;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(7) && computer.contains(8) && !player.contains(6) && playerFlag) {
                id = 6;
                computer.add(id);
                playerFlag = false;
            }

            if (computer.contains(0) && computer.contains(3) && !player.contains(6) && playerFlag) {
                id = 6;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(0) && computer.contains(6) && !player.contains(3) && playerFlag) {
                id = 3;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(3) && computer.contains(6) && !player.contains(0) && playerFlag) {
                id = 0;
                computer.add(id);
                playerFlag = false;
            }

            if (computer.contains(1) && computer.contains(4) && !player.contains(7) && playerFlag) {
                id = 7;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(1) && computer.contains(7) && !player.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(4) && computer.contains(7) && !player.contains(1) && playerFlag) {
                id = 1;
                computer.add(id);
                playerFlag = false;
            }

            if (computer.contains(2) && computer.contains(5) && !player.contains(8) && playerFlag) {
                id = 8;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(2) && computer.contains(8) && !player.contains(5) && playerFlag) {
                id = 5;
                computer.add(id);
                playerFlag = false;
            }
            if (computer.contains(5) && computer.contains(8) && !player.contains(2) && playerFlag) {
                id = 2;
                computer.add(id);
                playerFlag = false;
            }

//            ============================================================
            if (player.contains(0) && player.contains(4) && !computer.contains(8) && playerFlag) {
                id = 8;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(0) && player.contains(8) && !computer.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(4) && player.contains(8) && !computer.contains(0) && playerFlag) {
                id = 0;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(2) && player.contains(4) && !computer.contains(6) && playerFlag) {
                id = 6;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(2) && player.contains(6) && !computer.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(4) && player.contains(6) && !computer.contains(2) && playerFlag) {
                id = 2;
                computer.add(id);
                playerFlag = false;
            }


            if (player.contains(0) && player.contains(1) && !computer.contains(2) && playerFlag) {
                id = 2;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(0) && player.contains(2) && !computer.contains(1) && playerFlag) {
                id = 1;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(1) && player.contains(2) && !computer.contains(0) && playerFlag) {
                id = 0;
                computer.add(id);
                playerFlag = false;
            }

            if (player.contains(3) && player.contains(4) && !computer.contains(5) && playerFlag) {
                id = 5;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(3) && player.contains(5) && !computer.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(4) && player.contains(5) && !computer.contains(3) && playerFlag) {
                id = 3;
                computer.add(id);
                playerFlag = false;
            }

            if (player.contains(6) && player.contains(7) && !computer.contains(8) && playerFlag) {
                id = 8;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(6) && player.contains(8) && !computer.contains(7) && playerFlag) {
                id = 7;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(7) && player.contains(8) && !computer.contains(6) && playerFlag) {
                id = 6;
                computer.add(id);
                playerFlag = false;
            }

            if (player.contains(0) && player.contains(3) && !computer.contains(6) && playerFlag) {
                id = 6;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(0) && player.contains(6) && !computer.contains(3) && playerFlag) {
                id = 3;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(3) && player.contains(6) && !computer.contains(0) && playerFlag) {
                id = 0;
                computer.add(id);
                playerFlag = false;
            }

            if (player.contains(1) && player.contains(4) && !computer.contains(7) && playerFlag) {
                id = 7;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(1) && player.contains(7) && !computer.contains(4) && playerFlag) {
                id = 4;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(4) && player.contains(7) && !computer.contains(1) && playerFlag) {
                id = 1;
                computer.add(id);
                playerFlag = false;
            }

            if (player.contains(2) && player.contains(5) && !computer.contains(8) && playerFlag) {
                id = 8;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(2) && player.contains(8) && !computer.contains(5) && playerFlag) {
                id = 5;
                computer.add(id);
                playerFlag = false;
            }
            if (player.contains(5) && player.contains(8) && !computer.contains(2) && playerFlag) {
                id = 2;
                computer.add(id);
                playerFlag = false;
            }

            Integer playerId = player.get(player.size() - 1);
            List<Integer> uneven = Stream.of(1, 3, 5, 7).collect(Collectors.toList());

            List<Integer> collectUneven = uneven.stream()
                    .filter(integer -> !player.contains(integer))
                    .filter(integer -> !computer.contains(integer))
                    .collect(Collectors.toList());
            if (playerFlag) {
                if ((playerId == 0 || playerId == 2 || playerId == 6 || playerId == 8) &&
                        !collectUneven.isEmpty()) {
                    id = collectUneven.get(new Random().nextInt(collectUneven.size()));
                    computer.add(id);
                } else {
                    List<Integer> even = Stream.of(0, 2, 6, 8).collect(Collectors.toList());
                    List<Integer> collectEven = even.stream()
                            .filter(integer -> !player.contains(integer))
                            .filter(integer -> !computer.contains(integer))
                            .collect(Collectors.toList());
                    if (!collectEven.isEmpty()) {
                        id = collectEven.get(new Random().nextInt(collectEven.size()));
                        computer.add(id);
                    }
                }
            }
        }

        cards.get(id).setColorInfo("btn-light");
        cards.get(id).setBadge("O");
        cards.get(id).setDisable("disabled");

        if (checkComputer()) {
            for (Integer i : computer) {
                cards.get(i).setColorInfo("btn-success");
            }
            for (Integer i : player) {
                cards.get(i).setColorInfo("btn-danger");
            }
            for (Integer i : template) {
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
