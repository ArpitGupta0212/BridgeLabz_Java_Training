package org.RegexAnnotationJUnit.CabService;

public class InvoiceService {

    RideRepository repository =
            new RideRepository();

    CabInvoiceGenerator generator =
            new CabInvoiceGenerator();

    public InvoiceSummary getInvoice(
            String userId) {

        Ride[] rides =
                repository.getRides(userId);

        return generator.getSummary(
                rides
        );
    }

    public static void main(String[] args) {

        InvoiceService service =
                new InvoiceService();

        System.out.println(
                service.getInvoice(
                        "ABC123"
                )
        );
    }
}