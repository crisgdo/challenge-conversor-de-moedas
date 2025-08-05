public class ConversorDeMoeda {
    public double converter(double valor, String moedaOrigem, String moedaDestino, TaxasDeCambio taxa) {
        double taxaOrigem = taxa.getTaxa(moedaOrigem);
        double taxaDestino = taxa.getTaxa(moedaDestino);

        if (taxaOrigem == 0.0 || taxaDestino == 0.0) {
            throw new IllegalArgumentException("Uma das moedas não foi encontrada nas taxas de câmbio");
        }
        return (valor / taxaOrigem) * taxaDestino;
    }
}
