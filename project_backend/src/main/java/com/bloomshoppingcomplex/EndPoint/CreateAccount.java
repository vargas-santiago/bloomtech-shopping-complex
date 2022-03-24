//package com.bloomshoppingcomplex.EndPoint;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.bloomshoppingcomplex.DynamoDB.AccountDao;
//import com.bloomshoppingcomplex.TableModel.request.CreateAccountRequest;
//import com.bloomshoppingcomplex.TableModel.result.CreateAccountResult;
//
//
//public class CreateAccount implements RequestHandler<CreateAccountRequest, > {
//    private final AccountDao accountDao;
//
//    public CreateAccount(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//
//    public CreateAccountResult handleRequest(final CreateAccountRequest createAccountRequest, Context context) {
//
//    }
//}