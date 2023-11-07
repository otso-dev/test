package com.smalleats.controller;


import com.smalleats.DTO.user.UserAddressReqDto;
import com.smalleats.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserAddressController {
    private final UserAddressService userAddressService;

    @RequestMapping(value = "/user/address/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> userAddressInsert(@RequestBody UserAddressReqDto userAddressReqDto){
        return ResponseEntity.ok(userAddressService.UserAddressInsert(userAddressReqDto));
    }

    @RequestMapping(value = "/user/address", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserAddressList(Model model){
        return ResponseEntity.ok(model.addAttribute("userAddressList",userAddressService.getUserAddressList()));
    }

    @RequestMapping(value = "/user/address/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> userAddressUpdate(@RequestBody UserAddressReqDto userAddressReqDto){
        return ResponseEntity.ok(userAddressService.UserAddressUpdate(userAddressReqDto));
    }
    @RequestMapping(value = "/user/address/delete/{userAddressId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> userAddressDelete(@PathVariable int userAddressId){
        return ResponseEntity.ok(userAddressService.userAddressDelete(userAddressId));
    }

    @RequestMapping(value = "user/address/default", method = RequestMethod.PUT)
    public ResponseEntity<?> userAddressDefault(@RequestBody Map<String,Integer> requestMap){
        return ResponseEntity.ok(userAddressService.userAddressDefault(requestMap));
    }
}
