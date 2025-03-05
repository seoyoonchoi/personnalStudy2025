package caffeManage;

public class Material {
    private String name;
    private int priceOfMaterial;
    private int amout; // 1회 구매 시 제공되는 양
    private int stock; // 현재 보유한 재료 양

    public Material(String name, int priceOfMaterial, int amout, int stock) {
        this.name = name;
        this.priceOfMaterial = priceOfMaterial;
        this.amout = amout;
        this.stock = stock;
    }

    // Getter 메서드 추가
    public String getName() {
        return name;
    }

    public int getPriceOfMaterial() {
        return priceOfMaterial;
    }

    public int getAmout() {
        return amout;
    }

    public int getStock() {
        return stock;
    }

    // 재료 사용 메서드
    public boolean useMaterial(int amount) {
        if (stock >= amount) {
            stock -= amount;
            return true; // 사용 성공
        } else {
            System.out.println(" 재료 부족: " + name + " (필요: " + amount + ", 보유: " + stock + ")");
            return false; // 사용 실패
        }
    }

    // 재고 추가 메서드 (추후 재료 구매 기능 추가 가능)
    public void addStock(int amount) {
        stock += amount;
    }
}
