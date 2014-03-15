import org.fest.assertions.api.Assertions;
import org.junit.Test;


public class HelloWorldTest {
   @Test
   public void hello_world_test(){
       Assertions.assertThat(("Hello World").equals("Hello World"));
   }
}
