package radix;

public class MainRadix {

    public static void main(String[] args) {
        int[] vector = {45, 18, 23, 17, 44, 19, 32, 53, 5, 62};

        SimpleList list = new SimpleList(0);
        SimpleList cachedList = list;

        for (int i = 1 ; i < vector.length ; i++) {
            list.setPosition(new SimpleList(i));
            list = list.getPosition();
        }

        System.out.println(list.getValue());

        while (cachedList != null) {
            System.out.println(cachedList.getValue());
            cachedList = cachedList.getPosition();
        }
    }

}
