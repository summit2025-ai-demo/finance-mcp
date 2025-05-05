package org.parasol.customerservice.finance.mcp;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.parasol.customerservice.finance.mcp.model.FinanceRecord;
import org.parasol.customerservice.finance.mcp.service.FinanceApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class FinanceApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceApi.class);

    @RestClient
    FinanceApiService financeApiService;

    @Tool(name = "getOrderHistory", description = "Retrieve a customer's order history based on their customer id.")
    public List<FinanceRecord> getOrderHistory(@ToolArg(description = "the customer id") String customerId) {
        LOGGER.info("getOrderHistory Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }

    @Tool(name = "getInvoiceHistory", description = "Retrieve a customer's invoice history based on their customer id.")
    public List<FinanceRecord> getInvoiceHistory(@ToolArg(description = "the customer id") String customerId) {
        LOGGER.info("getInvoiceHistory Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }

    @Tool(name = "startDuplicateChargeDispute", description = "Start the process to dispute a duplicate charge for a customer.")
    public List<FinanceRecord> startDuplicateChargeDispute(@ToolArg(description = "the customer id") String customerId) {
        LOGGER.info("startDuplicateChargeDispute Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }

    @Tool(name = "findMissingReceipt", description = "Start the process to find a lost receipt for a customer.")
    public List<FinanceRecord> findMissingReceipt(@ToolArg(description = "the customer id") String customerId) {
        LOGGER.info("findMissingReceipt Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }
}
