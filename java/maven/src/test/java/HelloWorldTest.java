import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class HelloWorldTest {
    @Test
    public void hello_world_test(){
       assertThat("Hello World").isEqualTo("Hello World");
    }

    @Test
    public void should_be_mocked(){
        HelloWorld helloWorld = mock(HelloWorld.class);
        when(helloWorld.beenCalled()).thenReturn("Hello World");

        assertThat(helloWorld.beenCalled()).isEqualTo("Hello World");
    }
}
