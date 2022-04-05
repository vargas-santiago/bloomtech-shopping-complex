package com.bloomshoppingcomplex.auth;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service
public class UsersService {
    @Value(value = "${aws.cognito.userPoolId}")
    private String userPoolId;
    @Value(value = "${aws.cognito.clientId}")
    private String clientId;
    @Value(value = "${aws.cognito.region}")
    private String region;
    @Value(value = "${aws.access-key}")
    private String accessKey;
    @Value(value = "${aws.access-secret}")
    private String secretKey;

    public UserLoginResponsePayload processLogin(UserLoginRequestPayload userLoginRequestPayload) throws Exception {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        AWSCognitoIdentityProvider cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(region).build();
        UserLoginResponsePayload userLoginResponsePayload = new UserLoginResponsePayload();
        final Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", userLoginRequestPayload.getUserName());
        authParams.put("PASSWORD", userLoginRequestPayload.getPassword());
        final AdminInitiateAuthRequest authRequest = new AdminInitiateAuthRequest();
        authRequest.withAuthFlow(AuthFlowType.ADMIN_USER_PASSWORD_AUTH).withClientId(clientId)
                .withUserPoolId(userPoolId).withAuthParameters(authParams);
        try {
            AdminInitiateAuthResult result = cognitoClient.adminInitiateAuth(authRequest);
            AuthenticationResultType authenticationResult = null;
            if (result.getChallengeName() != null && !result.getChallengeName().isEmpty()) {
                System.out.println("Challenge Name is " + result.getChallengeName());

                cognitoClient.shutdown();
                return userLoginResponsePayload;
            } else {
                System.out.println("User has no challenge");
                authenticationResult = result.getAuthenticationResult();
                userLoginResponsePayload.setAccessToken(authenticationResult.getAccessToken());
                userLoginResponsePayload.setRefreshToken(authenticationResult.getRefreshToken());
                cognitoClient.shutdown();
                return userLoginResponsePayload;
            }
        } catch (InvalidParameterException e) {
            cognitoClient.shutdown();
            throw new Exception(e.getErrorMessage());
        } catch (Exception e) {
            cognitoClient.shutdown();
            throw new Exception(e.getMessage());
        }
    }
}