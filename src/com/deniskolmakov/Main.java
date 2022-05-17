package com.deniskolmakov;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        int a;
        int b;
        int e;
        String[] digit;
        String inExpress;
        String [] operator = {"+", "-", "/", "*"};
        int opIndex = 0;
        Scanner in = new Scanner(System.in);
        int opCount = 0;
        String romeAnswer;

        //Запрашиваем математическое выражение
        System.out.println("Пожалуйста введите математическое выраение с двумя операндами от 1 до 10 включительно и одним оператором:");
        inExpress = in.next();
        //Находим и считаем операторы
        for (String x : operator) {
            for (char c : inExpress.toCharArray()){
                if (String.valueOf(c).hashCode() == x.hashCode()){
                    opCount++;
               }
            }
        }
        //Убеждаемся что оператор только один
        if (opCount > 1){
            try {
                throw new IOException();
            } catch (IOException y) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(1);
            }
        }
        //Проверяем есть ли одобренный оператор
        if (opCount < 1){
            try {
                throw new IOException();
            } catch (IOException y) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(1);
            }

        }
        for (String x : operator){
            opIndex = inExpress.indexOf(x);
            if (opIndex != -1){
                break;
            }
        }

        //Сложение
        if (inExpress.charAt(opIndex) == '+') {
            digit = inExpress.split("\\+");

            if (containsRome(digit[0], digit[1])) {
                Digit romeDigit1 = Digit.valueOf(digit[0]);
                Digit romeDigit2 = Digit.valueOf(digit[1]);
                a = romeDigit1.getDigit();
                b = romeDigit2.getDigit();
                inLimiter(a, b);
                e = a + b;
                for (Digit r : Digit.values()){
                    int v = r.getDigit();
                    if (v == e){
                        romeAnswer = String.valueOf(r);
                        System.out.println(inExpress + '=' + romeAnswer);
                        break;
                    }
                }

            }
            else if (!(containsRome(digit[0], digit[1]))) {
                try {
                    a = Integer.parseInt(digit[0]);
                    b = Integer.parseInt(digit[1]);
                    inLimiter(a, b);
                    e = a + b;
                    System.out.println(inExpress + '=' + e);
                } catch (IllegalArgumentException y){
                    try {
                        throw new IOException();
                    } catch (IOException p) {
                        System.out.println("throws Exception //Введены не подходящие числа, или не числа");
                        System.exit(1);
                    }

                }

            }
        }

        //Вычитание
        if (inExpress.charAt(opIndex) == '-') {
            digit = inExpress.split("-");

            if (containsRome(digit[0], digit[1])) {
                Digit romeDigit1 = Digit.valueOf(digit[0]);
                Digit romeDigit2 = Digit.valueOf(digit[1]);
                a = romeDigit1.getDigit();
                b = romeDigit2.getDigit();
                inLimiter(a, b);
                e = a - b;
                if (e < 0){
                    try {
                        throw new IOException();
                    } catch (IOException p) {
                        System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                        System.exit(1);
                    }

                }
                if (e < 1){
                    try {
                        throw new IOException();
                    } catch (IOException p) {
                        System.out.println("throws Exception //В системе римских цифр отсутствует ноль, но ранее использовалось обозначение нуля как nulla (нет), nihil (ничто) и N (первая буква этих слов).");
                        System.exit(1);
                    }

                }
                for (Digit r : Digit.values()){
                    int v = r.getDigit();
                    if (v == e){
                        romeAnswer = String.valueOf(r);
                        System.out.println(inExpress + '=' + romeAnswer);
                        break;
                    }
                }

            }
            else if (!(containsRome(digit[0], digit[1]))) {
                try {
                    a = Integer.parseInt(digit[0]);
                    b = Integer.parseInt(digit[1]);
                    inLimiter(a, b);
                    e = a - b;
                    System.out.println(inExpress + '=' + e);
                } catch (IllegalArgumentException y){
                    try {
                        throw new IOException();
                    } catch (IOException p) {
                        System.out.println("throws Exception //Введены не подходящие числа, или не числа");
                        System.exit(1);
                    }

                }

            }
        }

        // Умножение
        if (inExpress.charAt(opIndex) == '*') {
            digit = inExpress.split("\\*");

            if (containsRome(digit[0], digit[1])) {
                Digit romeDigit1 = Digit.valueOf(digit[0]);
                Digit romeDigit2 = Digit.valueOf(digit[1]);
                a = romeDigit1.getDigit();
                b = romeDigit2.getDigit();
                inLimiter(a, b);
                e = a * b;

                for (Digit r : Digit.values()){
                    int v = r.getDigit();
                    if (v == e){
                        romeAnswer = String.valueOf(r);
                        System.out.println(inExpress + '=' + romeAnswer);
                        break;
                    }
                }

            }
            else if (!(containsRome(digit[0], digit[1]))) {
                try {
                    a = Integer.parseInt(digit[0]);
                    b = Integer.parseInt(digit[1]);
                    inLimiter(a, b);
                    e = a * b;
                    System.out.println(inExpress + '=' + e);
                } catch (IllegalArgumentException y){
                    try {
                        throw new IOException();
                    } catch (IOException p) {
                        System.out.println("throws Exception //Введены не подходящие числа, или не числа");
                        System.exit(1);
                    }
                }

            }
        }


        // Деление
        if (inExpress.charAt(opIndex) == '/') {
            digit = inExpress.split("/");

            if (containsRome(digit[0], digit[1])) {
                Digit romeDigit1 = Digit.valueOf(digit[0]);
                Digit romeDigit2 = Digit.valueOf(digit[1]);
                a = romeDigit1.getDigit();
                b = romeDigit2.getDigit();
                inLimiter(a, b);
                e = a / b;

                for (Digit r : Digit.values()){
                    int v = r.getDigit();
                    if (v == e){
                        romeAnswer = String.valueOf(r);
                        System.out.println(inExpress + '=' + romeAnswer);
                        break;
                    }
                }

            }
            else if (!(containsRome(digit[0], digit[1]))) {
                try {
                    a = Integer.parseInt(digit[0]);
                    b = Integer.parseInt(digit[1]);
                    inLimiter(a, b);
                    e = a / b;
                    System.out.println(inExpress + '=' + e);
                } catch (IllegalArgumentException y){
                    try {
                        throw new IOException();
                    } catch (IOException p) {
                        System.out.println("throws Exception //Введены не подходящие числа, или не числа");
                        System.exit(1);
                    }
                }

            }
        }

    }
    //Находим римские цифры, отсекаем использование разных систем счисления
    public static boolean containsRome (String d1, String d2) {
        boolean rome0 = true;
        boolean rome1 = true;
        boolean ret;
        try {
            Digit.valueOf(d1);
        } catch (IllegalArgumentException y){
            rome0=false;
        }
        try {
            Digit.valueOf(d2);
        } catch (IllegalArgumentException y){
            rome1=false;
        }
        if (rome0 != rome1) {
            try {
                throw new IOException();
            } catch (IOException p) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                System.exit(1);
            }

            }

        ret = rome0 & rome1;
        return ret;
}
    //Ограничитель входных операндов
public static void inLimiter(int s, int n) throws IOException {

   if (s < 1 | s > 10 | n < 1 | n > 10){
       try {
           throw new IOException();
       } catch (IOException p) {
           System.out.println("throws Exception //На вход принимаются лишь числа от 1 до 10");
           System.exit(1);
       }

   }
}
}

