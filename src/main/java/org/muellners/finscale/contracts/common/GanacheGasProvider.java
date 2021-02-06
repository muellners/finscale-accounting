package org.muellners.finscale.contracts.common;

import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class GanacheGasProvider extends StaticGasProvider {
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(6_721_975);
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(1_000);

    public GanacheGasProvider() {
        super(GAS_PRICE, GAS_LIMIT);
    }
}
