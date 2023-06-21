package ru.nsu.izhuravskii;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

/**
 * Module for reading info from json file.
 */
public class JsonData {
    int stockCapacity;
    List<Cook> cooks;
    List<Deliver> delivers;

    public int getStockCapacity() {
        return stockCapacity;
    }

    public List<Cook> getCooks() {
        return cooks;
    }

    public List<Deliver> getDelivers() {
        return delivers;
    }

    /**
     * Exact method of reading info from json.
     *
     * @param file - json file to read.
     */
    public JsonData(String file) {
        Gson gson = new Gson();
        JsonData jsonData;
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(
                Main.class.getClassLoader().getResourceAsStream(file)))) {
            jsonData = gson.fromJson(reader, JsonData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.stockCapacity = jsonData.stockCapacity;
        this.cooks = jsonData.cooks;
        this.delivers = jsonData.delivers;
    }
}
