
import java.util.Arrays;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public Human(){
    }

    public Human(String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year,Human father, Human mother){
        this(name,surname,year);
        this.mother = mother;
        this.father = father;
    }


    public Human(String name, String surname, int year,Human father, Human mother,int iq,Pet pet){
        this(name,surname,year, father, mother);
        this.iq = iq;
        this.pet = pet;
    }


    public void greetPet(){
        System.out.printf("Привет,%s \n",pet.nickname);
    }

    public void describePet(){
        String trickLevel = pet.trickLevel > 50 ? "очень хитрый" : "почти не хитрый";
        System.out.printf("У меня есть %s, ему %d лет, он %s \n",pet.species,pet.age,trickLevel);
    }

    public boolean feedPet(boolean isTimeToFeed){
        if (isTimeToFeed){
            System.out.println("Питомец накормлен");
            return true;
        }

        if (pet.trickLevel > new Random().nextInt(101)){
            System.out.printf("Хм... покормлю ка я %s\n",pet.nickname);
            return true;
        }else {
            System.out.printf("Думаю,%s не голоден \n",pet.nickname);
            return false;
        }
    }

    @Override
    public String toString() {
        System.out.printf(
                "%s{name='%s',surname='%s',year=%d,iq=%d,\n" +
                "mother=%s %s,\n" +
                "father=%s %s,\n" +
                "pet=%s{nickname='%s', age=%d, trickLevel=%d, habits=[%s]}}\n",
                this.getClass(),name,surname,year,iq,
                mother.name,mother.surname,
                father.name,father.surname,
                pet.species,pet.nickname,pet.age,pet.trickLevel, Arrays.toString(pet.habits));
        return "";
    }
}
