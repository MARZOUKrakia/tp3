package fr.univ_amu.iut.exercice1;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue ;

public class PropertyExample {
    private ChangeListener changeListener=
            (observableValue, oldValue, newValue) -> {
        System.out.println("the observableValue had changed:" + oldValue + " " + newValue) ;
            } ;

    private InvalidationListener invalidationListener = observable -> System.out.println ("the observable has been invalidated") ;


    private IntegerProperty anIntProperty;

    public static void main(String[] args) {
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.createProperty();
        propertyExample.addAndRemoveInvalidationListener();
        propertyExample.addAndRemoveChangeListener();
    }

    void createProperty() {
        anIntProperty = new SimpleIntegerProperty(1024);
        System.out.println();
        System.out.println("anIntProperty= "+ anIntProperty);
        System.out.println("anIntProperty.get()= " + anIntProperty.get());
        System.out.println("anIntProperty.getValue() = " + anIntProperty.getValue());

    }

    void addAndRemoveInvalidationListener() {
        System.out.println();
        System.out.println("Add invalidation listener.");
        anIntProperty.addListener(invalidationListener);
        System.out.println("setValue() with 1024.");
        anIntProperty.setValue(Integer.valueOf(1024));
        System.out.println("set() with 2105.");
        anIntProperty.set(2105);
        System.out.println("The observable has been invalidated.");
        System.out.println("setValue() with 5012.");
        anIntProperty.setValue(Integer.valueOf(5012));
        System.out.println("Remove invalidation listener.");
        anIntProperty.removeListener(invalidationListener);
        System.out.println("set() with 1024.");
        anIntProperty.set(1024);
        // throw new RuntimeException("Not yet implemented !");
    }
    void addAndRemoveChangeListener() {

    }


    public int getAnInt() {
        return anIntProperty.get();
    }

    public void setAnInt(int anInt) {
        if (anIntProperty == null)
            anIntProperty = new SimpleIntegerProperty();
        this.anIntProperty.set(anInt);
    }

    public IntegerProperty anIntProperty() {
        return anIntProperty;
    }

}