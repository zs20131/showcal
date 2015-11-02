<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>PL_SETTING_USER_TAG</name>
     <meaning>用户标签</meaning>
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
             <name>TAG</name>
             <type>String</type>
             <meaning>标签名称</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>TAG_RGB</name>
             <type>String</type>
             <meaning>标签RGB颜色</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>REMARK</name>
             <type>String</type>
             <meaning>备注</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>IS_ACTIVE</name>
             <type>Boolean</type>
             <meaning>是否有效</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>true</isSortable>
        </column>
        <column>
             <name>ACTIVE_DATE</name>
             <type>Date</type>
             <meaning>生效日期</meaning>
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
     </columns>
</table>