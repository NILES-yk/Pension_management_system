package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/*
 * @author Wang Yanchen
 * @date 2025/06/23/09:06:15
 * @description 客户信息VO类
 */
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="CustomerInfoVo类",description = "这是CustomerInfoVo类")
public class CustomerInfoVo{
    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value="客户姓名")
    @TableField(value="customer_name")
    private String customerName;

    @ApiModelProperty(value="客户年龄")
    @TableField(value="customer_age")
    private Integer customerAge;

    @ApiModelProperty(value="客户性别 0：男  1：女")
    @TableField(value="customer_sex")
    private Integer customerSex;

    @ApiModelProperty(value="身份证号")
    @TableField(value="id_card")
    private String idCard;

    @ApiModelProperty(value="房间编号")
    @TableField(value="room_no")
    private String roomNo;

    @ApiModelProperty(value="所属楼房")
    @TableField(value="building_no")
    private String buildingNo;

    @ApiModelProperty(value="入住时间")
    @TableField(value="checkin_name")
    private Date checkinDate;

    @ApiModelProperty(value="合同到期时间")
    @TableField(value="expiration_name")
    private Date expirationDate;

    @ApiModelProperty(value="联系电话")
    @TableField(value="contact_tel")
    private String contactTel;

    @ApiModelProperty(value="床号")
    @TableField(value="bed_id")
    private Integer bedId;

    @ApiModelProperty(value="身心状况")
    @TableField(value="psychosomatics_state")
    private String psychosomaticState;

    @ApiModelProperty(value="注意事项")
    @TableField(value="attention")
    private String attention;

    @ApiModelProperty(value="出生日期")
    @TableField(value="birthday")
    private Date birthday;

    @ApiModelProperty(value="身高")
    @TableField(value="height")
    private String height;

    @ApiModelProperty(value="体重")
    @TableField(value="weight")
    private String weight;

    @ApiModelProperty(value="血型")
    @TableField(value="blood_type")
    private String bloodType;

    @ApiModelProperty(value="头像路径")
    @TableField(value="file_path")
    private String filePath;

    @ApiModelProperty(value="关联系统健康管家(护工)  无管家设置  -1")
    @TableField(value="user_id")
    private Integer userId;

    @ApiModelProperty(value="护理等级")
    @TableField(value="level_id")
    private Integer levelId;

    @ApiModelProperty(value="家属")
    @TableField(value="family_member")
    private String familyMember;

    //其他字段:NurseLevel+User+Bed
    @ApiModelProperty(value="健康管家真实姓名")
    @TableField(value="nickname")
    private String nickName;

    @ApiModelProperty(value="护理级别")
    @TableField(value="level_name")
    private String levelName;

    @ApiModelProperty(value="床位编号")
    @TableField(value="bed_no")
    private String bedNo;

}
