package modelo;

public record Moneda_Exchange(String base_code, String target_code, double conversion_rate) {
    /**
     * Esta clase representa un registro de cotización de monedas.
     * Se obtiene del archivo JSON de cotizaciones y almacena información sobre dos monedas elegidas y sus respectivos códigos.
     * Esta información se utiliza posteriormente para calcular conversiones de moneda.
     */
}
