package com.hgc.cryptotest.controller;

import com.hgc.cryptotest.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/util")
@RequiredArgsConstructor
public class CryptoController {
    private final CryptoService cryptoService;

    @RequestMapping(value = "/crypto", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String getCrypto() {
        return "crypto/crypto";
    }

    @RequestMapping(value = "/crypto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String postCrypto(
            @RequestParam(value = "option") String option,
            @RequestParam(value = "inputText") String inputText,
            @RequestParam(value = "toUpper") boolean toUpper
    ) {
        JSONObject response = new JSONObject();
        String result = this.cryptoService.textToHash(inputText,option);
        System.out.println("result:"+result);
        if(result.equals("retry") ){
            response.put("status", "FAIL");
            response.put("result", "실패");
        }else{
            response.put("status", "SUCCESS");
            if (toUpper) {
                response.put("result",result.toUpperCase());
            }else{
                response.put("result", result);
            }
        }
        return response.toString();
    }

}
