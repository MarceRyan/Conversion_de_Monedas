package Control;

import com.google.gson.Gson;
import modelo.Moneda;
import modelo.Moneda_Exchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversion {
    //Esta URL se utiliza posteriormente para calcular conversiones de moneda.
    public String pairConversion(String monedaBase, String monedaDestino){
        String url = "https://v6.exchangerate-api.com/v6/1b515f4d6cc2bd646fd050c0/pair/" + monedaBase + "/" + monedaDestino;
        return url;
    }

    //Esta funcion obtiene un JSON de la API con la cotizacion de las monedas.
    //Retorna Gson de clase MonedaExchange.
    public Moneda_Exchange convertirMoneda(String monedaBase, String monedaDestino){
        HttpClient client = HttpClient.newHttpClient();

        //Crear URL request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(pairConversion(monedaBase,monedaDestino)))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        Moneda_Exchange monedaExchange = new Gson().fromJson(response.body(), Moneda_Exchange.class);
        return monedaExchange;
    }

    //Debemos calcular el total segun la cotizacion de las monedas
    public double calcularTotal(double cantidad, String monedaBase, String monedaDestino){
        Moneda_Exchange monedaExchange = convertirMoneda(monedaBase,monedaDestino);
        Moneda moneda = new Moneda(monedaExchange);
        return moneda.convertir(cantidad);
    }
}
