<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>TC_SPORT_HEAD</name>
     <meaning>运动方案</meaning>
     <description></description>
     <isByTenant>false</isByTenant>
     <uniqueIndex></uniqueIndex>
     <columns>
        <column>
             <name>ID</name>
             <type>Id</type>
             <meaning>主键</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>NAME</name>
             <type>String</type>
             <meaning>运动头名称</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>100</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>true</isSortable>
        </column>
        <column>
             <name>TOTAL_TIME</name>
             <type>Integer</type>
             <meaning>运动总时长</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>INTENSITY</name>
             <type>String</type>
             <meaning>运动强度</meaning>
             <description>高中低</description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>Enum</referenceType>
             <referenceObject>HIGH(高),MIDDLE(中),LOW(低)</referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>ADDRESS</name>
             <type>String</type>
             <meaning>运动地点</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>Enum</referenceType>
             <referenceObject>OUTDOORS(户外),HOME(家中),GYM(健身房)</referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>START_BMI</name>
             <type>Decimal</type>
             <meaning>BMI起始值</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>END_BMI</name>
             <type>Decimal</type>
             <meaning>BMI结束值</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>IS_INJURY_JOIN</name>
             <type>Boolean</type>
             <meaning>有运动损伤是否可以参与</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
     </columns>
</table>