package j120;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fuzzb
 */
class StringArrayException extends Exception {

    private static final String DEFAUTL_DESCRIPTION
            = "Common error";

    /**
     * Конструктор по умолчанию.
     */
    public StringArrayException() {
        super(DEFAUTL_DESCRIPTION);
    }

    /**
     * Конструктор с описание причины возникновения исключения.
     *
     * @param string описание причины возникновения исключения.
     */
    public StringArrayException(String string) {
        super(string);
    }
}
