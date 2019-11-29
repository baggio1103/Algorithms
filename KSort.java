public class ksort {

    public String alphabet = "abcdefgh";
    public String[] items;

    public ksort(){
        int size = 100 * (alphabet.length() - 1) + 10 * 9 + 10;
        items = new String[size];
    }

    public boolean add(String s){
        int index = isSuitable(s);
        if (index != -1){
            items[index] = s;
            return true;
        }else {
            return false;
        }
    }

    public int index(String s) {
        return isSuitable(s);
    }

    public int isSuitable(String item) {
        int index = -1;
        if (item.length() == 3) {
            for (int i = 0; i < alphabet.length(); i++) {
                if (alphabet.charAt(i) == item.charAt(0)) {
                    index *= 100*i *(-1);
                    i = alphabet.length();
                }
            }
            //checking whether alphabet contains the first letter of "item"
            if (index == -1) {
                return -1;
            } else {
                if (def(item)) {
                    index = index + 10 * Character.getNumericValue(item.charAt(1)) + Character.getNumericValue(item.charAt(2));
                    return index;
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public boolean def(String item){
        return Character.isDigit(item.charAt(1))&& Character.isDigit(item.charAt(2));
    }

}
