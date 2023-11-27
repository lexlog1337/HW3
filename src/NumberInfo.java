import java.util.Scanner;


public class NumberInfo {
    Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    private String answer;
    private String number;
    private String digits;
    private String codeGBDD;
    private String letters;

    //Далее через гетеры и циклы пользователь проходя шаги, которые я ему подготовил приходит  к ответу. Можно было сделать через хеш таблицу, но т.к я в Java совсем зеленый, я не смог это понять и реализовать
    public void getNumberInfo() {
        System.out.println("Дратути");

        while (!exit) {
            System.out.println("Что бы вы хотели сделать?\n(Введите номер ответа)\n\n1. Получить информацию по номеру.\n2. Выйти из программы.");
            answer = scanner.nextLine();

            if (answer.equals("1")) {
                System.out.println("\nА сейчас вам нужно будет ввести номер машины.\nБуквы можно вводить как заглавные, так и строчные, но только одновременно\nприсутствующие в кириллице и в латинице (АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx)\nи отдельно латинские буквы (Dd).\n\nВ качестве образца ввода выберите один из следующих вариантов, только без скобок:\n\n(Y000YY77) (y000yy77) (y 000yy77) (Y 000 YY 77) (y 000 yy RUS 77) (y 000 yy rus 77)\n(yy 000 RUS 777) (YY0000 RUS 77) (000 CD 0 rus 77) (000 d 000rus77) (000T00077) (YY655Y 78)\n\nПожалуйста введите номер машины:");
                number = scanner.nextLine();
                // муторные регулрки для проверки номеров
                if (number.matches("[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s?\\d{3}\\s?[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]{2}(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3}")) {
                    System.out.println("\nНомер: " + number + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nЭто регистрационный знак дорожного транспортного средства,\n относящийся к категориям: легковых, грузовых автомобилей и автобусов\n (кроме отнесённых к типу 1Б).");
                    getCodeGBDDFromNumber(number);
                }


                else if (number.matches("[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]{2}\\s?\\d{3}(\\s|(\\s?([Rr][Uu][Ss])\\s?))\\d{2,3}")) {
                    System.out.println("\nНомер: " + number + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nЭто регистрационный знак дорожного транспортного средства,\n относящийся к категории: легковых такси, транспортных средств,\n оборудованных для перевозок более восьми человек, осуществляющих перевозку\n на основании лицензии.");
                    getCodeGBDDFromNumber(number);
                }

                else if (number.matches("[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]{2}\\s?\\d{4}(\\s|(\\s?([Rr][Uu][Ss])\\s?))\\d{2,3}")) {
                    System.out.println("\nНомер: " + number + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nЭто регистрационный знак дорожного транспортного средства,\n относящийся к категории: автомобильных прицепов и полуприцепов.\n");
                    getCodeGBDDFromNumber(number);
                }

                else if (number.matches("[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]{2}\\s?\\d{6}")) {
                    System.out.println("\nПожалуйста, введите только код ГБДД от данного номера (без пробелов и других знаков разделения).");
                    codeGBDD = scanner.nextLine();

                    if (codeGBDD.length() == 3) {
                        System.out.println("\nНомер: " + number + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nЭто регистрационный знак дорожного транспортного средства,\n относящийся к категории: легковых такси, транспортных средств,\n оборудованных для перевозок более восьми человек, осуществляющих перевозку\n на основании лицензии.");
                        getSubjectOfTheRF(codeGBDD);
                    }

                    else if (codeGBDD.length() == 2) {
                        System.out.println("\nНомер: " + number + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nЭто регистрационный знак дорожного транспортного средства,\n относящийся к категории: автомобильных прицепов и полуприцепов.\n");
                        getSubjectOfTheRF(codeGBDD);
                    }

                    else {
                        System.out.println("\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nТакого кода ГБДД не существует. Пожалуйста уточните правильность номера и введите его заново.\n");
                    }
                }

                else if (number.matches("\\d{3}\\s?([DTdt]|[Cc][Dd])\\s?\\d{1,3}(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3}")) {
                    System.out.println("\nНомер: " + number + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nЭто регистрационный знак дорожного транспортного средства,\n относящийся к категории: транспортные средства, принадлежащие\n дипломатическим представительствам, консульским учреждениям,\n в том числе возглавляемым почётными консульскими должностными лицами,\n международным (межгосударственным) организациям и их сотрудникам,\n аккредитованным при Министерстве иностранных дел Российской Федерации.");
                    letters = "";

                    for (int i = 0; i < 6; i++ ) {
                        letters += number.charAt(i);
                    }

                    if (letters.matches("\\d{3}\\s?[Cc][Dd]\\s?\\d{0,3}")) {
                        System.out.println("\nCD — автомобиль с данным регистрационным знаком зарегистрирован на\n посла или иное лицо в ранге главы дипломатического представительства.");
                    }

                    else if (letters.matches("\\d{3}\\s?[Dd]\\s?\\d{0,3}")) {
                        System.out.println("\nD — регистрационный знак выдан на автомобиль (мотоцикл), принадлежащий\n дипломатическому представительству, консульскому учреждению,\n международной организации или сотруднику такого представительства\n (учреждения, организации), обладающего дипломатическим статусом.");
                    }

                    else if (letters.matches("\\d{3}\\s?[Tt]\\s?\\d{0,3}")) {
                        System.out.println("\nT — регистрационный знак выдан на автомобиль (мотоцикл) сотрудника\n дипломатического представительства, консульского учреждения,\n международной организации, не обладающего дипломатическим статусом\n (административно-технический персонал).");
                    }

                    if (number.matches("\\d{3}\\s?([DTdt]|[Cc][Dd])\\s?\\d{1,3}\\d{2,3}")) {
                        System.out.println("\nПожалуйста, введите только код ГБДД от данного номера (без пробелов и других знаков разделения).");
                        codeGBDD = scanner.nextLine();
                        getSubjectOfTheRF(codeGBDD);
                    }

                    else {
                        getCodeGBDDFromNumber(number);
                    }
                }

                else if (number.matches("[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]{2}\\s?\\d{3}\\s?[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx](\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3}")) {
                    System.out.println("\nНомер: " + number + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nЭто регистрационный знак дорожного транспортного средства,\n относящийся к категории: легковых, грузовых, грузопассажирских\n автомобилей, автобусов, автомобильных прицепов и полуприцепов.");
                    getCodeGBDDFromNumber(number);
                }

                else if (number.matches("(([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]|[АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx])\\s?[0-9]{3}\\s?(([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]\\s?[АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx])|([АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx]\\s?[А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]])|([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]\\s?[А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]))(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})|([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]\\s?[0-9]{3}\\s?[АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx]\\s?[АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx](\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})|(([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]\\s?[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx])|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s?[А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]])|([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]\\s?[А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]])\\s?[0-9]{3,4}(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})|((([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]\\s?[АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx])|([АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx]\\s?[А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]])|([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]\\s?[А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]))\\s?[0-9]{3}\\s?([А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]]|[АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx])(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})|([АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx]\\s?[АВЕКМНОРСТУХавекмнорстухABCEKMHOPYXabcekmhopyx]\\s?[0-9]{3}\\s?[А-Яа-яA-Za-z&&[^АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]](\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})")) {
                    System.out.println("\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nВведённый номер: " + number + " - некорректный! Введены недопустимые буквы");
                }

                else if (number.matches("([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s{2,}[0-9]\\s*[0-9]\\s*[0-9]\\s*([0-9]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s{2,}([0-9]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s{2,}([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*[АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s{2,}([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s{2,}[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]\\s{2,}[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]\\s{2,}[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]\\s{2,}(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?(\\s{2,}|\\s{2,}([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])?\\s{2,}|\\s{2,}([Rr][Uu][Ss])\\s{2,})[0-9]\\s*[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s{2,}[0-9]\\s*[0-9]?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s{2,}[0-9]?)|(\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?\\s+)|(\\s+[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?\\s*)|(\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s*[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]?\\s*[0-9]\\s+[0-9]\\s*[0-9]\\s*[0-9]?\\s*([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?([АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s*)?[0-9]?\\s*[0-9]?\\s*[0-9]?\\s*(\\s*|\\s*([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s*|\\s*([Rr][Uu][Ss])\\s*)[0-9]\\s*[0-9]\\s*[0-9]?\\s*)")) {
                    System.out.println("\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nУ данного номера: \"" + number + "\" - оооооочень много \"п ро б   е л  ов\". Это TOO MUCH!\nЗапишите пожалуйста как в одном из приведённых примеров.\nПробелы используются только для отделения чисел от букв и наоборот,\nи только не более одного пробела на одно разделение.\nМожно пробелы вообще не использовать, если вам так будет удобнее ;)");
                }

                else if (number.matches("([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s?\\d{0,2}\\s?[АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx][АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s?(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx][АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s?\\d{0,2}\\s?[АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]?\\s?(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})|(\\d{0,2}\\s?(([Cc][Dd])|[Tt]|[Dd])\\d{1,3}\\s?(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d{2,3})")) {
                    System.out.println("\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nВведённый номер: " + number + " - некорректный!\nНе хватает цифр в регистрационном номере, здесь должно быть не менее\n3 цифр.");
                }

                else if (number.matches("([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s?\\d{3}\\s?[АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx][АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]\\s?(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d?)|([АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx][АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]\\s?\\d{3,4}\\s?[АВЕКМНОРСТУХавекмнорстухABDEKMHOPCTYXabdekmhopctyx]?\\s?(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d?)|(\\d{3}\\s?(([Cc][Dd])|[Tt]|[Dd])\\s?(\\s?|\\s?([Rr][Uu][Ss])?|([Rr][Uu][Ss])?\\s?|\\s([Rr][Uu][Ss])\\s)\\d?)")) {
                    System.out.println("\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nВведённый номер: " + number + " - некорректный!\nНе хватает цифр в коде региона регистрации, здесь должно быть не менее\n2 цифр.");
                }

                else {
                    System.out.println("\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nВведённый номер: " + number + " - некорректный! Запишите заново.");
                }
                System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\n");
            }

            else if (answer.equals("2")) {
                System.out.println("*Вы вышли из программы*");
                exit = true;
            }

            else {
                System.out.println("\nТакого варианта ответа нет.\n");
            }
        }
    }

    // тут номер принимается в геттер в getCodeGBDDFromNumber, где выделяется код ГИБДД
    private void getCodeGBDDFromNumber(String number) {
        digits = "";
        int i = number.length()-1;
        while (Character.isDigit(number.charAt(i))){
            digits = number.charAt(i) + digits;
            i--;
        }
        codeGBDD = "";
        // Тут происходит то, что нужно было в дз, т.е. код номера 'Важно показать сам принцип. Обязательно надо взять регион у которого несколько разных типов региональных значений, и несколько дополнительных регионов.'
        switch (digits.length()) {

            case 2:
            case 3:
                codeGBDD = digits;
                break;

            case 5:
                for (i = 4; i > 2; i--) {
                    codeGBDD = digits.charAt(i) + codeGBDD;
                }
                break;

            case 7:
                for (i = 6; i > 3; i--) {
                    codeGBDD = digits.charAt(i) + codeGBDD;
                }
                break;
        }

        getSubjectOfTheRF(codeGBDD);
    }

// проверка с значеними в 'Switch {case:}' и вывод информации
    private void getSubjectOfTheRF(String codeGBDD) {
        System.out.println();
        System.out.print(codeGBDD + " - ");
        switch (codeGBDD) {
            case "77":
            case "97":
            case "99":
            case "177":
            case "199":
            case "197":
            case "777":
            case "797":
            case "799":
                System.out.println("код ГИБДД соответствует субъекту город Москва");
                break;
            case "02":
            case "102":
            case "702":
                System.out.println("код ГИБДД соответствует субъекту республика Башкортостан");
                break;
            case "23":
            case "93":
            case "123":
            case "193":
                System.out.println("код ГИБДД соответствует субъекту Краснодарский край");
                break;
            case "30":
                System.out.println("код ГИБДД соответствует субъекту Астраханская область");
                break;
            case "50":
            case "90":
            case "150":
            case "190":
            case "750":
            case "790":
                System.out.println("код ГИБДД соответствует субъекту Московская область");
                break;
            case "61":
            case "161":
            case "761":
                System.out.println("код ГИБДД соответствует субъекту Ростовская область");
                break;
            case "63":
            case "163":
            case "763":
                System.out.println("код ГИБДД соответствует субъекту Самарская область");
                break;
            case "66":
            case "96":
            case "196":
                System.out.println("код ГИБДД соответствует субъекту Свердловская область");
                break;
            case "78":
            case "98":
            case "178":
            case "198":
                System.out.println("код ГИБДД соответствует субъекту г. Санкт-Петербург");
                break;
            case "82":
                System.out.println("код ГИБДД соответствует субъекту Республика Крым");
                break;
            case "24":
            case "84":
            case "88":
            case "124":
                System.out.println("код ГИБДД соответствует субъекту Красноярский край\n (включая индексы бывших Таймырского и Эвенкийского автономных округов)");
                break;
            case "26":
            case "126":
                System.out.println("код ГИБДД соответствует субъекту Ставропольский край");
                break;
            default:
                System.out.println("для данного кода обозначения нет, либо он ещё не занесён в реестр.");
                break;
        }
    }
}