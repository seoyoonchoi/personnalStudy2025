package caffeManage;

public class Main {
    public static void main(String[] args) {

        //원재료 데이터 생성
        Material coffeeBean = new Material("커피원두",12000,1000,5000);
        Material milk = new Material("우유",3000,1000,1000000);
        Material lemon = new Material("레몬",2660,30,20);
        Material strawberrySweets = new Material("딸기청",14910,1000,36);

        //각 메뉴별 재료 사용량 설정
        Menu americano = new Menu("아메리카노",1);
        americano.ingredient(coffeeBean,15);

        Menu latte = new Menu("카페라떼",2);
        latte.ingredient(coffeeBean,15);
        latte.ingredient(milk,150);

        Menu lemonTea = new Menu("딸기레몬에이드",2);
        lemonTea.ingredient(lemon, 5);
        lemonTea.ingredient(strawberrySweets, 10);

        //각 메뉴별 이익률 결정
        americano.calculatePrice(200);

        latte.sell();

        americano.printMenuInfo();
        latte.printMenuInfo();
        lemonTea.printMenuInfo();
    }
}
