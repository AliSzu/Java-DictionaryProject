package dictionaryWork;

import fileWork.PDFDocument;
import fileWork.ReadFile;
import mainObject.Dictionary;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class DictionarySearcher {
    static List<String> filesList = new ArrayList<>();
    static HashMap<String, Dictionary> dictionaryMap = new HashMap<>();

    public static void SearcherMain()
    {
        Scanner scan = new Scanner(System.in);
        String text;
        System.out.println("Proszę o podanie szukanego słowa: ");
        String word = scan.nextLine();
        DirectorySearch();
        for (String fileName : filesList) {
            Dictionary dictionary = ReadFile.ReadAndMapJson(fileName);
            dictionaryMap.put(dictionary.getLanguage(), dictionary);
            }
        List<String> languageList = SearchForWord(word, dictionaryMap);
        if(languageList.isEmpty())
        {
            text = "Słowo " + word + " nie zostało znalezione w żadnym słowniku.";
            System.out.println(text);
            PDFDocument.addLogToList(text);
        }
        else {
            text = "Słowo " + word + " znajduje sie w natępujących słownikach: ";
            System.out.println(text);
            System.out.println(languageList);
            PDFDocument.addLogToList(text);
            PDFDocument.addLogToList(String.join(",", languageList));
        }

        PDFDocument.addLogToList(" ");

    }

    public static List<String> SearchForWord(String word, HashMap<String, Dictionary> dictionaryMap) {
        List<String> languageList = dictionaryMap.entrySet()
                    .stream()
                    .filter(x -> x.getValue().getWords().contains(word))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        return languageList;
    }

    private static void DirectorySearch() {
        File directoryPathTMP = new File("Languages");
        String directoryList[] = directoryPathTMP.list();
        for (int i = 0; i < directoryList.length; i++) {
            filesList.add((directoryList[i]));
        }
    }

}


