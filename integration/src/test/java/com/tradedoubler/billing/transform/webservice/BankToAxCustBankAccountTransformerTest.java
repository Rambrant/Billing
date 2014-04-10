package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.tradedoubler.billing.domain.Bank;
import com.tradedoubler.billing.service.ax.webservice.call.FindBankCall;
import org.junit.*;
import org.mockito.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * User: erigu
 * Date: 2012-09-21
 */
public class BankToAxCustBankAccountTransformerTest {


    private BankToAxCustBankAccountTransformer bankToAxCustBankAccountTransformer;

    @Mock
    private FindBankCall findCall;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testTransform() throws Exception {
        Bank bank = new Bank("clientId", 51, "code", "1234", "acc Owner");
        bankToAxCustBankAccountTransformer = new BankToAxCustBankAccountTransformer("1", bank);
        AxdEntityCustBankAccount axBank = bankToAxCustBankAccountTransformer.transform();
        assertEquals("entity", axBank.getClazz());
        assertEquals("clientId", axBank.getCustAccount());
        assertEquals("1234", axBank.getAccountNum().getValue());
        assertEquals("1", axBank.getAccountID());
        assertEquals("acc Owner", axBank.getName().getValue());
        assertEquals("code", axBank.getRegistrationNum().getValue());
    }

    @Test
    public void testTransformForUpdate() throws Exception {
        Bank bank = new Bank("clientId", 51, "code", "1234", "acc Owner");
        bankToAxCustBankAccountTransformer = new BankToAxCustBankAccountTransformer("1", bank);
        ObjectFactory objectFactory = new ObjectFactory();
        when(findCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityCustBankAccountDocumentHash("12345abc"));


        AxdEntityCustBankAccount axBank = bankToAxCustBankAccountTransformer.transformForUpdate(findCall);
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axBank.getAction());
        assertEquals("12345abc", axBank.getDocumentHash().getValue());

        assertEquals("entity", axBank.getClazz());
        assertEquals("clientId", axBank.getCustAccount());
        assertEquals("1234", axBank.getAccountNum().getValue());
        assertEquals("1", axBank.getAccountID());
        assertEquals("acc Owner", axBank.getName().getValue());
        assertEquals("code", axBank.getRegistrationNum().getValue());
    }



    @Test
    public void testTransformForUpdateWithFind(){
        Bank bank = new Bank("clientId", 51, "code", "1234", "acc Owner");
        bankToAxCustBankAccountTransformer = new BankToAxCustBankAccountTransformer("1", bank);
        ObjectFactory objectFactory = new ObjectFactory();
        when(findCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityCustBankAccountDocumentHash("12345abc"));


        AxdEntityCustBankAccount axBank = bankToAxCustBankAccountTransformer.transformForUpdate(findCall);
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axBank.getAction());
        assertEquals("12345abc", axBank.getDocumentHash().getValue());

        assertEquals("entity", axBank.getClazz());
        assertEquals("clientId", axBank.getCustAccount());
        assertEquals("1234", axBank.getAccountNum().getValue());
        assertEquals("1", axBank.getAccountID());
        assertEquals("acc Owner", axBank.getName().getValue());
        assertEquals("code", axBank.getRegistrationNum().getValue());


    }

}
