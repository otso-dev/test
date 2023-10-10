package com.smalleats.controller;


import com.smalleats.DTO.user.UserAddressReqDto;
import com.smalleats.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
