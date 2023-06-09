package com.decagon.dev.paybuddy.services;

import com.decagon.dev.paybuddy.dtos.requests.CreateTransactionPinDto;
import com.decagon.dev.paybuddy.dtos.requests.WithdrawalDto;
import com.decagon.dev.paybuddy.dtos.responses.WalletResponse;
import com.decagon.dev.paybuddy.dtos.responses.vtpass.request.BuyAirtimeRequest;
import com.decagon.dev.paybuddy.dtos.responses.vtpass.request.BuyDataPlanRequest;
import com.decagon.dev.paybuddy.dtos.responses.vtpass.response.data.*;
import com.decagon.dev.paybuddy.models.User;
import com.decagon.dev.paybuddy.restartifacts.BaseResponse;
import com.decagon.dev.paybuddy.services.paystack.payStackPojos.Bank;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface WalletService {
    WalletResponse getWalletBalance();
    ResponseEntity<String> fundWallet(BigDecimal bigDecimal, String transactionType);
    ResponseEntity<String> verifyPayment(String reference, String transactionType);
    BaseResponse updateWalletPin(CreateTransactionPinDto createTransactionPinDto);
    ResponseEntity<List<Bank>> getAllBanks();
    ResponseEntity<?> walletWithdrawal(WithdrawalDto withdrawalDto);
    ResponseEntity<String> verifyAccountNumber(String accountNumber, String bankCode);
    DataServicesResponse getDataServices();
    DataPlansResponse getDataPlans(String dataType);
    BuyDataPlanResponse buyDataPlan(BuyDataPlanRequest request, String pin);
    BuyAirtimeResponse buyAirtimeServices(BuyAirtimeRequest buyAirtimeRequest , String pin);

    AirtimeServiceResponse getAirtimeServices();
}
