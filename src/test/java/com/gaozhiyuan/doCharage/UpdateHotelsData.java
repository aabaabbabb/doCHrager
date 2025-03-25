package com.gaozhiyuan.doCharage;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gaozhiyuan.doCharage.mapper.primary.*;
import com.gaozhiyuan.doCharage.model.*;
import com.gaozhiyuan.doCharage.service.ShuipfHotelquyuGdHotelYejiService;
import com.gaozhiyuan.doCharage.service.impl.ShuipfHotelquyuGdHotelYejiServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class UpdateHotelsData {

    @Autowired
    private GdEbookingEmployeeHotelMapper gdEbookingEmployeeHotelMapper;
    @Autowired
    private XdHotelMapper xdHotelMapper;
    @Autowired
    private GdEbookingHotelsMapper gdEbookingHotelsMapper;
    @Autowired
    private XdHotelExpandMapper xdHotelExpandMapper;
    @Autowired
    private ShuipfHotelquyuGdHotelYejiMapper shuipfHotelquyuGdHotelYejiMapper;

    @Autowired
    private ShuipfHotelquyuGdHotelMapper shuipfHotelquyuGdHotelMapper;

    @Autowired
    private XdAdminMapper xdAdminMapper;
    @Autowired
    private GdHotelMapper gdHotelMapper;

    @Test
    public void executionTest() {
        List<ShuipfHotelquyuGdHotel> gdEbookingEmployeeHotels = selectData();
        System.out.println("查询到数据：" + gdEbookingEmployeeHotels.size());
        // 更新数据
        doUpdate(gdEbookingEmployeeHotels);
        log.info("更新结束");
    }

    private List<ShuipfHotelquyuGdHotel> selectData() {
        return shuipfHotelquyuGdHotelMapper.selectByUpdatetimeBetweenAndIsUpdate(1704038400, 1742471009, 1);
    }

    private void doUpdate(List<ShuipfHotelquyuGdHotel> dataList) {
        int logCounter = 1; // 初始化计数器
        for (ShuipfHotelquyuGdHotel shuipfHotelquyuGdHotel : dataList) {
            String elongHotelId = shuipfHotelquyuGdHotel.getEid();
            Integer userid = shuipfHotelquyuGdHotel.getCuruserid();
            if(userid == 0){
                log.info("第{}条---eid：{}---eid为：{}，userid为空，进入下一条", logCounter,elongHotelId,elongHotelId);
                shuipfHotelquyuGdHotelMapper.updateIsUpdateById(2, shuipfHotelquyuGdHotel.getId());
                logCounter++;
                continue;
            }
            XdAdmin xdAdmin = xdAdminMapper.selectById(userid);
            if (xdAdmin == null) {
                log.info("第{}条---eid：{}---eid为：{}，user为空，进入下一条", logCounter,elongHotelId,elongHotelId);
                shuipfHotelquyuGdHotelMapper.updateIsUpdateById(2, shuipfHotelquyuGdHotel.getId());
                logCounter++;
                continue;
            }
            Integer tid = xdAdmin.getTid();
            if(tid == null){
                tid = 0;
            }
            XdHotel xdHotel = xdHotelMapper.selectByEid(elongHotelId);
            if (xdHotel != null) {
                Integer hotelId = xdHotel.getId();
                String hotelName = xdHotel.getName();
                XdHotelExpand xdHotelExpand = xdHotelExpandMapper.selectByHid(hotelId.longValue());
                if (xdHotelExpand != null) {
                    if(xdHotelExpand.getAid()>0){
                        log.info("第{}条---eid：{}---eid为：{}，xdHotelExpand.getAid不为空，进入下一条", logCounter,elongHotelId,elongHotelId);
                        shuipfHotelquyuGdHotelMapper.updateIsUpdateById(2, shuipfHotelquyuGdHotel.getId());
                        logCounter++;
                        continue;
                    }
                    long getUpdateTimeMillis = shuipfHotelquyuGdHotel.getCreatetime();
                    long getUpdateTimeSeconds = getUpdateTimeMillis / 1000;
                    if (xdHotelMapper.updateIsOpenXdjAndActivationTimeById(2, (int) getUpdateTimeSeconds, hotelId) > 0) {
                        xdHotelExpand.setAid(userid);
                        xdHotelExpand.setTid(tid);
                        // 将 BigDecimal 转换为 double
                        double commissionRateDouble = 10.00;
                        // 将值乘以100
                        BigDecimal result = new BigDecimal(commissionRateDouble * 100);
                        // 设置保留2位小数，使用四舍五入
                        result = result.setScale(2, RoundingMode.HALF_UP);
                        xdHotelExpand.setExpandBrokerage(result);
                        if (xdHotelExpandMapper.updateAidAndAdjustmentModeAndConfirmaModeAndGidAndExpandBrokerageById(
                                xdHotelExpand.getAid(),
                                xdHotelExpand.getExpandBrokerage(),
                                xdHotelExpand.getTid(),
                                xdHotelExpand.getId()
                        ) > 0) {
                            shuipfHotelquyuGdHotelMapper.updateIsUpdateById(2, shuipfHotelquyuGdHotel.getId());
                            log.info("第{}条日志：通过id更新XdHotelExpand成功: {}", logCounter, xdHotelExpand.getId());
                        } else {
                            log.info("第{}条日志：通过id更新XdHotelExpand失败: {}", logCounter, xdHotelExpand.getId());
                        }
                    }
                } else {
                    log.info("第{}条日志：xdHotelExpand为空开始插入hotelId: {}，艺龙ID：{}", logCounter,hotelId,elongHotelId);
                    long getUpdateTimeMillis = shuipfHotelquyuGdHotel.getCreatetime();
                    long getUpdateTimeSeconds = getUpdateTimeMillis / 1000;
                    GdHotel gdHotel = gdHotelMapper.selectOneByElongid(elongHotelId);
                    Long gdId = 0L;
                    if(gdHotel!=null){
                        gdId = gdHotel.getId();
                    }
                    List<XdHotelExpand> list = new ArrayList<>();
                    xdHotelExpand = new XdHotelExpand();
                    xdHotelExpand.setHid(hotelId.longValue());
                    xdHotelExpand.setSid(0L);
                    xdHotelExpand.setXid(0L);
                    xdHotelExpand.setGid(gdId);
                    xdHotelExpand.setTcid(0L);
                    xdHotelExpand.setFid(0L);
                    xdHotelExpand.setBid(0L);
                    xdHotelExpand.setDlid(0);
                    xdHotelExpand.setAid(userid);
                    xdHotelExpand.setTid(tid);
                    xdHotelExpand.setOperatorId(259);
                    xdHotelExpand.setCreateTime((int) getUpdateTimeSeconds);
                    xdHotelExpand.setAlterTime((int) getUpdateTimeSeconds);
                    xdHotelExpand.setBalance(BigDecimal.valueOf(0));
                    list.add(xdHotelExpand);
                    xdHotelExpandMapper.insertAll(list);

                    if (xdHotelMapper.updateIsOpenXdjAndActivationTimeById(2, (int) getUpdateTimeSeconds, hotelId) > 0) {
                        shuipfHotelquyuGdHotelMapper.updateIsUpdateById(2, shuipfHotelquyuGdHotel.getId());
                        log.info("第{}条日志：通过Hid更新XdHotel成功: {}", logCounter,hotelId);
                    }
                }
            }
            logCounter++; // 每次循环结束后递增计数器
        }
    }

//    private List<GdEbookingEmployeeHotel> queryData() {
//        log.info("开始查询数据");
//        // 获取数据
//        List<Integer> roleIdList = new ArrayList<>();
//        roleIdList.add(3);
//        roleIdList.add(4);
//
//        List<GdEbookingEmployeeHotel> gdEbookingEmployeeHotels = gdEbookingEmployeeHotelMapper.selectElongHotelIdByRoleIdIn(roleIdList);
//
//        log.info("结束查询数据条数：{}", gdEbookingEmployeeHotels.size());
//        return gdEbookingEmployeeHotels;

    //    },
    public static void main(String[] args) {
//
//                        $row['id'],
//				        $row['withdraw_subject'],
//				        $row['pay_channels_name'],
//				        $row['hotel_name'],
//				        number_format((float)$row['cash_out_price'], 2, '.', ''),
//	                    $row['account_name'],
//				        $row['account_number'],
//				        $row['full_bank_name'],
//				        $row['alipay_account_name'],
//				        $row['alipay_account'],
//				        $row['status_text'],
//				        $row['create_time'],
//				        $row['pay_time'],
//
//
//			        $row['payee_name'], //'type' => DataType::TYPE_STRING], // 收款方名称（文本）
//			        $row['payee_account'], //'type' => DataType::TYPE_STRING], // 收款方账号（文本）
//			        $row['bank_name'], //'type' => DataType::TYPE_STRING], // 收款方开户行名称（文本）
//			        $row['bank_union_code'], //'type' => DataType::TYPE_STRING], // 收款行联行号（文本）
//			        number_format((float)$row['cash_out_price'], 2, '.', ''), //'type' => DataType::TYPE_NUMERIC, 'format' => NumberFormat::FORMAT_NUMBER_00], // **金额，保留两位小数**
//			        $row['withdraw_subject'], //'type' => DataType::TYPE_STRING], // 提现状态（文本）


        int[] array1 = {218,259,263,305, 329,343,349,389,
                405,
                407,
                410,
                416,
                432,
                445,
                450,
                453,
                454,
                455,
                456,
                462,
                463,
                467,
                468,
                469,
                471,
                472,
                478,
                480,
                487,
                494,
                498,
                499,
                500,
                501,
                445114,
                445117,
                445118,
                445190,
                445191,
                445193,
                445236,
                445243,
                445248,
                445251,
                445252,
                445255};

        int[] array2 ={
                128,
                218,
                259,
                263,
                305,
                312,
                324,
                329,
                335,
                341,
                343,
                347,
                349,
                350,
                374,
                389,
                394,
                395,
                396,
                405,
                407,
                410,
                413,
                416,
                432,
                433,
                434,
                441,
                443,
                445,
                448,
                450,
                453,
                454,
                455,
                456,
                458,
                459,
                462,
                463,
                467,
                468,
                469,
                471,
                472,
                474,
                478,
                480,
                481,
                487,
                494,
                498,
                499,
                500,
                501,
                888,
                445114,
                445117,
                445118,
                445130,
                445131,
                445140,
                445175,
                445183,
                445187,
                445190,
                445191,
                445193,
                445236,
                445243,
                445248,
                445251,
                445252,
                445255,
        };
        // 转换数组为 Set
        Set<Integer> set1 = IntStream.of(array1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = IntStream.of(array2).boxed().collect(Collectors.toSet());

        // 计算 array1 - array2（仅在 array1 中存在）
        Set<Integer> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);

        // 计算 array2 - array1（仅在 array2 中存在）
        Set<Integer> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);

        // 计算对称差集（两个数组的总差异）
        Set<Integer> totalDifference = new HashSet<>(diff1);
        totalDifference.addAll(diff2);

        // 输出结果
        System.out.println("array1 中有但 array2 没有的元素: " + diff1);
        System.out.println("array2 中有但 array1 没有的元素: " + diff2);
        System.out.println("两个数组的差异（对称差集）: " + totalDifference);
    }




}
