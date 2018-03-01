package com.github.mihalyfodor.lambdas;

/**
 * Helper class for showcasing streams.
 * 
 * @author Mihaly Fodor
 *
 */
public class Person {

    private String name;
    private Gender gender;
    private int age;
    
    public Person(String name, Gender gender, int age) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

    

}
