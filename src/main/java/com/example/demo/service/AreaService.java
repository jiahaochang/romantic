package com.example.demo.service;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaService {
    public List<Area> getAreaList();
    public Area getAreaById(int areaId);
    public boolean addArea(Area area);
    public boolean modifyArea(Area area);
    public boolean deleteArea(int areaId);
}
