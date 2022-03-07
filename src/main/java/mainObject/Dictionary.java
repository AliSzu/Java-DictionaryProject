package mainObject;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    List<String> words = new ArrayList<>();
    String language;

    public Dictionary()
    {}

    public Dictionary(String name, List<String> words) {
        this.language = name;
        this.words = words;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String name) {
        this.language = name;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
