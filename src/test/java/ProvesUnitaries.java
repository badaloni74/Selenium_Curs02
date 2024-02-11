import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class ProvesUnitaries {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    @Test
    public void test01() {
        System.out.println("Hello World");
    }

    @Test
    public void test02(){
        Assert.fail("Prova fallida");
    }

    @Test
    public void test03(){
        Assert.fail("Prova fallida: true == false");
    }

    @Test
    public void test04(){
        Assert.assertTrue("Prova fallida: true == true", true);
    }

    @BeforeEach
    public void setUp() {
        System.out.println("BeforeEach");
    }
}

