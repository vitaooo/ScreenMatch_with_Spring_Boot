package br.com.alura.screematch.principal;

import br.com.alura.screematch.model.DadosSerie;
import br.com.alura.screematch.service.ConsumoApi;
import br.com.alura.screematch.service.ConverterDados;

import java.util.Scanner;

public class Principal {

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=ef816ea2";

    private ConsumoApi consumo = new ConsumoApi();

    private ConverterDados conversor = new ConverterDados();

    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu()  {
        System.out.println("Digite o nome da série para buscar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);
    }
}
