package caffeManage;

import java.util.ArrayList;
import java.util.List;

    public class Menu {
        private String menuName;
        private List<Material> ingredients = new ArrayList<>();
        private int count;
        private List<Integer> amounts = new ArrayList<>();
        private int margin;

        public Menu(String menuName,int count) {
            this.menuName = menuName;
            this.count = count;
        }

        public void ingredient(Material material, int amount) {
            ingredients.add(material);
            amounts.add(amount);
        }

        // 한 잔 판매 시 재료 차감
        public boolean sell() {
            // 모든 재료가 충분한지 확인
            for (int i = 0; i < ingredients.size(); i++) {
                if (!ingredients.get(i).useMaterial(amounts.get(i))) {
                    System.out.println("❌ 판매 실패: " + menuName + " (재료 부족)");
                    return false;
                }
            }

            System.out.println( menuName + " 판매 완료!");
            return true;
        }

        // 현재 메뉴의 가격 계산
        public int calculatePrice(int margin) {
            int totalPrice = 0;
            for (int i = 0; i < ingredients.size(); i++) {
                totalPrice += (ingredients.get(i).getPriceOfMaterial() * amounts.get(i)) / ingredients.get(i).getAmout();
                totalPrice = totalPrice+(totalPrice*margin/100);
            }
            return totalPrice;
        }

        // 메뉴 정보 출력
        public void printMenuInfo() {
            System.out.println("메뉴: " + menuName);
            System.out.print("사용된 재료:");
            for (int i = 0; i < ingredients.size(); i++) {
                System.out.println("- " + ingredients.get(i).getName() + ": " + amounts.get(i) + "g/ml (재고: " + ingredients.get(i).getStock() + ")");
            }
            System.out.println("한 잔 가격: " + calculatePrice(margin) + "원");
        }
    }


