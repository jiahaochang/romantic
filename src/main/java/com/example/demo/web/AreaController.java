package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
/*@Controller
@ResponseBody
等同于两个注解的组合*/
@RequestMapping("/superadmin") //根路由
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method=RequestMethod.GET)
    private Map<String, Object> listArea(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @GetMapping(value = "/getareabyid")
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("areaList",area);
        return modelMap;
    }

    @PostMapping(value = "addarea")
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @PostMapping(value = "modifyarea")
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @GetMapping(value = "removearea")
    private Map<String,Object> removeArea(Integer areaid){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaService.deleteArea(areaid));
        return modelMap;
    }
}
