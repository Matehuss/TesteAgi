import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteInexistente.class,
	TesteExistente.class,
	TesteLimiteCaractere.class
})
public class SuiteTeste {

}
