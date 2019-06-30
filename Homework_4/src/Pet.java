import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel;
    String[] habits;

    public Pet() {

    }

    Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    Pet(String species, String nickname, int age, int trickLevel, String habits) {
        this(species, nickname);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits.split(",");
    }


    public void eat() {
        System.out.println("Я кушаю!");
    }

    public void respond() {
        System.out.printf("Привет, хозяин. Я - %s. Я соскучился \n", nickname);
    }

    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

    @Override
    public String toString() {
        System.out.printf("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s} \n",
                species, nickname, age, trickLevel, Arrays.toString(habits));
        return "";
    }
}
