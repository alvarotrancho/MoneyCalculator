package Persistance;

import Model.Currency;
import Model.CurrencyList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileCurrencyListLoader implements CurrencyListLoader {
    private final String filename;

    public FileCurrencyListLoader(String filename) {
        this.filename = filename;
    }
    
    @Override
    public CurrencyList load() {
        CurrencyList lista = new CurrencyList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String line;
            while((line = reader.readLine()) != null) {
                lista.add(currencyOf(line));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    private Currency currencyOf(String line) {
        String[] split = line.split(",");
        return new Currency(split[0], split[1], split[2]);
    }
}
