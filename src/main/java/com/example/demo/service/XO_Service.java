package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XO_Service {
    private List<Integer> player1 = new ArrayList<>();
    private List<Integer> player2 = new ArrayList<>();

    public boolean checkWinner(int num, int hod) {
        if (hod == 0) {
            player1.clear();
            player2.clear();
        }
        if (hod % 2 == 0) {
            player1.add(num);
        } else {
            player2.add(num);
        }
        if (player1.contains(0) && player1.contains(1) && player1.contains(2) ||
                player1.contains(3) && player1.contains(4) && player1.contains(5) ||
                player1.contains(6) && player1.contains(7) && player1.contains(8) ||
                player1.contains(0) && player1.contains(3) && player1.contains(6) ||
                player1.contains(1) && player1.contains(4) && player1.contains(7) ||
                player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            player1.clear();
            player2.clear();
            return true;
        }
        if (player2.contains(0) && player2.contains(1) && player2.contains(2) ||
                player2.contains(3) && player2.contains(4) && player2.contains(5) ||
                player2.contains(6) && player2.contains(7) && player2.contains(8) ||
                player2.contains(0) && player2.contains(3) && player2.contains(6) ||
                player2.contains(1) && player2.contains(4) && player2.contains(7) ||
                player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            player1.clear();
            player2.clear();
            return true;
        }
        if (
                player1.contains(0) && player1.contains(4) && player1.contains(8) ||
                player1.contains(2) && player1.contains(4) && player1.contains(6)) {
            player1.clear();
            player2.clear();
            return true;
        }
        if (
                player2.contains(0) && player2.contains(4) && player2.contains(8) ||
                player2.contains(2) && player2.contains(4) && player2.contains(6)) {
            player1.clear();
            player2.clear();
            return true;
        }
        if (hod == 8) {
            player1.clear();
            player2.clear();
        }

        return false;
    }

    public String checkHod(int hod, boolean b) {
        if (b) {
            if (hod % 2 == 0) {
                return "Выиграл 1 игрок";
            } else {
                return "Выиграл 2 игрок";
            }
        } else {
            return "";
        }
    }
}
