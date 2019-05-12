package com.car.modules.car.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.exception.RRException;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.ExerciseContentEntity;
import com.car.modules.car.entity.ExerciseTypeEntity;
import com.car.modules.car.entity.SectionEntity;
import com.car.modules.car.entity.vo.IdVo;
import com.car.modules.car.service.ExerciseContentService;
import com.car.modules.car.service.ExerciseTypeService;
import com.car.modules.car.service.SectionService;
import com.car.modules.oss.cloud.OSSFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
@RestController
@RequestMapping("car/exercisecontent")
public class ExerciseContentController {
    private static final Logger log = LoggerFactory.getLogger(ExerciseContentController.class);

    List<ExerciseContentEntity> ExerciseContentList = new ArrayList<ExerciseContentEntity>();
    String errinfo = "";
    @Autowired
    private ExerciseContentService exerciseContentService;
    @Autowired
    private ExerciseTypeService exerciseTypeService;
    @Autowired
    private SectionService sectionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        /*PageUtils page = exerciseContentService.queryPage(params);*/
        PageUtils page = exerciseContentService.strengSelectPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R listByCondition(@RequestBody String data) {
//        Set<Object>
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = exerciseContentService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Access-Control");
        response.setHeader("Allow", "POST");
        ExerciseContentEntity exerciseContent = exerciseContentService.selectById(id);
        return R.ok().put("exerciseContent", exerciseContent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data) {
        ExerciseContentEntity exerciseContentEntity = JsonUtils.readValue(data, ExerciseContentEntity.class);
        ValidatorUtils.validateEntity(exerciseContentEntity);
        if (exerciseContentEntity.getId() == null || exerciseContentEntity.getId() == 0) {
            exerciseContentEntity.setCreateDate(new Date());
            exerciseContentEntity.setUpdateTime(new Date());
            exerciseContentService.insert(exerciseContentEntity);
        } else {
            exerciseContentEntity.setUpdateTime(new Date());
            exerciseContentService.updateAllColumnById(exerciseContentEntity);//全部更新
        }
        Integer count = exerciseContentService.selectCount(new EntityWrapper<ExerciseContentEntity>().eq("section_id", exerciseContentEntity.getSectionId()));
        SectionEntity sectionEntity = sectionService.selectById(exerciseContentEntity.getSectionId());
        sectionEntity.setExerciseCount(count);
        sectionService.updateAllColumnById(sectionEntity);
        return R.ok();
    }


    @RequestMapping("/save/patch")
    public R patchSave(@RequestBody String data) {
        List<ExerciseContentEntity> exerciseContentEntities = JsonUtils.readValueByList(data, ExerciseContentEntity.class);
        if (exerciseContentEntities != null && exerciseContentEntities.size() > 0) {
            for (ExerciseContentEntity item : exerciseContentEntities) {
                String optionss = item.getOptionss();
                optionss = optionss.replaceAll(" ", "");
                item.setOptionss(optionss);
            }
            for (ExerciseContentEntity item : exerciseContentEntities) {
                item.setUpdateTime(new Date());
            }
            exerciseContentService.insertOrUpdateBatch(exerciseContentEntities);

            Integer count = exerciseContentService.selectCount(new EntityWrapper<ExerciseContentEntity>().eq("section_id", exerciseContentEntities.get(0).getSectionId()));
            SectionEntity sectionEntity = sectionService.selectById(exerciseContentEntities.get(0).getSectionId());
            sectionEntity.setExerciseCount(count);
            sectionService.updateAllColumnById(sectionEntity);
        }
        return R.ok();
    }


    @RequestMapping("/clean")
    public R clean() {
        List<ExerciseContentEntity> exerciseContentEntities = exerciseContentService.selectList(new EntityWrapper<ExerciseContentEntity>());
        int i = 0;
        for (ExerciseContentEntity item : exerciseContentEntities) {
            item.setExerciseContent(item.getExerciseContent().replaceAll("\r\n", ""));
            item.setAnswerAnalysis(item.getAnswerAnalysis().replaceAll("\r\n", ""));
            item.setOptionss(item.getOptionss().replaceAll("\r\n", ""));
            item.setRightAnswer(item.getRightAnswer().replaceAll("\r\n", ""));


            item.setExerciseContent(item.getExerciseContent().replaceAll("\n", ""));
            item.setAnswerAnalysis(item.getAnswerAnalysis().replaceAll("\n", ""));
            item.setOptionss(item.getOptionss().replaceAll("\n", ""));
            item.setRightAnswer(item.getRightAnswer().replaceAll("\n", ""));

            item.setExerciseContent(item.getExerciseContent().replaceAll("\r", ""));
            item.setAnswerAnalysis(item.getAnswerAnalysis().replaceAll("\r", ""));
            item.setOptionss(item.getOptionss().replaceAll("\r", ""));
            item.setRightAnswer(item.getRightAnswer().replaceAll("\r", ""));

            exerciseContentService.updateAllColumnById(item);
            i++;
            System.out.println("count:" + i);
        }
        List<ExerciseContentEntity> xexerciseContentEntities = exerciseContentService.selectList(new EntityWrapper<ExerciseContentEntity>());
        return R.ok().put("list", xexerciseContentEntities);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(MultipartHttpServletRequest request) throws IOException {
        String exerciseContent = request.getParameter("exerciseContent");
        if (!(exerciseContent != null && !exerciseContent.isEmpty())) {
            return R.error("更新失败");
        }
        ExerciseContentEntity exerciseContentEntity = JSON.parseObject(exerciseContent, ExerciseContentEntity.class);
        MultipartFile contentImg = request.getFile("contentImg");
        if (contentImg != null && !contentImg.isEmpty()) {
            String suffix = contentImg.getOriginalFilename().substring(contentImg.getOriginalFilename().lastIndexOf("."));
            String url = OSSFactory.build().uploadSuffix(contentImg.getBytes(), suffix);
            if (suffix != null && url != null && !suffix.isEmpty() && !url.isEmpty()) {
                exerciseContentEntity.setExerciseContentPicture(url);
            }
        }
        MultipartFile answerImg = request.getFile("answerImg");
        if (answerImg != null && !answerImg.isEmpty()) {
            String suffix = answerImg.getOriginalFilename().substring(answerImg.getOriginalFilename().lastIndexOf("."));
            String url = OSSFactory.build().uploadSuffix(answerImg.getBytes(), suffix);
            if (suffix != null && url != null && !suffix.isEmpty() && !url.isEmpty()) {
                exerciseContentEntity.setExerciseAnswerPicture(url);
            }
        }
        String answer = exerciseContentEntity.getRightAnswer();
        if (answer != null && !answer.equals("")) {
            answer = answer.toUpperCase();
            char arr[] = answer.toCharArray();
            Arrays.sort(arr);
            answer = "";
            for (int i = 0; i < arr.length; i++) {
                answer += arr[i];
            }
            exerciseContentEntity.setRightAnswer(answer);
        }
        exerciseContentEntity.setUpdateTime(new Date());
        ValidatorUtils.validateEntity(exerciseContentEntity);
        exerciseContentService.updateAllColumnById(exerciseContentEntity);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String data) {
        IdVo idVo = JsonUtils.readValue(data, IdVo.class);
        exerciseContentService.deleteById(idVo.getId());
        return R.ok();
    }

    @RequestMapping("/upload/{id}")
    public R upload(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws Exception {
        if (file == null) {
            throw new RRException("上传文件不能为空");
        }
        File f = null;
        try {
            //获取一个绝对地址的流
            InputStream ins = file.getInputStream();
            f = new File(file.getOriginalFilename());
            inputStreamToFile(ins, f);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("格式出错");
        }
        errinfo = "";
        getDataFromExcel(f, id);
        return R.ok("导入成功的数据编号为" + errinfo);
    }

    public Object getRightTypeCell(Cell cell) {

        Object object = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: {
                object = cell.getStringCellValue();
                break;
            }
            case Cell.CELL_TYPE_NUMERIC: {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object = cell.getNumericCellValue();
                break;
            }

            case Cell.CELL_TYPE_FORMULA: {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object = cell.getNumericCellValue();
                break;
            }

            case Cell.CELL_TYPE_BLANK: {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
                object = cell.getStringCellValue();
                break;
            }
        }
        return object;
    }

    public void getDataFromExcel(File file, Long id) {
        List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
        FileInputStream fis = null;
        Workbook wookbook = null;
        int flag = 0;
        try {
            fis = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿
        } catch (Exception ex) {
            try {
                //2007版本的excel，用.xlsx结尾
                wookbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //得到一个工作表
        Sheet sheet = wookbook.getSheetAt(0);
        //获得表头
        Row rowHead = sheet.getRow(2);
        //根据不同的data放置不同的表头
        Map<Object, Integer> headMap = new HashMap<Object, Integer>();
        if (rowHead.getPhysicalNumberOfCells() != 7) {
            log.error("表头列数与要导入的数据库不对应");
            throw new RRException("表头列数与要导入的数据库不对应");
        }
        while (flag < 7) {
            Cell cell = rowHead.getCell(flag);
            switch (getRightTypeCell(cell).toString()) {
                case "题型":
                    break;
                case "分数":
                    break;
                case "题目内容":
                    break;
                case "可选项":
                    break;
                case "答案":
                    break;
                case "答案解析":
                    break;
                case "备注":
                    break;
                default: {
                    System.out.println("表头不合规范，请修改后重新导入");
                    throw new RRException("表头不合规范，请修改后重新导入");
                }
            }
            flag++;
        }
        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum() - 2;
        if (0 == totalRowNum) {
            log.error("Excel内没有数据！");
            throw new RRException("Excel内没有数据！");
        }
        int headRow = 3;
        int c = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[totalRowNum][c];
        for (int i = headRow; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < c; j++) {
                Cell cell = null;
                try {
                    cell = row.getCell(j);
                    // 读字符串数据
                    if ((j == 0) || (j >= 2 && j <= 6)) {
                        data[i - headRow][j] = cell.getStringCellValue();
                        // 读数字数据
                    } else if (j == 1) {
                        try {
                            data[i - headRow][j] = cell.getNumericCellValue();
                        } catch (Exception e) {
                            data[i - headRow][j] = cell.getStringCellValue();
                        }
                    }

                } catch (Exception e) {
                    System.out.println("i=" + i + ";j=" + j + ":"
                            + e.getMessage());
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                log.info(data[i][j] + "\t");
            }
            log.info("");
        }
        importExcel(data, id);
    }

    public void importExcel(Object[][] data, Long id) {
        int row = data.length;
        int col = 0;// data[0].length;
        SectionEntity sectionEntity = sectionService.selectById(id);
        List<ExerciseTypeEntity> exerciseList = exerciseTypeService.selectList(new EntityWrapper<ExerciseTypeEntity>());
        if (exerciseList.size() <= 0) {
            throw new RRException("找不到该节课程对应的题型，导入失败。");
        }

        String[] stitle = {"题型", "分数", "题目内容", "可选项", "答案", "答案解析", "备注"};
        for (int i = 0; i < row; i++) {
            ExerciseContentEntity single = new ExerciseContentEntity();
            single.setSectionId(id);
            try {
                col = 0;
                String exerciseModel = data[i][col++].toString();
                boolean bok = false;
                for (int k = 0; k < exerciseList.size(); k++) {
                    ExerciseTypeEntity exer = exerciseList.get(k);
                    if (exer.getExerciseName().equals(exerciseModel)) {
                        single.setExerciseTypeId(exer.getId());
                        bok = true;
                        break;
                    }
                }
                if (!bok) {
                    errinfo += "第" + (i + 1) + "行," + stitle[col] + "数据有误;";
                    continue;
                }

                try {
                    int t = (int) Double.parseDouble(data[i][col++].toString());
                    single.setScore(t);
                } catch (Exception e) {
                    errinfo += "第" + (i + 1) + "行," + stitle[col] + "数据有误;";
                    continue;
                }
                single.setExerciseContent(data[i][col++].toString());
                single.setOptionss(data[i][col++].toString());

                String answer = data[i][col++].toString();
                answer = answer.toUpperCase();
                char arr[] = answer.toCharArray();
                Arrays.sort(arr);
                answer = "";
                for (int s = 0; s < arr.length; s++) {
                    answer += arr[s];
                }
                single.setRightAnswer(answer);
                single.setAnswerAnalysis(data[i][col++].toString());
                single.setRemark(data[i][col].toString());
                single.setUpdateTime(new Date());
                single.setCreateDate(new Date());
                exerciseContentService.insert(single);
                errinfo += i + ",";
            } catch (Exception e) {
                errinfo += "第" + (i + 1) + "行," + stitle[col] + "数据有误;";
                System.out.print("第" + i + "行," + col + "列数据有误;");
                System.out.println("错误数据=" + data[i][col]);
                e.printStackTrace();
            }
        }
        errinfo += ",数据导入结束!";
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/listExerciseType/{sectionId}")
    public R listExerciseType(@PathVariable("sectionId") Long sectionId) {
        SectionEntity sectionEntity = sectionService.selectById(sectionId);
        List<ExerciseTypeEntity> exerciseTypeList = exerciseTypeService.selectList(new EntityWrapper<ExerciseTypeEntity>());
        return R.ok().put("exerciseTypeList", exerciseTypeList);
    }
}
