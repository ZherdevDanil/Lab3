package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1505%3 = 2 => тип String
 * 1505%17 = 9 => Дія з рядком "Задано текст та масив слів.Підрахувати у скількох реченнях зустрічається кожне слово масиву."
 * */

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        String separationSign = "ФФФ";
        ArrayList<String> wordsFromText = new ArrayList<>();
        System.out.println("Введіть текст \nЯкщо хочете зупинити введення тексту напишіть 'СТОП': ");

        //цикл для вводу тексту, поки не буде введен "СТОП"
        while (true) {
            String sentence = scanner.nextLine();
            if (sentence.equals("СТОП")) {
                break;
            } else {
                //заміняємо знаки кінця речення на знак роздільності
                sentence = sentence.replace(".",separationSign)
                        .replace("?",separationSign)
                        .replace("!",separationSign);
                text = text + sentence;
                text += "\n";
            }

        }
        System.out.println(text);
        String textWithoutPunctuation = text.replaceAll("[^a-zA-Zа-яА-ЯіІїЇ' ']", " ");
        System.out.println("БезПунктуації\n" + textWithoutPunctuation);
        //цикл для введенння шуканих слів
        System.out.println("Введіть деякі слова");
        while (true) {
            String word = scanner.next();
            if (word.equals("СТОП")) {
                break;
            } else {
                wordsFromText.add(word);
            }
        }
        //Перевіряємо, якщо було введено одне слово декілька раз, видаляємо одне з них
        for (int i = 0; i < wordsFromText.size() - 1; i++) {
            for (int j = wordsFromText.size() - 1; j > i; j--) {
                if (wordsFromText.get(j).toUpperCase().equals(wordsFromText.get(i).toUpperCase())) {
                    wordsFromText.remove(j);
                }
            }
        }
        System.out.println("В множині зберігаються такі слова " + wordsFromText);

        //Розділяємо текст на речення за допомогою знаку роздільності
        String[] textSplitBySentences = textWithoutPunctuation.split(separationSign);
        for (int i = 0; i < wordsFromText.size(); i++) {
            int count = 0;
            for (String s : textSplitBySentences) {
                String[] textSplitByWord = s.split(" ");
                for (int j = 0; j < textSplitByWord.length; j++) {
                    if (wordsFromText.get(i).toUpperCase().equals(textSplitByWord[j].toUpperCase())) {
                        count += 1;
                        break;
                    }
                }
            }
            if (count == 0) {
                System.out.println("Слово '" + wordsFromText.get(i) + "' не зустрічається в реченнях");
            } else if (count == 1) {
                System.out.println("Слово '" + wordsFromText.get(i) + "' зустрічається в " + count + " реченні");
            } else {
                System.out.println("Слово '" + wordsFromText.get(i) + "' зустрічається в "
                        + count + " реченнях");
            }
        }
    }
}