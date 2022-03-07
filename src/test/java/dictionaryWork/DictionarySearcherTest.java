package dictionaryWork;

import mainObject.Dictionary;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

class DictionarySearcherTest {

    @Test
    public void TestSearch() {
        List<String> dictionaryWords = new ArrayList<>();
        List<String> testResult = new ArrayList<>();
        HashMap<String, Dictionary> dictionaryMap = new HashMap<>();

        dictionaryWords = List.of("man", "kan", "die", "der", "den", "das");
        Dictionary dic1 = new Dictionary("Niemiecki", dictionaryWords);
        dictionaryMap.put("Niemiecki", dic1);
        dictionaryWords = List.of("man", "can", "die", "string", "pen", "keyboard");
        Dictionary dic2 = new Dictionary("Angielski", dictionaryWords);
        dictionaryMap.put("Angielski", dic2);
        dictionaryWords = List.of("man", "kunna", "din", "leka", "den", "lampa");
        Dictionary dic3 = new Dictionary("Szwedzki", dictionaryWords);
        dictionaryMap.put("Szwedzki", dic3);
        dictionaryWords = List.of("człowiek", "lis", "nic", "lek", "drewno", "lampa");
        Dictionary dic4 = new Dictionary("Polski", dictionaryWords);
        dictionaryMap.put("Polski", dic4);

        //dla słowa man
        testResult = Arrays.asList("Niemiecki", "Angielski", "Szwedzki");

        Assert.assertThat("List equality without order",
                testResult, containsInAnyOrder(DictionarySearcher.SearchForWord("man", dictionaryMap).toArray()));
        //brak słowa a w żadnym słowniku
        Assert.assertTrue(DictionarySearcher.SearchForWord("a", dictionaryMap).isEmpty());



    }
    @Test
    public void TestSearch2()
    {
        List<String> dictionaryWords = new ArrayList<>();
        List<String> testResult = new ArrayList<>();
        HashMap<String, Dictionary> dictionaryMap = new HashMap<>();

        //inne słowniki do testów
        dictionaryWords = List.of("a", "b", "c", "d", "e", "1");
        Dictionary dic1 = new Dictionary("Niemiecki", dictionaryWords);
        dictionaryMap.put("Slownik1", dic1);
        dictionaryWords = List.of("a", "a", "34");
        Dictionary dic2 = new Dictionary("Angielski", dictionaryWords);
        dictionaryMap.put("Slownik34", dic2);
        dictionaryWords = List.of("1", "2", "3", "4", "5", "77");
        Dictionary dic3 = new Dictionary("Szwedzki", dictionaryWords);
        dictionaryMap.put("Slownik77", dic3);

        //dla 1
        testResult = Arrays.asList("Slownik1", "Slownik77");
        Assert.assertThat(testResult, containsInAnyOrder(DictionarySearcher.SearchForWord("1", dictionaryMap).toArray()));

        //dla a
        testResult = Arrays.asList("Slownik1", "Slownik34");
        Assert.assertThat(testResult, containsInAnyOrder(DictionarySearcher.SearchForWord("a", dictionaryMap).toArray()));

        //dla 77
        testResult = Arrays.asList("Slownik77");
        Assert.assertThat(testResult, containsInAnyOrder(DictionarySearcher.SearchForWord("77", dictionaryMap).toArray()));
    }
}
