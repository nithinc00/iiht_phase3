//package com.sgproj.eauction.controllers;
//
//import com.sgproj.eauction.entities.AuctionItem;
//import com.sgproj.eauction.entities.User;
//import com.sgproj.eauction.services.AuctionService;
//import com.sgproj.eauction.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//
//public class UserController {
//    final String CLIENT_ID = "381472079955-jah68q207j1o6hpsevb4u3niqc79ud81.apps.googleusercontent.com";
//    final String CLIENT_SECRET = "K8f5M0PIq6PvubQYUWgwarh2";
//
//    final String passwordSalt = "keyboard-kitten";
//
//    @Autowired
//    private UserService userService;
//
//    @Resource(name="authenticationManager")
//    private AuthenticationManager authManager;
//
//    @PostMapping("/storeauthcode")
//    public String storeauthcode(@RequestBody String code, @RequestHeader("X-Requested-With") String encoding, HttpServletRequest req) {
//        if(encoding == null || encoding.isEmpty()) {
//            return "Error, wrong headers";
//        }
//        GoogleTokenResponse tokenResponse = null;
//        try {
//            tokenResponse = new GoogleAuthorizationCodeTokenRequest(
//                    new NetHttpTransport(),
//                    JacksonFactory.getDefaultInstance(),
//                    "https://www.googleapis.com/oauth2/v4/token",
//                    CLIENT_ID,
//                    CLIENT_SECRET,
//                    code,
//                    "http://localhost:9000")
//                    .execute();
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        String accessToken = tokenResponse.getAccessToken();
//        String refreshToken = tokenResponse.getRefreshToken();
//        Long expiresAt = System.currentTimeMillis() + (tokenResponse.getExpiresInSeconds() * 5000);
//
//        GoogleIdToken idToken = null;
//        try {
//            idToken = tokenResponse.parseIdToken();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        GoogleIdToken.Payload payload = idToken.getPayload();
//
//        String userId = payload.getSubject();
//
//        String email = payload.getEmail();
//        boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
//        String name = (String) payload.get("name");
//        String pictureUrl = (String) payload.get("picture");
//        String locale = (String) payload.get("locale");
//        String familyName = (String) payload.get("family_name");
//        String givenName = (String) payload.get("given_name");
//
//        String password = email + passwordSalt + userId;
//        userService.registerUser(name, email, pictureUrl, password);
//        securityLogin(email, password, req);
//        return "OK";
//
//    }
//
//    @GetMapping("/currentuser")
//    public ResponseEntity<User> currentUser() {
//        User user = userService.findCurrentUser();
//        if(user == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("/auth/user")
//    public User getUser(){
//        return userService.findCurrentUser();
//    }
//
//    @PostMapping("/auth/register")
//    public ResponseEntity<User> register(@RequestBody User user){
//        var newuser = userService.registerUser(user.getName(), user.getEmail(), user.getPictureUrl(), user.getPassword());
//        return ResponseEntity.ok(newuser);
//    }
//
//    private void securityLogin(String email, String password, HttpServletRequest req) {
//        UsernamePasswordAuthenticationToken authReq
//                = new UsernamePasswordAuthenticationToken(email, password);
//        Authentication auth = authManager.authenticate(authReq);
//
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(auth);
//        HttpSession session = req.getSession(true);
//        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
//    }
//}
