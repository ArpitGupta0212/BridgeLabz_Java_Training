package org.RegexAnnotationJUnit.CabServices;

import org.RegexAnnotationJUnit.CabService.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceServiceTest {

    @Test
    public void testInvoiceService() {

        InvoiceService service =
                new InvoiceService();

        InvoiceSummary summary =
                service.getInvoice(
                        "ABC123"
                );

        assertNotNull(summary);
    }
}