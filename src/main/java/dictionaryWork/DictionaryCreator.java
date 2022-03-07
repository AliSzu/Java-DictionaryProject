package dictionaryWork;

import com.fasterxml.jackson.databind.*;
import fileWork.PDFDocument;
import mainObject.Dictionary;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DictionaryCreator {
    static List<String> creatorLog = new ArrayList<>();

    public static void Create() {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Dictionary> dictionaryMap = new HashMap<>();
        String dictionaryName, word;
        List<String> wordsList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        String creatorInfo;

        System.out.println("Proszę o podanie nazwy języka w jakim ma zostać utworzony słownik: ");
        dictionaryName = scan.nextLine();

        System.out.println("Proszę o podanie słów do nowo utworzonego słownika. !!Uwaga Aby zakończyć wpisywanie wyrazów należy nacisnąć dwa razy enter!!");
        while (true) {
            word = scan.nextLine();
            if (word.isEmpty()) break;
            wordsList.add(word);
        }
        String wordsString = String.join(",", wordsList);


        Dictionary dictionary = new Dictionary(dictionaryName, wordsList);
        dictionaryMap.put(dictionaryName, dictionary);
        try {
            mapper.writeValue(new File("Languages/" + dictionaryName + ".json"), dictionaryMap.get(dictionaryName));
            creatorInfo = "Słownik o nazwie " + dictionaryName + " oraz słowach " + wordsString + " został utworzony";
            System.out.println(creatorInfo);

            PDFDocument.addLogToList(creatorInfo);
            PDFDocument.addLogToList(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


