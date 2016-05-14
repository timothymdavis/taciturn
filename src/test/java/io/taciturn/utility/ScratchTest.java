package io.taciturn.utility;

import java.lang.reflect.Method;

import org.junit.Test;

import static io.taciturn.Utility.$;

public class ScratchTest {

    @Test
    public void scratch() throws Exception {
        $("a", "3", "2")
                .mapEach(i -> $(i).convertToInteger(16).orElse(null))
                .filterEach(o -> o != null)
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);

        $("a", "3", "2")
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
    }
    
    @Test
    public void getFieldsTest() throws Exception {
        User user = new User();
        user.setFirstName("Tim");
        user.setLastName("Davis");
        $(user).getPublicFields()
               .mapEach(FieldUtility::getObject)
               .filterEach(o -> o != null)
               .forEach(System.out::println);
    }

    @Test
    public void getMethodsTest() throws Exception {
        User user = new User();
        user.setFirstName("Tim");
        user.setLastName("Davis");

        $(user).getPublicGetterMethods()
               .mapEach(o -> o.map(Method::getName).orElse("") + ": " + o.invoke())
               .forEach(System.out::println);

        $(user).getPrivateFields()
               .filterEach(o -> o.map(f -> Boolean.class.equals(f.getType())).orElse(false))
               .forEach(o -> o.setObject(true));
        
        $(user).getPublicGetterMethods()
               .mapEach(o -> o.map(Method::getName).orElse("") + ": " + o.invoke())
               .forEach(System.out::println);
    }
    
    public static class User {

        private Boolean olderThan18;
        private String firstName;
        private String LastName;

        public void someVoidMethod() {
            System.out.println("Side Effect!");
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public Boolean getOlderThan18() {
            return olderThan18;
        }

        public void setOlderThan18(Boolean olderThan18) {
            this.olderThan18 = olderThan18;
        }
    }

}
