//package com.nhnacademy.springboot.gatewayserver.adaptor;
//
//import com.nhnacademy.springboot.gatewayserver.domain.MemberDetailsDto;
//import com.nhnacademy.springboot.gatewayserver.domain.MemberRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.client.RestTemplate;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberAdaptorImpl implements MemberAdaptor{
//    private final RestTemplate restTemplate;
//
//    @Override
//    public MemberDetailsDto findUserDetails(String username) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "application/json");
//
//        HttpEntity<MemberDetailsDto> httpEntity = new HttpEntity<>(headers);
//
//        ResponseEntity<MemberDetailsDto> member = restTemplate.exchange("http://localhost:8081/member/" + username,
//            HttpMethod.GET,
//            httpEntity,
//            MemberDetailsDto.class);
//
//        return member.getBody();
//    }
//
//    @Override
//    public MemberDetailsDto insertMember(MemberRequest memberRequest) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "application/json");
//
//        HttpEntity<MemberRequest> httpEntity = new HttpEntity<>(headers);
//
//        ResponseEntity<MemberDetailsDto> member = restTemplate.postForEntity("http://localhost:8081/member",
//            memberRequest,
//            MemberDetailsDto.class);
//
//        return member.getBody();
//    }
//}
