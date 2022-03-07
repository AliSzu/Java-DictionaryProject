import dictionaryWork.*;
import fileWork.PDFDocument;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while(loop) {

            System.out.println("Witam w małej bazie słowników języków obcych. Proszę o wybranie jednej z dwóch dostępnych opcji: ");
            System.out.println("1. Znalezienie podanego słowa w naszej bazie słowników");
            System.out.println("2. Stworzenie własnego słownika");
            System.out.println("3. Zakonczenie programu");

            int option = scan.nextInt();
            switch (option) {
                case 1: {
                    DictionarySearcher.SearcherMain();
                    break;
                }
                case 2: {
                    DictionaryCreator.Create();
                    break;
                }
                case 3: {
                    System.out.println("Dziękuję za skorzystanie z programu!");
                    try {
                        PDFDocument.CreatePDF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    loop = false;
                }
            }
        }
    }
}

