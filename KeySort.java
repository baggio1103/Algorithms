public class ksort {

    public String alphabet = "abcdefgh";
    public String[] items;

    public ksort(){
        int size = (int)'h' + 2*(int)'9';
        items = new String[size];
    }

    public boolean add(String s){
        if (isSuitable(s)){
          items[(int)s.charAt(0) +(int)s.charAt(1)+(int)s.charAt(2) - 1] = s;
          return true;
        }else {
            return false;
        }
    }

    public int index(String s) {
        if (isSuitable(s)){
            return (int)s.charAt(0) +(int)s.charAt(1)+(int)s.charAt(2);
        }else {
            return -1;
        }
    }

    public boolean isSuitable(String item) {
        boolean contains = false;
        if (item.length() == 3) {
            for (int i = 0; i < alphabet.length(); i++) {
                if (alphabet.charAt(i) == item.charAt(0)) {
                    contains = true;
                    i = alphabet.length();
                }
            }
            if(contains && (def(item.charAt(1)) && def(item.charAt(2)))){
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean def(char c){
        return (int) c >= 48 && (int) c <= 57;
    }

}
