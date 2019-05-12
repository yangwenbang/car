package com.car.modules.car.controller;

import com.car.common.utils.ExcelUtils;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.R;
import com.car.common.utils.StringUtil;
import com.car.modules.car.entity.ExerciseContentEntity;
import com.car.modules.oss.cloud.OSSFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("car/file")
public class FileUploadController {

    @RequestMapping("/upload")
    public R save(MultipartHttpServletRequest request) throws IOException {
        MultipartFile file = request.getFile("file");
        if (file != null && !file.isEmpty()) {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);
            if (StringUtil.hasValue(url)) {
                return R.ok().put("url", url);
            } else {
                return R.error("上传失败");
            }
        }
        else{
            return R.error("未选中任何文件");
        }
    }


    @RequestMapping("/read/excel")
    public R readExcel(MultipartHttpServletRequest request) throws IOException {
        MultipartFile file = request.getFile("file");
        if (file != null && !file.isEmpty()) {
            String[][] result = ExcelUtils.read(file);
            return R.ok().put("list", result);
        }
        else{
            return R.error("文件异常");
        }
    }

}
