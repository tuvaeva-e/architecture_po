package HW2;

public class SapphireGenerator extends ItemFabric {

    @Override
    public iGameItem createItem() {
        System.out.println("Создал новый сундук");
        return new SapphireReward();
    }
}
