package com.vehicle.vss.service;

import com.vehicle.vss.entity.Image;
import com.vehicle.vss.entity.Vehicle;
import com.vehicle.vss.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(String title) {
        if (title!=null)
            return vehicleRepository.findByName(title);
        return vehicleRepository.findAll();
    }

    public Vehicle getById(Integer id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public void createVehicle(Vehicle vehicle, MultipartFile file1, MultipartFile file2, MultipartFile file3) {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize()!=0){
            image1=toImageEntity(file1);
            image1.setPreviewImage(true);
            vehicle.addImageToVehicle(image1);
        }
        if (file2.getSize()!=0){
            image2=toImageEntity(file2);
            image2.setPreviewImage(true);
            vehicle.addImageToVehicle(image2);
        }
        if (file3.getSize()!=0){
            image3=toImageEntity(file3);
            image3.setPreviewImage(true);
            vehicle.addImageToVehicle(image3);
        }
        Vehicle vehicleFromDB = vehicleRepository.save(vehicle);
        vehicleFromDB.setPreviewImageId(vehicle.getImages().get(0).getId());
        vehicleRepository.save(vehicleFromDB);
    }

    private Image toImageEntity(MultipartFile file){
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        try {
            image.setBytes(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
