
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

//        System.out.println(persons);
//        System.out.println();

        System.out.println("\nМЛАДШЕ ВОСЕМНАДЦАТИ");

        long count = persons.stream().filter(pers -> pers.getAge() < 18).count();

        System.out.println(count);

        //Получить список фамилий призывников
        System.out.println("\nПРИЗЫВНИКИ");



         Stream<Person> recruits  = persons.stream();
                recruits.filter(pers -> pers.getAge() >= 18 && pers.getAge() <= 27)
                .filter(pers -> pers.getSex() == Sex.MAN)
                .forEach(System.out::println);

        //System.out.println(listPeople);

        // СПИСОК МУЖЧИН (18-65), ЖЕНЩИН (18-60) С ВЫСШИМ ОБРАЗОВАНИЕМ

        System.out.println("\nС ВЫСШИМ ОБРАЗОВАНИЕМ");
        Stream<Person> streamInArray = persons.stream();

        streamInArray.filter(pers -> (pers.getAge() >= 18 && pers.getAge() <= 60 && pers.getSex() == Sex.WOMAN && pers.getEducation() == Education.HIGHER) || (pers.getAge() >= 18 && pers.getAge() <= 65 && pers.getSex() == Sex.MAN && pers.getEducation() == Education.HIGHER))
                .sorted((p1, p2) -> p1.getFamily().compareTo(p2.getFamily()))
                .forEach(System.out::println);

        
    }

}