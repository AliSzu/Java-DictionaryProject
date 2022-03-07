package fileWork;

import com.fasterxml.jackson.databind.ObjectMapper;
import mainObject.Dictionary;

import java.io.File;
import java.io.IOException;

public class ReadFile {

        public static Dictionary ReadAndMapJson(String file)
        {
            ObjectMapper mapper = new ObjectMapper();
            Dictionary dictionary = null;
            try {
                dictionary = mapper.readValue(new File("Languages/" + file ), Dictionary.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dictionary;
        }

        public static File ReadPDF()
    {
        File file = new File("Document/document_log.pdf");
        return file;
    }
    }
