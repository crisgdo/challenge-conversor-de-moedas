import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class TaxasDeCambio {
   private String base_code;
   private Map<String, Double> converseion_rates;

    public TaxasDeCambio(JsonObject jsonObject) {
        this.base_code = jsonObject.get("base_code").getAsString();

        this.converseion_rates = new Gson().fromJson(jsonObject.get("conversion_rates"), new TypeToken<Map<String, Double>>(){}.getType());
    }

    public double getTaxa(String moeda) {
        return this.converseion_rates.getOrDefault(moeda, 0D);
    }
}

