import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class HelloWorldTest {
   @Test
   public void hello_world_test(){
       assertThat("Hello World").isEqualTo("Hello World");
   }
}
