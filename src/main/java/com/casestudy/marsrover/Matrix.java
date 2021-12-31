package com.casestudy.marsrover;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matrix {

    private int x;
    private int y;

    static Matrix parseMatrix(String matrixArea) {
        matrixArea = matrixArea.replaceAll("\\s", "");
        char[] coordinates = matrixArea.toCharArray();
        int x = Integer.parseInt(String.valueOf(coordinates[0]));
        int y = Integer.parseInt(String.valueOf(coordinates[1]));
        return new Matrix(x, y);
    }

    @Override
    public String toString() {
        return "x : " + x + ", y : " + y;
    }
}
