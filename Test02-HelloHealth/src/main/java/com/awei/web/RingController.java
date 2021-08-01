package com.awei.web;

import com.awei.doman.Ring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description:
 * @Author: Awei
 * @Create: 2021-04-06 15:23
 **/
@Controller
public class RingController {

    @GetMapping("/showDeviceInfo")
    public @ResponseBody
    Ring showInfo(Integer id) {
        Ring ring = new Ring();
        ring.setNo(id);
        ring.setCanbeUse(true);
        ring.setDatetime(new Date());
        ring.setRemark("");
        ring.setRepository("湖北");
        ring.setPhoNum("13647169672");
        ring.setUseing(false);
        ring.setVersion("1.0.0");

        return ring;
    }

    @RequestMapping("/error")
    public @ResponseBody String error() {
        return "hello";
    }
}
