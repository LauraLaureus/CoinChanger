package moneychanger;

import java.util.HashMap;
import java.util.TreeSet;

class CoinSet extends HashMap<Integer,Integer> {
    
    private int sum;

    public CoinSet() {
        this.sum = 0;
    }

    @Override
    public Integer put(Integer key, Integer value) {
        if(this.containsKey(key)){
            this.sum -= this.get(key);
        }
        this.sum += value;
        return super.put(key, value); 
    }

    public int getSum() {
        return sum;
    }
    
    public CoinSet getMapWithKeysOnly() {
        CoinSet copy = new CoinSet();
        for (Integer key : this.keySet()) {
            copy.put(key, 0);
        }
        
        return copy;
    }

    int getMostWorthyCoinWhichValuesIsLessOrEqualThan(int i) {
        TreeSet<Integer> coins = new TreeSet<>(this.keySet());
        if(coins.contains(i)) return i;
        return coins.lower(i);
    }

    void add(Integer currentCoin) {
        this.put(currentCoin, this.get(currentCoin)+1);
    }
}
