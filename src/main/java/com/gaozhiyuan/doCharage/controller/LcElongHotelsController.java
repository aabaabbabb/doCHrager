package com.gaozhiyuan.doCharage.controller;

import com.gaozhiyuan.doCharage.model.LcElongHotels;
import com.gaozhiyuan.doCharage.model.XdHotel;
import com.gaozhiyuan.doCharage.service.LcElongHotelsService;
import com.gaozhiyuan.doCharage.service.XdHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelInfo")
public class LcElongHotelsController {
    @Autowired
    private LcElongHotelsService lcElongHotelsService;
    @Autowired
    private XdHotelService xdHotelService;

    @GetMapping("/lc_hotel")
    public List<LcElongHotels> getLcHotels(
            @RequestParam String id,
            @RequestParam String businessZone) {
        return lcElongHotelsService.selectByIdAndBusinessZone(id, businessZone);
    }

    @GetMapping("/xd_hotel")
    public List<XdHotel> getXdHotels(  @RequestParam String businessZone){
        return xdHotelService.selectHotelBusinessIdAndTmpByHotelBusinessIdAndTmp(Integer.parseInt(businessZone), 1);
    }


    // http://127.0.0.1:8080/userinfo/123/roles/222
    @RequestMapping(value = "/userinfo/{userId}/roles/{roleId}", method = RequestMethod.GET)
    public String getLogin(@PathVariable("userId") String userId, @PathVariable("roleId") String roleId) {
        return "User Id : " + userId + " Role Id : " + roleId;
    }
}
