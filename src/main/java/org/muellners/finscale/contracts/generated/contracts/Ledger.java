package org.muellners.finscale.contracts.generated.contracts;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.4.
 */
@SuppressWarnings("rawtypes")
public class Ledger extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b5060405162000cac38038062000cac83398181016040526101008110156200003857600080fd5b81019080805160405193929190846401000000008211156200005957600080fd5b9083019060208201858111156200006f57600080fd5b82516401000000008111828201881017156200008a57600080fd5b82525081516020918201929091019080838360005b83811015620000b95781810151838201526020016200009f565b50505050905090810190601f168015620000e75780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200010b57600080fd5b9083019060208201858111156200012157600080fd5b82516401000000008111828201881017156200013c57600080fd5b82525081516020918201929091019080838360005b838110156200016b57818101518382015260200162000151565b50505050905090810190601f168015620001995780820380516001836020036101000a031916815260200191505b5060405260200180516040519392919084640100000000821115620001bd57600080fd5b908301906020820185811115620001d357600080fd5b8251640100000000811182820188101715620001ee57600080fd5b82525081516020918201929091019080838360005b838110156200021d57818101518382015260200162000203565b50505050905090810190601f1680156200024b5780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200026f57600080fd5b9083019060208201858111156200028557600080fd5b8251640100000000811182820188101715620002a057600080fd5b82525081516020918201929091019080838360005b83811015620002cf578181015183820152602001620002b5565b50505050905090810190601f168015620002fd5780820380516001836020036101000a031916815260200191505b506040818152602083015192018051929491939192846401000000008211156200032657600080fd5b9083019060208201858111156200033c57600080fd5b82516401000000008111828201881017156200035757600080fd5b82525081516020918201929091019080838360005b83811015620003865781810151838201526020016200036c565b50505050905090810190601f168015620003b45780820380516001836020036101000a031916815260200191505b50604081815260208301519201805192949193919284640100000000821115620003dd57600080fd5b908301906020820185811115620003f357600080fd5b82516401000000008111828201881017156200040e57600080fd5b82525081516020918201929091019080838360005b838110156200043d57818101518382015260200162000423565b50505050905090810190601f1680156200046b5780820380516001836020036101000a031916815260200191505b506040525050506000806200048f876200078d640100000000026401000000009004565b9050620004e06040518060400160405280600581526020017f41535345540000000000000000000000000000000000000000000000000000008152506200078d640100000000026401000000009004565b811415620004f25760009150620006dd565b620005416040518060400160405280600981526020017f4c494142494c49545900000000000000000000000000000000000000000000008152506200078d640100000000026401000000009004565b811415620005535760019150620006dd565b620005a26040518060400160405280600681526020017f45515549545900000000000000000000000000000000000000000000000000008152506200078d640100000000026401000000009004565b811415620005b45760029150620006dd565b620006036040518060400160405280600781526020017f524556454e5545000000000000000000000000000000000000000000000000008152506200078d640100000000026401000000009004565b811415620006155760039150620006dd565b620006646040518060400160405280600781526020017f455850454e5345000000000000000000000000000000000000000000000000008152506200078d640100000000026401000000009004565b811415620006765760049150620006dd565b604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601c60248201527f50726f766964656420756e6b6e6f776e204c6564676572547970652100000000604482015290519081900360640190fd5b8951620006f29060009060208d019062000806565b508851620007089060019060208c019062000806565b5087516200071e9060029060208b019062000806565b506003805483919060ff191660018360048111156200073957fe5b0217905550600486905584516200075890600590602088019062000806565b506006805460ff191685151517905582516200077c90600790602086019062000806565b5050505050505050505050620008b2565b6000816040516020018082805190602001908083835b60208310620007c45780518252601f199092019160209182019101620007a3565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051602081830303815290604052805190602001209050919050565b828054600181600116156101000203166002900490600052602060002090601f0160209004810192826200083e576000855562000889565b82601f106200085957805160ff191683800117855562000889565b8280016001018555821562000889579182015b82811115620008895782518255916020019190600101906200086c565b50620008979291506200089b565b5090565b5b808211156200089757600081556001016200089c565b6103ea80620008c26000396000f3fe608060405234801561001057600080fd5b50600436106100a5576000357c0100000000000000000000000000000000000000000000000000000000900480638c2109de116100785780638c2109de14610153578063af640d0f1461017c578063d4c3eea014610184578063dd8e53531461019e576100a5565b806306fdde03146100aa57806317e0513d146101275780637284e416146101435780637998a1c41461014b575b600080fd5b6100b26101a6565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100ec5781810151838201526020016100d4565b50505050905090810190601f1680156101195780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61012f610231565b604080519115158252519081900360200190f35b6100b261023a565b6100b2610295565b61015b6102ef565b6040518082600481111561016b57fe5b815260200191505060405180910390f35b6100b26102f8565b61018c610353565b60408051918252519081900360200190f35b6100b2610359565b6002805460408051602060018416156101000260001901909316849004601f810184900484028201840190925281815292918301828280156102295780601f106101fe57610100808354040283529160200191610229565b820191906000526020600020905b81548152906001019060200180831161020c57829003601f168201915b505050505081565b60065460ff1681565b6005805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156102295780601f106101fe57610100808354040283529160200191610229565b60018054604080516020600284861615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156102295780601f106101fe57610100808354040283529160200191610229565b60035460ff1681565b6000805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156102295780601f106101fe57610100808354040283529160200191610229565b60045481565b6007805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156102295780601f106101fe5761010080835404028352916020019161022956fea2646970667358221220fc484ea85c80eb27797ec1a0fc6e44d279d3ee922158bfac720e4736cea2f77864736f6c63430007050033";

    public static final String FUNC_DESCRIPTION = "description";

    public static final String FUNC_ID = "id";

    public static final String FUNC_IDENTIFIER = "identifier";

    public static final String FUNC_LEDGERTYPE = "ledgerType";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_PARENTLEDGERID = "parentLedgerId";

    public static final String FUNC_SHOWACCOUNTSINCHART = "showAccountsInChart";

    public static final String FUNC_TOTALVALUE = "totalValue";

    @Deprecated
    protected Ledger(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ledger(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Ledger(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Ledger(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> description() {
        final Function function = new Function(FUNC_DESCRIPTION,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> id() {
        final Function function = new Function(FUNC_ID,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> identifier() {
        final Function function = new Function(FUNC_IDENTIFIER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> ledgerType() {
        final Function function = new Function(FUNC_LEDGERTYPE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> parentLedgerId() {
        final Function function = new Function(FUNC_PARENTLEDGERID,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> showAccountsInChart() {
        final Function function = new Function(FUNC_SHOWACCOUNTSINCHART,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> totalValue() {
        final Function function = new Function(FUNC_TOTALVALUE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Ledger load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ledger(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Ledger load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ledger(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Ledger load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Ledger(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Ledger load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Ledger(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Ledger> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _id, String _identifier, String _name, String _ledgerTypeAsString, BigInteger _totalValue, String _description, Boolean _showAccountsInChart, String _parentLedgerId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_id),
                new Utf8String(_identifier),
                new Utf8String(_name),
                new Utf8String(_ledgerTypeAsString),
                new Uint256(_totalValue),
                new Utf8String(_description),
                new Bool(_showAccountsInChart),
                new Utf8String(_parentLedgerId)));
        return deployRemoteCall(Ledger.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Ledger> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _id, String _identifier, String _name, String _ledgerTypeAsString, BigInteger _totalValue, String _description, Boolean _showAccountsInChart, String _parentLedgerId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_id),
                new Utf8String(_identifier),
                new Utf8String(_name),
                new Utf8String(_ledgerTypeAsString),
                new Uint256(_totalValue),
                new Utf8String(_description),
                new Bool(_showAccountsInChart),
                new Utf8String(_parentLedgerId)));
        return deployRemoteCall(Ledger.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ledger> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _id, String _identifier, String _name, String _ledgerTypeAsString, BigInteger _totalValue, String _description, Boolean _showAccountsInChart, String _parentLedgerId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_id),
                new Utf8String(_identifier),
                new Utf8String(_name),
                new Utf8String(_ledgerTypeAsString),
                new Uint256(_totalValue),
                new Utf8String(_description),
                new Bool(_showAccountsInChart),
                new Utf8String(_parentLedgerId)));
        return deployRemoteCall(Ledger.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ledger> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _id, String _identifier, String _name, String _ledgerTypeAsString, BigInteger _totalValue, String _description, Boolean _showAccountsInChart, String _parentLedgerId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_id),
                new Utf8String(_identifier),
                new Utf8String(_name),
                new Utf8String(_ledgerTypeAsString),
                new Uint256(_totalValue),
                new Utf8String(_description),
                new Bool(_showAccountsInChart),
                new Utf8String(_parentLedgerId)));
        return deployRemoteCall(Ledger.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
