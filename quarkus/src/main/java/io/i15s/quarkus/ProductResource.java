package io.i15s.quarkus;


import org.javamoney.moneta.Money;

import javax.enterprise.context.RequestScoped;
import javax.money.Monetary;
import javax.money.convert.MonetaryConversions;
import javax.money.format.AmountFormatQuery;
import javax.money.format.MonetaryFormats;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Locale;

@Path("/product")
@RequestScoped
public class ProductResource {

    @GET
    public String get() {
        var value = Money.of(100, "EUR");

        var rateProvider = MonetaryConversions.getExchangeRateProvider();
        var conversion = rateProvider.getCurrencyConversion(Monetary.getCurrency("USD"));

        var valueUsd = value.with(conversion);

        var formatter = MonetaryFormats.getAmountFormat(AmountFormatQuery.of(Locale.US));

        return formatter.format(valueUsd);
    }
}
