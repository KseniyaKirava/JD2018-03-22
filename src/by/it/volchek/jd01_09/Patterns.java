package by.it.volchek.jd01_09;

/**
 * Created by volchek on 10.04.18.
 */

abstract class Patterns {
    static final String OPERATION = "[-+*/]";// // TODO: negative  correction
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{(((-?[0-9]+\\.?[0-9]*),?)+)\\}";
    static final String MATRIX = "\\{((\\{(((-?[0-9]+\\.?[0-9]*),?)+)\\},?)+)\\}";
}
