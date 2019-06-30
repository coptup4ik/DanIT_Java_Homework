public class Main {

    public static void main(String[] args) {
        Human f1Father = new Human("Father","First",1970);
        Human f1Mother = new Human("Mother","First",1970);
        Pet f1Dog = new Pet("dog","f1Dog",5,75,"eat,sleep,rave,repeat");
        Human f1Son = new Human("Son","First",2000,f1Father,f1Mother,100,f1Dog);

        f1Son.greetPet();
        f1Son.describePet();
        f1Dog.toString();


        f1Son.toString();
    }
}
