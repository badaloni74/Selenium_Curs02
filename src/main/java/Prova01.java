import org.junit.Assert;
import org.junit.Test;

public class Prova01 {
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
        Assert.assertTrue("Prova fallida: true == false", true == false);
    }

    @Test
    public void test04(){
        Assert.assertTrue("Prova fallida: true == true", true == true);
    }

}
