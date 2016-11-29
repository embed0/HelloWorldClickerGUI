package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Items {
    private List<Item> itemsList;
    public Items (){
        itemsList = new LinkedList<>();
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("items_.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray itemy = (JSONArray) jsonObject.get("items");
            Iterator iterator = itemy.iterator();
            while (iterator.hasNext()) {
                JSONObject slide = (JSONObject) iterator.next(); //pobieranie itemu


                Item item = new Item(
                        (String)slide.get("name"),
                        (Long)slide.get("basicPrice"),
                        (Long)slide.get("bugsGrowth"),
                        (String)slide.get("icon")
                );
                itemsList.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



    public List<Item> getItems(){
        return itemsList;
    }

}
