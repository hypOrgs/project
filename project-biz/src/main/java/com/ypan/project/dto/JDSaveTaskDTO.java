package com.ypan.project.dto;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class JDSaveTaskDTO {

    private String name;

    private String appVersion;

    private String buildVersion;

    private String appCode;

    private OrientationRuleBo orientationRuleBo;

    private Map<String, OrientationRuleBo.Rule> ruleMap;

    private Map<String, OrientationRuleBo.Stat> statsMap;

    private String creator;

    private String baseInfo;

    private Long runState;

    private Long state;

    private Long id;

    private String modifier;


    @Data
    static class OrientationRuleBo {

        private String instanceType;

        private Long projectId;

        private String ruleName;

        private String appVersion;

        private String clientType;

        private String creator;

        private String modifier;

        private AndroidOsVersion androidOsVersion;

        private City citys;

        private Device device;

        private DeviceId deviceId;

        private Long androidStartingVersion;

        private Long androidEndVersion;

        private Pin pin;

        private Long instanceId;


        @Data
        public static class Rule {
            private int id;
            private int publishId;
            private int taskId;
            private int ruleType;
            private String taskCode;
            private int state;
            private int orderNum;
            private int shortCircuit;
            private Object enable;
            private Object param;
            private int yn;
            private String creator;
            private String modifier;
            @JSONField(format = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private LocalDateTime createdTime;
            @JSONField(format = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private LocalDateTime modifiedTime;
        }


        @Data
        public static class Stat {
            private int id;
            private int taskId;
            private int type;
            private int plan;
            private Object amount;
            private int yn;
            private String creator;
            private String modifier;
            @JSONField(format = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private LocalDateTime createdTime;
            @JSONField(format = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private LocalDateTime modifiedTime;

            // Getter and Setter methods
        }

        @Data
        static class AndroidOsVersion {

            private List<Object> value;

            private Long type;

        }

        @Data
        static class DeviceId {

            private List<Object> value;

            private Long type;

        }

        @Data
        static class Pin {

            private List<Object> value;

            private Long type;

        }

        @Data
        static class City {

            private List<Object> value;

            private Long type;

        }

        @Data
        static class Device {

            private List<Object> value;

            private Long type;

        }
    }
}
