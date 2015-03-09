package moneychanger;

import java.util.Scanner;

class CoinSetCreator {

    private final Scanner teclado;

    public CoinSetCreator() {
        teclado = new Scanner(System.in);
    }

    CoinSet create() {
        Integer type;
        Integer num;
        CoinSet currentSet = new CoinSet();

        while (true) {

            type = askForCoinType();
            num = askForNumberOfCoins();
            currentSet.put(type, num);
            if(hasUserFinished()) return currentSet;
        }

    }

    private Integer askForCoinType() {
        boolean isGoodValue = false;
        Integer value = 0;

        while(!isGoodValue){
            System.out.println("Ingrese el tipo de moneda: (En euros del 1[un céntimo] a 200[dos euros])");
            value = teclado.nextInt();
            if (isGoodValueTest(value)) {
                return value;
            }
            System.out.println("El tipo de moneda no es correcto.");
        }

        return value;
    }


    private Integer askForNumberOfCoins() {
        Integer amount;
        System.out.println("Ingrese la cantidad de monedas de este tipo: ");
        amount = teclado.nextInt();
        return amount;
    }

    private boolean hasUserFinished() {
        System.out.println("¿Ha terminado de insertar monedas? Introduzca S o N");
        String response = "";
        while (!response.equalsIgnoreCase("S") && !response.equalsIgnoreCase("N"))
            response = teclado.nextLine();
        if(response.equalsIgnoreCase("S")){
            System.out.println("El usuario ha terminado.");
            return true;
        }else{
            System.out.println("El usuario no ha terminado.");
            return false;
        }
        
    }

    private boolean isGoodValueTest(Integer value) {
        switch(value){
            case 1: return true;
            case 2: return true;
            case 5: return true;
            case 10: return true;
            case 20: return true;
            case 50: return true;
            case 100: return true;
            case 200: return true;
            default: return false;
        }
    }

}
