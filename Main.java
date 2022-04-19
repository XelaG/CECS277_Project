public class Main {

    public static void main(String[] args) {
        System.out.print("What is your name, traveler ? ");
        String heroName = CheckInput.getString();
        Hero h = new Hero(heroName);
        EnemyGenerator eGen = new EnemyGenerator();
        loop: while (true) {
            if (h.getHp() == 0) break;
            System.out.println(h.toString());
            int menuChoice = mainMenu(h);
            char currentCase = 'x';
            switch (menuChoice) {
                case 1:
                    currentCase = h.goNorth();
                    break;
                case 2:
                    currentCase = h.goSouth();
                    break;
                case 3:
                    currentCase = h.goEast();
                    break;
                case 4:
                    currentCase = h.goWest();
                    break;
                case 5:
                    break loop;
                default:
                    break;
            }
            switch (currentCase) {
                case 'x':
                    System.out.println("Position was out of bound");
                    break;
                case 'n':
                    System.out.println("There was nothing there");
                    break;
                case 's':
                    store(h);
                    break;
                case 'f':
                    if (h.hasKey()) {
                        h.levelUp();
                        h.useKey();
                        System.out.println("You found a locked gate. Luckily you have a key! You proceed to the next area");
                    } else {
                        System.out.println("You found a locked gate. Find the key to proceed to the next area");
                    }
                    break;
                case 'i':
                    if (MyUtils.randomIntRange(0, 1) == 1) {
                        h.pickUpKey();
                        System.out.println("You found a key !");
                    } else {
                        h.pickUpPotion();
                        System.out.println("You found a potion !");
                    }
                    break;
                case 'm':
                    Enemy e = eGen.generateEnemy(h.getLevel());
                    monsterRoom(h, e);
                default:
                    break;
            }
        }
        System.out.println("Game Over !");
    }

    public static int mainMenu(Hero h) {
        System.out.println("1. Go North");
        System.out.println("2. Go South");
        System.out.println("3. Go East");
        System.out.println("4. Go West");
        System.out.println("5. Quit");
        return CheckInput.getIntRange(1, 5);
    }

    public static Boolean monsterRoom(Hero h, Enemy e) {
        loop: while (true) {
            System.out.println(e.toString());
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            if (h.hasPotion()) System.out.println("3. Drink Potion");
            int decision = CheckInput.getIntRange(1, h.hasPotion() ? 3 : 2);
            switch (decision) {
                case 1:
                    fight(h, e);
                    break;
                case 2:
                    break loop;
                case 3:
                    h.usePotion();
                    break;
                default:
                    break;
            }
            
        }
        return false;
    }

    public static Boolean fight(Hero h, Enemy e) {
        System.out.println(h.getAttackMenu());
        int choice = CheckInput.getIntRange(1, h.getNumAttackMenuItems());
        System.out.println(h.getSubAttackMenu(choice));
        int subChoice = CheckInput.getIntRange(1, h.getNumSubAttackMenuItems(choice));
        h.attack(e, choice, subChoice);
        e.attack(h);
        return false;
    }

    public static void store(Hero h) {
        
    }
}