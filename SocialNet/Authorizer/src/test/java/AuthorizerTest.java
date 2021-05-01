import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizerTest {

    IDataBase dataBase = Mockito.mock( IDataBase.class );
    private IAuthorizer authorizer = new Authorizer( dataBase );

    @Test
    public void onLoginTest() {
        Mockito.when(dataBase.getWebPage("Alex", 123 ))
                .thenReturn(new WebPage( "Alex", 123, 0 ));

        assertTrue( authorizer.onLogin( "Alex", 123 ) );
    }
}