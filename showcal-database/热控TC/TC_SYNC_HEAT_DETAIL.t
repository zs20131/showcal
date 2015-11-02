<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>TC_SYNC_HEAT_DETAIL</name>
     <meaning>热量同步明细表</meaning>
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
             <name>SYNC_HEAT_ID</name>
             <type>Id</type>
             <meaning>同步表头ID</meaning>
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
             <name>FOOD_ID</name>
             <type>Id</type>
             <meaning>食物ID</meaning>
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
             <name>FOOD_NAME</name>
             <type>String</type>
             <meaning>食物名称</meaning>
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
             <name>UNIT</name>
             <type>String</type>
             <meaning>食物单位</meaning>
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
             <name>RECOMMEND_VALUE</name>
             <type>Decimal</type>
             <meaning>推荐值</meaning>
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
             <name>ACTUAL_VALUE</name>
             <type>Decimal</type>
             <meaning>实际值</meaning>
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