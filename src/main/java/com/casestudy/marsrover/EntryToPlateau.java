package com.casestudy.marsrover;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryToPlateau {

    private Scanner scanner;
    private int roverSize = 0;

    public EntryToPlateau() {
        scanner = new Scanner(System.in);
    }

    public void begin() {
        List<Rover> rovers = new ArrayList<>();
        Matrix matrix = enterMatrix();
        System.out.println("Her bir Rover icin Konumu ve Komutlari ayri satirlarda giriniz");
        while (scanner.hasNext()) {
            roverSize++;
            Position position = enterLocation();
            Instruction instruction = enterInstruction();
            Rover rover = new Rover(matrix, position, instruction);
            rover.action();
            rovers.add(rover);
        }
        scanner.close();
        System.out.println("Roverlarin Yeni Konumlari");
        rovers.stream().map(Rover::getPosition).map(Position::toString).forEach(System.out::println);
    }

    private Instruction enterInstruction() {
        String instructionsAsString = scanner.nextLine();
        Instruction instruction = Instruction.parseCommands(instructionsAsString);
        System.out.println(roverSize + ". Rover icin Komutlar olusturuldu.. " + instruction.toString());
        return instruction;
    }

    private Position enterLocation() {
        String locationAsString = scanner.nextLine();
        Position position = Position.parsePosition(locationAsString);
        System.out.println(roverSize + ". Rover icin Konum olusturuldu.. " + position.toString());
        return position;
    }

    private Matrix enterMatrix() {
        System.out.println("Matrix alanini giriniz : ");
        String matrixAsString = scanner.nextLine();
        Matrix matrix = Matrix.parseMatrix(matrixAsString);
        System.out.println("Matrix olusturuldu.. " + matrix.toString());
        return matrix;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
