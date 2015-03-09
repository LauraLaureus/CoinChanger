package moneychanger;

import java.util.Map;
import java.util.Scanner;

public class MoneyChanger {
    public static void main(String[] args) {
        CoinSet currentCoins = new CoinSetCreator().create();
        show(change(currentCoins));
    }

    private static CoinSet change(CoinSet currentCoins) {
        CoinSet s = currentCoins.getMapWithKeysOnly();
        
        int objective = askForObjetive();
        Integer currentCoin;
        while(s.getSum() != objective){
            currentCoin  = currentCoins.getMostWorthyCoinWhichValuesIsLessOrEqualThan(objective-s.getSum());
             if(currentCoin == null){
                 System.out.println("No hay solución.");
                 return null;
             }
             s.add(currentCoin);
        }
        
        return s;
    }

    private static int askForObjetive() {
        System.out.println("Cuanto hay que devolverte");
        return new Scanner(System.in).nextInt();
    }

    private static void show(CoinSet change) {
        if(change == null) System.out.println("No hay solución");
        else{
            System.out.println("La solución es la siguiente");
            for (Map.Entry<Integer, Integer> coin : change.entrySet()) {
                System.out.println(coin.getValue() + "monedas de " 
                        + coin.getKey() + "centimos");
            }
        }
    }
    
}
