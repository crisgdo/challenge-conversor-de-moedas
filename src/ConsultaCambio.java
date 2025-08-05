import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaCambio {
    private String apiKey;

    public ConsultaCambio(String apiKey) {
        this.apiKey = apiKey;
    }

    public TaxasDeCambio buscarTaxas(String codigoMoeda) {
            String url_str = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/USD";// Setting URL

        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            if (request.getResponseCode() != 200){
                throw new IOException("Erro na requisição" + request.getResponseCode());
            }

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            String req_result = jsonobj.get("result").getAsString();

            if("sucess".equals(req_result)){
                String errorType = jsonobj.get("error_type").getAsString();
                System.out.printf("A API retornou um erro: " + errorType);
            }

            return new TaxasDeCambio(jsonobj);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter as taxas de câmbio",e);
        }
    }
}