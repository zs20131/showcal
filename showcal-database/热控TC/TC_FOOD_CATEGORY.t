<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>TC_FOOD_CATEGORY</name>
     <meaning>食物类别</meaning>
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
             <meaning>食物类别名称</meaning>
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
     </columns>
</table>