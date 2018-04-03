package sungard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import sungard.Person.Sex;

public class LambdaTest1 {

	public static void main(String[] args) {
		List<Person> roster = new ArrayList<Person>();
		roster.add(new Person("Nimisha", LocalDate.of(1991,11,06), Sex.FEMALE, "ng.nimishagupta@gmail.com" ));
		processPersons(
			     roster,
			     p -> p.getGender() == Person.Sex.MALE
			         && p.getAge() >= 18
			         && p.getAge() <= 25,
			     p -> p.printPerson()
			);
	}
	
	public static void processPersons(
		    List<Person> roster,
		    Predicate<Person> tester,
		    Consumer<Person> block) {
		        for (Person p : roster) {
		            if (tester.test(p)) {
		                block.accept(p);
		            }
		        }
		}
}
