package org.epam.dsa.java8.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {

        // empty
        Optional<String> emptyOpt=Optional.empty();
        System.out.println("empty optional:"+ emptyOpt.isPresent());

        // of(value)
        Optional<String> nameOpt= Optional.of("amresh");
        System.out.println("nameOpt.get():"+ nameOpt.get());

        // ofNullable(value)
        Optional<String> nullableOpt=Optional.empty();
        System.out.println("nullable isPresent:"+ nullableOpt.isPresent());

        // isPresent()
        if(nameOpt.isPresent()){
            System.out.println("nameOpt contains:"+ nameOpt.get());
        }

        // get() { Only safe if isPresent is true}
        try{
            System.out.println("nullableOpt.get:"+ nullableOpt.get());
        } catch ( Exception e){
            System.out.println("Exception on get():"+ e);
        }

        // ifPresent(Consumer)
        nameOpt.ifPresent((val)-> System.out.println("value:"+ val));

        // orElse(default)
        String result1=nullableOpt.orElse("default name");
        System.out.println("orElse result:"+ result1);


        //orElseGet(Supplier)
        String result2=nullableOpt.orElseGet(()->"generated default");
        System.out.println("orElseGet result:"+ result2);

        // orElseThrow()
        try{
            String result3=nullableOpt.orElseThrow(()-> new IllegalArgumentException("value is null"));
            System.out.println("orElseThrow result: " + result3);
        } catch (Exception e){
            System.out.println("Exception on orElseThrow(): " + e);
        }

        // map
        Optional<Integer> lengthOpt=nameOpt.map((str)->str.length());
        System.out.println("Mapped to length:"+ lengthOpt.get());

        // flatMap
        Optional<Optional<String>> nested=nameOpt.map(Optional::of);
        Optional<String> flattend=nameOpt.flatMap(Optional::of);
        System.out.println("nested.get():"+ nested.get());
        System.out.println("flattened.get():"+ flattend.get());

        //

    }
}
