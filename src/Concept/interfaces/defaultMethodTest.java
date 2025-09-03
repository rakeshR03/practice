package Concept.interfaces;

public class defaultMethodTest {
    public static void main(String[] args) {

    }
}

interface LivingThing {
    default boolean canBreathe() {
        return true;
    }
}

interface Bird extends LivingThing {
    @Override
    default boolean canBreathe() {
        return LivingThing.super.canBreathe();
    }
}
