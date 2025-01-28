package org.example;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    /**
     * Метод проверяет, что имя содержит от 3 вкл. до 19 вкл символов
     * И также имя не должно содержать пробел в начале или в конце строки
     * И имя должно содержать только один пробел
     */
    public boolean checkNameToEmboss() {
        if (name.length() >= 3 && name.length() <= 19) {
            char[] charArray = name.toCharArray();
            if (Character.toString(charArray[0]).equals(" ") || Character.toString(charArray[charArray.length - 1]).equals(" ")) {
                return false;
            } else {
                int countOfSpace = 0;
                for (char c : charArray) {
                    if (Character.toString(c).equals(" ")) {
                        countOfSpace++;
                    }
                }
                return countOfSpace == 1;
            }
        }
        return false;
    }
}
