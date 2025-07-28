package org.example.exeption;

public final class InputException {

    //-------------- CORE-LEVEL PARSERS (только парсинг + исключения) ---------

    /**
     * Пытается распарсить строку как int
     * @throws NumberFormatException если строка нецелочисленная
     */
    public static int parseIntStrict(String line) {
        return Integer.parseInt(line);
    }
}
