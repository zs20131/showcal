<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>TC_SYNC_SPORT</name>
     <meaning>运动同步表)</meaning>
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
             <name>SPORT_HEAD_ID</name>
             <type>Id</type>
             <meaning>执行的运动方案ID</meaning>
             <description></description>
             <isRequired>false</isRequired>
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
             <name>TOTAL_TIME</name>
             <type>Integer</type>
             <meaning>本次运动总时长</meaning>
             <description></description>
             <isRequired>false</isRequired>
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
             <name>IS_SYNCED</name>
             <type>Boolean</type>
             <meaning>是否同步完成</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
     </columns>
</table>