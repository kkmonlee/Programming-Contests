package com.company;

/**
 * Created by aa on 14/03/17.
 */

abstract class Animal {
    protected boolean isMammal;
    protected boolean isCarnivorous;

    public Animal(boolean isMammal, boolean isCarnivorous) {
        this.isMammal = isMammal;
        this.isCarnivorous = isCarnivorous;
    }

    public boolean getIsMammal() {
        return this.isMammal;
    }

    public boolean getIsCarnivorous() {
        return this.isCarnivorous;
    }

    abstract public String getGreeting();

    public void printAnimal(String name) {
        System.out.println(
                "A " + name + " says '" + this.getGreeting()
                        + "', is " + (this.getIsCarnivorous() ? "" : "not ")
                        + "carnivorous, and is " + (this.getIsMammal() ? "" : "not ") + "a mammal."
        );
    }
}

class Dog extends Animal {
    Dog() {
        super(true, true);
    }

    @Override
    public String getGreeting() {
        return "ruff";
    }
}

class Cow extends Animal {
    Cow() {
        super(true, false);
    }

    @Override
    public String getGreeting() {
        return "moo";
    }
}

class Duck extends Animal {
    Duck() {
        super(false, false);
    }

    @Override
    public String getGreeting() {
        return "quack";
    }
}